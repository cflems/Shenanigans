package org.archphantom.shenanigans.elements;
import java.util.Hashtable;
import org.archphantom.shenanigans.elements.values.Namespace;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class Program implements Runnable {
	private VarTable globalVars;
	private Hashtable<String, Namespace> namespaces;
	
	public Program (Hashtable<String, Namespace> namespaces) {
		this.globalVars = new VarTable();
		this.namespaces = namespaces;
	}
	
	public Namespace getNamespace (String name) {
		return namespaces.get(name.toLowerCase());
	}
	
	public void run () {
		Namespace ns;
		if ((ns = namespaces.get("main")) != null) {
			ns.getValue(globalVars, this);
		}
	}
	
}
