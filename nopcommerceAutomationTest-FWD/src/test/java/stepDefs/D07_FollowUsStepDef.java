package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P03_Homepage;

import java.util.ArrayList;

import static stepDefs.Hooks.driver;

public class D07_FollowUsStepDef {
    P03_Homepage homepage = new P03_Homepage();

    @When("user opens facebook link ")

    public void open_facebook(){
        homepage.facebookBtn.click();
    }

    @When("user opens twitter link")

    public void open_twitter(){
        homepage.twitterBtn.click();
    }

   // @When("user opens rss link ")

    //public void open_rss(){
      //  homepage.rssBtn.click();
    //}


 //   @Then("{string} is opened in a new tab")

   // public void check_link(String link ) throws InterruptedException {
     //   Thread.sleep(2000);
       // ArrayList<String> tabs =new ArrayList<>(Hooks.driver.getWindowHandles());
        //Hooks.driver.switchTo().window(tabs.get(1));
        //Assert.assertEquals(Hooks.driver.getCurrentUrl(),link);
        //Hooks.driver.close();
        //Hooks.driver.switchTo().window(tabs.get(0));
    //}


    @When("user opens facebook link")
    public void userOpensFacebookLink()throws InterruptedException

    {homepage.facebookBtn.click();
        ArrayList tab= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf((tab.get(1))));
   }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String link)throws InterruptedException {
        Thread.sleep(1000);
        ArrayList<String> tabs =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),link);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @When("user opens rss link")
    public void userOpensRssLink() { homepage.rssBtn.click();
        ArrayList tab= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf((tab.get(1))));
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {homepage.youtubeBtn.click();
        ArrayList tab= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf((tab.get(1))));
    }
}
