package org.archphantom.shenanigans.elements.expressions.comparators;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.BoolValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class BoolEqual extends Expression {
	private Expression a, b;
	
	public BoolEqual (Expression a, Expression b) {
		this.a = a;
		this.b = b;
	}
	
	public BoolValue evaluate (VarTable vars, Program program) {
		Value aval = a.evaluate(vars, program);
		Value bval = b.evaluate(vars, program);
		return new BoolValue(aval.getValue(vars, program).equals(bval.getValue(vars, program)));
	}
	
}
