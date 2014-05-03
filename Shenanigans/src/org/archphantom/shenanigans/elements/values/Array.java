package org.archphantom.shenanigans.elements.values;
import java.util.ArrayList;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Array extends Value {
	private static final long serialVersionUID = -1094670284231123418L;
	private ArrayList<Value> vals;
	
	public Array () {
		this.vals = new ArrayList<Value>();
	}
	
	public Array (ArrayList<Value> values) {
		this.vals = values;
	}
	
	public Array (String string) {
		this.vals = new ArrayList<Value>(string.length());
		for (int i = 0; i < string.length(); i++) {
			this.vals.add(new CharValue(string.charAt(i)));
		}
	}
	
	public Value getElement (IntValue index, VarTable vars, Program program) {
		return vals.get(index.intValue(vars, program).intValue());
	}
	
	public Value setElement (IntValue index, Value value, VarTable vars, Program program) {
		int iindex = index.intValue(vars, program).intValue();
		int size = vals.size();
		if (iindex >= size) {
			for (int i = size; i <= iindex; i++) {
				vals.add(null);
			}
		}
		vals.set(index.intValue(vars, program).intValue(), value);
		return value;
	}
	
	public int size () {
		return vals.size();
	}

	public ArrayList<Value> getValue(VarTable vars, Program program) {
		return vals;
	}

}
