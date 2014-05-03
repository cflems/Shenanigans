package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;


public class If extends ConditionalStatement {
	private static final long serialVersionUID = -8033692342706309763L;
	private Expression condition;
	private Expression evaluate;
	
	public If (Expression condition, Expression evaluate) {
		this.condition = condition;
		this.evaluate = evaluate;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		if (boolify(condition, vars, program)) {
			return evaluate.evaluate(vars, program);
		} else {
			return null;
		}
	}

}
