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

public class GigaAccountTest {
    private static ChromeDriver driver;
    GigaAccountPage giga;


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
        giga = new GigaAccountPage(driver);
        giga.navigate();
    }
    @Test
    public void logInBlank() throws Exception {
        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        logInButton.click();
        String failLogIn = driver.getTitle();
        assertEquals("401 Unauthorised",failLogIn);
    }
    @Test

    public void loginValidInput(){
        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("username");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        logInButton.click();
        String sucessfullLogIn = driver.getTitle();
        assertEquals("Welcome to Giga",sucessfullLogIn);
    }
    @Test
    public void loginInvalidPassword () {

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("username");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password!");
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        logInButton.click();
        String failLogIn = driver.getTitle();
        assertEquals("401 Unauthorised", failLogIn);
    }




}