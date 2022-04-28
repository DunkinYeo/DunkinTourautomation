package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.HeaderPage;
import app.pivotour.dashboard.pages.LoginPage;
import app.pivotour.dashboard.pages.SearchResultPage;
import app.pivotour.dashboard.pages.TourViewerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TourViewerTest extends TestBase {

    @Test(groups = {"smoke"})
    public void verifyTourViewerUI() {
        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);

            HeaderPage header = new HeaderPage();
            //Thread.sleep(3000);
            header.searchTour(driver, "iphone 13 2D 10p");

            Thread.sleep(3000);

            SearchResultPage search = new SearchResultPage();
            WebElement tour = search.getTourByTitle(driver, "iphone 13 2D 10p");
            tour.click();
            Thread.sleep(5000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("iphone 13 2D 10p"));
            //More asserts to be added below

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }

    public static class TourViewerTest2 extends TestBase {

        @Test(groups = {"GG"})
        public void                                verifyTourViewerUI2() {
            WebDriver driver = getDriver();
            //Go to Tour frontpage (login)
            //driver.get(config.getString("BASEURL"));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                //Input Email, Password and Click on Login button
                LoginPage login = new LoginPage();
                login.clickLogin(driver);

                HeaderPage header = new HeaderPage();
                //Thread.sleep(3000);
                header.searchTour2(driver, "80 Points 12pro 2D");

                Thread.sleep(3000);

                SearchResultPage search = new SearchResultPage();
                WebElement tour = search.getTourByTitle(driver, "80 Points 12pro 2D");
                tour.click();
                Thread.sleep(5000);

                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));

                TourViewerPage tourView = new TourViewerPage();
                System.out.println(tourView.getPageTitle(driver));
                assertTrue(tourView.getPageTitle(driver).contains("80 Points 12pro 2D"));
                //More asserts to be added below

            } catch (Exception e) {
                e.printStackTrace(System.out);
                fail("Test Case Failed!");
            }
        }


    }
}