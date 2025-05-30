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
        password.sendKeys("fred");
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        logInButton.click();
        String failLogIn = driver.getTitle();
        assertEquals("401 Unauthorised", failLogIn);
    }


    @Test
    public void loginNonExistentUser () {

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("cheryl");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("fred");
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        logInButton.click();
        String failLogIn = driver.getTitle();
        assertEquals("401 Unauthorised", failLogIn);
    }
    @Test
    public void signupValid () {

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement signUp = driver.findElement((By.linkText("Sign Up")));
        signUp.click();
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("username123");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("password!");
        WebElement confirmPassword = driver.findElement(By.cssSelector("#confirm_password"));
        confirmPassword.sendKeys("password!");
        WebElement signUpButton = driver.findElement(By.cssSelector("input[type='submit'][value='Sign up']"));
        signUpButton.click();
        String LogIn = driver.getTitle();
        assertEquals("Log In",LogIn);
    }
    @Test
    public void signupInValidPassComplex () throws Exception {

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
        WebElement signUp = driver.findElement((By.linkText("Sign Up")));
        signUp.click();
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("username123");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("pass");
        WebElement confirmPassword = driver.findElement(By.cssSelector("#confirm_password"));
        confirmPassword.sendKeys("pass");
        WebElement signUpButton = driver.findElement(By.cssSelector("input[type='submit'][value='Sign up']"));
        signUpButton.click();
        GigaGigsPage.takeScreenshot (driver, "signPage.png");
        String failLogIn = driver.getTitle();
        assertEquals("Sign Up", failLogIn);
    }
}