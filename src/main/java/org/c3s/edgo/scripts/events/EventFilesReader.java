package org.c3s.edgo.scripts.events;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import org.c3s.db.jpa.ManagerJPA;
import org.c3s.edgo.common.entity.Event;
import org.c3s.utils.RegexpUtils;

public class EventFilesReader {

	public static void main(String[] args) throws IOException {
		String savedgames = System.getenv("USERPROFILE") + "\\Saved Games\\Frontier Developments\\Elite Dangerous\\";;
		
		System.out.println(savedgames);
		
		File saveDir = new File(savedgames);
		
		File[] files = saveDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if  (pathname.getName().endsWith(".log")) {
					return true;
				}
				return false;
			}
		});
		
		
		List<File> filelist = Arrays.asList(files);
		
		Collections.sort(filelist, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				return new Long(o1.lastModified() - o2.lastModified()).intValue();
			}
		});
		
		int count = 0;
		for(File f: filelist) {
			//System.out.println(f.getName() + ": " + f.lastModified());
			processFile(f);
			count++;
			if (count > 3) {
				break;
			}
		}
	}

	
	public static void processFile(File file) throws IOException {
		
		int userId = 1;
		
		EntityManager em = ManagerJPA.get("edgo");
		
		em.getTransaction().begin();
		
		System.out.println(file.getName());
		
		//BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
	
		String line = null;
		
		while((line = reader.readLine()) != null) {
			if (line.trim().length() > 0) {
				
				String name = RegexpUtils.preg_replace("~^.+\"event\"\\s*:\\s*\"([^\"]+)\".*$~isu", line, "$1");
				//System.out.println(name);
				//System.exit(0);
				Event evt = new Event();
				evt.setEventId(System.nanoTime());
				evt.setUserId(userId);
				evt.setEventName(name);
				evt.setEventJson(line);
				evt.setIsLocked((byte)0);
				em.persist(evt);
			}
		}
		
		reader.close();
		
		em.getTransaction().commit();
	}
	
}
