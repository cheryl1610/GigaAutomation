import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GigaBookingPage {
    protected WebDriver driver;

    public GigaBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("http://localhost:5001/gigs");
    }

    public void clickMoreDetails(){
        WebElement moreDeatils = driver.findElement(By.className("details-booking"));
        WebElement moreDeatils1 = moreDeatils;
        moreDeatils1.click();

    }
    public void bookNowButton(){
        WebElement bookNow = driver.findElement(By.cssSelector("input[value='Book gig']"));
        bookNow.isDisplayed();
    }
}