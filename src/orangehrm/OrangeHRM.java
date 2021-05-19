package orangehrm;

/*
https://opensource-demo.orangehrmlive.com/
( Username : Admin | Password : admin123 )
Enter username
Enter password
Click login
Verify that the text “Welcome Paul”
After Paul one symbol there so click on symbol for logout.
Verify that the below text.
LOGIN Panel

 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class OrangeHRM {

    WebDriver driver;

    @Before
    public void setUp(){
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void verifyUserAbleToLoginAndLogoutSuccessfully(){

        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        String expectedText = "Welcome Paul";
        WebElement webText = driver.findElement(By.xpath("//a[text()='Welcome Paul']"));
        String actualText = webText.getText();
        Assert.assertEquals("Welcome text result",expectedText,actualText);

        driver.findElement(By.xpath("//a[@class='panelTrigger']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        expectedText = "LOGIN Panel";
        WebElement webText1 = driver.findElement(By.xpath("//div[text()='LOGIN Panel']"));
        actualText = webText1.getText();
        Assert.assertEquals("Confirm Text of LOGIN panel",expectedText,actualText);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
