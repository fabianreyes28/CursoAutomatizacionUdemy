import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Compra {
    private WebDriver firefoxDriver;

    @Before
    public void abrirDriver() {
        //encontrar archivo exe de geckodriver
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

        //creamos opciones sobre nuestro driver
        FirefoxOptions options= new FirefoxOptions();
        options.setCapability("marionette",true);

        //nueva instancia de fireFoxDriver
        firefoxDriver =  new FirefoxDriver(options);
        //firefoxDriver = new FirefoxDriver(options);
        //definimos tiempo de espera hasta que aceptemos un timeout
        //firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hacer_una_compra() {
        //Abrimos una URL
        firefoxDriver.get("http://www.automationpractice.com/index.php");

        //Crear elementos Web
        WebElement labelSignIn = firefoxDriver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
        labelSignIn.click();

        //Cargamos el campo de email
        WebElement campoEmail = firefoxDriver.findElement(By.xpath("//input[@id='email']"));
        campoEmail.sendKeys("fabianreyes28@gmail.com");

        //Cargamos el campo de contraseña
        WebElement campoPassword = firefoxDriver.findElement(By.xpath("//input[@id='passwd']"));
        campoPassword.sendKeys("lomejor28");

        //Hacemos click en Sign in
        WebElement botonSignIn = firefoxDriver.findElement(By.xpath("//span[normalize-space()='Sign in']"));
        botonSignIn.click();

        //Seleccionamos la pestaña de "T-shirts"
        WebElement etiquetaTshirts = firefoxDriver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]"));
        etiquetaTshirts.click();


        //Creamos una acción
        Actions accion = new Actions(firefoxDriver);

        //Encontramos  la imagen que queremos comprar
        WebElement img_shirt = firefoxDriver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));

        //hacemos un scroll para encoantrar el objeto
        JavascriptExecutor javaScriptScroll = (JavascriptExecutor) firefoxDriver;
        javaScriptScroll.executeScript("arguments[0].scrollIntoView(true);", img_shirt);


        //String parent = firefoxDriver.getWindowHandle();
        //System.out.println("ventana actual= "+parent);

        //Movemos el cursor hacia el boton de agregar al carrito
        accion.moveToElement(img_shirt).moveToElement(firefoxDriver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"))).click().build().perform();
        WebElement btn_add = firefoxDriver.findElement(By.xpath("//span[normalize-space()='Add to cart']"));
        btn_add.click();

        //confirmar producto
        WebDriverWait wait = new WebDriverWait(firefoxDriver, 20);

        //WebElement btn_conf=firefoxDriver.findElement(By.cssSelector("body.category.category-5.category-tshirts.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) a.btn.btn-default.button.button-medium > span:nth-child(1)"));
        WebElement btn_conf = firefoxDriver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']"));

        String a = btn_conf.getText();
        System.out.println("Boton" + a);
        wait.until( ExpectedConditions.visibilityOf(btn_conf)).click();

        //Hacemos click en el tercer boton para cerrar compra
        WebElement botonTercerCerrarCompra = firefoxDriver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"));
        botonTercerCerrarCompra.click();

        WebElement botonTercerCerrarCompra2 = firefoxDriver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]"));
        botonTercerCerrarCompra2.click();
        //Hacemos click en el checkbox de aceptar las condiciones
        WebElement checkboxAceptoLasCondiciones = firefoxDriver.findElement(By.cssSelector("#cgv"));
        checkboxAceptoLasCondiciones.click();

        //Hacemos click en el cuarto boton para cerrar compra
        WebElement botonCuartoCerrarCompra = firefoxDriver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"));
        botonCuartoCerrarCompra.click();


        //Hacemos click en el boton pagar con cheque
        WebElement botonPagarConCheque = firefoxDriver.findElement(By.cssSelector(".cheque"));
        botonPagarConCheque.click();

        //Confirmamos la orden
        WebElement botonConfirmarOrden = firefoxDriver.findElement(By.xpath("//*[contains(text(),'I confirm my order')]"));
        botonConfirmarOrden.click();

        //Acertamos el banner de orden completa
        WebElement bannerOrdenCompleta = firefoxDriver.findElement(By.className("alert"));
        Assert.assertTrue(bannerOrdenCompleta.isDisplayed());




    }

    @After
    public void cerrarDriver() {
        //Cerrar ventana, apagar driver
        //firefoxDriver.quit();
    }
}