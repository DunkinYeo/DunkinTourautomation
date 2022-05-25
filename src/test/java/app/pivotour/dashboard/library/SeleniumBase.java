package app.pivotour.dashboard.library;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.startWebDriverSession;
import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;
import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.closeWebDriverSession;

/* To-Do for Selenium Grid */
public class SeleniumBase {

    public static WebDriver driver;

    // To-Do : Getting parameters from external config file
    public static PropertiesConfiguration config = null;
    public static boolean isRunningInGrid = false;

    public void openBrowser() throws MalformedURLException {
        String browser = config.getString("BROWSER");
        String chromedriverwin = config.getString("CHROMEDRIVERWIN");
        String chromedrivermac = config.getString("CHROMEDRIVERMAC");
        String ffdriverwin = config.getString("FFDRIVERWIN");
        String ffdrivermac = config.getString("FFDRIVERMAC");

        String targetEnv = System.getProperty("environment");
        String baseurl = "https://tour.pivo.app/";
        if (targetEnv != null) {
            if (targetEnv.contains("DEV")) {
                baseurl = config.getString("BASEURLDEV");
            } else if (targetEnv.contains("STAG")) {
                baseurl = config.getString("BASEURLSTAG");
            } else if (targetEnv.contains("LIVE")) {
                baseurl = config.getString("BASEURLLIVE");
            } else {
                baseurl = config.getString("BASEURLLIVE");
            }
        } else {
            baseurl = config.getString("BASEURLLIVE");
        }

        String osType = System.getProperty("os.name").toLowerCase();
        String chromedriver = null;
        String ffdriver = null;
        if (osType.contains("mac")) {
            chromedriver = chromedrivermac;
            ffdriver = ffdrivermac;
        } else if (osType.contains("win")) {
            chromedriver = chromedriverwin;
            ffdriver = ffdriverwin;
        }

        /* Local Mode*/
        switch (browser) {
            case "CH": //Chrome
                System.setProperty("webdriver.chrome.driver", chromedriver);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en");
                driver = new ChromeDriver(options);
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                System.setProperty("webdriver.gecko.driver", ffdriver);
                driver = new FirefoxDriver();
                break;
        }

        driver.get(baseurl);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Grid Mode*/
    public void openBrowserInGrid() throws MalformedURLException {
        isRunningInGrid = true;
        String hubhost = config.getString("HUBHOST");
        String browser = config.getString("BROWSER");
        String baseurl = config.getString("BASEURL");

        /* Selenium Grid Mode*/
        switch (browser) {
            case "CH": //Chrome
                ChromeOptions chromeOptions = new ChromeOptions();
                startWebDriverSession(hubhost, browser, baseurl);
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                //driver = new FirefoxDriver();
                break;
        }

        getDriver().manage().window().maximize();
    }

    public void closeBrowserInGrid() {
        try {
            closeWebDriverSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void startSeleniumServer() throws Exception {

    }

    public void stopSeleniumServer() {
        //seleniumServer.stop();
    }



}
