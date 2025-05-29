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

public class GigaGigsTest {
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
    public void shouldGotoBandPageFromClickThrough() {

        giga.clickBand("Placebo");
        assertEquals("Placebo: Gig Dates", driver.getTitle());
    }

    @Test
    public void gigsInChronologicalOrder() {
        assertTrue(giga.getDateOfGig(1).isBefore(giga.getDateOfGig(2)));
        assertTrue(giga.getDateOfGig(2).isBefore(giga.getDateOfGig(3)));
    }

    @Test
    public void verifyGigDetails(){
        WebElement gig = driver.findElement(By.cssSelector("body div[id='page-content'] div[class='container-fluid'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        assertTrue(gig.getText().contains("Placebo"));
        assertTrue(gig.getText().contains("Brixton Academy"));
        assertTrue(gig.getText().contains("London"));
        assertTrue(gig.getText().contains("When: 2025-06-04 19:30"));

    }
    //@Test
//    public void shouldFilterLocationCompare () throws Exception {
//        giga.filterLocation("All");
//        List<WebElement> gigsBefore = driver.findElements(By.("gig"));
//        giga.takeScreenshot(driver, "beforefilter.png");
//        int countBefore = gigsBefore.size();
//        System.out.println(gigsBefore.size());
//        giga.filterLocation("Cambridge");
//
//        List<WebElement> gigsAfter = driver.findElements(By.("gig"));
//        giga.takeScreenshot(driver, "afterfilter.png");
//       int countAfter = gigsAfter.size();
//        System.out.println(gigsAfter.size());
//       assertTrue(countBefore > countAfter);
    // Cant locate the right elements

}