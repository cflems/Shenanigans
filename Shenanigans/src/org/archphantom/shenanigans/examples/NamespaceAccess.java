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
import org.archphantom.shenanigans.elements.expressions.statements.NamespaceCall;
import org.archphantom.shenanigans.elements.expressions.statements.PrintLn;
import org.archphantom.shenanigans.elements.values.Function;
import org.archphantom.shenanigans.elements.values.IntValue;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class NamespaceAccess {
	
	public static Program buildExample () {
		ArrayList<Expression> foo_body = new ArrayList<Expression>();
		Namespace foo = new Namespace("foo", new Group(foo_body), new VarTable());
		foo_body.add(new Assignment("x", new IntValue("0")));
		ArrayList<String> argNames1 = new ArrayList<String>(1);
		argNames1.add("y");
		foo_body.add(new Assignment("set", new Function(argNames1, new Assignment("foo.x", new Variable("y")))));
		ArrayList<String> argNames2 = new ArrayList<String>(2);
		argNames2.add("n");
		foo_body.add(new Assignment("inc", new Function(argNames2, new Assignment("foo.x", new Addition(new Variable("foo.x"), new Variable("n"))))));
		foo_body.add(new Assignment("show", new Function(new ArrayList<String>(0), new PrintLn(new Variable("foo.x")))));
		ArrayList<Expression> main_body = new ArrayList<Expression>();
		main_body.add(new NamespaceCall("foo"));
		ArrayList<Expression> arguments1 = new ArrayList<Expression>(1);
		arguments1.add(new IntValue("0"));
		main_body.add(new FunctionCall("foo.set", arguments1));
		ArrayList<Expression> arguments2 = new ArrayList<Expression>(1);
		arguments2.add(new IntValue("4"));
		main_body.add(new FunctionCall("foo.inc", arguments2));
		main_body.add(new FunctionCall("foo.show", new ArrayList<Expression>()));
		Namespace main = new Namespace("main", new Group(main_body), new VarTable());
		Hashtable<String, Namespace> namespaces = new Hashtable<String, Namespace>(2);
		namespaces.put("foo", foo);
		namespaces.put("main", main);
		return new Program(namespaces);		
	}
	
	public static void main (String[] args) {
		buildExample().run();
	}

}
