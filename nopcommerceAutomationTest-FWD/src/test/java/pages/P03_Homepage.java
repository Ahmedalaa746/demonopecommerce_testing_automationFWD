package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.Hooks;

import java.util.List;

public class P03_Homepage {
    public P03_Homepage (){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(id = "customerCurrency")
    public WebElement currencyList ;

    @FindBy(className = "price")
    public List<WebElement> prices;

    // search feature annotations

    @FindBy(id = "small-searchterms")
    public WebElement searchbox ;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement searchBtn;

    @FindBy(className = "product-title")
    public WebElement product;

    @FindBy(className = "sku")
    public WebElement productsku ;

    //hoverCategories annotations

    @FindBy(className = "page-title")
    public WebElement pagetitle;

    // homeSliders annotations
    @FindBy(className = "nivo-imageLink")
    public List<WebElement>slider ;

    //followUs annotations

    @FindBy(className = "facebook")
    public WebElement facebookBtn;

    @FindBy(className = "twitter")
    public WebElement twitterBtn;

    @FindBy(className = "rss")
    public WebElement rssBtn ;

    @FindBy(className = "youtube")
    public WebElement youtubeBtn ;

    //wishlist annotations

    @FindBy(css = "button[class=\"button-2 add-to-wishlist-button\"]")
    public List<WebElement> wishlistBtns;

    @FindBy(id = "bar-notification")
    public WebElement successmsg ;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div")
    public WebElement bg;

    @FindBy(className = "wishlist-label")
    public WebElement wishlistBtn;

    @FindBy(className = "qty-input")
    public WebElement wishlistQty;

    public List<WebElement> getMainCategories(){

        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public WebElement get_page_title(){

        return (WebElement) Hooks.driver.findElements(By.className("page-title"));


    }



}
