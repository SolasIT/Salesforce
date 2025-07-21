package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PickList {

    WebDriver driver;
    String label;

    public PickList(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format
                ("//label[text()='%s']//ancestor::lightning-picklist//button", label))).click();
        driver.findElement(By.xpath
                (String.format("//label[text()='%s']//ancestor::lightning-picklist" +
                        "//lightning-base-combobox-item//span[text()='%s']", label, option))).click();
    }
}