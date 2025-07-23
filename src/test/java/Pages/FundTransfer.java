package Pages;

import PageBase.pageBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FundTransfer extends pageBaseClass {

    public FundTransfer(AndroidDriver driver){
        super(driver);
    }
    @AndroidFindBy(accessibility = "Send Money")
    public WebElement sendMoneyBTN;
    @AndroidFindBy(accessibility = "To AccionMFB")
    public WebElement to_Accion_MFB_BTN;
    @AndroidFindBy(accessibility = "Select Source Account")
    public WebElement AccountSourceBTN;
    @AndroidFindBy(accessibility = "Brighta Staff - Current - 1107103561")
    public WebElement staffAccountBTN;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
    public WebElement Enter_Account_Number;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[2]")
    public WebElement Enter_Amount;
    @AndroidFindBy(accessibility = "Proceed")
    public WebElement proceed;
    public void tapSendMoney() {
        sendMoneyBTN.click();
    }
    public void tapToAccionMFB() {
        to_Accion_MFB_BTN.click();
    }
    public void tapAccountSource() {
        AccountSourceBTN.click();
    }
    public void selectStaffAccount() {
        staffAccountBTN.click();
    }
    public void inputAccountNumber(String accountNumber) {
        Enter_Account_Number.sendKeys(accountNumber);
    }
    public void inputAmount(String amount) {
        Enter_Amount.sendKeys(amount);
    }
    public void tapProceed() {
        proceed.click();
    }
}
