package com.bluestack.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static class LazyHolder {
        private static final ExtentReports INSTANCE = createInstance(new File(System.getProperty("user.dir")+"/Reports/extentreport.html"));
    }

    /**
     * Gets the single instance of ExtentManager.
     *
     * @return ExtentReports    instance of Extent Report.
     */
    public static ExtentReports getExtentReportInstance() {
        return LazyHolder.INSTANCE;
    }
    

    /**
     * Creates the instance.
     *
     * @param fileName file name.
     * @return ExtentReports    instance of Extent Report.
     */
    private static ExtentReports createInstance(File file) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(file);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Engie Test Execution Report");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        return extentReports;
    }
}
