package org.archphantom.shenanigans.examples;
import java.util.ArrayList;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.expressions.comparators.BoolLess;
import org.archphantom.shenanigans.elements.expressions.comparators.Count;
import org.archphantom.shenanigans.elements.expressions.operations.Addition;
import org.archphantom.shenanigans.elements.expressions.operations.Subtraction;
import org.archphantom.shenanigans.elements.expressions.statements.ArrayAssignment;
import org.archphantom.shenanigans.elements.expressions.statements.ArrayVariable;
import org.archphantom.shenanigans.elements.expressions.statements.Assignment;
import org.archphantom.shenanigans.elements.expressions.statements.ForLoop;
import org.archphantom.shenanigans.elements.expressions.statements.FunctionCall;
import org.archphantom.shenanigans.elements.expressions.statements.Group;
import org.archphantom.shenanigans.elements.expressions.statements.PrintLn;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.CharValue;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.values.Value;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class ShiftIt {
	
	public static void main (String[] args) {
		ArrayList<Expression> list = new ArrayList<Expression>();
		ArrayList<String> argnames = new ArrayList<String>();
		argnames.add("a");
		ArrayList<Expression> shiftit_expr_body = new ArrayList<Expression>(3);
		shiftit_expr_body.add(new Assignment("tmp", new ArrayVariable("a", new IntValue("0"))));
		shiftit_expr_body.add(new ForLoop(new Assignment("l", new IntValue("0")), new BoolLess(new Variable("l"), new Subtraction(new Count(new Variable("a")), new IntValue("1"))), new Assignment("l", new Addition(new Variable("l"), new IntValue("1"))), new ArrayAssignment("a", new Variable("l"), new ArrayVariable("a", new Addition(new Variable("l"), new IntValue("1"))))));
		shiftit_expr_body.add(new ArrayAssignment("a", new Subtraction(new Count(new Variable("a")), new IntValue("1")), new Variable("tmp")));
		shiftit_expr_body.add(new Variable("a"));
		Group shiftit_body = new Group(shiftit_expr_body);
		Function shiftit = new Function(argnames, shiftit_body);
		list.add(new Assignment("shiftit", shiftit));
		ArrayList<Expression> arguments = new ArrayList<Expression>(1);
		ArrayList<Value> elements = new ArrayList<Value>(4);
		elements.add(new IntValue("3"));
		elements.add(new IntValue("6"));
		elements.add(new IntValue("9"));
		elements.add(new IntValue("12"));
		arguments.add(new Array(elements));
		ArrayList<Expression> to_print = new ArrayList<Expression>(2);
		to_print.add(new FunctionCall("shiftit", arguments));
		to_print.add(new CharValue('\n'));
		list.add(new PrintLn(new FunctionCall("shiftit", arguments)));
		Group group = new Group(list);
		Namespace main = new Namespace("main", group, new VarTable());
		Hashtable<String, Namespace> namespaces = new Hashtable<String, Namespace>();
		namespaces.put("main", main);
		Program p = new Program(namespaces);
		p.run();
	}

}
