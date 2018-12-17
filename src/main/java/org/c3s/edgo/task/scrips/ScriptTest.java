package org.c3s.edgo.task.scrips;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.c3s.exceptions.FileSystemException;
import org.c3s.utils.FileSystem;
import org.c3s.utils.JSONUtils;

public class ScriptTest {

	public static void main(String[] args) throws ScriptException, FileSystemException, InterruptedException {
		
		/*
		String json = FileSystem.fileGetContents("e:/some.json");
		
		//Map<String, Object> map = JSONUtils.fromJSON(json, HashMap.class);
		
		ScriptEngine engine = (new ScriptEngineManager()).getEngineByName("javascript");
		ScriptEngineFactory factory = engine.getFactory();
		Bindings bind = engine.createBindings();
		
		bind.put("jsonString", json);
		
		Object result = engine.eval("JSON.parse(jsonString)", bind);
		
		bind = engine.createBindings();		
		bind.put("jsonObject", result);
		String script = "for (k in jsonObject) { print(k + ': ' + jsonObject[k]) };"; 
		engine.eval(script, bind);
	    if (engine instanceof Compilable) {
	        System.out.println("Script compilation is supported.");
	      } else {
	        System.out.println("Script compilation is not supported.");
	      }
		*/
		//engine.getContext();
		//System.out.println(factory.getEngineName());
		//System.out.println(factory.getLanguageName());
		
		SimpleThread[] ss = new SimpleThread[] {new SimpleThread(), new SimpleThread(), new SimpleThread()};
		int size = ss.length;
		int i = 0;
		while (true) {
			int num = new Double(Math.random() * size).intValue();
			if (!ss[num].isAlive()) {
				ss[num].start();
			}
			ss[num].execute("Number - " + i++);
			Thread.sleep(1000);
		}
	}

	public static class SimpleThread extends Thread {

		//private boolean started = true;
		private Queue<String> events = new LinkedList<>();
		
		@Override
		public void run() {
			while (!interrupted()) {
				checkRun();
				System.out.println("Thread #" + Thread.currentThread().getId() + " echo: " + events.poll());
			}
		}
		
		public synchronized void execute(String commandd) {
			events.add(commandd);
			notify();
		}
		
		private synchronized void checkRun() {
	        while (events.size() == 0) {
	            try {
	                wait();
	            } catch (InterruptedException ex) {
	                interrupt();
	                //started = true;
	            }
	        }
	    }		
	}
}
