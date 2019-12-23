package lesson10.labsolns.prob1.bugreporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Logger;

import lesson10.labsolns.prob1.classfinder.ClassFinder;



/**
 * This class scans the package lesson10.labsolns.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.labsolns.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report2.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		//Maps developer name to list of bug reports for that developer
		HashMap<String, List<String>> reporterMap = new HashMap<>();
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				String name = annotation.assignedTo();
				List<String> listOfReports = null;
				if(!reporterMap.containsKey(name)) {
					listOfReports = new ArrayList<String>();
					reporterMap.put(name, listOfReports);
				} else {
					listOfReports = reporterMap.get(name);
				}
				StringBuilder sb = new StringBuilder();
				sb.append("   " + REPORTED_BY + annotation.reportedBy() + "\n");
				sb.append("   " + CLASS_NAME + cl.getName()+ "\n");
				sb.append("   " + DESCRIPTION + annotation.description() + "\n");
				sb.append("   " + SEVERITY + annotation.severity() + "\n\n");
				listOfReports.add(sb.toString());				
			}
		}
		String report = assembleReport(reporterMap);
		try {
			writeReport(report);
		} catch(IOException e) {
			LOG.severe("IOException thrown when writing file: " + e.getMessage());
		}		
	}
	
	private String assembleReport(HashMap<String, List<String>> reports) {
		StringBuilder sb = new StringBuilder();
		for(HashMap.Entry<String, List<String>> e : reports.entrySet()) {
			sb.append(e.getKey()+"\n");  //name
			List<String> value = e.getValue();
			for(String report : value) {
				sb.append(report);
			}
		}
		return sb.toString();
	}
	private void writeReport(String output) throws IOException {
		File reportFile = new File(REPORT_NAME);
		try(PrintWriter pw = new PrintWriter(new FileWriter(reportFile))) {
			pw.println(output);	
		}
	}
}
