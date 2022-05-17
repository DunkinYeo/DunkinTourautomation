package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.PrivateTourPage;
import app.pivotour.dashboard.pages.PublicTourPage;
import app.pivotour.dashboard.pages.LoginPage;
import app.pivotour.dashboard.pages.HeaderPage;

import org.openqa.selenium.WebDriver;
import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ProfileTest extends TestBase {

    @Test(groups = {"PF"})

    public void Profile() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));
        //Page loding timeout (10s)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);
            //Check Title
            HeaderPage header = new HeaderPage();
            assertEquals(header.getPageTitle(driver), "Pivo Tour Dashboard");
            //Check Public Tour Page loaded
            Thread.sleep(3000);


            //PrivateTourPage PrivateTour = new PrivateTourPage();
            //assertTrue(PrivateTour.getPageTitle(driver).contains("Private Tour"));

            //PrivateTourpage PrivateTour = new PrivateTourpage();
            //assertTrue(PrivateTour.getPageTitle(driver).contains("Private Tour"));

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }
}
