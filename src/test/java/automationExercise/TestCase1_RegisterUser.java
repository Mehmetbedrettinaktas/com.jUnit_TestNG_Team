package automationExercise;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;


public class TestCase1_RegisterUser  {

    @Test
    public void test01() throws InterruptedException {
        Faker faker=new Faker();
        //2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("[class='logo pull-left']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        Driver.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //6. Enter name and email address
        Driver.getDriver().findElement(By.xpath("//*[@name='name']")).sendKeys(faker.name().firstName());
        Driver.getDriver().findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);
        //7. Click 'Signup' button
        Driver.getDriver().findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccount=Driver.getDriver().findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
        String expectedEnterAccount="ENTER ACCOUNT INFORMATION";
        Assert.assertTrue(expectedEnterAccount.contains(actualEnterAccount));
        //9. Fill details: Title, Name, Email, Password, Date of birth

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//input[@id='id_gender1']")).click();
        Actions actions = null;
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("123abc.1").perform();

        WebElement ddmDays= Driver.getDriver().findElement(By.xpath("//select[@id='days']"));
        Select select=new Select(ddmDays);
        select.selectByVisibleText("5");
        Thread.sleep(3000);
        WebElement ddmMonths= Driver.getDriver().findElement(By.xpath("//select[@id='months']"));
        Select select2=new Select(ddmMonths);
        select2.selectByVisibleText("April");

        WebElement ddmyears= Driver.getDriver().findElement(By.xpath("//select[@id='years']"));
        Select select3=new Select(ddmyears);
        select3.selectByVisibleText("1995");
        Thread.sleep(3000);
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        Driver.getDriver().findElement(By.xpath("//input[@id='newsletter']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@id='optin']")).click();



        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'

        Driver.getDriver().findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName(),Keys.TAB);
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys("Aktas").sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress()).sendKeys(Keys.TAB).sendKeys(faker.address().buildingNumber()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().country()).sendKeys(Keys.TAB).sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).click().perform();
        Thread.sleep(3000);
        //14. Verify that 'ACCOUNT CREATED!' is visible
        String actualText=Driver.getDriver().findElement(By.xpath("//b[text()='Account Created!']")).getText();
        String expectedText="ACCOUNT CREATED!";
        Assert.assertEquals(expectedText,actualText);

        //15. Click 'Continue' button
        Driver.getDriver().findElement(By.cssSelector("[class=\"btn btn-primary\"]")).click();
        Thread.sleep(3000);
        //16. Verify that 'Logged in as username' is visible
        String actualLogged=Driver.getDriver().findElement(By.xpath("//*[text()=' Logged in as ']")).getText();
        String expectedLogged="Logged in as username";
        Assert.assertNotEquals(expectedLogged,actualLogged);
        //17. Click 'Delete Account' button
        Driver.getDriver().findElement(By.xpath("//a[text()=' Delete Account']")).click();
        Thread.sleep(3000);
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        String actualDelete=Driver.getDriver().findElement(By.tagName("//h1")).getText();
        String expectedDelete="ACCOUNT DELETED!";
        Assert.assertTrue(expectedDelete.contains(actualDelete) );
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.cssSelector("[class=\"btn btn-danger\"]")).click();


    }
}
