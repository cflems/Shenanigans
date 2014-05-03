package org.archphantom.shenanigans.elements.expressions;
import java.io.Serializable;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public abstract class Expression implements Serializable {
	private static final long serialVersionUID = 3202650253846618491L;

	public abstract Value evaluate(VarTable vars, Program program);
	
}