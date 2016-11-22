package org.c3s.edgo.scripts;

import org.c3s.exceptions.FileSystemException;

public class ModulesReader {

	public static void main(String[] args) throws FileSystemException {

		/**
		String source = FileSystem.fileGetContents("F:/Distributive/Elite/API/modules.json"); 

		EddbModuleInfo[] json = JSONUtils.fromJSON(source, EddbModuleInfo[].class);
		
		System.out.println(json.length);
		EntityManager em = ManagerJPA.get("edgo");
		
		em.getTransaction().begin();
		
		SlotType st = null;
		ModuleGroup mg = null;
		Module md = null;
		*/
		
		/**
		for (EddbModuleInfo list: json) {
			//SlotType st = null;
			st = em.find(SlotType.class, list.group.category_id);
			
			if (st == null) {
				st = new SlotType();
				st.setId(list.group.category_id);
				st.setName(list.group.category);
				em.merge(st);
			}
		}

		for (EddbModuleInfo list: json) {
			mg = em.find(ModuleGroup.class, list.group.id);
			if (mg == null) {
				st = em.find(SlotType.class, list.group.category_id);
				mg = new ModuleGroup();
				mg.setId(list.group.id);
				mg.setName(list.group.name);
				mg.setSlotType(st);
				em.merge(mg);
			}
		}
		
		*/
		/**
		for (EddbModuleInfo list: json) {
			
			try {
				int id = (list.ed_id != 0)?list.ed_id:list.id;
				md = em.find(Module.class, id);
				if (md == null) {
					mg = em.find(ModuleGroup.class, list.group.id);
					if (list.ed_symbol != null || list.name != null) {
						md = new Module();
						md.setId(list.id);
						md.setName(list.name);
						md.setUniq(list.ed_symbol != null?list.ed_symbol:list.name);
						md.setModuleRating(list.rating);
						md.setModuleClass(list._class);
						md.setModuleGroup(mg);
						em.merge(md);
					} else {
						System.out.println(list.id);
					}
					
				}
				
			} finally {
				
			}
		}
		*/
		/**
		*/
		
		//em.getTransaction().commit();
		//em.close();
	}


	
	
}
