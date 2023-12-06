import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage extends BasePage {

    private By openNewAccount  = By.xpath("//a[normalize-space()='Open New Account']\n");
    private By  savingsType= By.id("type");
    private By  checkingType= By.xpath("//*[@id=\"type\"]/option[2]/text()\n");
    private By openNewAccountButton  = By.xpath("//input[@value='Open New Account']");
    private By  okNewAccountMessage = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]\n");


    public NewAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickLinkAbrirCuentaNueva() throws InterruptedException {
        click(openNewAccount);
    }
    public void clickSavingsType() throws InterruptedException {
        click(savingsType);
    }
    public void clickButtonAbrirCuentaNueva() throws InterruptedException {
        click(openNewAccountButton);
    }






}
