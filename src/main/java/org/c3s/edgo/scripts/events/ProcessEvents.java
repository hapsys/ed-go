package org.c3s.edgo.scripts.events;

import org.c3s.edgo.event.EventDispatcher;
import org.c3s.edgo.event.EventProcessor;
import org.c3s.storage.ApplicationStorage;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageType;

public class ProcessEvents {

	public static void main(String[] args) {
		
		EventDispatcher.registerEventPackage("org.c3s.edgo.event.impl");
		
		StorageFactory.register(StorageType.APPLICATION, new ApplicationStorage());
		
		new Thread(new EventProcessor()).start();
	}

}
