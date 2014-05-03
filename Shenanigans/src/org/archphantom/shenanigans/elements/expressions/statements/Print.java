package org.archphantom.shenanigans.elements.expressions.statements;
import java.math.BigInteger;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Print extends Expression {
	private Expression data;
	
	public Print (Expression data) {
		this.data = data;
	}
		
	public Value evaluate(VarTable vars, Program program) {
		Value vdata = data.evaluate(vars, program);
		if (vdata instanceof Array) {
			System.out.print('[');
			Array arr = (Array) vdata;
			for (int i = 0; i < arr.size(); i++) {
				Value val = arr.getElement(new IntValue(BigInteger.valueOf(i)), vars, program).evaluate(vars, program);
				if (val instanceof Array) {
					new Print ((Array) val).evaluate(vars, program);
				} else {
					System.out.print(val.getValue(vars, program).toString());
				}
				if (i < arr.size()-1) {
					System.out.print(", ");
				}
			}
			System.out.print(']');
		} else {
			System.out.print(vdata.getValue(vars, program).toString());
		}
		return vdata;
	}
	
}
