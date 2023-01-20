import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static POM.URLs.BASE_URL;

public class TestBase extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
    }

    protected void after() {
        driver.quit();
    }
}
