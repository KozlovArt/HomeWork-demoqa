package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.DemoqaConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void setUp() {
        DemoqaConfig config = ConfigFactory.create(DemoqaConfig.class, System.getProperties());
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemoteUrl();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
