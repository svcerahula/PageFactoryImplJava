package com.TestcasesForWebPages;

import com.objectrepository.GoogleSignInPage;
import com.utilities.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleLoginPageTestcases {
    WebDriver wd;
    PropertyManager  propManager;


    @BeforeMethod
    public void setup() throws IOException, ClassNotFoundException {
        propManager = PropertyManager.getInstance(this.getClass().getName()
                ,"src\\test\\resources\\Properties\\application.properties");;
        System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void LoginTest() {
        GoogleSignInPage page = PageFactory.initElements(wd,GoogleSignInPage.class);
        wd.get(propManager.getGoogleUrl());
        page.clickSignInButton();
        page.inputEmail(propManager.getEmailId());
        page.clickOnNextButton();
        page.inputPassword(propManager.getPassword());
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.xpathNextButton)).click();
        //page.clickOnNextButton();


        wait.until(ExpectedConditions.visibilityOfElementLocated(page.xpathGoogleAccInfo)).click();
        //page.googleAccButtonClick();
        page.signOutButtonClick();
    }

    @AfterMethod
    public void closeSetup() {
       wd.close();
    }
}
