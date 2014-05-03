package org.archphantom.shenanigans.elements.variables;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.values.Value;

public class VarTable {
	private Hashtable<String, Value> vars;
	
	public VarTable () {
		vars = new Hashtable<String, Value>();
	}
	
	public Value set (String identifier, Value value) {
		vars.put(identifier, value);
		return value;
	}
	
	public Value get (String identifier) {
		return vars.get(identifier);
	}
	
}
