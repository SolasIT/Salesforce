package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By waffleButton = By.xpath("//button[@title='App Launcher']");
    private final By salesConsoleButton = By.xpath("//span/p[text()='Sales Console']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setWaffleButton() {
        driver.findElement(waffleButton).click();
    }

    public void setSalesConsoleButton() {
        driver.findElement(salesConsoleButton).click();
    }

}
