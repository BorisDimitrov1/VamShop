package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Browser {

    public static final String CHROME_DRIVER_PATH = System.getProperties().getProperty("user.dir") + "/drivers/chromedriver.exe";
    public static String downloadsPath = System.getProperties().getProperty("user.dir") + "\\downloads";

    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public static void openBrowser() throws Exception {

        switch (System.getProperty("browser")){
            case "chrome":
                initChrome();
                break;
            default:
                throw new Exception("No such browser");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private static void initChrome(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadsPath);

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-gpu"); // applicable to Windows os only
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
    }


    public static void tearDown(){
        Browser.getDriver().quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
