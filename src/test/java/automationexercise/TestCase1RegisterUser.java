package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase1RegisterUser {


    WebDriver driver;

    @Before
    public void setup() {
        //    1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        Actions actions = new Actions(driver);
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //    3. Verify that home page is visible successfully
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //    4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //a[text()=' Signup / Login']")).click();

        //    5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignUp.isDisplayed());

        //    6. Enter name and email address
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameBox.sendKeys("Alparslan");
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailBox.sendKeys("damarrion.johnjoseph7@free2ducks.com");

        //    7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInformationExt = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInformationExt.isDisplayed());

        //    9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleRadiButton = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadiButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("April")
                .sendKeys(Keys.TAB)
                .sendKeys("1978")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click().perform();

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement newsletterCheckbox = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox));

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement uniformOptin = driver.findElement(By.xpath("//div[@id='uniform-optin']"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(uniformOptin));

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameElement = driver.findElement(By.id("first_name"));
        firstNameElement.sendKeys("Alaprslan");
        actions.sendKeys(Keys.TAB)
                .sendKeys("ygd")
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
                .sendKeys("5551254568").perform();
//                .sendKeys(Keys.TAB)
//                .sendKeys(Keys.ENTER)

        //    13. Click 'Create Account button'

        WebElement createAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.elementToBeClickable(createAccount));

        //    14. Verify that 'ACCOUNT CREATED!' is visible

//        String expectedText = "ACCOUNT CREATED!";
//        String actualText = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b")).getText();
//        Assert.assertEquals(expectedText, actualText);

//        //    15. Click 'Continue' button
//        WebElement clickContinue = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
//        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait4.until(ExpectedConditions.elementToBeClickable(clickContinue));
//
//        //    16. Verify that 'Logged in as username' is visible
//        String expectedUsernameText = "Alparslan";
//        String actualUsernameText = driver.findElement(By.xpath("//i[@class='fa fa-user']")).getText();
//        Assert.assertEquals(expectedUsernameText, actualUsernameText);
//
//        //    17. Click 'Delete Account' button
//        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//
//        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        String expectedDeletedText = "ACCOUNT DELETED!";
//        String actualDeletedText = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
//        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


    }


}
