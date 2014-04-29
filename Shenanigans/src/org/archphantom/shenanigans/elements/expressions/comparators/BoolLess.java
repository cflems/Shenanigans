package org.archphantom.shenanigans.elements.expressions.comparators;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.BoolValue;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class BoolLess extends Expression {
	private Expression a, b;
	
	public BoolLess (Expression a, Expression b) {
		this.a = a;
		this.b = b;
	}
	
	public BoolValue evaluate (VarTable vars, Program program) {
		Value aval = a.evaluate(vars, program);
		Value bval = b.evaluate(vars, program);
		if (!(aval instanceof DecimalValue) || !(bval instanceof DecimalValue)) {
			throw new RuntimeException("Not Implemented");
		}
		return new BoolValue(((DecimalValue) aval).getValue(vars, program).compareTo(((DecimalValue) bval).getValue(vars, program)) < 0);
	}
	
}
