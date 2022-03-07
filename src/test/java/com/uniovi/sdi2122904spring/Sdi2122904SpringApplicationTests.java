package com.uniovi.sdi2122904spring;

import com.uniovi.sdi2122904spring.pageobjects.*;
import com.uniovi.sdi2122904spring.util.SeleniumUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.*;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sdi2122904SpringApplicationTests {
    //UNIVERSIDAD
    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    static String Geckodriver = "C:\\Users\\uo276436\\Downloads\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    //CASA
    //static String Geckodriver = "B:\\Users\\Sergio\\Desktop\\UNIVERSIDAD 2\\2nd\\SDI\\recursos\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    //static String Geckodriver = "C:\\Path\\geckodriver-v0.30.0-win64.exe";
    //static String Geckodriver = "C:\\Dev\\tools\\selenium\\geckodriver-v0.30.0-win64.exe";
    //Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";
    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }
    @Test
    void contextLoads() {
    }
    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }
    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }
    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {}
    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }
/*
    @Test
    @Order(1)
    void PR01A() {
        PO_HomeView.checkWelcomeToPage(driver, PO_Properties.getSPANISH());
    }
    @Test
    @Order(2)
    void PR01B() {
        List<WebElement> welcomeMessageElement = PO_HomeView.getWelcomeMessageText(driver,
                PO_Properties.getSPANISH());
        Assertions.assertEquals(welcomeMessageElement.get(0).getText(),
                PO_HomeView.getP().getString("welcome.message", PO_Properties.getSPANISH()));
    }
    //PR02. Opción de navegación. Pinchar en el enlace Registro en la página home
    @Test
    @Order(3)
    public void PR02() {
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
    }
    //PR03. Opción de navegación. Pinchar en el enlace Identifícate en la página home
    @Test
    @Order(4)
    public void PR03() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
    }
    //PR04. Opción de navegación. Cambio de idioma de Español a Inglés y vuelta a Español
    @Test
    @Order(5)
    public void PR04() {
        PO_HomeView.checkChangeLanguage(driver, "btnSpanish", "btnEnglish",
                PO_Properties.getSPANISH(), PO_Properties.getENGLISH());
    }
        //hice el anterior commit mal
        //PR05. Prueba del formulario de registro. registro con datos correctos
        @Test
        @Order(6)
        public void PR05() {
            //Vamos al formulario de registro
            PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
            //Rellenamos el formulario.
            PO_SignUpView.fillForm(driver, "77777778A", "Josefo", "Perez", "77777", "77777");
            //Comprobamos que entramos en la sección privada y nos nuestra el texto a buscar
            String checkText = "Notas del usuario";
            List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
            Assertions.assertEquals(checkText, result.get(0).getText());
        }
        //PR06A. Prueba del formulario de registro. DNI repetido en la BD
        // Propiedad: Error.signup.dni.duplicate
        @Test
        @Order(7)
        public void PR06A() {
            PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
            PO_SignUpView.fillForm(driver, "99999990A", "Josefo", "Perez", "77777", "77777");
            List<WebElement> result = PO_SignUpView.checkElementByKey(driver, "Error.signup.dni.duplicate",
                    PO_Properties.getSPANISH() );
            //Comprobamos el error de DNI repetido.
            String checkText = PO_HomeView.getP().getString("Error.signup.dni.duplicate",
                    PO_Properties.getSPANISH());
            Assertions.assertEquals(checkText , result.get(0).getText());
        }
        //PR06B. Prueba del formulario de registro. Nombre corto.
        // Propiedad: Error.signup.dni.length
        @Test
        @Order(8)
        public void PR06B() {
            PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
            PO_SignUpView.fillForm(driver, "99999990B", "Jose", "Perez", "77777", "77777");
            List<WebElement> result = PO_SignUpView.checkElementByKey(driver, "Error.signup.name.length",
                    PO_Properties.getSPANISH() );
            //Comprobamos el error de Nombre corto de nombre corto .
            String checkText = PO_HomeView.getP().getString("Error.signup.name.length",
                    PO_Properties.getSPANISH());
            Assertions.assertEquals(checkText , result.get(0).getText());
        }

    @Test
    @Order(9)
    public void PR07() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999990A", "123456");
        //Comprobamos que entramos en la pagina privada de Alumno
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }
    @Test
    @Order(10)
    public void PR08() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999993D", "123456");
        //Comprobamos que entramos en la pagina privada de profesor
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }
    @Test
    @Order(11)
    public void PR09() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999988F", "123456");
        //Comprobamos que entramos en la pagina privada de administrador
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }
    @Test
    @Order(12)
    public void PR10() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999990A", "123455");

        //Comprobamos el error de identificacion
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, "text",PO_View.getTimeout());

    }
    @Test
    @Order(13)
    public void PR11() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999990A", "123456");

        //Comprobamos que entramos en la pagina privada de usuario
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());


        //Nos desconectamos
        PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
    }
*/
    //PR12. Loguearse, comprobar que se visualizan 4 filas de notas y desconectarse usando el rol de  estudiante
    @Test
    @Order(14)
    public void PR12() {
        PO_PrivateView.login(driver ,"99999990A", "123456",      "Notas del usuario");
        //COmprobamos que entramos en la pagina privada de Alumno
        List<WebElement> result = PO_View.checkElementBy(driver, "text", "Notas del usuario");
        //Contamos el número de filas de notas
        List<WebElement> markList = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr",
                PO_View.getTimeout());
        Assertions.assertEquals(4, markList.size());
        PO_PrivateView.logout(driver);
    }
    //PR13. Loguearse como estudiante y ver los detalles de la nota con Descripcion = Nota A2.
    @Test
    @Order(15)
    public void PR13() {
        PO_PrivateView.login(driver ,"99999990A", "123456", "Notas del usuario");
        List<WebElement> result = PO_View.checkElementBy(driver, "text", "Notas del usuario");
        //SeleniumUtils.esperarSegundos(driver, 1);
        //Contamos las notas
        By enlace = By.xpath("//td[contains(text(), 'Nota A2')]/following-sibling::*[2]");
        driver.findElement(enlace).click();
        //Esperamos por la ventana de detalle
        String checkText = "Detalles de la nota";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText,result.get(0).getText());
        PO_PrivateView.logout(driver);
    }
    //P14. Loguearse como profesor y Agregar Nota A2.
