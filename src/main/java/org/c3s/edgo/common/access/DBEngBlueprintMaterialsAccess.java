/**
 *  Autogenerated class
 */
package org.c3s.edgo.common.access;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.c3s.db.access.Access;
import org.c3s.db.*;
import org.c3s.db.beans.*;
import org.c3s.db.injectors.SqlInjectorInterface;
import org.c3s.db.injectors.EmptySqlInjector;
import org.c3s.data.mapers.*;
import org.c3s.data.cast.*;


import org.c3s.edgo.common.beans.*;


@SuppressWarnings("unused")
public class DBEngBlueprintMaterialsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "eng_blueprint_materials";
	}
	
	
	public int insert(DBEngBlueprintMaterialsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBEngBlueprintMaterialsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBEngBlueprintMaterialsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBEngBlueprintMaterialsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBEngBlueprintMaterialsBean>();
			for (Map<String, Object> res : result) {
				DBEngBlueprintMaterialsBean bean = dataMapper.mapFromRow(res, DBEngBlueprintMaterialsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public List<DBMaterialsByTypeUniqBean> getMaterialsByTypeUniq(String paramTypeUniq) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT m.material_uniq 				FROM eng_blueprint b, eng_grade g, eng_type t, eng_blueprint_materials bm, materials m 				WHERE t.eng_type_uniq = ? 				AND b.eng_type_id = t.eng_type_id 				AND g.eng_blueprint_id = b.eng_blueprint_id 				AND bm.eng_grade_id = g.eng_grade_id 				AND m.material_id = bm.material_id  				GROUP BY m.material_uniq 				ORDER BY m.material_uniq 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getMaterialsByTypeUniq", query ,  paramTypeUniq);
		List<DBMaterialsByTypeUniqBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBMaterialsByTypeUniqBean>();
				
			for (Map<String, Object> res : result) {
				DBMaterialsByTypeUniqBean bean = dataMapper.mapFromRow(res, DBMaterialsByTypeUniqBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBMaterialsByBlueprintAndGradeBean> getMaterialsByBlueprintAndGrade(String paramBlueprintUniq, String paramGrade) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT m.material_uniq 				FROM eng_blueprint b, eng_grade g, eng_blueprint_materials bm, materials m 				WHERE eng_blueprint_uniq = ? 				AND g.eng_blueprint_id = b.eng_blueprint_id 				AND g.grade = ? 				AND bm.eng_grade_id = g.eng_grade_id 				AND m.material_id = bm.material_id  				GROUP BY m.material_uniq 				ORDER BY m.material_uniq 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getMaterialsByBlueprintAndGrade", query ,  paramBlueprintUniq,  paramGrade);
		List<DBMaterialsByBlueprintAndGradeBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBMaterialsByBlueprintAndGradeBean>();
				
			for (Map<String, Object> res : result) {
				DBMaterialsByBlueprintAndGradeBean bean = dataMapper.mapFromRow(res, DBMaterialsByBlueprintAndGradeBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBMaterialUnsingInfoBean> getMaterialUnsingInfo(String paramMaterial) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT m.material_uniq, '' as material_loc, g.*, b.*, t.*, GROUP_CONCAT(e.engeneer_name ORDER BY e.engeneer_name SEPARATOR ', ') as engeneers 				FROM  materials m, eng_blueprint b, eng_grade g, eng_type t,eng_blueprint_materials bm 				LEFT JOIN eng_engeneers_grade eg ON eg.eng_grade_id = bm.eng_grade_id 				LEFT JOIN eng_engeneers e ON e.eng_engeneer_id = eg.eng_engeneer_id 				WHERE m.material_uniq = ? 				AND bm.material_id = m.material_id 				AND g.eng_grade_id = bm.eng_grade_id 				AND b.eng_blueprint_id = g.eng_blueprint_id 				AND t.eng_type_id = b.eng_type_id 				GROUP BY bm.eng_grade_id 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getMaterialUnsingInfo", query ,  paramMaterial);
		List<DBMaterialUnsingInfoBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBMaterialUnsingInfoBean>();
				
			for (Map<String, Object> res : result) {
				DBMaterialUnsingInfoBean bean = dataMapper.mapFromRow(res, DBMaterialUnsingInfoBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}