package com.bluestack.utility;
import org.apache.log4j.Logger;
import org.testng.*;

public class CustomTestNGListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
	static Logger log = Logger.getLogger(CustomTestNGListener.class);
    // This belongs to ISuiteListener and will execute before the Suite start
    public void onStart(ISuite arg0) {
        
    }

    // This belongs to ISuiteListener and will execute, once the Suite is finished
    public void onFinish(ISuite arg0) {
        
    }

    // This belongs to ITestListener and will execute before starting of Test set/batch
    public void onStart(ITestContext arg0) {
        
    }

    // This belongs to ITestListener and will execute, once the Test set/batch is finished
    public void onFinish(ITestContext arg0) {
      
    }

    // This belongs to ITestListener and will execute only when the test is pass
    public void onTestSuccess(ITestResult arg0) {
    	LoggingManager.getInstance().logTestStatus(arg0);
        
        printTestResults(arg0);
    }

    // This belongs to ITestListener and will execute only on the event of fail test
    public void onTestFailure(ITestResult arg0) {
    	LoggingManager.getInstance().logTestStatus(arg0);
        printTestResults(arg0);
    }

    // This belongs to ITestListener and will execute before the main test start (@Test)
    public void onTestStart(ITestResult arg0) {
    }

    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult arg0) {
    	LoggingManager.getInstance().logTestStatus(arg0);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    // This is the method which will be executed in case of test pass or fail
    // This will provide the information on the test
    private void printTestResults(ITestResult result) {
    	log.info("Test Method resides in " + result.getTestClass().getName());
    
        if (result.getParameters().length != 0) {
            String params = null;
            for (Object parameter : result.getParameters()) {
                params += parameter.toString() + ",";
            }
            log.info("Test Method had the following parameters : " + params);
        }

        String status = null;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;
            case ITestResult.FAILURE:
                status = "Failed";
                break;
            case ITestResult.SKIP:
                status = "Skipped";
        }
        log.info("Test Status: " + status);
    }

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
        log.info(textMsg);
    }

    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
        log.info(textMsg);
    }

    // This will return method names to the calling function
    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }
}