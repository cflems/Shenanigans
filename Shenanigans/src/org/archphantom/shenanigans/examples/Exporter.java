package org.archphantom.shenanigans.examples;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.archphantom.shenanigans.elements.Program;

public class Exporter {
	
	public static void main (String[] args) {
		Program addit = AddIt.buildExample();
		Program checkit = CheckIt.buildExample();
		Program factorial = Factorial.buildExample();
		Program factorialz = FactorialZ.buildExample();
		Program nsaccess = NamespaceAccess.buildExample();
		Program shiftit = ShiftIt.buildExample();
		Scanner s = new Scanner(System.in);
		System.out.println("Export AddIt To:");
		writeToFile(addit, s.nextLine());
		System.out.println("Export CheckIt To:");
		writeToFile(checkit, s.nextLine());
		System.out.println("Export Factorial To:");
		writeToFile(factorial, s.nextLine());
		System.out.println("Export FactorialZ To:");
		writeToFile(factorialz, s.nextLine());
		System.out.println("Export NamespaceAccess To:");
		writeToFile(nsaccess, s.nextLine());
		System.out.println("Export ShiftIt To:");
		writeToFile(shiftit, s.nextLine());
		s.close();
		System.out.println("Export complete.");
	}
	
	public static void writeToFile (Program program, String filename) {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
			stream.writeObject(program);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
