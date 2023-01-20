package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegPage extends PageMethod{
    private final By nameField = By.xpath("//label[text() = 'Имя']/../input");
    private final By emailField = By.xpath("//label[text() = 'Email']/../input");
    private final By passField = By.xpath("//label[text() = 'Пароль']/../input");
    private final By regButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By passError = By.xpath("//p[text() = 'Некорректный пароль']");
    private final By loginLink = By.xpath("//*[text() = 'Войти']");



    public RegPage(WebDriver driver) {
        super(driver);
    }

    public By getLoginLink(){return loginLink;}

    public RegPage setName(String firstName)  {
       driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(firstName);
        return this;
    }

    public RegPage setEmail(String email)  {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegPage setPass(String pass)  {
        driver.findElement(passField).click();
        driver.findElement(passField).sendKeys(pass);
        return this;
    }

    public RegPage clickRegButton(){
        driver.findElement(regButton).click();
        return this;
    }

    public RegPage passErrorText(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(passError));
        return this;
    }

}
