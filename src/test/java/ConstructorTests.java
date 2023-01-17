import POM.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@RunWith(Parameterized.class)
public class ConstructorTests {
    private static WebDriver driver;


    @Parameterized.Parameter()
    public By tab;

    @Parameterized.Parameters
    public static Object[][] data() {
        MainPage mainPage = new MainPage(driver);
        return new Object[][]{
                {mainPage.getPanTab()},
                {mainPage.getSauceTab()},
                {mainPage.getFillingTab()},
        };
    }

    @Rule
    public TestBase rule = new TestBase();

    @Test
    public void constructorNaviTest() {
        MainPage mainPage = new MainPage(rule.getDriver());
        if (tab.equals(mainPage.getPanTab()))
        {mainPage.clickButton(mainPage.getFillingTab());
        }
        mainPage.clickButton(tab);
        mainPage.isTabActive(tab);
    }
}
