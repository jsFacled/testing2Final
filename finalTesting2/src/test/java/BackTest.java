import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;



/*

● Validación del código de estado 200 para todas las etapas de las pruebas frontales

    ○ Registro URL: https://parabank.parasoft.com/parabank/register.htm

    ○ Abrir una nueva cuenta URL:
https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?cust
omerId=12545&newAccountType=1&fromAccountId=xxxxx

    ○ Resumen de las cuentas URL:
https://parabank.parasoft.com/parabank/overview.htm

    ○ Descarga de fondos URL:
https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccou
ntId=13566&toAccountId=13677&amount=xxxxx

    ○ Actividad de la cuenta (cada mes) URL:
https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/tra
nsactions/month/All/type/All

 */

/*
    ---------------- Prueba de endpoints Get ---------------------
 */
public class BackTest {

    @Test
    public void GetTestRegistro () {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());
    }
    @Test
    public void GetTestAbrirNuevaCuenta () {
        Response resGet = RestAssured.get("//parabank.parasoft.com/parabank/services_proxy/bank/createAccount?cust\n" +
                "omerId=12545&newAccountType=1&fromAccountId=xxxxx\n");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());
    }
    @Test
    public void GetTestResumenDeLasCuentas () {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/overview.htm" +
                "omerId=12545&newAccountType=1&fromAccountId=xxxxx\n");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());
    }
    @Test
    public void GetTestDescargaDeFondos () {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());
    }

    @Test
    public void GetTestActividadDeLaCuenta () {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/tra\n" + "nsactions/month/All/type/All");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());
    }

/*
        ------------------ Casos Puntuales ---------------------

 */


    @Test
    public void PostTestRegistro() {
        JsonObject request = new JsonObject();
        request.addProperty("customer.firstName", "FAC");
        request.addProperty("customer.lastName", "LED");
        request.addProperty("customer.address.street", "A");
        request.addProperty("customer.address.city", "B");
        request.addProperty("customer.address.state", "C");
        request.addProperty("customer.address.zipCode", "11");
        request.addProperty("customer.phoneNumber", "11111111");
        request.addProperty("customer.ssn", "5555HH");
        request.addProperty("customer.username", "FF");
        request.addProperty("customer.password", "123");
        request.addProperty("repeatedPassword", "123");



        given()
                .contentType("application/json")
                .body(request)
                .when().post("https://parabank.parasoft.com/parabank/register.htm")
                .then().statusCode(201)
                .log().status()
                .log().body();
    }


}
