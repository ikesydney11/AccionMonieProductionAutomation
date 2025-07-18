package Pages;

import PageBase.pageBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class loginPage extends pageBaseClass {

    public loginPage(AndroidDriver driver) {
        super(driver);
    }
    @AndroidFindBy(accessibility = "Skip")
    public WebElement SkipBTN;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Individual Banking')]")
    public WebElement individualBankingButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    public WebElement phoneNumberField;
    @AndroidFindBy(className = "android.widget.CheckBox")
    public static WebElement termsAndConditionBTN;
    @AndroidFindBy(accessibility = "Continue")
    public static WebElement ContinueBTN;
    @AndroidFindBy(className = "android.view.View")
    public static WebElement passWord;
    @AndroidFindBy(accessibility = "0")
    public static WebElement ZeroBtn;
    @AndroidFindBy(accessibility = "1")
    public static WebElement OneBTN;
    @AndroidFindBy(accessibility = "2")
    public static WebElement TwoBTN;
    @AndroidFindBy(accessibility = "3")
    public static WebElement ThreeBTN;
    @AndroidFindBy(accessibility = "4")
    public static WebElement FourBTN;
    @AndroidFindBy(accessibility = "5")
    public static WebElement FiveBTN;
    @AndroidFindBy(accessibility = "6")
    public static WebElement SixBTN;
    @AndroidFindBy(accessibility = "7")
    public static WebElement sevenBTN;
    @AndroidFindBy(accessibility = "8")
    public static WebElement eight;
    @AndroidFindBy(accessibility = "9")
    public static WebElement NineBTN;
    public void SkipBTN() {
        click(SkipBTN);
    }
    public void IndividualBankingBtn() {
        click(individualBankingButton);
    }

    public void PhoneNumberField(String number) {
        click(phoneNumberField);
        phoneNumberField.sendKeys();
    }
    public static void TermsAndConditionBTN() {
        click(termsAndConditionBTN);
    }
    public static void ContinueLogin() {
        click(ContinueBTN);
    }
    public static void PassWord(String Number) {
        passWord.sendKeys("");
    }
    public static String enterPasscode(String pin) throws InterruptedException {
        for (char digit : pin.toCharArray()) {
            switch (digit) {
                case '0':
                    ZeroBtn.click();
                    break;
                case '1':
                    OneBTN.click();
                    break;
                case '2':
                    TwoBTN.click();
                    break;
                case '3':
                    ThreeBTN.click();
                    break;
                case '4':
                    FourBTN.click();
                    break;
                case '5':
                    FiveBTN.click();
                    break;
                case '6':
                    SixBTN.click();
                    break;
                case '7':
                    sevenBTN.click();
                    break;
                case '8':
                    eight.click();
                    break;
                case '9':
                    NineBTN.click();
                    break;
            }
            Thread.sleep(150);
        }
        return pin;
    }
}
