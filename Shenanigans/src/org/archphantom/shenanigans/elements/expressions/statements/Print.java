package org.archphantom.shenanigans.elements.expressions.statements;
import java.math.BigInteger;
import java.util.ArrayList;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Print extends Expression {
	private Array data;
	
	public Print (Expression data) {
		ArrayList<Expression> list = new ArrayList<Expression>(1);
		list.add(data);
		this.data = new Array(list);
	}
	
	public Print (Array data) {
		this.data = data;
	}
	
	public Array evaluate(VarTable vars, Program program) {
		for (int i = 0; i < data.size(); i++) {
			System.out.print(data.getElement(new IntValue(BigInteger.valueOf(i)), vars, program).evaluate(vars, program).getValue(vars, program).toString());
		}
		return data;
	}
	
}
