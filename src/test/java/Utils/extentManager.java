package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class extentManager {
    public   static ExtentReports extent;

    public static class ExtentManager {

        private static ExtentReports extent;
        public static ExtentReports getInstance() {
            if (extent == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
                spark.config().setReportName("Automation Report");
                spark.config().setDocumentTitle("Test Summary");

                extent = new ExtentReports();
                extent.attachReporter(spark);
                extent.flush();
            }
            return extent;

        }
    }

}
