package org.archphantom.shenanigans.elements.values;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class BoolValue extends Value {
	private static final long serialVersionUID = 531596655233771451L;
	private boolean val;
	
	public BoolValue (boolean val) {
		this.val = val;
	}
	
	public Boolean getValue (VarTable vars, Program program) {
		return val;
	}
	
}
