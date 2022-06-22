package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ViewerDetailTest extends TestBase {

    @Test(groups = {"smoke", "VD"})
    public void FloorplanTest(){

   // /html/body/div[1]/div/section/main/div/div[5]/header/span[1]/span

    WebDriver driver = getDriver();
    //Go to Tour frontpage (login)
    //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        TourViewerPage tourView = new TourViewerPage();
        System.out.println(tourView.getPageTitle(driver));
        assertTrue(tourView.getPageTitle(driver).contains("For Public Automation Testing"));

        Thread.sleep(3000);
/*
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
*/
        System.out.println(tourView.getPageSource(driver));
        assertTrue(tourView.getPageSource(driver).contains("For Public Automation Testing"));
        //More asserts to be added below

        Thread.sleep(3000);

        //TourViewerPage FloorplanTest = new TourViewerPage();
        //FloorplanTest.FloorplanTest(driver);
        tourView.FloorplanTest(driver);

        Thread.sleep(1000);

    } catch (Exception e) {
        e.printStackTrace(System.out);
        fail("Test Case Failed!");
    }
}

    @Test(groups = {"smoke", "VD"})
    public void DollhouseTest(){

        // /html/body/div[1]/div/section/main/div/div[5]/header/span[1]/span

        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("For Public Automation Testing"));

            Thread.sleep(3000);
/*
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
*/
            System.out.println(tourView.getPageSource(driver));
            assertTrue(tourView.getPageSource(driver).contains("For Public Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);


            //TourViewerPage DollhouseTest = new TourViewerPage();
            //DollhouseTest.DollhouseTest(driver);

            tourView.DollhouseTest(driver);

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }

    @Test(groups = {"debug", "VD"})
    public void SharingTourTest(){

        // /html/body/div[1]/div/section/main/div/div[5]/header/span[1]/span

        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("For Public Automation Testing"));

            Thread.sleep(3000);

/*
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
*/
            System.out.println(tourView.getPageSource(driver));
            assertTrue(tourView.getPageSource(driver).contains("For Public Automation Testing"));
            //More asserts to be added below

            Thread.sleep(3000);


            //TourViewerPage SharingTourTest = new TourViewerPage();
            //SharingTourTest.SharingTourTest(driver);
            tourView.SharingTourTest(driver);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail("Test Case Failed!");
        }
    }
}
