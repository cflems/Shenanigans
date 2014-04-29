package org.archphantom.shenanigans.elements.expressions;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public abstract class Expression {
	
	public abstract Value evaluate(VarTable vars, Program program);
	
}