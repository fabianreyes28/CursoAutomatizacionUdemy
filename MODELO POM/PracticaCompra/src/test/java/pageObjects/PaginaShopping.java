package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaShopping {


    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    private WebElement btn_confirmar;


    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    private WebElement Btn_confirmar2;

    @FindBy(css = "#cgv")
    private WebElement checkBox;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    private WebElement Btn_confirmar3;

    @FindBy(css = ".cheque")
    WebElement pagarConCheck;

    @FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
    WebElement btnConfirmar4;

    @FindBy(className = "alert")
    WebElement confirmarBanerOrdenCompleta;



    public void clickBtnSumary(){
        btn_confirmar.click();
    }
    public void clickBtnAddress(){ Btn_confirmar2.click();}
    public void clickCheckBox()  { checkBox.click();}
    public void clickBtn3 (){ Btn_confirmar3.click();}
    public void clickPagarConCheck(){ pagarConCheck.click();}
    public void clickbtnConfirmar4(){ btnConfirmar4.click();}
    public boolean assertConfirmarBanerOrdenCompleta(String mensaje){

        System.out.println("Mensaje enviado="+ mensaje);
        System.out.println("Mensaje=="+confirmarBanerOrdenCompleta.getText());
        return mensaje.equals(confirmarBanerOrdenCompleta.getText() );
        // Assert.assertTrue(confirmarBanerOrdenCompleta.isDisplayed());
    }



    public PaginaShopping(WebDriver driver){
        PageFactory.initElements( driver,this );

    }
}
