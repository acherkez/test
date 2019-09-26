package test.java;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    @DataProvider(name = "provider")
    public Object[][] provider() {
        return new Object[][]{
                {"345345", "345345", "345345", "", "Введено неприпустимі символи.", "Введено неприпустимі символи.", "Будь ласка, виправте помилку в ел. пошті.", "Будь ласка, введіть ваш пароль."},
                {"", "", "", "", "Введено неприпустимі символи.", "Введено неприпустимі символи.", "Будь ласка, виправте помилку в ел. пошті.", "Будь ласка, введіть ваш пароль."},
//                {"", "", "", "", "", "", "", ""},
        };
    }

    @Test(dataProvider = "provider")
    public void test1(String name, String lastName, String mail, String password,
                      String error1, String error2, String error3, String error4) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\1\\chromedriver5.exe");
//        System.setProperty("webdriver.gecko.driver", "D:\\driver\\1\\geckodriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("https://www.work.ua/jobseeker/register/");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName(name);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(mail);
        registrationPage.setPassword(password);
        registrationPage.clickOnRegistrationButton();

        Thread.sleep(3000);

        String error11 = registrationPage.getFirstNameError();
        String error22 = registrationPage.getLastNameError();
        String error33 = registrationPage.getEmailError();
        String error44 = registrationPage.getPasswordError();

        System.out.println("error11 " + error11);
        System.out.println("error22 " + error22);
        System.out.println("error33 " + error33);
        System.out.println("error44 " + error44);

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(error1, error11);
//        softAssert.assertEquals(error2, error22);
//        softAssert.assertEquals(error3, error33);
//        softAssert.assertEquals(error4, error44);
//        softAssert.assertAll();

        checkErrorText(error1, error11);
        checkErrorText(error2, error22);
        checkErrorText(error3, error33);
        checkErrorText(error4, error44);




        driver.close();
    }

    @Step
    public void checkErrorText(String actual, String expected){
        Assert.assertTrue(expected.equals(actual), "Error message wrong");
    }
}
