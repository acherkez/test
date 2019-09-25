package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;

public class RegistrationPage {

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "btSub")
    public WebElement submit;

    @FindBy(id = "first_name-error")
    public WebElement firstNameError;

    @FindBy(id = "last_name-error")
    public WebElement lastNameError;

    @FindBy(id = "email-error")
    public WebElement emailError;

    @FindBy(id = "password-error")
    public WebElement passwordError;

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public String getFirstNameError() {
        return firstNameError.getText();
    }

    public String getLastNameError() {
        return lastNameError.getText();
    }

    public String getEmailError() {
        return emailError.getText();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }

    public void clickOnRegistrationButton(){
        submit.click();
    }
}
