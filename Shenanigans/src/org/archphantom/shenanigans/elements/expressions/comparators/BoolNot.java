package org.archphantom.shenanigans.elements.expressions.comparators;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.BoolValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class BoolNot extends Expression {
	private static final long serialVersionUID = 8925098393357319876L;
	private BoolValue val;
	
	public BoolNot (BoolValue val) {
		this.val = val;
	}

	public BoolValue evaluate(VarTable vars, Program program) {
		Value aval = val.evaluate(vars, program);
		if (!(aval instanceof BoolValue)) {
			throw new RuntimeException("Not Implemented");
		}
		return new BoolValue(!((BoolValue) aval).getValue(vars, program).booleanValue());
	}

}
