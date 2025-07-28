package Pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

@Log4j2
public class NewAccountModal extends BasePage {

    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    private final By SCROLL_TO_ELEMENT = By.xpath("//span[text()='Description']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal open() {
        log.info("Open New account creator");
        driver.get(BASE_URL + "/lightning/o/Account/new");
        return this;
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public NewAccountModal createAccount(Account account) {
        log.info("Create new account");
        new PickList(driver, "Rating").select(account.getRating());
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Account Number").write(account.getNumber());
        new Input(driver, "Account Site").write(account.getAccountSite());
        new Input(driver, "Ticker Symbol").write(account.getSymbol());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getRevenue());
        new Input(driver, "SIC Code").write(account.getCode());
        new PickList(driver, "Type").select(account.getType());
        new PickList(driver, "Industry").select(account.getIndustry());
        new PickList(driver, "Ownership").select(account.getOwnership());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Checkbox(driver, "VIP Client").check();
        new Checkbox(driver, "TeachingSkills").check();
        return this;
    }

    public AccountsPage saveButton() {
        log.info("Click Save bautton");
        driver.findElement(saveButton).click();
        return new AccountsPage(driver);
    }
}