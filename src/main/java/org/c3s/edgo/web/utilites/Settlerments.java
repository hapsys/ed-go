package org.c3s.edgo.web.utilites;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBSettlementTypesBean;
import org.c3s.edgo.common.beans.DBSettlementsSearchBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.web.validator.Result;
import org.c3s.exceptions.XMLException;
import org.c3s.utils.Utils;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

public class Settlerments {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Settlerments.class);
	
	public void getCanvas(@Parameter("tag") String tag, @Parameter("template") String template) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, XMLException {
		
		List<DBSettlementTypesBean> types = DbAccess.settlementTypesAccess.getSorted();
	
		for (DBSettlementTypesBean type: types) {
			type.setGroup(type.getType().substring(0,2));
		}
		
		Map<Object , List<DBSettlementTypesBean>> gr = Utils.getArrayGrouped(types, "group");
		
		Document xml = XMLUtils.arrayToXml(gr); 
		
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:canvas"});
		
		//logger.debug(XMLUtils.saveXML(xml));
	}

	
	public void searchSettlements(@ParameterRequest("stype") String typesStr, @ParameterRequest("system") String systemId, @ParameterRequest("visited") String visitedStr, 
			@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		typesStr = (typesStr != null)? typesStr.trim():"";
		visitedStr = (visitedStr != null)? visitedStr.trim():"";
		//System.out.println(">>>" + visitedStr);
		List<String> types =  Arrays.stream(typesStr.split(";")).filter(x -> x.length() > 0).collect(Collectors.toList());
		List<Long> visited =  Arrays.stream(visitedStr.split(";")).filter(x -> x.length() > 0).map(x -> Long.valueOf(x)).collect(Collectors.toList());
		
		Double x = .0, y = .0, z = .0;
		BigInteger sysId = BigInteger.ZERO;
		
		if (systemId != null && systemId.matches("[0-9]+")) {
			DBSystemsBean system = DbAccess.systemsAccess.getByPrimaryKey(new BigInteger(systemId));
			if (system != null) {
				x = system.getX();
				y = system.getY();
				z = system.getZ();
			}
		}
		
		List<DBSettlementsSearchBean> result = null;
		List<DBSettlementsSearchBean> sys = DbAccess.settlementsAccess.getSettlementsSearch(new InInjector("t.type", types));
		if (sys != null) {
			sys = sys.stream().filter(s -> !visited.contains(s.getSettlementId())).filter(s -> !visited.contains(s.getSettlementId())).collect(Collectors.toList());
			Map<BigInteger, Dsts> dst = new HashMap<>();
			dst.put(sysId, new Dsts(sysId, x, y, z));
			//Map<BigInteger, Dsts> dst =  sys.stream().map(s->s.getSystemId()).collect(Collectors.toMap(s -> s.getSystemId(), s -> new Dsts(s.getSystemId(), s.getX(), s.getY(), s.getZ())));
			for (DBSettlementsSearchBean s: sys) {
				dst.put(s.getSystemId(), new Dsts(s.getSystemId(), s.getX(), s.getY(), s.getZ()));
			}
			for (BigInteger sId : dst.keySet()) {
				for (BigInteger tId : dst.keySet()) {
					if (!sId.equals(tId) && !dst.get(sId).dst.containsKey(tId)) {
						Double r = Math.sqrt(Math.pow(dst.get(sId).x - dst.get(tId).x, 2) + Math.pow(dst.get(sId).y - dst.get(tId).y, 2) + Math.pow(dst.get(sId).z - dst.get(tId).z, 2));
						dst.get(sId).dst.put(tId, r);
						if (!BigInteger.ZERO.equals(sId)) {
							dst.get(tId).dst.put(sId, r);
						}
					}
				}
			}
			Map<BigInteger, Integer> path = getPath(dst);
			
			result = sys.stream().sorted(new Comparator<DBSettlementsSearchBean>() {
				@Override
				public int compare(DBSettlementsSearchBean o1, DBSettlementsSearchBean o2) {
					return path.get(o1.getSystemId()) - path.get(o2.getSystemId()); 
				}
			}).collect(Collectors.toList());
			
			for (DBSettlementsSearchBean s: result) {
				s.setSolDest(Math.sqrt(Math.pow(s.getX(), 2) + Math.pow(s.getY(), 2) + Math.pow(s.getZ(), 2)));
				s.setDest(Math.sqrt(Math.pow(s.getX() - x, 2) + Math.pow(s.getY() - y, 2) + Math.pow(s.getZ() - z, 2)));
				x = s.getX();
				y = s.getY();
				z = s.getZ();
			}
		}
		
		ContentObject.getInstance().setData(tag, new Result().put("settlerments", result).get());
		redirect.setRedirect(new DropRedirect());
	}

	
	private Map<BigInteger, Integer> getPath(Map<BigInteger, Dsts> source) {
		Map<BigInteger, Integer> result = new HashMap<>();
		Dsts current = source.get(BigInteger.ZERO);
		source.remove(BigInteger.ZERO);
		Integer i = 0;
		while(source.size() > 0) {
			for (BigInteger s: source.keySet()) {
				source.get(s).dst.remove(current.id);
			}
			Dsts cur = current; 
			//System.out.println(cur.id);
			//System.out.println(cur.dst.keySet().size());
			BigInteger targetId = cur.dst.keySet().stream().sorted(new Comparator<BigInteger>() {
				@Override
				public int compare(BigInteger o1, BigInteger o2) {
					if (cur.dst.get(o1) > cur.dst.get(o2)) {
						return 1;
					} else if (cur.dst.get(o1) < cur.dst.get(o2)) {
						return -1;
					}
					return 0;
				}
			}).findFirst().get();
			result.put(targetId, i++);
			current = source.get(targetId);
			source.remove(targetId);
		}
		
		return result;
	}
	
	public static class Dsts {
		
		BigInteger id;
		Double x = .0, y = .0, z = .0;
		
		public Dsts(BigInteger id, Double x, Double y, Double z) {
			super();
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		Map<BigInteger, Double> dst = new HashMap<>();
	}
}
