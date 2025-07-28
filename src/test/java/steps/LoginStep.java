package steps;

import Pages.LoginPage;
import Pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    public LoginStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public void auth(String user, String password) {
        log.info("Login with credential: {} {}", user, password);
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
    }
}
