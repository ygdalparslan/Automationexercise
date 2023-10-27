package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Allovercommerce {
    public Allovercommerce() {

        PageFactory.initElements(Driver.getDriver(),this);
        /*
        PageFactory.initElements() metodu,
        Page Object Model (POM) tasarım deseniyle Selenium WebDriver kullanırken kullanılan bir yöntemdir.
        Bu metod, WebElement'leri tanımlamak ve başlatmak için kullanılır.
         */
    }

    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    public WebElement homePageLogo;

    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement registerFailed;

}
