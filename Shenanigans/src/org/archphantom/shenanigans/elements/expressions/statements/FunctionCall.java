package org.archphantom.shenanigans.elements.expressions.statements;
import java.util.ArrayList;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class FunctionCall extends Expression {
	private static final long serialVersionUID = -5711425379993291311L;
	private String identifier;
	private ArrayList<Expression> arguments;
	
	public FunctionCall (String identifier, ArrayList<Expression> arguments) {
		this.identifier = identifier;
		this.arguments = arguments;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		Value vfn = new Variable(identifier).evaluate(vars, program);
		if (vfn instanceof Function) {
			Function function = (Function) vfn;
			ArrayList<String> argNames = function.getArgNames();
			int argnum = Math.min(argNames.size(), arguments.size());
			VarTable localVars = new VarTable();
			for (int i = 0; i < argnum; i++) {
				localVars.set(argNames.get(i), arguments.get(i).evaluate(vars, program));
			}
			Value retval = function.getValue(localVars, program);
			return retval;
		} else {
			throw new RuntimeException("No such function exists: "+identifier+".");
		}
	}
	
}
