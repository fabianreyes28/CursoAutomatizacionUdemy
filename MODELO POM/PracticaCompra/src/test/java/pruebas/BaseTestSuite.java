package pruebas;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.PaginaCategoriaShirt;
import pageObjects.PaginaPrincipal;
import pageObjects.PaginaShopping;
import pageObjects.PaginaSingIn;

public class BaseTestSuite {
    WebDriver firefoxDriver;
    PaginaPrincipal paginaPrincipal;
    PaginaSingIn paginaSingIn;
    PaginaCategoriaShirt paginaCategoriaShirt;
    PaginaShopping paginaShopping;

    private void inizializarPaginas(WebDriver driver){
        paginaPrincipal =new PaginaPrincipal(driver);
        paginaSingIn=new PaginaSingIn( driver );
        paginaCategoriaShirt=new PaginaCategoriaShirt( driver );
        paginaShopping=new  PaginaShopping( driver );

    }

    @Before
    public void abrirDriver() {
        //encontrar archivo exe de geckodriver
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

        //creamos opciones sobre nuestro driver
        FirefoxOptions options= new FirefoxOptions();
        options.setCapability("marionette",true);

        //nueva instancia de fireFoxDriver
        firefoxDriver =  new FirefoxDriver(options);
        //definimos tiempo de espera hasta que aceptemos un timeout
        //firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inizializarPaginas(firefoxDriver);
    }


    @After
    public void cerrarDriver() {
        //Cerrar ventana, apagar driver
        //firefoxDriver.quit();
    }


}
