package automationexercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02 {

    WebDriver driver;
    CommonMethods commonMethods;
    Faker faker = new Faker();

    @Before
    public void setup() {
        //    1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        commonMethods = new CommonMethods(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void loginUser() {
        //2. Navigate to url 'http://automationexercise.com'
        commonMethods.launchBrowserAndNavigate("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        commonMethods.verifyElementIsVisible(By.xpath("//img[@src='/static/images/home/logo.png']"));

        //4. Click on 'Signup / Login' button
        commonMethods.clickElement(By.xpath("//a[text()=' Signup / Login']"));

        //5. Verify 'Login to your account' is visible
        commonMethods.verifyElementIsVisible(By.xpath("//h2[text()='Login to your account']"));

        //6. Enter correct email address and password
        commonMethods.enterText(By.xpath("//input[@data-qa='login-email']"), "aceson.essiah@free2ducks.com");//aceson.essiah@free2ducks.com
        commonMethods.enterText(By.xpath("//input[@data-qa='login-password']"), "Alp135+");//Alp135+ -- usurname:Alp135

        //7. Click 'login' button
        commonMethods.clickElement(By.xpath("//button[@data-qa='login-button']"));
        commonMethods.waitFor(3);

        //8. Verify that 'Logged in as username' is visible
        commonMethods.verifyData("Logged in as Alp135",By.xpath("//a[text()=' Logged in as ']"));

        //9. Click 'Delete Account' button
        commonMethods.clickElement(By.xpath("//a[@href='/delete_account']"));

        //10. Verify that 'ACCOUNT DELETED!' is visible
        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        commonMethods.verifyData("ACCOUNT DELETED!",By.xpath("//h2[@data-qa='account-deleted']"));
        commonMethods.clickElement(By.xpath("//a[@data-qa='continue-button']"));
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
