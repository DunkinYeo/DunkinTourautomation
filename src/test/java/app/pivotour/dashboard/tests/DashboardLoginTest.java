//by D
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

public class DashboardLoginTest extends TestBase {

    @Test(groups = {"smoke", "login"})
    public void VerifyLogin() {
        WebDriver driver = getDriver();
        if (driver == null) {
            System.out.println("DRIVER IS NULL");
            return;
        }
        //WebDriverWait wait=new WebDriverWait(driver, 10);

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
            PublicTourPage publicTour = new PublicTourPage();
            assertTrue(publicTour.getPageTitle(driver).contains("Public Tour"));
            //assertEquals(publicTour.getPageTitle(driver), "Public Tour");


            //PrivateTourPage PrivateTour = new PrivateTourPage();
            //assertTrue(PrivateTour.getPageTitle(driver).contains("Private Tour"));

            //PrivateTourpage PrivateTour = new PrivateTourpage();
            //assertTrue(PrivateTour.getPageTitle(driver).contains("Private Tour"));

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }

    @Test(groups={"smoke", "login"})
    public void VerifyGoogleLogin() {
      WebDriver driver = getDriver();
        WebDriverWait wait=new WebDriverWait(driver, 10);

        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));
        //Page loding timeout (10s)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.GLogin(driver);
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }




    @Test(groups={"smoke", "login"})
    public void VerifyFacebookLogin() {
        WebDriver driver = getDriver();
        WebDriverWait wait=new WebDriverWait(driver, 10);
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));
        //Page loding timeout (10s)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.Flogin(driver);
            Thread.sleep(3000);

            ArrayList<String> pops = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(pops.get(0));

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }

    @Test(groups = {"smoke", "login"})
    public void VerifyAppleLogin() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));
        //Page loding timeout (10s)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.Alogin(driver);
            Thread.sleep(3000);

            ArrayList<String> pops = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(pops.get(1));

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }

}
