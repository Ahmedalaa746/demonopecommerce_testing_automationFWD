package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P03_Homepage;

public class D06_homeSlidersStepDef {
    P03_Homepage homepage=new P03_Homepage();

    @When("user clicks on first slider")
    public void clicks_on_first_slider(){
        homepage.slider.get(0).click();
    }

    @Then("check if url is nokia url")
    public void check_nokia_url(){
        // i didn't use explicit wait because the loading is done before this method is even invoked
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    @When("user clicks on second slider")
    public void click_on_second_slider(){
        homepage.slider.get(1).click();
    }

    @Then("check if url is iphone url")
    public void check_iphone_url(){
        // i didn't use explicit wait because the loading is done before this method is even invoked
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
}
