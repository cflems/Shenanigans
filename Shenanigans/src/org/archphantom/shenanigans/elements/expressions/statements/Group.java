package org.archphantom.shenanigans.elements.expressions.statements;
import java.util.ArrayList;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Group extends Expression {
	private ArrayList<Expression> items;
	
	public Group (ArrayList<Expression> items) {
		this.items = items;
	}
	
	public Value evaluate(VarTable vars, Program program) {
		Value retval = null;
		System.out.println("Running group's body...");
		for (Expression e : items) {
			System.out.println("Running "+e.getClass().getSimpleName()+" in Group.");
			retval = e.evaluate(vars, program);
			System.out.println("Returned a "+retval.getClass().getSimpleName()+": "+retval.hashCode());
		}
		return retval;
	}

}
