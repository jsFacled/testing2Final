import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{

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

    private By registerButton = By.xpath("//a[normalize-space()='Register']\n");

    private By okLoginMessage = By.xpath("//*[@id=\"rightPanel\"]/p");




    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerTituloRegistro() throws InterruptedException {
        System.out.println("Me encuentro en la página de Registro: " + getText(titulo));
        return this.getText(titulo);
    }

    public void escribirNombre(String name) throws InterruptedException {
        sendText(name, nombre);
    }

    public void escribirApellido(String lastName) throws InterruptedException {
        sendText(lastName, apellido);
    }

    public void escribirMail(String mail) throws InterruptedException {
        sendText(mail, email);
    }

    public void escribirContraseña(String clave) throws InterruptedException {
        sendText(clave, contrasena);
    }

    public void escribirConfirmarContraseña(String clave) throws InterruptedException {
        sendText(clave, recontrasena);
    }

    public void clickRegistrarse() throws InterruptedException {
        click(registrarseBtn);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Se creo la cuenta: " + getText(exito));
        return this.getText(exito);
    }

    public String obtenerMensajeConfirmarMail() throws InterruptedException {
        System.out.println("Valido el mensaje de confirmar mail: " + getText(confirmarMail));
        return this.getText(confirmarMail);
    }

    public String obtenerMensajeNombreObligatorio() throws InterruptedException {
        System.out.println("Verificar Nombre: " + getText(nombreObligatorio));
        return this.getText(nombreObligatorio);
    }

    public String obtenerMensajeApellidoObligatorio() throws InterruptedException {
        System.out.println("Verificar Apellido: " + getText(apellidoObligatorio));
        return this.getText(apellidoObligatorio);
    }

    public String obtenerMensajeCorreoObligatorio() throws InterruptedException {
        System.out.println("Verificar Correo: " + getText(mailObligatorio));
        return this.getText(mailObligatorio);
    }

    public String obtenerMensajeContraseñaObligatorio() throws InterruptedException {
        System.out.println("Verificar Contraseña: " + getText(contrasenaObligatorio));
        return this.getText(contrasenaObligatorio);
    }

    public String obtenerMensajeConfirmarContraseñaObligatorio() throws InterruptedException {
        System.out.println("Verificar Nombre: " + getText(recontrasenaObligatorio));
        return this.getText(recontrasenaObligatorio);
    }

    public String obtenerMensajeCorreoRepetido() throws InterruptedException {
        System.out.println("Verificar el mensaje de correo repetido: " + getText(mailRepetido));
        return this.getText(mailRepetido);
    }
}
