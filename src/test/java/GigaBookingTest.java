import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GigaBookingTest {
    private static ChromeDriver driver;
    GigaGigsPage giga;


    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();

    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @BeforeEach
    void beforeEach() {
        giga = new GigaGigsPage(driver);
        giga.navigate();
    }
    @Test
    public void ShouldGoToBookingPage() throws Exception {
        WebElement detail = driver.findElement(By.cssSelector("a[href='/gigs/1']"));
        detail.click();
        giga.takeScreenshot (driver, "afterclick.png");
        String gigPage = driver.getCurrentUrl();
        assertTrue(gigPage.startsWith("http://localhost:5001/gigs/"));
    }
    @Test
    public void loggedOutUserViewBooking() throws Exception {
        WebElement account = driver.findElement(By.linkText("Account"));
        account.click();
        giga.takeScreenshot (driver, "accountPage.png");
        String accountPage = driver.getTitle();
        assertEquals("401 Unauthorised",accountPage);
    }


}