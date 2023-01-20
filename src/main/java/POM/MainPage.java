package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends PageMethod {
    private final By LKLink = By.xpath("//p[text() = 'Личный Кабинет']/..");
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By constrLink = By.xpath("//p[text() = 'Конструктор']/..");
    private final By logo = By.xpath("//a[@href = '/']");
    private final By panTab = By.xpath("//span[text() = 'Булки']/..");
    private final By sauceTab = By.xpath("//span[text() = 'Соусы']/..");
    private final By fillingTab = By.xpath("//span[text() = 'Начинки']/..");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public By getLoginButton() {return loginButton;}
    public By getLKLink() {return LKLink;}
    public By getConstrLink() { return constrLink;}
    public By getLogo() {return logo;}
    public By getPanTab() {return panTab;}
    public By getSauceTab() {return sauceTab;}
    public By getFillingTab() {return fillingTab;}

    public void isTabActive(By tab){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeToBe(tab,"class","tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }
}
