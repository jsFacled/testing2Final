import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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
            /*
            -------------- Registro -----------------
             */
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

            /*
            -------------- New account -----------------
             */


        ExtentTest testNewAccount = extent.createTest("Prueba de Abrir una nueva cuenta");
        test.log(Status.INFO, "Comienza el Test");
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);

             newAccountPage.clickLinkAbrirCuentaNueva();
            test.log(Status.PASS, "Ingreso a newAccount exitosamente.");
            System.out.println("Ingreso a newAccount exitosamente.");

             newAccountPage.selectSavingsType();
             newAccountPage.clickButtonAbrirCuentaNueva();

             newAccountPage.obtenerMensajeNewAccountOk();
            Assertions.assertEquals("Congratulations, your account is now open.", newAccountPage.obtenerMensajeNewAccountOk());

            test.log(Status.PASS, "Valido que la apertura de nueva cuenta se haya hecho de forma exitosa");



             /*
            -------------- Resumen de las cuentas -----------------
             */
            ExtentTest testAccountSumary = extent.createTest("Prueba de Resumen de cuenta");
            test.log(Status.INFO, "Comienza el Test");
            AccountSummaryPage  accountSummaryPage = new AccountSummaryPage(driver, wait);

            accountSummaryPage.clickAccountOverview();
            accountSummaryPage.obtenerMensajeBalanceSubjectTo();
            Assertions.assertEquals("*Balance includes deposits that may be subject to holds", accountSummaryPage.obtenerMensajeBalanceSubjectTo());

            test.log(Status.PASS, "Valido que aparezca el mensaje al pie sobre depositos sujetos a...");
            System.out.println("El mensaje al pie sobre depositos sujetos a--- está ok.");


            /*
            ----------------- Transferir Fondos------------------
             */
            ExtentTest testFundTransfer = extent.createTest("Prueba de Transferencia de fondos");
            test.log(Status.INFO, "Comienza el Test");
            FundTransferPage  fundTransferPage = new FundTransferPage(driver, wait);



            /*

             Account1  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
             Account2  = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a");
             titleAccountDetails  = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
             accountActivityPeriodSelect  = By.id("month");
             accountActivityPeriodOptionAll = By.xpath("//*[@id=\"month\"]/option[1]");
             accountActivityTypeSelect = By.id("transactionType");
             accountActivityTypeSelectAll = By.xpath("//*[@id=\"transactionType\"]/option[1]");
             goButton= By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");
*/


        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }



    @AfterEach
    public void cerrar() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        Thread.sleep(5000);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }



}
