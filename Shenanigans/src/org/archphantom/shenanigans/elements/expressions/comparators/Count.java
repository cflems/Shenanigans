package org.archphantom.shenanigans.elements.expressions.comparators;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Count extends Expression {
	private static final long serialVersionUID = -491231132081798904L;
	private Expression val;
	
	public Count (Expression val) {
		this.val = val;
	}
	
	public IntValue evaluate(VarTable vars, Program program) {
		Value aval = val.evaluate(vars, program);
		if (aval == null) {
			return new IntValue("0");
		} else if (!(aval instanceof Array)) {
			return new IntValue("1");
		}
		Array array = (Array) aval;
		return new IntValue(array.size());
	}
	
}
