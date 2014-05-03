package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class ForLoop extends ConditionalStatement {
	private static final long serialVersionUID = 4620309283857707757L;
	private Expression initializer;
	private Expression condition;
	private Expression iterator;
	private Expression evaluate;
	
	public ForLoop (Expression initializer, Expression condition, Expression iterator, Expression evaluate) {
		this.initializer = initializer;
		this.condition = condition;
		this.iterator = iterator;
		this.evaluate = evaluate;
	}

	public Value evaluate (VarTable vars, Program program) {
		Value retval = null;
		for (initializer.evaluate(vars, program); boolify(condition, vars, program); iterator.evaluate(vars, program)) {
			retval = evaluate.evaluate(vars, program);
		}
		return retval;
	}

}
