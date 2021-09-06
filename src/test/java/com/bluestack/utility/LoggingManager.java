package com.bluestack.utility;

import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * This class takes care of all the logging. Using this class, you can :
 * <ul>
 * <li>Write console logs. See {@link #getConsoleLogger()}</li>
 * <li>Write report logs. See {@link #getReportLogger()}</li>
 * </ul>
 * {@link LoggingManager} has been kept Singleton as there is only one logging
 * manager required throughout the application. In order for the report logging
 * to work, a currently executing test case must capture events such
 * {@link BeforeClass}, {@link BeforeMethod}, {@link AfterMethod} and
 * {@link AfterClass} and correspondingly inform the {@link LoggingManager} via
 * helper methods such {@link #createParentTestNode(String)},
 * {@link #createChildTestNode(String)}, {@link #clearChildTestNode()} and
 * {@link #clearParentTestNode()} respectively so as to print reports correctly.
 * 
 */
public class LoggingManager {

	private final ThreadLocal<ExtentTest> parentNodeReportLogger;
	private final ThreadLocal<ExtentTest> childNodeReportLogger;
	private final static Logger consoleLogger = Logger.getLogger(LoggingManager.class);
	private ExtentReports extentReports;

	/**
	 * 
	 * Helper class to create singleton instance of {@link LoggingManager}
	 *
	 */
	private static class LazyHolder {
		private static final LoggingManager INSTANCE = new LoggingManager();
	}

	/**
	 * 
	 * @return instance of {@link LoggingManager}
	 */
	public static LoggingManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * Returns a {@link Logger} instance to log information to console
	 *
	 * @return Logger
	 */
	public static Logger getConsoleLogger() {
		return consoleLogger;
	}
	
	private LoggingManager() {
		// Keep this constructor private to prevent LoggingManager instance creation
		parentNodeReportLogger = new ThreadLocal<ExtentTest>();
		childNodeReportLogger = new ThreadLocal<ExtentTest>();
		extentReports = ExtentManager.getExtentReportInstance();
	}


	/**
	 * Creates a parent test based on the provided name
	 *
	 * @param parentTestName
	 *            name of parent test
	 */
	public void createParentTestNode(String parentTestName) {
		ExtentTest parentTest = extentReports.createTest(parentTestName);
		parentNodeReportLogger.set(parentTest);
	}

	/**
	 * Creates a child test based on the provided name
	 *
	 * @param childTestName
	 *            name of child test
	 */
	public void createChildTestNode(String childTestName) {
		ExtentTest childTest = parentNodeReportLogger.get().createNode(childTestName);
		childNodeReportLogger.set(childTest);
	}

	/**
	 * Returns an instance of report logger to log reports
	 *
	 * @return report logger of type {@link ExtentTest}
	 */
	public static ExtentTest getReportLogger() {
		return getInstance().childNodeReportLogger.get();
	}

	/**
	 * Clear the parent test
	 */
	public void clearParentTestNode() {
		parentNodeReportLogger.remove();
	}

	/**
	 * Clear the child test
	 */
	public void clearChildTestNode() {
		childNodeReportLogger.remove();
	}

	/**
	 * Write the test report to the file
	 */
	public synchronized void writeTestReport() {
		consoleLogger.info("3456789456789678");
		extentReports.flush();
	}

	/**
	 * This method logs the test result into the extent report
	 *
	 * @param result
	 *            ITestResult instance with the current status of the test case
	 */
	public void logTestStatus(ITestResult result) {
		if(null==getReportLogger()) {
			createChildTestNode(result.getName());
		}
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				consoleLogger.info("Test case PASSED");
				getReportLogger()
						.pass(MarkupHelper.createLabel(result.getName() + "Test case PASSED", ExtentColor.GREEN));
			} else if (result.getStatus() == ITestResult.FAILURE) {
				
				getReportLogger().fail(result.getThrowable());
				getReportLogger()
						.fail(MarkupHelper.createLabel(result.getName() + "Test case FAILED", ExtentColor.RED));

			} else if (result.getStatus() == ITestResult.SKIP) {
				
				getReportLogger().skip(result.getThrowable());
				getReportLogger()
						.skip(MarkupHelper.createLabel(result.getName() + "Test case SKIPPED", ExtentColor.BLUE));

			}
			
		} finally {
			LoggingManager.getInstance().clearChildTestNode();
		}
	}
}

