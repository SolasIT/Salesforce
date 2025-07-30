package pages;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AccountsPage extends BasePage {

    private final By accounts = By.cssSelector("[title=Accounts]");
    private final By newButton = By.xpath("//div[text()='New']");
    private final By message = By.xpath("//span[contains(@class, 'toastMessage')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage open() {
        log.info("Open Account page");
        driver.get(BASE_URL + "/lightning/o/Account/list");
        return this;
    }

    @Override
    public AccountsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(newButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public AccountsPage accountsClick() {
        log.info("Click accounts");
        driver.findElement(accounts).click();
        return this;
    }

    public NewAccountModal newClick() {
        log.info("Click New button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newButton)).click();
        return new NewAccountModal(driver);
    }

    public String getPopUpMessage() {
        return driver.findElement(message).getText();
    }
}