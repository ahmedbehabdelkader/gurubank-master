package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.Files.copy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public WebDriver driver;

    @BeforeTest
    public void launchbrowser(){
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver= new ChromeDriver();

    }

    @Test
    public void Loginwithvaliduseridandvalidpassword(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr581500");
        driver.findElement(By.name("password")).sendKeys("AhUmArU");
        driver.findElement(By.name("btnLogin")).click();
        String expectedtitle="Guru99 Bank Manager HomePage";
        String actualtitle= driver.getTitle();
        Assert.assertEquals(expectedtitle,actualtitle);
        String expectedManagerid="Manger Id : mngr581500";
        String actualManagerid=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        Assert.assertEquals(expectedManagerid,actualManagerid);
        TakesScreenshot screenshot=((TakesScreenshot)driver);
        File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile= new File("D:\\test.png");
        Files.copy(SrcFile.toPath(), DestFile.toPath());
    }
    @Test
    public void loginwithinvaliduseridandvalidpassword(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("hello");
        driver.findElement(By.name("password")).sendKeys("AhUmArU");
        driver.findElement(By.name("btnLogin")).click();
        Alert a= driver.switchTo().alert();
        String expected ="User or Password is not valid";
        String actual=a.getText();
        Assert.assertEquals(expected,actual);
        a.accept();
    }
    @Test
    public void loginwithvaliduseridandinvalidpassword(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr581500");
        driver.findElement(By.name("password")).sendKeys("hey");
        driver.findElement(By.name("btnLogin")).click();
        Alert a=driver.switchTo().alert();
        String expected_title="User or Password is not valid";
        String actual_title= a.getText();
        Assert.assertEquals(expected_title,actual_title);
        a.accept();
    }
    @Test
        public void loginwithinvaliduseridandinvalidpassword(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("hello");
        driver.findElement(By.name("password")).sendKeys("hey");
        driver.findElement(By.name("btnLogin")).click();
        Alert a= driver.switchTo().alert();
        String expected_tit ="User or Password is not valid";
        String actual_tit=a.getText();
        Assert.assertEquals(expected_tit,actual_tit);
        a.accept();
    }

    @Test
    public void checkresetbutton(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("hey");
        driver.findElement(By.name("password")).sendKeys("2278174Hd");
        driver.findElement(By.name("btnReset")).click();
        String expecteduid="";
        String actualuid=driver.findElement(By.name("uid")).getText();
        String expectedpassword="";
        String actualpassword=driver.findElement(By.name("password")).getText();
        Assert.assertEquals(expecteduid,actualuid);
        Assert.assertEquals(expectedpassword,actualpassword);
    }
    
    @Test
    public void checkselinumbutton(){
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr/td[2]/a[2]")).click();
        String expectedtitle="Selenium Tutorial";
        String actualtitle= driver.getTitle();
        Assert.assertEquals(expectedtitle,actualtitle);
    }
     
    @Test
    public void deletecustomerform(){
        driver.get("https://www.demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("Ahmed");
        driver.findElement(By.name("submit")).click();
        Alert a=driver.switchTo().alert();
        a.accept();
        String expected="Customer Successfully Delete!";
        String actual=a.getText();
        Assert.assertEquals(expected,actual);
        a.accept();
    }
    
}
