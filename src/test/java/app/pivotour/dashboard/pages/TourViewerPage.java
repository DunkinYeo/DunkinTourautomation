package app.pivotour.dashboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourViewerPage {

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

}
