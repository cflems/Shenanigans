package org.archphantom.shenanigans.elements.values;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class CharValue extends Value {
	private char val;
	
	public CharValue (char val) {
		this.val = val;
	}
	
	public Character getValue (VarTable vars, Program program) {
		return val;
	}
}
