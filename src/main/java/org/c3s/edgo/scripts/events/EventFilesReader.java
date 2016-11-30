package org.c3s.edgo.scripts.events;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.utils.RegexpUtils;

public class EventFilesReader {

	private static String[] using = new String[]{"Bounty", "Docked", "FSDJump", "FetchRemoteModule", "LoadGame", "Location", 
			"MaterialCollected", "MaterialDiscarded", "MaterialDiscovered", "MissionAbandoned", "MissionAccepted", "MissionCompleted", 
			"MissionFailed", "ModuleBuy", "ModuleRetrieve", "ModuleSell", "ModuleStore", "ModuleSwap", "PowerplayCollect", 
			"PowerplayDefect", "PowerplayDeliver", "PowerplayFastTrack", "PowerplayJoin", "PowerplayLeave", "PowerplaySalary", "PowerplayVote", "PowerplayVoucher", 
			"Progress", "Rank", "ShipyardBuy", "ShipyardNew", "ShipyardSell", "ShipyardSwap"};

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		
		Properties props = new Properties();
		/*
		props.put("user", "root");
		props.put("password", "root");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ed-go", props);
		*/
		props.put("user", "hapsys");
		props.put("password", "123467890");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.10:3306/ed-go", props);
		
		String savedgames = System.getenv("USERPROFILE") + "\\Saved Games\\Frontier Developments\\Elite Dangerous\\";;
		long userId = 1L;
		
		//String savedgames = "F:\\freelance\\elite-dangerous\\journals\\oleg\\";
		//long userId = 2L;
		//String savedgames = "F:\\freelance\\elite-dangerous\\journals\\flack\\";
		//long userId = 3L;
		//String savedgames = "F:\\freelance\\elite-dangerous\\journals\\victor\\";
		//long userId = 4L;
		
		
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
			processFile(f, userId);
			count++;
			if (count < 3) {
				//break;
			}
		}
	}

	
	public static void processFile(File file, long userId) throws IOException {
		
		System.out.println(file.getName());
		
		//BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
	
		String line = null;
		
		try {
			while((line = reader.readLine()) != null) {
				if (line.trim().length() > 0) {
					
					String name = RegexpUtils.preg_replace("~^.+\"event\"\\s*:\\s*\"([^\"]+)\".*$~isu", line, "$1");
					if (Arrays.asList(using).stream().filter(x->x.equals(name)).findFirst().orElse(null) != null) {
						//System.out.println(name);
						//System.exit(0);
						DBEventsBean evt = new DBEventsBean();
						evt.setEventId(BigInteger.valueOf(System.nanoTime()));
						evt.setUserId(userId);
						evt.setEventName(name);
						evt.setEventJson(line);
						evt.setIsLocked(0);
						DbAccess.eventsAccess.insert(evt);
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			throw new RuntimeException(e);
		} finally {
			reader.close();
		}
		
	}
	
}
