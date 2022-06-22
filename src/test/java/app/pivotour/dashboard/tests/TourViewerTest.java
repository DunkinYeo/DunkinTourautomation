package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TourViewerTest extends TestBase {


    @Test(groups = {"debug", "GG"})
    public void verifyTourViewerUI() {
        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);

            Thread.sleep(3000);

            HeaderPage header = new HeaderPage();
            //Thread.sleep(3000);
            header.searchTour(driver, "For Public Automation Testing");

            Thread.sleep(3000);

            SearchResultPage search = new SearchResultPage();
            WebElement tour = search.getTourByTitle(driver, "For Public Automation Testing");
            tour.click();
            Thread.sleep(10000);

            TourViewerPage tourView = new TourViewerPage();

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            String strTitle = tourView.getPageTitle(driver);
            System.out.println(strTitle);
            assertTrue(strTitle.contains("For Public Automation Testing"));

            Thread.sleep(5000);

            String strTourName = tourView.getPageSource(driver);
            System.out.println(strTourName);
            assertTrue(strTourName.contains("For Public Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }


    @Test(groups = {"smoke", "GG"})
    public void  verifyTourViewerUI2() {
        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);

            Thread.sleep(3000);

            HeaderPage header = new HeaderPage();
            //Thread.sleep(3000);
            header.searchTour2(driver, "For Private Automation Testing");

            Thread.sleep(3000);

            SearchResultPage search = new SearchResultPage();
            WebElement tour = search.getTourByTitle(driver, "For Private Automation Testing");
            tour.click();
            Thread.sleep(5000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            TourViewerPage tourView = new TourViewerPage();
            String strTitle = tourView.getPageTitle(driver);
            System.out.println(strTitle);
            assertTrue(strTitle.contains("For Private Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);

            String strTourName = tourView.getPageSource(driver);
            System.out.println(strTourName);
            assertTrue(strTourName.contains("For Private Automation Testing"));

            Thread.sleep(3000);

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }

}
