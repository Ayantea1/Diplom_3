package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LkPage extends PageMethod{
    private final By logout = By.xpath("//*[text() = 'Выход']");

    public LkPage(WebDriver driver) {
        super(driver);
    }

    public By getLogoutLink(){
        return logout;
    }
}
