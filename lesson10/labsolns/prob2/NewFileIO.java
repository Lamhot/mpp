package lesson10.labsolns.prob2;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;



public class NewFileIO {
	private static final Logger LOG = Logger.getLogger(NewFileIO.class.getName());
	public final static String FILE_NAME = "output4.txt";
	public final static String TO_PRINT = "This is the string to print to file.";
	
	void writeText(String filename, String text) {
		
		try(PrintWriter writer 
			   = new PrintWriter(new FileWriter(getFullPathToOutput(filename)))) {
		   writer.print(text);
		} catch(IOException e) {
			LOG.warning("IOException attempting to write a file: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except -> LOG.warning("Suppressed message: " 
			                                         + except.getMessage()));
		} 
	}
	
	private File getFullPathToOutput(String filename) {
		
		//This path starts one level below "src" in source code
		String pkge = asPath(getClass().getPackage().getName());
		pkge = "src/" + pkge;  //use "bin/" includes output in bin 
		return new File(pkge, filename);
	}
	private String asPath(String packageName) {
		//replace dots with '/'
		return packageName.replace('.','/');
	}
	
	public static void main(String[] args) {
		NewFileIO nfi = new NewFileIO();
	    nfi.writeText(FILE_NAME, TO_PRINT);
		
	}

}
