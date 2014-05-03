package org.archphantom.shenanigans.elements.values;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.variables.VarTable;

public abstract class Value extends Expression {
	private static final long serialVersionUID = 3704411592873487046L;

	public abstract Object getValue(VarTable vars, Program program);
	
	public Value evaluate (VarTable vars, Program program) {
		return this;
	}
	
}
