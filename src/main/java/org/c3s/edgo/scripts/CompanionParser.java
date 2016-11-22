package org.c3s.edgo.scripts;

import org.c3s.exceptions.FileSystemException;

public class CompanionParser {

	public static void main(String[] args) throws FileSystemException {
		
		/*
		
		List<String> skip =  Arrays.asList(new String[] {"PaintJob", "Decal", "PlanetaryApproachSuite", "Bobble", "WeaponColour", "EngineColour", "ShipKit"});
		
		String source = FileSystem.fileGetContents("E:/sites/ed-tourney/tmp/commander_new.txt");
		source = source.replaceAll("\\[\\]", "{}");
		
		CompanionBean companion = JSONUtils.fromJSON(source, CompanionBean.class);
		
		EntityManager em = ManagerJPA.get("edgo");
		
		em.getTransaction().begin();
		
		
		Pilot pilot = em.find(Pilot.class, 1);
		int currentShipId = companion.ship.id;
		
		for (String id: companion.ships.keySet()) {
			
			PilotShip pilotShip = pilot.getPilotShip(companion.ships.get(id).id);
			
			Ship ship = null;
			if (pilotShip == null) {
				ship = em.createNamedQuery("Ship.findByUniq", Ship.class).setParameter("uniq", companion.ships.get(id).name).getResultList().stream().findFirst().orElse(null);
				//System.out.println(ship);
				if (ship == null) {
					ship = new Ship();
					ship.setUniq(companion.ships.get(id).name);
					em.persist(ship);
				}
				
				pilotShip = new PilotShip();
				pilotShip.setShip(ship);
				pilotShip.setLinkShipId(companion.ships.get(id).id);
				pilotShip.setIsMain((companion.ships.get(id).id == currentShipId) ? (byte)1:0);
				pilotShip.setPilot(pilot);
				pilotShip.setStation(null);
				pilotShip.setSystem(null);
				if (companion.ships.get(id).starsystem != null) {
					pilotShip.setSystem(em.createNamedQuery("StarSystem.findByUniq", org.c3s.edgo.common.entity.StarSystem.class).setParameter("uniq", companion.ships.get(id).starsystem.getName()).getResultList().stream().findFirst().orElse(null));
				}
				if (companion.ships.get(id).station != null) {
					pilotShip.setStation(em.createNamedQuery("Station.findByUniq", Station.class).setParameter("uniq", companion.ships.get(id).station.getName()).getResultList().stream().findFirst().orElse(null));
				}
				em.persist(pilotShip);
			} else {
				pilotShip.setStation(null);
				pilotShip.setSystem(null);
				if (companion.ships.get(id).starsystem != null) {
					System.out.println(companion.ships.get(id).starsystem.getName());
					pilotShip.setSystem(em.createNamedQuery("StarSystem.findByUniq", org.c3s.edgo.common.entity.StarSystem.class).setParameter("uniq", companion.ships.get(id).starsystem.getName()).getResultList().stream().findFirst().orElse(null));
				}
				if (companion.ships.get(id).station != null) {
					pilotShip.setStation(em.createNamedQuery("Station.findByUniq", Station.class).setParameter("uniq", companion.ships.get(id).station.getName()).getResultList().stream().findFirst().orElse(null));
				}
				em.merge(pilotShip);
				System.out.println("Update ship " + id);
				ship = pilotShip.getShip();
			}
				

			for (final String cslot : companion.ships.get(id).modules.keySet()) {
				
				if (companion.ships.get(id).modules.get(cslot).module == null || skip.stream().filter(s -> cslot.toLowerCase().startsWith(s.toLowerCase())).map(s->true).findFirst().orElse(false)) {
					//System.out.println("Skip: " + cslot);
					continue;
				}
				
				Module module = em.createNamedQuery("Module.findByUniq", Module.class).setParameter("uniq", companion.ships.get(id).modules.get(cslot).module.name).getResultList().stream().findFirst().orElse(null);
				if (module != null) {
					Slot slot = em.createNamedQuery("Slot.findByUniq", Slot.class).setParameter("uniq", cslot).getResultList().stream().findFirst().orElse(null);
					
					if (slot == null) {
						slot = new Slot();
						slot.setSlotType(module.getModuleGroup().getSlotType());
						slot.setUniq(cslot);
						em.persist(slot);
					}

					if (ship.getSlot(cslot) == null) {
						ShipSlotPK ssPk = new ShipSlotPK();
						ssPk.setShipId(ship.getId());
						ssPk.setSlotId(slot.getId());
						
						ShipSlot shipSlot = new ShipSlot();
						shipSlot.setId(ssPk);
						shipSlot.setShip(ship);
						shipSlot.setSlot(slot);
						em.merge(shipSlot);
					}
					
					em.merge(slot);
					em.merge(ship);
					
				} else {
					System.out.println(id + "|" + cslot + "|" + companion.ships.get(id).modules.get(cslot).module.name);
				}
			}
			
		}
		
		em.getTransaction().commit();
		//
		// Хреначим модули у пилота 
		//
		em.getTransaction().begin();
		
		for (PilotShip pilotShip : pilot.getPilotShips()) {
			 org.c3s.edgo.companion.Ship cship = companion.ships.get(String.valueOf(pilotShip.getLinkShipId()));
			 
			 if (cship == null) {
				 em.remove(pilotShip);
				 System.out.println("1: WTF, why ship is null {" + pilotShip.getShip().getUniq() + "} ?");
			 } else {
				 System.out.println(pilotShip.getShip().getSlots().size());
				 for (Slot slot: pilotShip.getShip().getSlots()) {
					 PilotModule pilotModule = em.createNamedQuery("PilotModule.findByPilotShipAndSlot", PilotModule.class).setParameter("pilotShip", pilotShip).setParameter("slot", slot).getResultList().stream().findFirst().orElse(null);
					 if (pilotModule != null && cship.modules.get(slot.getUniq()).module != null) {
						 if (!pilotModule.getModule().getUniq().equals(cship.modules.get(slot.getUniq()).module.name)) {
							 Module module = em.createNamedQuery("Module.findByUniq", Module.class).setParameter("uniq", cship.modules.get(slot.getUniq()).module.name).getResultList().stream().findFirst().orElse(null);
							 if (module == null) {
								 System.out.println("1: WTF, module {" + cship.modules.get(slot.getUniq()).module.name + "} not found!");
							 } else {
								 pilotModule.setModule(module);
								 em.merge(pilotModule);
							 }
						 }
					 } else if (cship.modules.get(slot.getUniq()).module == null && pilotModule != null) {
						 em.remove(pilotModule);
					 } else if (cship.modules.get(slot.getUniq()).module != null) {
						 Module module = em.createNamedQuery("Module.findByUniq", Module.class).setParameter("uniq", cship.modules.get(slot.getUniq()).module.name).getResultList().stream().findFirst().orElse(null);
						 if (module == null) {
							 System.out.println("2: WTF, module {" + cship.modules.get(slot.getUniq()).module.name + "} not found!");
						 } else {
							 pilotModule = new PilotModule();
							 pilotModule.setPilotShip(pilotShip);
							 pilotModule.setSlot(slot);
							 pilotModule.setModule(module);
							 em.persist(pilotModule);
						 }
					 }
				 }
			 }
		}
		//
		// Коммитим 
		//
		em.getTransaction().commit();
		
		*/
	}

}
