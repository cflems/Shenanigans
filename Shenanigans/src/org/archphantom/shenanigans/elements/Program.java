package org.archphantom.shenanigans.elements;
import java.io.Serializable;
import java.util.Hashtable;

import org.archphantom.shenanigans.elements.expressions.statements.NamespaceCall;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Program implements Runnable, Serializable {
	private static final long serialVersionUID = 4309390632410676282L;
	private VarTable globalVars;
	private Hashtable<String, Namespace> namespaces;
	
	public Program (Hashtable<String, Namespace> namespaces) {
		this.globalVars = new VarTable();
		this.namespaces = namespaces;
	}
	
	public Namespace getNamespace (String name) {
		return namespaces.get(name.toLowerCase());
	}
	
	public VarTable getGlobalVars () {
		return globalVars;
	}
	
	public void run () {
		new NamespaceCall("main").evaluate(globalVars, this);
	}
	
}
