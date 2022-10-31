package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P03_Homepage;

import java.util.ArrayList;

public class D07_FollowUsStepDef {
    P03_Homepage homepage = new P03_Homepage();

    @When("user opens facbook link ")

    public void open_facebook(){
        homepage.facebookBtn.click();
    }

    @When("user opens twitter link")

    public void open_twitter(){
        homepage.twitterBtn.click();
    }

    @When("user opens rss link ")

    public void open_rss(){
        homepage.rssBtn.click();
    }


    @Then("{string} is opened in a new tab")

    public void check_link(String link ) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs =new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),link);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }


}
