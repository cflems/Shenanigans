package org.archphantom.shenanigans.examples;
import java.util.ArrayList;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.expressions.comparators.BoolEqual;
import org.archphantom.shenanigans.elements.expressions.operations.Multiplication;
import org.archphantom.shenanigans.elements.expressions.operations.Subtraction;
import org.archphantom.shenanigans.elements.expressions.statements.Assignment;
import org.archphantom.shenanigans.elements.expressions.statements.FunctionCall;
import org.archphantom.shenanigans.elements.expressions.statements.Group;
import org.archphantom.shenanigans.elements.expressions.statements.IfElse;
import org.archphantom.shenanigans.elements.expressions.statements.Print;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.CharValue;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Factorial {
	
	public static void main (String[] args) {
		ArrayList<Expression> list = new ArrayList<Expression>();
		ArrayList<String> argnames = new ArrayList<String>();
		argnames.add("n");
		ArrayList<Expression> factorial_expr_body = new ArrayList<Expression>();
		ArrayList<Expression> recursionargs = new ArrayList<Expression>();
		recursionargs.add(new Subtraction(new Variable("n"), new IntValue("1")));
		factorial_expr_body.add(new IfElse(new BoolEqual(new Variable("n"), new IntValue("0")), new IntValue("1"), new Multiplication(new FunctionCall("main.factorial", recursionargs), new Variable("n"))));
		Group factorial_body = new Group(factorial_expr_body);
		Function factorial = new Function(argnames, factorial_body);
		list.add(new Assignment("factorial", factorial));
		ArrayList<Expression> arguments = new ArrayList<Expression>();
		arguments.add(new IntValue("10"));
		ArrayList<Expression> to_print = new ArrayList<Expression>();
		to_print.add(new FunctionCall("factorial", arguments));
		to_print.add(new CharValue('\n'));
		list.add(new Print(new Array(to_print)));
		Group group = new Group(list);
		Namespace main = new Namespace("main", group, new VarTable());
		Hashtable<String, Namespace> namespaces = new Hashtable<String, Namespace>();
		namespaces.put("main", main);
		Program p = new Program(namespaces);
		p.run();
	}

}
