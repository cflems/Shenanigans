package org.archphantom.shenanigans.elements.variables;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.expressions.Expression;

public class VarTable {
	private Hashtable<String, Expression> vars;
	
	public VarTable () {
		vars = new Hashtable<String, Expression>();
	}
	
	public Expression set (String identifier, Expression value) {
		vars.put(identifier, value);
		return value;
	}
	
	public Expression get (String identifier) {
		return vars.get(identifier);
	}
	
}
