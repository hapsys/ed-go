package org.c3s.edgo.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.c3s.annotations.ActionUrl;
import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.UrlPart;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.entity.Module;
import org.c3s.edgo.common.entity.ModuleGroup;
import org.c3s.edgo.common.entity.Pilot;
import org.c3s.edgo.common.entity.PilotModule;
import org.c3s.edgo.common.entity.PilotShip;
import org.c3s.edgo.common.entity.Ship;
import org.c3s.edgo.common.entity.Slot;
import org.c3s.edgo.common.entity.SlotType;
import org.c3s.edgo.common.entity.StarSystem;
import org.c3s.edgo.common.entity.User;
import org.c3s.edgo.utils.DomSerializer;
import org.c3s.edgo.web.GeneralController;
import org.c3s.web.redirect.DirectRedirect;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.web.redirect.RelativeRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Controller
public class Commander extends GeneralController {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Commander.class);
	
	private Pilot current = null;
	
	@SuppressWarnings("serial")
	public void getInformation(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			Map<Object, Object> tree = new HashMap<Object, Object>() {{
				put(Pilot.class, new HashMap<Object, Object>() {{
					put(PilotShip.class, new HashMap<Object, Object>() {{
						put(Ship.class, new HashMap<Object, Object>() {{
							
						}});
						/*
						put(PilotModule.class, new HashMap<Object, Object>() {{
							put(Slot.class, new HashMap<Object, Object>() {{
								put(SlotType.class, new HashMap<Object, Object>() {{
								}});
							}});
							put(Module.class, new HashMap<Object, Object>() {{
								put(ModuleGroup.class, new HashMap<Object, Object>() {{
								}});
							}});
						}});
						*/
					}});
				}});
			}};
			
			Document xml = XMLUtils.createXML("data");
			new DomSerializer(current).__toXML(xml.getDocumentElement(), tree);
			/*
			for (Pilot p: pilots) {
				Element elm;
				xml.getDocumentElement().appendChild(elm = xml.createElement("commander"));
			}
			*/
			//logger.debug(XMLUtils.xml2out(xml));
			//XMLUtils.save(xml, "/out.xml");
			logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});
		}
	
		if (current == null) {
			//redirect.setRedirect(new DirectRedirect("/"));
			//throw new SkipSubLevelsExeption();
		}
		
	}
	
	@SuppressWarnings("serial")
	public void getShips(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			Map<Object, Object> tree = new HashMap<Object, Object>() {{
				put(Pilot.class, new HashMap<Object, Object>() {{
					put(PilotShip.class, new HashMap<Object, Object>() {{
						put(StarSystem.class, new HashMap<Object, Object>() {{
							
						}});
						put(Ship.class, new HashMap<Object, Object>() {{
							
						}});
						/*
						put(PilotModule.class, new HashMap<Object, Object>() {{
							put(Slot.class, new HashMap<Object, Object>() {{
								put(SlotType.class, new HashMap<Object, Object>() {{
								}});
							}});
							put(Module.class, new HashMap<Object, Object>() {{
								put(ModuleGroup.class, new HashMap<Object, Object>() {{
								}});
							}});
						}});
						*/
					}});
				}});
			}};
			
			Document xml = XMLUtils.createXML("data");
			new DomSerializer(current).__toXML(xml.getDocumentElement(), tree);
			//logger.debug(XMLUtils.xml2out(xml));
			//XMLUtils.save(xml, "/out.xml");
			logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:ships"});
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}

	
	@SuppressWarnings("serial")
	public void getShip(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect, PatternerInterface patterner) throws Exception {
	
		if (current != null) {
			
			PilotShip ship = current.getPilotShip(Integer.valueOf(url.getPattern().substring(0, url.getPattern().length() - 1)));  
			
			if (ship != null) {
				Map<Object, Object> tree = new HashMap<Object, Object>() {{
					put(PilotShip.class, new HashMap<Object, Object>() {{
						/*
						put(Ship.class, new HashMap<Object, Object>() {{
							
						}});
						*/
						put(PilotModule.class, new HashMap<Object, Object>() {{
							put(Slot.class, new HashMap<Object, Object>() {{
								put(SlotType.class, new HashMap<Object, Object>() {{
								}});
							}});
							put(Module.class, new HashMap<Object, Object>() {{
								put(ModuleGroup.class, new HashMap<Object, Object>() {{
								}});
							}});
						}});
						/*
						*/
					}});
				}};
				
				Document xml = XMLUtils.createXML("data");
				new DomSerializer(ship).__toXML(xml.getDocumentElement(), tree);
				//logger.debug(XMLUtils.xml2out(xml));
				//XMLUtils.save(xml, "/out1.xml");
				//logger.debug("template {}", template);
				/*
				 * Path
				 */
				ContentObject.getInstance().addPath("/", ship.getShip().getName());
				
				ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_ship"});
				redirect.setRedirect(new DropRedirect());
			} else {
				redirect.setRedirect(new RelativeRedirect("../", patterner));
				throw new StopDispatchException();
			}
			
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	//@SuppressWarnings("serial")
	public void checkCommander(UrlPart url, RedirectControlerInterface redirect) {
		
		String actionUrl = url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase();
		User user = getUser();
		Pilot pilot = null;

		if (user != null) {
			//logger.debug("Current {}", actionUrl);
			pilot = getEntityManager().createNamedQuery("Pilot.findByName", Pilot.class).setParameter("name", actionUrl).getResultList().stream().findFirst().orElse(null);
			if (pilot != null && pilot.getUserId() == user.getUserId()) {
				current = pilot;
				ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName());
			}
		}
		//logger.debug("Current {}", url.getClass().getName());
		//logger.debug("Current {}", actionUrl);
		//redirect.setRedirect(new DropRedirect());
	}
	
}
