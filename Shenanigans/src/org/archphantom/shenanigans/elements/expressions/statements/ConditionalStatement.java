package org.archphantom.shenanigans.elements.expressions.statements;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.values.BoolValue;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public abstract class ConditionalStatement extends Expression {
	
	boolean boolify (Expression expr, VarTable vars, Program program) {
		Value val = expr.evaluate(vars, program);
		if (val instanceof BoolValue) {
			return ((BoolValue)val).getValue(vars, program);
		} else {
			if (val instanceof DecimalValue) {
				return ((DecimalValue)val).getValue(vars, program).intValue() > 0;
			} else {
				return true;
			}
		}
	}
	
}
