package vertex.CD.ExtentReportListener;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String path = System.getProperty("user.dir") 
                    + "/target/extent-report/index.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("Claim Driver Automation Report");
            spark.config().setDocumentTitle("Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Jayant");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
