package org.archphantom.shenanigans.examples;
import java.util.ArrayList;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.expressions.Expression;
import org.archphantom.shenanigans.elements.expressions.Variable;
import org.archphantom.shenanigans.elements.expressions.operations.Addition;
import org.archphantom.shenanigans.elements.expressions.statements.Assignment;
import org.archphantom.shenanigans.elements.expressions.statements.FunctionCall;
import org.archphantom.shenanigans.elements.expressions.statements.Group;
import org.archphantom.shenanigans.elements.expressions.statements.PrintLn;
import org.archphantom.shenanigans.elements.values.DecimalValue;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class AddIt {
	
	public static void main (String[] args) {
		ArrayList<Expression> list = new ArrayList<Expression>();
		ArrayList<String> argnames = new ArrayList<String>();
		argnames.add("x");
		argnames.add("y");
		ArrayList<Expression> addit_expr_body = new ArrayList<Expression>();
		addit_expr_body.add(new PrintLn(new Addition(new Variable("x"), new Variable("y"))));
		Group addit_body = new Group(addit_expr_body);
		Function addit = new Function(argnames, addit_body);
		list.add(new Assignment("add_it", addit));
		ArrayList<Expression> arguments = new ArrayList<Expression>();
		arguments.add(new DecimalValue("2.6789553890921339210"));
		arguments.add(new DecimalValue("-1.8888888888888888888"));
		list.add(new FunctionCall("add_it", arguments));
		Group group = new Group(list);
		Namespace main = new Namespace("main", group, new VarTable());
		Hashtable<String, Namespace> namespaces = new Hashtable<String, Namespace>();
		namespaces.put("main", main);
		Program p = new Program(namespaces);
		System.out.println("Running...");
		p.run();
		System.out.println("Ran...");
	}

}
