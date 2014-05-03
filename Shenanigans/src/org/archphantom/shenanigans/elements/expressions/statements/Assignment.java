package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Assignment extends Expression {
	private static final long serialVersionUID = 7206490732056473577L;
	private String identifier;
	private Expression value;
	
	public Assignment (String identifier, Expression value) {
		this.identifier = identifier;
		this.value = value;
	}

	public Value evaluate(VarTable vars, Program program) {
		if (identifier.contains(".")) {
			String nspacecall = identifier.substring(0, identifier.indexOf('.'));
			String varname = identifier.substring(identifier.indexOf('.')+1);
			Namespace ns;
			if ((ns = program.getNamespace(nspacecall)) != null) {
				Value val = value.evaluate(vars, program);
				return ns.setVar(varname, val, vars, program);
			} else {
				return null;
			}
		} else {
			return vars.set(identifier, value.evaluate(vars, program)).evaluate(vars, program);
		}
	}

}
