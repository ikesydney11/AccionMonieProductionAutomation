package LoginTest;

import Pages.FundTransfer;
import Pages.loginPage;
import TestBase.TestBase;
import org.testng.annotations.Test;

import static Utils.ExtentManager.extent;

public class funds_Transfer extends TestBase {


    @Test(priority = 1)
    public void sendMoney() throws InterruptedException {
        FundTransfer transfer = new FundTransfer(driver);
        extent.createTest("Verify that user can send money to another accion account");
        transfer.sendMoneyBTN.click();
        transfer.AccountSourceBTN.click();
        transfer.staffAccountBTN.click();
        transfer.Enter_Account_Number.sendKeys("1107167475");
        transfer.Enter_Amount.sendKeys("50");
        transfer.proceed.click();
        loginPage.enterPasscode("4190");
    }


}
