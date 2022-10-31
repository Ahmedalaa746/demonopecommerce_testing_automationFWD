package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.Hooks;

public class P01_Register {
    //constructor
    public P01_Register(){
        PageFactory.initElements(Hooks.driver,this);}

    @FindBy(className = "ico-register")
    public WebElement registerBtn ;

    @FindBy(id = "gender-male")
    public WebElement maleCheckBox ;

    @FindBy(id = "FirstName")
    public WebElement fNameField ;

    @FindBy(id = "LastName")
    public WebElement lNameField ;

    @FindBy(css = "select[name=\"DateOfBirthDay\"]")
    public WebElement DList ;

    @FindBy(css = "select[name=\"DateOfBirthMonth\"]")
    public WebElement MList ;

    @FindBy(css = "select[name=\"DateOfBirthYear\"]")
    public WebElement YList ;

    @FindBy(id = "Email")
    public WebElement EmailField ;

    @FindBy(id = "Password")
    public WebElement PassField ;

    @FindBy(id = "ConfirmPassword")
    public WebElement ConfirmField ;

    @FindBy(id = "register-button")
    public WebElement finishregisterBtn ;

    @FindBy(className = "result")
    public WebElement registermessage;





    }

