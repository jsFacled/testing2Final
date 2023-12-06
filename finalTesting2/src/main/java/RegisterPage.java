import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private By registerLink = By.xpath("//a[normalize-space()='Register']");


    private By  firstName = By.id("customer.firstName");
    private By  lastName = By.id("customer.lastName");
    private By  address = By.id("customer.address.street");
    private By  city = By.id("customer.address.city");
    private By  state = By.id("customer.address.state");
    private By  zipCode= By.id("customer.address.zipCode");
    private By  phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By  username = By.id("customer.username");
    private By  password = By.id("customer.password");
    private By  passwordConfirm = By.id("repeatedPassword");

    private By registerSendButton = By.xpath("//input[@value='Register']");

    private By okLoginMessage = By.xpath("//*[@id=\"rightPanel\"]/p");

    //p[contains(text(),'If you have an account with us you can sign-up for')]
    //*[@id="rightPanel"]/p/text()

    //p[contains(text(),'Your account was created successfully. You are now')]
    //*[@id="rightPanel"]/p



    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickIngresoRegistro() throws InterruptedException {
        click(registerLink);
    }



    public void escribirNombre(String nombre) throws InterruptedException {
        sendText(nombre, firstName);
    }

    public void escribirApellido(String apellido) throws InterruptedException {
        sendText(apellido, lastName);
    }

    public void escribirDireccion(String direccion) throws InterruptedException {
        sendText(direccion, address);
    }

    public void escribirCiudad(String ciudad) throws InterruptedException {
        sendText(ciudad, city);
    }

    public void escribirEstado(String estado) throws InterruptedException {
        sendText(estado, state);
    }

    public void escribirCodigoPostal(String codigoPostal) throws InterruptedException {
        sendText(codigoPostal, zipCode);
    }

    public void escribirTelefono(String telefono) throws InterruptedException {
        sendText(telefono, phone);
    }

    public void escribirSSN(String ssnText) throws InterruptedException {
        sendText(ssnText, ssn);
    }

    public void escribirUsuario(String usuario) throws InterruptedException {
        sendText(usuario, username);
    }

    public void escribirPassword(String contrasena) throws InterruptedException {
        sendText(contrasena, password);
    }

    public void escribirPasswordConfirm(String contrasenaConfirm) throws InterruptedException {
        sendText(contrasenaConfirm, passwordConfirm);
    }

    public void clickRegistrarse() throws InterruptedException {
        click(registerSendButton);
    }

    public String obtenerMensajeRegistroOk() {
        // Espera explícita para esperar a que el elemento del mensaje esté presente
        WebElement mensajeElement = wait.until(ExpectedConditions.presenceOfElementLocated(okLoginMessage));

        // Obtén el texto del elemento del mensaje
        String mensaje = mensajeElement.getText();

        System.out.println("Me encuentro logueado correctamente: " + mensaje);
        return mensaje;
    }
}
