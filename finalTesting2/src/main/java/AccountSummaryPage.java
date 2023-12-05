import org.openqa.selenium.By;

public class AccountSummaryPage {

    private By accountsOverview  = By.xpath("//a[normalize-space()='Accounts Overview']\n");
    private By footBalanceSubjectTo   = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td\n");
    private By Account1  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By Account2  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a");
    private By titleAccountDetails  = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    private By accountActivityPeriodSelect  = By.id("month");
    private By accountActivityPeriodOptionAll = By.xpath("//*[@id=\"month\"]/option[1]");
    private By accountActivityTypeSelect = By.id("transactionType");
    private By accountActivityTypeSelectAll = By.xpath("//*[@id=\"transactionType\"]/option[1]");
    private By goButton= By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");









}
