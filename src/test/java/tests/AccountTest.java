package tests;

import dto.Account;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static dto.AccountFactory.getAccount;


public class AccountTest extends BaseTest {

    @Test(testName = "Проверка создания аккаунта")
    @Owner("Martyanova O.I")
    @Description("Проверка создания карточки аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Salesforce-1.0")
    @Feature("create account")
    @Story("Создание")
    @TmsLink("www.jira.com/ITM-343")
    @Issue("www.jira.com/ITM-5234")
    public void checkCreateAccount() {
        Account account = getAccount("Cold", "23456787654563", "4567", "Prospect",
                "Private", "Banking", "1001", "sfgs", "5765675");
        loginStep.auth("tborodich@tms.sandbox", "Password003!");
        mainPage.setWaffleButton()
                .setSalesConsoleButton();
        accountsPage.accountsClick()
                .newClick();
        accountStep.createAccount(account);
    }
}