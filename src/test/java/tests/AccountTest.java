package tests;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {

        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password003!");
        mainPage.setWaffleButton();
        mainPage.setSalesConsoleButton();
        accountsPage.accountsClick();
        accountsPage.newClick();
        newAccountModal.createAccount("Cold", "Olga", "7977475435", "23456787654563",
                "4567", "test.com", "ts.com", "456", "Prospect",
                "Private", "Banking", "1001", "1634345", "23",
                "1str", "weebstre");
        newAccountModal.saveButton();

    }
}