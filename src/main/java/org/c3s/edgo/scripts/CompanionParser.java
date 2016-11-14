package org.c3s.edgo.scripts;

import org.c3s.edgo.companion.CompanionBean;
import org.c3s.exceptions.FileSystemException;
import org.c3s.utils.FileSystem;
import org.c3s.utils.JSONUtils;

public class CompanionParser {

	public static void main(String[] args) throws FileSystemException {
		String source = FileSystem.fileGetContents("E:/sites/ed-tourney/tmp/commander_new.txt");
		
		CompanionBean companion = JSONUtils.fromJSON(source, CompanionBean.class);
		
		
		for (String id: companion.ships.keySet()) {
			System.out.println(companion.ships.get(id).name);
		}
		
	}

}
