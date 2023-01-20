
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
import static POM.URLs.LOGIN_URL;

@RunWith(Parameterized.class)
public class HeaderTests {

    private static WebDriver driver;
    Faker faker = new Faker();

    @Parameterized.Parameter()
    public By link;

    @Parameterized.Parameters
    public static Object[][] data() {
        MainPage mainPage = new MainPage(driver);
        return new Object[][]{
                {mainPage.getLogo()},
                {mainPage.getConstrLink()}
        };
    }

    @Rule
    public TestBase rule = new TestBase();

    @Test
    public void headerNaviTest(){
        RegPage regPage = new RegPage(rule.getDriver());
        MainPage mainPage = new MainPage(rule.getDriver());
        regPage.openPage(REG_URL);
        var email = faker.internet().emailAddress();
        var pass = faker.lorem().characters(6,8);
        regPage.setName(faker.name().firstName())
                .setEmail(email)
                .setPass(pass)
                .clickRegButton();
        regPage.isPageOpen(LOGIN_URL);
        regPage.setEmail(email)
                .setPass(pass);
        regPage.clickButton(regPage.getLoginLink());
        regPage.clickButton(mainPage.getLKLink());
        regPage.isPageOpen(LK_URL);
        mainPage.clickButton(link);
        mainPage.isPageOpen(BASE_URL);
    }
}
