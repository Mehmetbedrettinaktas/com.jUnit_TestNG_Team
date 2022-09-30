package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath= " //*[text()=' Signup / Login']")
    public WebElement signupLogin;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement loginEmail;

    @FindBy(xpath = " //input[@type='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement loginButton;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement signupName;
    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement signupEmail;

    @FindBy(xpath = "//*[text()='Signup']")
    public WebElement signupButton;
    @FindBy(xpath = "//div[@class='radio-inline']")
    public WebElement titleMr;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement accountName;
}
