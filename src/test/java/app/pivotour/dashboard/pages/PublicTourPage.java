package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PublicTourPage   {


    public String getPageTitle(WebDriver driver)  {


        return driver.findElement(By.className("custom-header__title")).getText();
    }
    public void ClickShare (WebDriver driver)throws Exception{

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/span/span/button")).click();

        Thread.sleep(3000);



        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div/button")).click();

        Thread.sleep(3000);

    }
    public void ClickShare2 (WebDriver driver) throws Exception{

        driver.findElement(By.className("container")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/span/span/button")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div/button")).click();

        Thread.sleep(3000);
    }
}

