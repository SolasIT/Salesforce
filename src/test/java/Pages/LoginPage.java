package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By login = By.id("username");
    private final By password = By.id("password");
    private final By loginButton = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String username, String password) {
        driver.findElement(login).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}