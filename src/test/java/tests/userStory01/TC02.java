package tests.userStory01;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Allovercommerce;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC02 {

    Allovercommerce allovercommerce =new Allovercommerce();
    Faker faker =new Faker();


    @Test
    public void testCase02(){

        //1	Verilen URL'e git
        Driver.getDriver().get(ConfigurationReader.getProperty("allovercommerceUrl"));

        //2	Register linkine tıkla
        allovercommerce.registerButton.click();
        // 3 Username kutusunu boş bırak

        //4	Your Email address kutusuna bir eposta gir
        allovercommerce.emailBox.sendKeys(faker.internet().emailAddress());

        //5	Password kutusuna şifre gir
        allovercommerce.passwordBox.sendKeys(faker.internet().password());

        //6	I agree to the privacy policy kutusunu işaretle
        allovercommerce.privacyPolicyCheckbox.click();

        //7	SIGN UP butonuna tıkla
        allovercommerce.signUpButton.click();

        //8	Kayıt işleminin gerçekleşmediğini doğrula

    }



}
