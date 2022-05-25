//by D
package app.pivotour.dashboard.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    public void clickLogin(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //email field
        //driver.findElement(By.cssSelector("#app > div > div > div > form > div:nth-child(1) > div > div > input")).sendKeys("Test@3i.ai");
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Test@3i.ai");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div/div[1]/input")).sendKeys("3iDev8593");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/button")).click();

    }

    public void GLogin(WebDriver driver) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("svg.google.social-icon")).click();
        Thread.sleep(5000);
        //password field;

        ArrayList<String> pops = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(pops.get(1));

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")).sendKeys("Test@3i.ai");
        //Click Login button

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("3iDev8593");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();


    }


    public void Flogin(WebDriver driver) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("svg.facebook.social-icon")).click();
        Thread.sleep(5000);
        //password field
        ArrayList<String> pops = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(pops.get(1));
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[1]/div/input")).sendKeys("rpivo164@gmail.com");
        //Click Login button

        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[2]/div/input")).sendKeys("QweAsd!23");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[3]/label[2]/input")).click();

    }

    public void Alogin(WebDriver driver) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("svg.apple.social-icon")).click();
        Thread.sleep(5000);
        //password field
        ArrayList<String> pops = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(pops.get(1));
        driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/div[1]/div/div/div[1]/div/div/input")).sendKeys("Test@3i.ai");
        driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/button[1]")).click();

        Thread.sleep(5000);
        //Click Login button


        driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/div[1]/div/div/div[2]/div/div/input")).sendKeys("3!Dev8593");
        driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/button[1]")).click();
    }
}
