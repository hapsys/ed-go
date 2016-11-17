package org.c3s.edgo.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomSerializer {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(DomSerializer.class);
	
	
	private static Map<Class<?>, List<Field>> cache = new ConcurrentHashMap<Class<?>, List<Field>>();
	
	private Object object;
	
	public DomSerializer() {
		super();
		object = this;
	}

	public DomSerializer(Object object) {
		super();
		this.object = object;
	}
	
	@SuppressWarnings("rawtypes")
	protected List<Field> getAllFieldsList(Class cls) {

		List<Field> fields = cache.get(cls);
		
		if (fields == null) {
			fields = new ArrayList<Field>(); 
			Field[] fs = cls.getDeclaredFields();
			for (Field field : fs) {
				fields.add(field);
			}
		}

		return fields;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	
	private Map<Object, Object> useClass = null;

	public Document __toXML(Element node) throws Exception {
		return __toXML(node, null);
	}
	
	@SuppressWarnings("unchecked")
	public Document __toXML(Element node, Object useClasses) throws Exception {
		
		//this.useClass = );
		if (useClasses != null && useClasses instanceof Map) {
			this.useClass = (Map<Object, Object>)useClasses;
		}
		
		//logger.debug("Deserialize class: {}", );
		
		Document xml = null;
		
		try {
		
			if (object == null || useClass == null || useClass != null && !useClass.containsKey(object.getClass())  /*|| useClass == null && !object.getClass().getName().startsWith("org.c3s.edgo.")*/) {
				//logger.debug("Current class {}", object.getClass());
				return null;
			}
	
			if (node == null) {
				xml = XMLUtils.createXML("data");
				node = xml.getDocumentElement();
			} else {
				xml = node.getOwnerDocument(); 
			}
			//node.setAttribute("class", object.getClass().getName());
	
			List<Field> fields = getAllFieldsList(object.getClass());
	
			for (Field field : fields) {
				
				field.setAccessible(true);
	
				typeSeen(field, null, node);
				
			}
		} catch (Exception e) {
			throw e;
		}

		return xml;
	}

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	
	
	public Document toXML(Object useClasses) throws Exception {
		if (useClasses == null) {
			return toXML();
		} else if (useClasses instanceof Map) {
			Document doc = XMLUtils.createXML("data");
			__toXML(doc.getDocumentElement(), useClasses);
			return doc;
		} else {
			Document doc = XMLUtils.createXML("data");
			__toXML(doc.getDocumentElement());
			return doc;
		}
	}
	
	public Document toXML() throws Exception {
		Document doc = XMLUtils.createXML("data");
		typeSeen(null, object, doc.getDocumentElement());
		return doc;
	}
	
	@SuppressWarnings("unchecked")
	protected Element typeSeen(Field field, Object value, Element parent) throws Exception {
		Element e = null;
		Class<?> clazz = field != null? field.getType(): (value != null?value.getClass():null);
		if (clazz != null) {
			if (clazz.isArray()) {
				e = (field != null)?getArrayField(field, parent):getArrayField((Object[])value, parent);
			} else if (clazz.isAssignableFrom(Map.class)) {
				e = (field != null)?getMapField(field, parent):getMapField((Map<Object, Object>)value, parent);
			} else if (clazz.isAssignableFrom(List.class)) {
				e = (field != null)?getListField(field, parent):getListField((List<Object>)value, parent);
			} else if (clazz.getName().startsWith("org.c3s.edgo.")) {
				//logger.debug("Class: {},\tfield: {},\tvalue: {}",clazz.getName(), field, value);
				e = (field != null)?getField(field, parent):getField(value, parent);
			} else if (clazz.isPrimitive()) {
				e = (field != null)?getPrimitiveField(field, parent):getPrimitiveField(value, parent);
			} else {
				e = (field != null)?getObjectField(field, parent):getPrimitiveField(value, parent);
			}
		}
		return e;
	};
	
	protected Element getPrimitiveField(Object obj, Element elm) throws IllegalArgumentException, IllegalAccessException {
		String value = "";
		if (obj!= null) {
			value = obj.toString();
		}
		elm.setAttribute("value", value);
		return elm;
	}
	
	protected Element getPrimitiveField(Field field, Element parent) throws IllegalArgumentException, IllegalAccessException {
		Element elm = parent.getOwnerDocument().createElement("field");
		elm.setAttribute("name", field.getName());
		getPrimitiveField(field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}
	
	protected Element getObjectField(Field field, Element parent) throws IllegalArgumentException, IllegalAccessException {
		Element elm = parent.getOwnerDocument().createElement("field");
		elm.setAttribute("name", field.getName());
		getPrimitiveField(field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}
	
	protected Element getField(Object obj, Element elm) throws Exception {
		if (obj != null) {
			DomSerializer serializer = new DomSerializer(obj);
			if (useClass != null) {
				serializer.__toXML(elm, useClass.get(object.getClass()));
			} else {
				//serializer.__toXML(elm);
			}
		}
		return elm;
	}
	protected Element getField(Field field, Element parent) throws Exception {
		Element elm = parent.getOwnerDocument().createElement("field");
		elm.setAttribute("name", field.getName());
		getField(field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}

	protected Element getArrayField(Object[] objects,  Element parent) throws Exception {
		if (objects != null) {
			for(Object obj: objects) {
				Element value = parent.getOwnerDocument().createElement("item");
				typeSeen(null, obj, value);
				parent.appendChild(value);
			}
		}
		return parent;
	}
	protected Element getArrayField(Field field,  Element parent) throws Exception {
		Element elm = parent.getOwnerDocument().createElement("itemlist");
		elm.setAttribute("name", field.getName());
		getArrayField((Object[])field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}

	@SuppressWarnings("unchecked")
	protected Element getListField(List<Object> objects,  Element parent) throws Exception {
		if (objects != null) {
			for(Object obj: objects) {
				if (!obj.getClass().getName().startsWith("org.c3s.edgo.") || ((Map<Class<?>, Boolean>)useClass.get(object.getClass())).containsKey(obj.getClass())) {
					Element value = parent.getOwnerDocument().createElement("item");
					typeSeen(null, obj, value);
					parent.appendChild(value);
				}
			}
		}
		return parent;
	}
	@SuppressWarnings("unchecked")
	protected Element getListField(Field field,  Element parent) throws Exception {
		Element elm = parent.getOwnerDocument().createElement("itemlist");
		elm.setAttribute("name", field.getName());
		getListField((List<Object>)field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}
	
	protected Element getMapField(Map<Object, Object> objects,  Element parent) throws Exception {
		if (objects != null) {
			for(Object key: objects.keySet()) {
				Element value = parent.getOwnerDocument().createElement("item");
				value.setAttribute("name", key.toString());
				typeSeen(null, objects.get(key), value);
				parent.appendChild(value);
			}
		}
		return parent;
	}
	@SuppressWarnings("unchecked")
	protected Element getMapField(Field field,  Element parent) throws Exception {
		Element elm = parent.getOwnerDocument().createElement("itemlist");
		elm.setAttribute("name", field.getName());
		getMapField((Map<Object,Object>)field.get(object), elm);
		parent.appendChild(elm);
		return elm;
	}
}
