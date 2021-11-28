package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.components.RandomFaker;
import guru.qa.helpers.Attach;
import guru.qa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RandomFaker randomFaker = new RandomFaker();

    @BeforeEach
   public void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

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
