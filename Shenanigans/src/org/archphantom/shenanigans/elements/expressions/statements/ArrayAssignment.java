package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class ArrayAssignment extends Expression {
	private static final long serialVersionUID = 5675142957845934390L;
	private String identifier;
	private Expression index;
	private Expression value;
	
	public ArrayAssignment (String identifier, Expression index, Expression value) {
		this.identifier = identifier;
		this.index = index;
		this.value = value;
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
			return array.setElement(iindex, value.evaluate(vars, program), vars, program);
		} else {
			throw new RuntimeException("Not Implemented");
		}
	}
	
}
