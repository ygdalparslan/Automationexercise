package automationexercise;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.time.Duration;

public class TestCase01 {

    WebDriver driver;
    CommonMethods commonMethods;
    Faker faker =new Faker();

    @Before
    public void setup() {
        //    1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        commonMethods =new CommonMethods(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test()
    public void registerUser() throws InterruptedException {
        Actions actions =new Actions(driver);
        //    2. Navigate to url 'http://automationexercise.com'
        commonMethods.launchBrowserAndNavigate("http://automationexercise.com");

        //    3. Verify that home page is visible successfully
        commonMethods.verifyElementIsVisible(By.xpath("//img[@src='/static/images/home/logo.png']"));

        //    4. Click on 'Signup / Login' button
        commonMethods.clickElement(By.xpath("//a[text()=' Signup / Login']"));

        //    5. Verify 'New User Signup!' is visible
        commonMethods.verifyElementIsVisible(By.xpath("//h2[text()='New User Signup!']"));

        //    6. Enter name and email address
        String userName=faker.name().username();
        commonMethods.enterText(By.xpath("//input[@data-qa='signup-name']"),userName);
        commonMethods.enterText(By.xpath("//input[@data-qa='signup-email']"),faker.internet().emailAddress());

        //    7. Click 'Signup' button
        commonMethods.clickElement(By.xpath("//button[@data-qa='signup-button']"));

        //    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        commonMethods.verifyElementIsVisible(By.xpath("//b[text()='Enter Account Information']"));

        //    9. Fill details: Title, Name, Email, Password, Date of birth
        commonMethods.clickElement(By.xpath("//div[@id='uniform-id_gender1']"));
                        actions.sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB)
                        .sendKeys("12345")
                        .sendKeys(Keys.TAB)
                        .sendKeys("1")
                        .sendKeys(Keys.TAB)
                        .sendKeys("April")
                        .sendKeys(Keys.TAB)
                        .sendKeys("1978")
                        .sendKeys(Keys.TAB)
                        .click().perform();

        //10. Select checkbox 'Sign up for our newsletter!'
        commonMethods.clickElement(By.xpath("//div[@id='uniform-id_gender1']"));
        commonMethods.waitFor(5);
        actions.sendKeys(Keys.TAB)
        .click().perform();//11. Select checkbox 'Receive special offers from our partners!'

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        commonMethods.enterText(By.id("first_name"),faker.name().firstName());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("cad cadde no 55")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Samsun")
                .sendKeys(Keys.TAB)
                .sendKeys("Samsun")
                .sendKeys(Keys.TAB)
                .sendKeys("55400")
                .sendKeys(Keys.TAB)
                .sendKeys("5551254568")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();//    13. Click 'Create Account button'

        //    14. Verify that 'ACCOUNT CREATED!' is visible
        commonMethods.verifyData("ACCOUNT CREATED!",By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b"));

        //    15. Click 'Continue' button
        commonMethods.clickElement(By.xpath("//div[@class='pull-right']/a"));

        //    16. Verify that 'Logged in as username' is visible
        commonMethods.verifyData("Logged in as "+userName,By.xpath("//a[text()=' Logged in as ']"));

        //    17. Click 'Delete Account' button
        commonMethods.clickElement(By.xpath("//a[@href='/delete_account']"));

        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        commonMethods.verifyData("ACCOUNT DELETED!",By.xpath("//h2[@data-qa='account-deleted']"));
        commonMethods.clickElement(By.xpath("//a[@data-qa='continue-button']"));

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
