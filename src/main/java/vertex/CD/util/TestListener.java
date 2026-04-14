package vertex.CD.util;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

    Logger log = Log.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("===== Test Suite Started: " + context.getName() + " =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("===== Test Suite Finished =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("FAILED: " + result.getMethod().getMethodName());
        log.error("Reason: ", result.getThrowable());
        try {
    		TestUtil.captureScreen(result.getMethod().getMethodName());
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
     // Log retry info
        if (result.getMethod().getRetryAnalyzer(result) != null) {
        	log.error("Test was retried: " + result.getMethod().getMethodName()); 
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("SKIPPED: " + result.getMethod().getMethodName());
    }
}
