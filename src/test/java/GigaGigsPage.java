import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GigaGigsPage {
    protected WebDriver driver;

    public GigaGigsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception {
        TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }

    public void navigate() {
        driver.get("http://localhost:5001/gigs");
    }

    public void clickBand(String bandName) {
        driver.findElement(By.linkText(bandName)).click();
    }

    public LocalDateTime getDateOfGig(int index) {
        String dateElement = driver.findElement(By.cssSelector("body div[id='page-content'] div[class='container-fluid'] div:nth-child(" + index + ") div:nth-child(1) div:nth-child(1) p:nth-child(2)")).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateElement.replace("When: ", ""), formatter);
    }

    public  void filterLocation(String location){
        WebElement locationDropDown = driver.findElement(By.id("location"));
        Select select = new Select(locationDropDown);
        select.selectByVisibleText(location);
        WebElement applyFilter = driver.findElement(By.cssSelector("input[value='Apply filter(s)']"));
        applyFilter.click();


    }

    public int getNumberOfGigs(int number){
        return driver.findElements(By.className("gig")).size();

    }

}
