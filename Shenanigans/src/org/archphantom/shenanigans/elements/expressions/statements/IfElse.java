package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class IfElse extends ConditionalStatement {
	private static final long serialVersionUID = 5036859013313773084L;
	private Expression condition;
	private Expression evalTrue;
	private Expression evalFalse;
	
	public IfElse (Expression condition, Expression evalTrue, Expression evalFalse) {
		this.condition = condition;
		this.evalTrue = evalTrue;
		this.evalFalse = evalFalse;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		if (boolify(condition, vars, program)) {
			return evalTrue.evaluate(vars, program);
		} else {
			return evalFalse.evaluate(vars, program);
		}
	}

}
