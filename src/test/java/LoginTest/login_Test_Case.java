package LoginTest;

import Pages.loginPage;
import TestBase.TestBase;
import Utils.LoggerClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import static Utils.ExtentManager.extent;

public class login_Test_Case extends TestBase {



    @Test(priority = 1)

    public void login1() throws InterruptedException{

        loginPage page = new loginPage(driver);
        extent.createTest("Verify that user cannot login keeping the phone number field blank");
        Thread.sleep(10000);
        page.SkipBTN.click();
        page.individualBankingButton.click();
        page.phoneNumberField.click();
        page.phoneNumberField.sendKeys("");
        loginPage.termsAndConditionBTN.click();
        loginPage.ContinueBTN.click();}

    @Test(priority = 2)
        public void login2() throws InterruptedException{
        loginPage login2 = new loginPage(driver);
        Thread.sleep(1000);
        extent.createTest("Verify that user cannot login without checking the terms and condition button");
        login2.phoneNumberField.click();
        login2.phoneNumberField.sendKeys("8168439613");
        loginPage.termsAndConditionBTN.click();}

    @Test(priority = 3)
    public void login3() throws InterruptedException{
        loginPage page = new loginPage(driver);
        extent.createTest("Verify that user cannot login successfully with an invalid transaction PIN");
        page.phoneNumberField.click();
        page.phoneNumberField.sendKeys("8168439613");
        Thread.sleep(10000);
        loginPage.termsAndConditionBTN.click();
        loginPage.ContinueBTN.click();
        Thread.sleep(500);
        loginPage.passWord.click();
        Thread.sleep(1000);
        loginPage.enterPasscode("000000");

    }
    @Test(priority= 4)
    public void login4() throws InterruptedException{
        extent.createTest("Verify that user can can login successfully");
        Thread.sleep(5000);
        loginPage.enterPasscode("419000");
        Thread.sleep(10000);
       ;}
}