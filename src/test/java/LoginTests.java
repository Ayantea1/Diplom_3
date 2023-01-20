import POM.MainPage;
import POM.RegPage;
import com.github.javafaker.Faker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static POM.URLs.*;

@RunWith(Parameterized.class)
public class LoginTests {

    Faker faker = new Faker();
    private static WebDriver driver;


    @Parameterized.Parameter()
    public String api;
    @Parameterized.Parameter(1)
    public By loginButton;

    @Parameterized.Parameters
    public static Object[][] data() {
        RegPage regPage = new RegPage(driver);
        MainPage mainPage = new MainPage(driver);
        return new Object[][]{
                {BASE_URL, mainPage.getLoginButton()},
                {BASE_URL, mainPage.getLKLink()},
                {REG_URL, regPage.getLoginLink()},
                {PASS_URL, regPage.getLoginLink()}
        };
    }

    @Rule
    public TestBase rule = new TestBase();

    @Test
    public void successLoginTest(){
        RegPage regPage = new RegPage(rule.getDriver());
        MainPage mainPage = new MainPage(rule.getDriver());
        regPage.openPage(REG_URL);
        var email = faker.internet().emailAddress();
        var pass = faker.lorem().characters(6,8);
        regPage.setName(faker.name().firstName())
                .setEmail(email)
                .setPass(pass)
                .clickRegButton();
        regPage.openPage(api);
        regPage.clickButton(loginButton);
        regPage.setEmail(email)
                .setPass(pass);
        regPage.clickButton(regPage.getLoginLink());
        regPage.isPageOpen(BASE_URL);
        regPage.clickButton(mainPage.getLKLink());
        regPage.isPageOpen(LK_URL);
    }

}
