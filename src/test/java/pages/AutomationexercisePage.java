package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationexercisePage {

    public AutomationexercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
