package tests;

import Pages.AccountsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.NewAccountModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import steps.AccountStep;
import steps.LoginStep;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    AccountsPage accountsPage;
    MainPage mainPage;
    NewAccountModal newAccountModal;
    LoginStep loginStep;
    AccountStep accountStep;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Настройка драйвера")
    public void setUp(@Optional("chrome") String browser, ITestContext iTestContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        mainPage = new MainPage(driver);
        newAccountModal = new NewAccountModal(driver);
        accountStep = new AccountStep(driver);
        loginStep = new LoginStep(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}