package tests.userStory01;

import com.github.javafaker.Faker;
import org.junit.Test;
import pages.Allovercommerce;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC01 {

    Allovercommerce allovercommerce =new Allovercommerce();
    Faker faker =new Faker();

    @Test
    public void testCase01(){//Tüm alanlar doldurulduğunda kayıt işlemi gerçekleşmeli

        //1	Verilen URL'e git
        Driver.getDriver().get(ConfigurationReader.getProperty("allovercommerceUrl"));

        //2	Register linkine tıkla
        allovercommerce.registerButton.click();

        //3	Username kutusuna bir kulanıcı adı gir
        allovercommerce.userNameBox.sendKeys(faker.name().username());

        //4	Your Email address kutusuna bir eposta gir
        allovercommerce.emailBox.sendKeys(faker.internet().emailAddress());

        //5	Password kutusuna şifre gir
        allovercommerce.passwordBox.sendKeys(faker.internet().password());

        //6	I agree to the privacy policy kutusunu işaretle
        allovercommerce.privacyPolicyCheckbox.click();

        //7	SIGN UP butonuna tıkla
        allovercommerce.signUpButton.click();

        //8	Kayıt işleminin gerçekleştiğini doğrula

    }
}
