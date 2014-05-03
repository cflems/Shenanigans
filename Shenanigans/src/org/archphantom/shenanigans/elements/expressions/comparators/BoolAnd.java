package org.archphantom.shenanigans.elements.expressions.comparators;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.BoolValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class BoolAnd extends Expression {
	private static final long serialVersionUID = -2352274778863145062L;
	private Expression a, b;
	
	public BoolAnd (Expression a, Expression b) {
		this.a = a;
		this.b = b;
	}
	
	public BoolValue evaluate (VarTable vars, Program program) {
		Value aval = a.evaluate(vars, program);
		Value bval = b.evaluate(vars, program);
		if (!(aval instanceof BoolValue) || !(bval instanceof BoolValue)) {
			throw new RuntimeException("Not Implemented");
		}
		return new BoolValue ((((BoolValue) aval).getValue(vars, program)).booleanValue() && ((BoolValue) bval).getValue(vars, program).booleanValue());
	}
	
}
