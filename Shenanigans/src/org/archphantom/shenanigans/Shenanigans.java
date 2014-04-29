package org.archphantom.shenanigans;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Shenanigans {
	private static final String HELP_STRING = "############################### Shenanigans Help ###############################\r\n"
			+ "#                                                                              #"
			+ "# <no arguments>:             parse from standard input as Shenanigans code    #"
			+ "# -h or --HELP:               display this help message                        #"
			+ "# -f or --FILE <filename>:    parse this file as Shenanigans code              #"
			+ "#                                                                              #"
			+ "################################################################################";
	
	public static void main (String[] args) {
		try {
			boolean usefiles = false;
			ArrayList<InputStream> streams = new ArrayList<InputStream>();
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-h") || args[i].equalsIgnoreCase("--help")) {
					System.out.println(HELP_STRING);
					return;
				}
				if ((args[i].equals("-f") || args[i].equalsIgnoreCase("--file")) && (i+1) < args.length) {
					streams.add(new FileInputStream(args[i+1]));
					usefiles = true;
				}
			}
			if (usefiles) {
				parse(streams.toArray(new InputStream[] {}));
			} else {
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
		//ShenaniganParser.parse(data);
	}
	
}
