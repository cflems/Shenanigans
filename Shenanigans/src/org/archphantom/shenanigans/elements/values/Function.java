package org.archphantom.shenanigans.elements.values;
import java.util.ArrayList;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Function extends Value {
	private static final long serialVersionUID = -6290598231971188194L;
	private ArrayList<String> arguments;
	private Expression body;
	
	public Function (ArrayList<String> arguments, Expression body) {
		this.arguments = arguments;
		this.body = body;
	}
	
	public ArrayList<String> getArgNames () {
		return arguments;
	}
	
	public Value getValue (VarTable vars, Program program) {
		return body.evaluate(vars, program);
	}
		
}
