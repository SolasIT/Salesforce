package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    private final By SCROLL_TO_ELEMENT = By.xpath("//span[text()='Description']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String rating, String name, String phone, String fax, String number, String website,
                              String accountSite, String symbol, String type, String ownership, String industry,
                              String employees, String revenue, String code, String billingStreet,
                              String shippingStreet) {

        new PickList(driver, "Rating").select(rating);
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Input(driver, "Account Number").write(number);
        new Input(driver, "Account Site").write(accountSite);
        new Input(driver, "Ticker Symbol").write(symbol);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(revenue);
        new Input(driver, "SIC Code").write(code);
        new PickList(driver, "Type").select(type);
        new PickList(driver, "Industry").select(industry);
        new PickList(driver, "Ownership").select(ownership);
        new TextArea(driver, "Billing Street").write(billingStreet);
        new TextArea(driver, "Shipping Street").write(shippingStreet);
        new Checkbox(driver, "VIP Client").check();
        new Checkbox(driver, "TeachMeSkills").check();
    }

    public void saveButton() {
        driver.findElement(saveButton).click();
    }
}