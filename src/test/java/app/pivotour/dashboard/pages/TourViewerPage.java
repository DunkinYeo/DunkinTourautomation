package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class TourViewerPage {


    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }


    public String getPageSource(WebDriver driver) {

        return driver.findElement(By.className("tour-name")).getText();
    }
        public String getPageSource2(WebDriver driver) {

        return driver.findElement(By.className("tour-name")).getText();



    }
    public void FloorplanTest(WebDriver driver) throws Exception{

        driver.findElement(By.xpath("/html/body/div/div/section/main/div/div[5]/header/span[1]/span")).click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("/html/body/div/div/section/main/div/div[5]/header/span[1]/span")).click();

        Thread.sleep(3000);
    }
    public void DollhouseTest(WebDriver driver) throws Exception{

        driver.findElement(By.xpath("/html/body/div[1]/div/section/main/div/div[5]/header/span[2]/span")).click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("/html/body/div[1]/div/section/main/div/div[5]/header/span[2]/span")).click();

        Thread.sleep(3000);
    }

    public void SharingTourTest(WebDriver driver) throws Exception {

        driver.findElement(By.xpath("/html/body/div[1]/div/section/header/div/div/div[2]")).click();

        Thread.sleep(3000);

        ArrayList<String> pops = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(pops.get(1));

        driver.findElement(By.xpath("/html/body/div/div/div/main/div[3]/span[2]/span[1]/span[1]/span")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/div/div/main/div[3]/span[2]/span[1]/span[2]/span[2]/span/span")).click();


        Thread.sleep(3000);


    }
}

