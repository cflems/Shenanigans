package org.archphantom.shenanigans.examples;
import java.util.ArrayList;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.expressions.comparators.BoolGreater;
import org.archphantom.shenanigans.elements.expressions.operations.Multiplication;
import org.archphantom.shenanigans.elements.expressions.operations.Subtraction;
import org.archphantom.shenanigans.elements.expressions.statements.Assignment;
import org.archphantom.shenanigans.elements.expressions.statements.FunctionCall;
import org.archphantom.shenanigans.elements.expressions.statements.Group;
import org.archphantom.shenanigans.elements.expressions.statements.PrintLn;
import org.archphantom.shenanigans.elements.expressions.statements.WhileLoop;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class FactorialZ {
	
	public static Program buildExample () {
		ArrayList<Expression> list = new ArrayList<Expression>();
		ArrayList<String> argnames = new ArrayList<String>();
		argnames.add("n");
		ArrayList<Expression> factorialz_expr_body = new ArrayList<Expression>();
		factorialz_expr_body.add(new Assignment("res", new IntValue("1")));
		ArrayList<Expression> loop_body = new ArrayList<Expression>();
		loop_body.add(new Assignment("res", new Multiplication(new Variable("res"), new Variable("n"))));
		loop_body.add(new Assignment("n", new Subtraction(new Variable("n"), new IntValue("1"))));
		factorialz_expr_body.add(new WhileLoop(new BoolGreater(new Variable("n"), new IntValue("0")), new Group(loop_body)));
		factorialz_expr_body.add(new Variable("res"));
		Group factorialz_body = new Group(factorialz_expr_body);
		Function factorialz = new Function(argnames, factorialz_body);
		list.add(new Assignment("factorialz", factorialz));
		ArrayList<Expression> arguments = new ArrayList<Expression>();
		arguments.add(new IntValue("10"));
		list.add(new PrintLn(new FunctionCall("factorialz", arguments)));
		Group group = new Group(list);
		Namespace main = new Namespace("main", group, new VarTable());
		Hashtable<String, Namespace> namespaces = new Hashtable<String, Namespace>();
		namespaces.put("main", main);
		return new Program(namespaces);
	}
	
	public static void main (String[] args) {
		buildExample().run();
	}

}
