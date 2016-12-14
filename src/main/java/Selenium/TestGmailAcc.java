package Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by Dzmitry_Kavalenka on 12/14/2016.
 */
public class TestGmailAcc extends GmailAcc {
    @Test
    public void auth() {
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(email);
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        WebElement passInput = driver.findElement(By.id("Passwd"));
        passInput.sendKeys(pass);
        WebElement signIn = driver.findElement(By.id("signIn"));
        signIn.click();
        boolean isEmailpresent = isEmailPresent(By.id(biltEmail));
        Assert.assertTrue(isEmailpresent, "The email is not recieved");
    }

    @Test(dependsOnMethods = "auth")
    public void biltReg() {
        WebElement email = driver.findElement(By.id(biltEmail));
        email.click();
        WebElement link = driver.findElement(By.partialLinkText("https://qa1.labs.biltapp.com:443/sap/fla/snap/pp/createUser.html?validationToken"));
        link.click();
    }

    private boolean isEmailPresent(By by) {
        try {
            WebElement biltMail = driver.findElement(by);
            return biltMail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
//"Auto_BILT-APP_Integration@epam.com"