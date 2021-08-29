package pruebas;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PaginaCategoriaShirt;
import pageObjects.PaginaPrincipal;

public class Compra extends BaseTestSuite {


    @Test
    public void hacer_una_compra() {
        //Abrimos una URL
        firefoxDriver.get( "http://www.automationpractice.com/index.php" );

        paginaPrincipal.irASing();
        paginaSingIn.identificarse( "fabianreyes28@gmail.com", "lomejor28" );
        paginaPrincipal.irAShirt();
        paginaCategoriaShirt.comprarFadedShortSleeveTshirts();
        paginaShopping.clickBtnSumary();
        paginaShopping.clickBtnAddress();
        paginaShopping.clickCheckBox();
        paginaShopping.clickBtn3();
        paginaShopping.clickPagarConCheck();
        paginaShopping.clickbtnConfirmar4();
        Assert.assertTrue( paginaShopping.assertConfirmarBanerOrdenCompleta( "Your order on My Store is complete.") );

    }

}