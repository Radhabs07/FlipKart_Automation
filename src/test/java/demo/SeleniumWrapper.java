

package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWrapper {
    public WebDriver driver;

    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement findElement(By locator){
        return driver.findElement(locator);

    }


    public void enterText(By locator, String text) throws InterruptedException{
        WebElement element = findElement(locator);
        Thread.sleep(2000);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(By by) throws InterruptedException {
        // TODO Auto-generated method stub
        WebElement element = findElement(by);
        Thread.sleep(2000);
        element.click();
    }

}