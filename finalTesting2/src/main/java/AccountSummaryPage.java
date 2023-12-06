import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummaryPage extends BasePage{

    private By accountsOverview  = By.xpath("//a[normalize-space()='Accounts Overview']\n");
    private By footBalanceSubjectTo   = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td\n");

    private  By myAccount = By.xpath("//a[@class='ng-binding']");
    private By titleAccountDetails  = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");

    private By Account1  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By Account2  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a");

    private By accountActivityPeriodSelect  = By.id("month");
    private By accountActivityPeriodOptionAll = By.xpath("//*[@id=\"month\"]/option[1]");
    private By accountActivityTypeSelect = By.id("transactionType");
    private By accountActivityTypeSelectAll = By.xpath("//*[@id=\"transactionType\"]/option[1]");
    private By goButton= By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");

//h1[@class='title']

//*[@id="accountTable"]/tfoot/tr/td

    public AccountSummaryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void clickAccountOverview() throws InterruptedException {
        click(accountsOverview);
    }


    public String obtenerMensajeBalanceSubjectTo() {
        // Espera explícita para esperar a que el elemento del mensaje esté presente
        WebElement mensajeElement = wait.until(ExpectedConditions.presenceOfElementLocated(footBalanceSubjectTo));
        String mensaje = mensajeElement.getText();
        return mensaje;
    }

    public void clickMyAccount() throws InterruptedException {
        click(myAccount);
    }

    public String obtenerTituloAccountDetails() {
        // Espera explícita para esperar a que el elemento del mensaje esté presente
        WebElement mensajeElement = wait.until(ExpectedConditions.presenceOfElementLocated(footBalanceSubjectTo));

        String mensaje = mensajeElement.getText();
        return mensaje;
    }



    public void selectActivityPeriodAll() throws InterruptedException {
        click(accountActivityPeriodSelect);
        click(accountActivityPeriodOptionAll);
    }

    public void selectAccountActivityTypeAll() throws InterruptedException {
        click(accountActivityTypeSelect);
        click(accountActivityTypeSelectAll);
    }

    public void clickGo() throws InterruptedException {
        click(goButton);
    }




}
