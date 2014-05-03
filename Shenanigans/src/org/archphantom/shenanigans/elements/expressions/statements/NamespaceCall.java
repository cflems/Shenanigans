package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class NamespaceCall extends Expression {
	private static final long serialVersionUID = 660496406878146378L;
	private String identifier;
	
	public NamespaceCall (String identifier) {
		this.identifier = identifier;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		Namespace ns = program.getNamespace(identifier.toLowerCase());
		if (ns == null) {
			throw new RuntimeException("Not Implemented");
		}
		return ns.getValue(program.getGlobalVars(), program);
	}
	
}
