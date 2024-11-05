package Flipkart.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Using File.separator for compatibility with all OSes
        String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
        String screenshotPath = screenshotDir + File.separator + testName + "_" + timestamp + ".png";

        try {
            // Ensure the "screenshots" directory exists
            File screenshotFolder = new File(screenshotDir);
            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs(); // Creates the directory if it doesn't exist
            }
            FileUtils.copyFile(srcFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}

