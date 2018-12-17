package org.c3s.edgo.task.scrips;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GeneralTask implements Runnable {

	private static CompiledScript parseScript;
	private static ScriptEngine engine;
	
	static {
		engine = (new ScriptEngineManager()).getEngineByName("javascript");
		try {
			parseScript = ((Compilable) engine).compile("JSON.parse(jsonString)");
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		} 
	}
	
	private CompiledScript script;
	
	public GeneralTask(String scriptText) throws ScriptException {
		script = ((Compilable) engine).compile(scriptText);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
