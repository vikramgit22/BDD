package BaseDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return webDriverThreadLocal.get();
    }

    public static void setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
               setupChromeDriver();
                break;
            case "firefox":
                setupFirefoxDriver();
                break;
            case "edge":
               setupEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static void setupChromeDriver() {
        WebDriverManager.chromedriver().driverVersion("113.0.5672.63").setup();
        //WebDriverManager.chromedriver().setup();
        webDriverThreadLocal.set(new ChromeDriver());
    }

    private static void setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        webDriverThreadLocal.set(new FirefoxDriver());
    }

    private static void setupEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        webDriverThreadLocal.set(new EdgeDriver());
    }
       public static void quitDriver()
        {
            getDriver().quit();
            webDriverThreadLocal.remove();
        }


}
