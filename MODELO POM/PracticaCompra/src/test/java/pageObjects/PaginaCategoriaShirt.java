package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class PaginaCategoriaShirt {
    WebDriver driver;

    @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    WebElement img_shirt;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement btn_add;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement btn_confirma1;


    public void comprarFadedShortSleeveTshirts() {

        Actions action = new Actions( this.driver );
        JavascriptExecutor javaScriptScroll = (JavascriptExecutor) driver;
        javaScriptScroll.executeScript("arguments[0].scrollIntoView(true);", img_shirt);

        action.moveToElement( img_shirt ).moveToElement( btn_add ).click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until( ExpectedConditions.elementToBeClickable(btn_confirma1));
        btn_confirma1.click();

    }


    public PaginaCategoriaShirt(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements( driver, this );

    }
}
