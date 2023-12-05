import org.openqa.selenium.By;

public class FundTransferPage {
    private By   = By.xpath("//a[normalize-space()='Transfer Funds']
            ");
    private By  Transfer Funds = By.xpath("//h1[@class='title']
            ");
    private By CampoAmount   = By.id("amount");
    private By   fromAccount= By.id("fromAccountId");
    private By  toAccount = By.id("toAccountId");
    private By   toAccountOption1 = By.xpath("//*[@id=\"toAccountId\"]/option[1]");
    private By   toAccountOption2= By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By  transferButton = By.xpath("//input[@value='Transfer']\n");
    private By   okTransferComplete = By.xpath("//h1[@class='title']");
}