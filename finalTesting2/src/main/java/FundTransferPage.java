import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferPage extends BasePage {
    private By transferFundsLink = By.xpath("//a[normalize-space()='Transfer Funds']");
    private By transferFundsTitle = By.xpath("//h1[@class='title']");
    private By CampoAmount   = By.id("amount");
    private By fromAccount= By.id("fromAccountId");
    private By fromAccountOption1= By.xpath("//*[@id=\"fromAccountId\"]/option[1]");


    private By toAccount = By.id("toAccountId");
    private By toAccountOption1 = By.xpath("//*[@id=\"toAccountId\"]/option[1]");
    private By toAccountOption2= By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By transferButton = By.xpath("//input[@value='Transfer']\n");
    private By okTransferComplete = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");

    public FundTransferPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickTransferenciaFondos() throws InterruptedException {
        click(transferFundsLink);
    }

    public String obtenerTitleTransferFunds() {
        // Espera explícita para esperar a que el elemento del mensaje esté presente
        WebElement mensajeElement = wait.until(ExpectedConditions.presenceOfElementLocated(transferFundsTitle));
        String mensaje = mensajeElement.getText();
        return mensaje;
    }

    public void ingresarImporteATransferir(String importe) throws InterruptedException {
        sendText(importe, CampoAmount);
    }


    public void selectAccount() throws InterruptedException {
        click(fromAccount);
        click(fromAccountOption1);
    }
    public void selectToAccount() throws InterruptedException {
        click(toAccount);
        if(toAccountOption1 == fromAccountOption1){
            click(toAccountOption2);
        }
        click(transferButton);
    }


    public String obtenerTitleTransferComplete() {
        // Espera explícita para esperar a que el elemento del mensaje esté presente
        WebElement mensajeElement = wait.until(ExpectedConditions.presenceOfElementLocated(okTransferComplete));
        String mensaje = mensajeElement.getText();
        return mensaje;
    }


}
