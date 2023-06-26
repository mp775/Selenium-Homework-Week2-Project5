package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl ="https://courses.ultimateqa.com/";
    @Before
    public void openBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();
        //verify massage
        String expectedMassage = "Welcome Back!";
        String actualMassage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Welcome message not displayed",expectedMassage,actualMassage);

    }
    @Test
    public void verifyTheErrorMessage(){
       // click in sign in web element
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();
        //enter invalid email
        driver.findElement(By.xpath("//input[@id = 'user[email]']")).sendKeys("XYZ.gmail.com");
       // enter invalid password
        driver.findElement(By.xpath("//input[@name = 'user[password]']")).sendKeys("xyab12");
        //click on sign in button
        driver.findElement(By.xpath("//button[@type ='submit']")).click();
        //verify massage
        String expectedMassage = "Invalid email or password.";
        String actualMassage = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Invalid message not displayed",expectedMassage,actualMassage);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}

