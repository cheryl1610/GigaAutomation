import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GigaAccountPage {
    protected WebDriver driver;

    public GigaAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("http://localhost:5001/home");
    }

    public void logInTab (){
        WebElement logIn = driver.findElement(By.linkText("Log in"));
    }
}