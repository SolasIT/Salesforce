package pages;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MainPage extends BasePage {

    private final By waffleButton = By.xpath("//button[@title='App Launcher']");
    private final By salesConsoleButton = By.xpath("//span/p[text()='Sales Console']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage open() {
        log.info("Open Main page");
        driver.get(BASE_URL + "/lightning/setup/SetupOneHome/home");
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(waffleButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public MainPage setWaffleButton() {
        log.info("Click Waffle Button Menu");
        driver.findElement(waffleButton).click();
        return this;
    }

    public AccountsPage setSalesConsoleButton() {
        log.info("Click Sales Console button");
        driver.findElement(salesConsoleButton).click();
        return new AccountsPage(driver);
    }

}
