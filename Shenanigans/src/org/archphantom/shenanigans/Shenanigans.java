package org.archphantom.shenanigans;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import org.archphantom.shenanigans.elements.Program;

public class Shenanigans {
	private static final String HELP_STRING = "############################### Shenanigans Help ###############################\r\n"
			+ "#                                                                              #"
			+ "# <no arguments>:             parse from standard input as Shenanigans code    #"
			+ "# -h or --HELP:               display this help message                        #"
			+ "# -f or --FILE <file>:        parse this file as Shenanigans code              #"
			+ "# -p or --PARSED <file>:      load raw parser output into the interpreter      #"
			+ "#                                                                              #"
			+ "################################################################################";
	
	public static void main (String[] args) {
		try {
			boolean useparsed = false;
			boolean usefiles = false;
			ArrayList<InputStream> streams = new ArrayList<InputStream>();
			ArrayList<InputStream> pstreams = new ArrayList<InputStream>();
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-h") || args[i].equalsIgnoreCase("--help")) {
					System.out.println(HELP_STRING);
					return;
				}
				if ((args[i].equals("-p") || args[i].equalsIgnoreCase("--PARSED")) && (i+1) < args.length) {
					pstreams.add(new FileInputStream(args[i+1]));
					useparsed = true;
				}
				if ((args[i].equals("-f") || args[i].equalsIgnoreCase("--file")) && (i+1) < args.length) {
					streams.add(new FileInputStream(args[i+1]));
					usefiles = true;
				}
				if ((args[i].equals("-f") || args[i].equalsIgnoreCase("--file")) && (i+1) < args.length) {
					streams.add(new FileInputStream(args[i+1]));
					usefiles = true;
				}
			}
			if (useparsed) {
				for (int i = 0; i < pstreams.size(); i++) {
					try {
						ObjectInputStream oistream = new ObjectInputStream(pstreams.get(i));
						Object oread = oistream.readObject();
						if (oread instanceof Program) {
							Program p = (Program) oread;
							p.run();
						} else {
							System.err.println("Object is not valid parser output.");
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(1);
					}
				}
			}
			if (usefiles) {
				parse(streams.toArray(new InputStream[] {}));
			}
			if (!useparsed && !usefiles) {
				parse(System.in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void parse (InputStream[] streams) throws IOException {
		for (InputStream stream : streams) {
			parse(stream);
		}
	}
	
	public static void parse (InputStream stream) throws IOException {
		String data = "";
		int b;
		while ((b = stream.read()) != -1) {
			data += (char) b;
		}
		// Interact with parser
	}
	
}
