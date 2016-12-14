package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dzmitry_Kavalenka on 12/14/2016.
 */
public class GmailAcc {
    public WebDriver driver;
    protected static String url = "https://gmail.com/";
    protected String email = "testdzmitrykavalenka@gmail.com";
    protected String pass = "70618452Metadon";
    protected String biltEmail = ":3s";

    @BeforeClass()
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @BeforeClass(dependsOnMethods = "startBrowser")
    public void ImpWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
/*    @AfterClass
    public void closeBrowser(){
    driver.quit();
}*/

}
