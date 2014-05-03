package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class ArrayVariable extends Expression {
	private String identifier;
	private Expression index;
	
	public ArrayVariable (String identifier, Expression index) {
		this.identifier = identifier;
		this.index = index;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		Value vindex = index.evaluate(vars, program);
		if (!(vindex instanceof DecimalValue)) {
			throw new RuntimeException("Not Implemented");
		}
		IntValue iindex = new IntValue(((DecimalValue) vindex).getValue(vars, program).toBigInteger());
		Value varr = new Variable(identifier).evaluate(vars, program);
		if (varr instanceof Array) {
			Array array = (Array) varr;
			return array.getElement(iindex, vars, program);
		} else {
			throw new RuntimeException("Not Implemented");
		}
	}
	
}
