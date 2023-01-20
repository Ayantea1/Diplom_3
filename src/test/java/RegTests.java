import POM.RegPage;
import com.github.javafaker.Faker;
import org.junit.Rule;
import org.junit.Test;


import static POM.URLs.*;

public class RegTests {
    Faker faker = new Faker();

    @Rule
    public TestBase rule = new TestBase();

    @Test
    public void successRegTest(){
        RegPage regPage = new RegPage(rule.getDriver());
        regPage.openPage(REG_URL);
        regPage.setName(faker.name().firstName())
        .setEmail(faker.internet().emailAddress())
        .setPass(faker.lorem().characters(6,8))
        .clickRegButton();
        regPage.isPageOpen(LOGIN_URL);
    }

    @Test
    public void badPassTest(){
        RegPage regPage = new RegPage(rule.getDriver());
        regPage.openPage(REG_URL);
        regPage.setName(faker.name().firstName())
                .setEmail(faker.internet().emailAddress())
                .setPass(faker.lorem().characters(1,5))
                .clickRegButton()
                .passErrorText();
    }
}
