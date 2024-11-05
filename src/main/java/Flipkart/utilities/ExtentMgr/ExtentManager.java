package Flipkart.utilities.ExtentMgr;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
        private static ExtentReports extentReports;
        private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

        public static void createTest(String testName) {
            if (extentReports == null) {
                extentReports = new ExtentReports();
                // Configure ExtentReports (e.g., attach appenders)
            }
            ExtentTest test = extentReports.createTest(testName);
            extentTest.set(test);
        }

        public static ExtentTest getTest() {
            return extentTest.get();
        }

        public static void flush() {
            if (extentReports != null) {
                extentReports.flush();
            }
        }
    }



