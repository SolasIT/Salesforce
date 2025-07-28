package steps;

import Pages.NewAccountModal;
import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountStep {

    WebDriver driver;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountModal = new NewAccountModal(driver);
    }

    public void createAccount(Account account) {
        log.info("Create  new account with name: {}", account.getName());
        newAccountModal.open()
                .isPageOpened()
                .createAccount(account)
                .saveButton()
                .isPageOpened();
    }
}
