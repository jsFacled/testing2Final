import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

public class FrontTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
    static ExtentReports extent;

    // Genera un valor aleatorio entre 'A' y 'Z' (códigos Unicode)
    Random random = new Random();
    String letraAleatoria = String.valueOf((char) (random.nextInt(26) + 'A'));




    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
       // registerPage.getUrl("https://para.testar.org/parabank/index.htm");
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");

    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickIngresoRegistro();


            registerPage.escribirNombre(letraAleatoria);
            registerPage.escribirApellido(letraAleatoria);
            registerPage.escribirDireccion(letraAleatoria);
            registerPage.escribirCiudad(letraAleatoria);
            registerPage.escribirEstado(letraAleatoria);
            registerPage.escribirCodigoPostal(letraAleatoria);
            registerPage.escribirTelefono(letraAleatoria);
            registerPage.escribirSSN(letraAleatoria);
            registerPage.escribirUsuario(letraAleatoria);
            registerPage.escribirPassword(letraAleatoria);
            registerPage.escribirPasswordConfirm(letraAleatoria);

            test.log(Status.PASS, "Completo los datos de registro de forma correcta");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.obtenerMensajeRegistroOk());

            test.log(Status.PASS, "Ingreso a la página de Registro");
            test.log(Status.PASS, "Valido que el registro se haya hecho de forma exitosa");


        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }


    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void NewAccountPageTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Abrir una nueva cuenta");
        test.log(Status.INFO, "Comienza el Test");
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);

        try {
            newAccountPage.;


            test.log(Status.PASS, "Completo los datos de registro de forma correcta");



            Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.obtenerMensajeRegistroOk());

            test.log(Status.PASS, "Ingreso a la página de Registro");
            test.log(Status.PASS, "Valido que el registro se haya hecho de forma exitosa");


        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }





    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }



}
