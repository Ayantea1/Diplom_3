package POM;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageMethod {

    public WebDriver driver;
  //  public WebDriverWait wait;

  //  public static final int TIME_OUT_IN_SECONDS_FOR_FIND_WEB_ELEMENT = 10;

    public PageMethod(WebDriver driver) {
        this.driver = driver;
      //  wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS_FOR_FIND_WEB_ELEMENT));
    }

    public void openPage(String url){
        driver.get(url);
    }

    public void isPageOpen(String url){
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.urlToBe(url));
    }

    public void clickButton (By button){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(button).click();
    }
}
