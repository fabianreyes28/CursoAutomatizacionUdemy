package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSingIn {

    @FindBy(xpath = "//input[@id='email']" )
    WebElement campoEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement campoPassword;

    @FindBy(xpath ="//span[normalize-space()='Sign in']")
    WebElement botonSignIn;

    private void llenarCampoEmail(String email){
        campoEmail.sendKeys( email );
    }
    private void llenarContraseña(String password){
        campoPassword.sendKeys( password );
    }
    private void hacerClickSingIn(){
        botonSignIn.click();

    }
    public void identificarse(String email, String password){
        llenarCampoEmail( email );
        llenarContraseña( password );
        hacerClickSingIn();

    }

    public PaginaSingIn(WebDriver driver){
        PageFactory.initElements( driver,this );

    }
}
