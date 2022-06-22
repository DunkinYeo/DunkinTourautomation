package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.Test;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;

import java.util.ArrayList;
import java.util.Set;
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
            Thread.sleep(5000);

            //ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //driver.switchTo().window(tabs.get(1));
            String currentHandle= driver.getWindowHandle();
            Set<String> tabs = driver.getWindowHandles();
            for(String actual: tabs) {
                if (!actual.equalsIgnoreCase(currentHandle)) {
                    //Switch to the opened tab
                    driver.switchTo().window(actual);
                }
            }

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("For Public Automation Testing"));

            Thread.sleep(3000);
/*
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
*/
            String str = tourView.getPageSource(driver);
            System.out.println(str);
            assertTrue(str.contains("For Public Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }




    @Test(groups = {"debug", "GG"})
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

//            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
            String currentHandle= driver.getWindowHandle();
            Set<String> tabs = driver.getWindowHandles();
            for(String actual: tabs) {
                if (!actual.equalsIgnoreCase(currentHandle)) {
                    //Switch to the opened tab
                    driver.switchTo().window(actual);
                }
            }

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("For Private Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);
/*
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
*/
            String str = tourView.getPageSource(driver);
            System.out.println(str);
            assertTrue(str.contains("For Private Automation Testing"));

            Thread.sleep(3000);

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }

}
