package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaginaPrincipal {

    @FindBy(xpath = "//*[@title='Log in to your customer account']")
    private WebElement labelSignIn;

    @FindBy (xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]")
    private  WebElement pestanaShirt;


    public void irASing(){
        labelSignIn.click();
    }
    public void irAShirt() { pestanaShirt.click();}

    public PaginaPrincipal(WebDriver driver){
        PageFactory.initElements( driver,this );

    }
}
