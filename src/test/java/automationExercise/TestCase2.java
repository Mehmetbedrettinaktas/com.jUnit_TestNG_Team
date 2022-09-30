package automationExercise;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;


public class TestCase2   {

    @Test
    public void test01() {
// Login User with correct email and password
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-home']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        Driver.getDriver().findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        String actualLogintext=Driver.getDriver().findElement(By.xpath("//h2[text()='Login to your account']")).getText();
        String expektedloginText="Login to your account";
        Assert.assertTrue(expektedloginText.contains(actualLogintext));
        //6. Enter correct email address and password
        //7. Click 'login' button
        WebElement email= Driver.getDriver().findElement(By.xpath("(//input[@type='email'])[1]"));
        WebElement password= Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        Faker faker=new Faker();
        email.sendKeys("ahmettahmi47@gmail.com",Keys.TAB);
        password.sendKeys("ahmettahmi47",Keys.TAB);
        actions.sendKeys(Keys.ENTER);


        //8. Verify that 'Logged in as username' is visible
        String actualLogged= Driver.getDriver().findElement(By.xpath(" //*[text()=' Logged in as '] ")).getText();
        String expectedLogged= "Logged in as username";
        Assert.assertEquals(expectedLogged,actualLogged);
        //9. Click 'Delete Account' button
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1[text()='Delete Account']")).isDisplayed());

    }
}
