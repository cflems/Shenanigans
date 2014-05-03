package org.archphantom.shenanigans.examples;
import java.util.ArrayList;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.expressions.comparators.BoolGreater;
import org.archphantom.shenanigans.elements.expressions.statements.Assignment;
import org.archphantom.shenanigans.elements.expressions.statements.FunctionCall;
import org.archphantom.shenanigans.elements.expressions.statements.Group;
import org.archphantom.shenanigans.elements.expressions.statements.IfElse;
import org.archphantom.shenanigans.elements.expressions.statements.Print;
import org.archphantom.shenanigans.elements.values.Array;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class CheckIt {
	
	public static Program buildExample () {
		ArrayList<Expression> list = new ArrayList<Expression>();
		ArrayList<String> argnames = new ArrayList<String>();
		argnames.add("x");
		ArrayList<Expression> checkit_expr_body = new ArrayList<Expression>();
		checkit_expr_body.add(new IfElse(new BoolGreater(new Variable("x"), new IntValue("0")), new Print(new Array("True\n")), new Print(new Array("False\n"))));
		Group checkit_body = new Group(checkit_expr_body);
		Function checkit = new Function(argnames, checkit_body);
		list.add(new Assignment("checkit", checkit));
		ArrayList<Expression> arguments = new ArrayList<Expression>();
		arguments.add(new DecimalValue("298"));
		list.add(new FunctionCall("checkit", arguments));
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
