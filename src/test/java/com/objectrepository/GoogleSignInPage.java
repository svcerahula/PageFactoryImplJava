package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSignInPage {

     public static By xpathGoogleAccInfo = By.xpath("//a[contains(@title,\"Google Account\")]");
     public static By xpathNextButton = By.xpath("//span[text()=\"Next\"]");

     @FindBy(how= How.XPATH, using="//span[text()=\"Next\"]")
     WebElement nextButtonVerifyItsYouPage;

     @FindBy(how=How.XPATH,using="//a[text()=\"Sign in\"]")
     WebElement signInButton;

     @FindBy(how=How.ID,using="identifierId")
     WebElement userId;

     @FindBy(how=How.XPATH,using="//input[@name=\"password\"]")
     WebElement passwordTextBox;

     @FindBy(how=How.XPATH,using="//a[contains(@title,\"Google Account\")]")
     WebElement googleAccButton;

     @FindBy(xpath="//a[text()=\"Sign out\"]")
     WebElement signOutButton;

     public void inputEmail(String emailId) {
         userId.sendKeys(emailId);
     }

     public void inputPassword(String password) {
         passwordTextBox.sendKeys(password);
     }
     public void clickSignInButton() {
         signInButton.click();
     }

     public void clickOnNextButton() {
         nextButtonVerifyItsYouPage.click();
     }

     public void googleAccButtonClick() {
         googleAccButton.click();
     }

     public void signOutButtonClick() {
         signOutButton.click();
     }
     public void clickOnNextButtonForAlreadyConfiguredEmailId() {
         nextButtonVerifyItsYouPage.click();
     }
}
