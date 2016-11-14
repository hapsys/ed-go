package org.c3s.edgo.scripts.journal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.c3s.edgo.event.EventDispatcher;
import org.c3s.utils.JSONUtils;

public class Journal {

	public static void main(String[] args) throws IOException {
		
		
		EventDispatcher dispatcher = new EventDispatcher();
		dispatcher.registerEventPackage("org.c3s.edgo.event.impl");
		//System.exit(0);
		
		String filename = "E:\\Jornal\\Elite Dangerous\\Journal.161030185056.01.log";
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = "";
		
		while((line = reader.readLine()) != null) {
			
			@SuppressWarnings("unchecked")
			Map<String, Object> json = (Map<String, Object>)JSONUtils.fromJSON(line, Map.class);
			
			dispatcher.dispatch(json);
			
		}
		
		reader.close();
	}

}
