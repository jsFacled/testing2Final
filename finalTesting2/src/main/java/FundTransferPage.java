import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferPage extends BasePage {
    private By transferFundsLink = By.xpath("//a[normalize-space()='Transfer Funds']");
    private By transferFundsOk = By.xpath("//h1[@class='title']");
    private By CampoAmount   = By.id("amount");
    private By fromAccount= By.id("fromAccountId");
    private By toAccount = By.id("toAccountId");
    private By toAccountOption1 = By.xpath("//*[@id=\"toAccountId\"]/option[1]");
    private By toAccountOption2= By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By transferButton = By.xpath("//input[@value='Transfer']\n");
    private By okTransferComplete = By.xpath("//h1[@class='title']");


    public FundTransferPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickTransferenciaFondos() throws InterruptedException {
        click(transferFundsLink);
    }


}
