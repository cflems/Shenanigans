package org.archphantom.shenanigans.elements.values;
import java.util.ArrayList;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Array extends Value {
	private ArrayList<Expression> vals;
	
	public Array (ArrayList<Expression> values) {
		this.vals = values;
	}
	
	public Array (String string) {
		this.vals = new ArrayList<Expression>(string.length());
		for (int i = 0; i < string.length(); i++) {
			this.vals.add(new CharValue(string.charAt(i)));
		}
	}
	
	public Expression getElement (IntValue index, VarTable vars, Program program) {
		return vals.get(index.intValue(vars, program).intValue());
	}
	
	public Expression setElement (IntValue index, Expression value, VarTable vars, Program program) {
		return vals.set(index.intValue(vars, program).intValue(), value);
	}
	
	public int size () {
		return vals.size();
	}

	public ArrayList<Expression> getValue(VarTable vars, Program program) {
		return vals;
	}

}
