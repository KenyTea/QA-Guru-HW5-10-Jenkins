package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.components.RandomFaker;
import guru.qa.helpers.Attach;
import guru.qa.pages.RegistrationPage;
import guru.qa.tests.config.PropertiesConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RandomFaker randomFaker = new RandomFaker();
    public PropertiesConfig properties = ConfigFactory.create(PropertiesConfig.class);
    private final String url = properties.url();
    private final String login = properties.login();
    private final String password = properties.password();

    @BeforeEach
   public void setup() {
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = format("https://%s:%s@%s", login, password, url);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

//    @AfterEach
//    public void getAttach() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.browserConsoleLogs();
//        Attach.pageSource();
//        Attach.addVideo();
//    }
}
