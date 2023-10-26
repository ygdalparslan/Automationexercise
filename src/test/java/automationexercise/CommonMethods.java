package automationexercise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

    WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public CommonMethods() {
    }

    public void launchBrowserAndNavigate(String url) {
        driver.get(url);
    }

    public void verifyElementIsVisible(By locator) {
        WebElement element = driver.findElement(locator);
        assert element.isDisplayed();
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void waitFor(int sec) {

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyData(String expected, By locator) {

        String actualData = driver.findElement(locator).getText();
        Assert.assertEquals(expected, actualData);

    }


}
