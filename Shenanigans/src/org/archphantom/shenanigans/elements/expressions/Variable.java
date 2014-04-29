package org.archphantom.shenanigans.elements.expressions;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Variable extends Expression {
	private String identifier;
	
	public Variable (String identifier) {
		this.identifier = identifier;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		if (identifier.contains(".")) {
			String nspacecall = identifier.substring(0, identifier.indexOf('.'));
			String varname = identifier.substring(identifier.indexOf('.')+1);
			Namespace ns;
			if ((ns = program.getNamespace(nspacecall)) != null) {
				return ns.getVar(varname, vars, program).evaluate(vars, program);
			} else {
				return null;
			}
		} else {
			return vars.get(identifier).evaluate(vars, program);
		}
	}
	
}
