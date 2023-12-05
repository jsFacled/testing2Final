import org.openqa.selenium.By;

public class NewAccountPage {

    private By openNewAccount  = By.xpath("//a[normalize-space()='Open New Account']\n");
    private By  savingsType= By.id("type");
    private By  checkingType= By.xpath("//*[@id=\"type\"]/option[2]/text()\n");
    private By openNewAccountButton  = By.xpath("//input[@value='Open New Account']");
    private By  okNewAccountMessage = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]\n");

}
