import POM.LkPage;
import POM.MainPage;
import POM.RegPage;
import com.github.javafaker.Faker;
import org.junit.Rule;
import org.junit.Test;

import static POM.URLs.*;

public class NavigationTasts {
    Faker faker = new Faker();

    @Rule
    public TestBase rule = new TestBase();

    @Test
    public void notAuthLKTest(){
        MainPage mainPage = new MainPage(rule.getDriver());
        mainPage.clickButton(mainPage.getLKLink());
        mainPage.isPageOpen(LOGIN_URL);
    }

    @Test
    public void logoutButtonTest(){
        RegPage regPage = new RegPage(rule.getDriver());
        MainPage mainPage = new MainPage(rule.getDriver());
        LkPage lkPage = new LkPage(rule.getDriver());
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
        lkPage.clickButton(lkPage.getLogoutLink());
        regPage.isPageOpen(LOGIN_URL);
    }
}
