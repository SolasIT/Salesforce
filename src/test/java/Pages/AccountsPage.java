package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    private final By accounts = By.cssSelector("[title=Accounts]");
    private final By newButton = By.xpath("//div[text()='New']");
    private final By message = By.xpath("//span[contains(@class, 'toastMessage')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void accountsClick() {
        driver.findElement(accounts).click();
    }

    public void newClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newButton)).click();
    }

    public String getPopUpMessage() {
        return driver.findElement(message).getText();
    }
}