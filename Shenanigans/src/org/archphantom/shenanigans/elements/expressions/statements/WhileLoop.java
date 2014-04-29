package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class WhileLoop extends ConditionalStatement {
	private Expression condition;
	private Expression evaluate;
	
	public WhileLoop (Expression condition, Expression evaluate) {
		this.condition = condition;
		this.evaluate = evaluate;
	}
	
	public Value evaluate (VarTable vars, Program program) {
		Value retval = null;
		while (boolify(condition, vars, program)) {
			retval = evaluate.evaluate(vars, program);
		}
		return retval;
	}
	
}
