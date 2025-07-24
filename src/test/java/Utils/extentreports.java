package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreports {
        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
                spark.config().setReportName("Accion Mobile Test Report");
                spark.config().setDocumentTitle("Automation Report");

                extent = new ExtentReports();
                extent.attachReporter(spark);
                extent.setSystemInfo("Environment", "Production");
                extent.setSystemInfo("QA Engineer", "Ikechukwu Sydney");
            }
            return extent;




        }
    }