//P14. Esta prueba podría encapsularse mejor ...
    @Test
    @Order(16)
    public void PR14() {
        PO_PrivateView.login(driver ,"99999993D", "123456","99999993D");
        //Pinchamos en la opción de menú de Notas: //li[contains(@id, 'marks-menu')]/a
        //List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id, 'marksmenu')]/a");
        PO_PrivateView.clickElement(driver,"//li[contains(@id, 'marks-menu')]/a",0);
        //Esperamos a que aparezca la opción de añadir nota: //a[contains(@href, 'mark/add')]
        PO_PrivateView.clickElement(driver,"//a[contains(@href, 'mark/add')]",0);

        //Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
        String checkText = "Nota Nueva 1";
        PO_PrivateView.fillFormAddMark(driver, 3, checkText, "8");
        //Esperamos a que se muestren los enlaces de paginación de la lista de notas
        PO_PrivateView.clickElement(driver,"//a[contains(@class, 'page-link')]",3);
        //Comprobamos que aparece la nota en la página
        List<WebElement> elements = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, elements.get(0).getText());
        PO_PrivateView.logout(driver);
    }
    @Test
    @Order(17)
    public void PR15() {
        PO_PrivateView.login(driver ,"99999993D", "123456","99999993D");
        //Pinchamos en la opción de menú de Notas: //li[contains(@id, 'marks-menu')]/a
        //List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id, 'marksmenu')]/a");
        PO_PrivateView.clickElement(driver,"//li[contains(@id, 'marks-menu')]/a",0);
        //Pinchamos en la opción de lista de notas.
        PO_PrivateView.clickElement(driver,"//a[contains(@href, 'mark/list')]",0);
        //Esperamos a que se muestren los enlaces de paginación la lista de notas
        PO_PrivateView.clickElement(driver,"//a[contains(@class, 'page-link')]",3);
        //Esperamos a que aparezca la Nueva nota en la última página
        //Y Pinchamos en el enlace de borrado de la Nota "Nota Nueva 1"
        //elements = PO_View.checkElementBy(driver, "free", "//td[contains(text(), 'Nota Nueva 1')]/followingsibling::*/a[contains(@href, 'mark/delete')]");
        PO_PrivateView.clickElement(driver,"//td[contains(text(), 'Nota Nueva 1')]/following-sibling::*/a[contains(@href,'mark/delete')]",0);
        //Volvemos a la última página
        PO_PrivateView.clickElement(driver,"//a[contains(@class, 'page-link')]",3);
        //Y esperamos a que NO aparezca la última "Nueva Nota 1"
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, "Nota Nueva 1",PO_View.getTimeout());
        PO_PrivateView.logout(driver);
    }

}
