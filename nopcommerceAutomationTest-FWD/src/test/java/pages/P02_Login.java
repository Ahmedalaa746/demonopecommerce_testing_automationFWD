package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.Hooks;

public class P02_Login {
    public P02_Login (){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(className = "ico-login")
    public WebElement loginBtn ;

    @FindBy(id = "Email")
    public WebElement EmailField;

    @FindBy(id = "Password")
    public WebElement PassField ;

    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    public WebElement finishloginBtn ;

    @FindBy(className = "ico-account")
    public WebElement MyAccountTab;

    @FindBy(className = "message-error")
    public WebElement FailMessage ;

}
