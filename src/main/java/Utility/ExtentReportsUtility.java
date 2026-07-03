package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility {

	public static ExtentReports extent;

	public static ExtentReports getReportObject() {

		String path = "./Reports/ExtentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("VTiger Automation Report");
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Tanu");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");

		return extent;
	}

}
