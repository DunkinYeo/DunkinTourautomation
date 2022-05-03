package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
}

