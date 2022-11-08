package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.P03_Homepage;

import java.time.Duration;

import static stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef {
    P03_Homepage homepage=new P03_Homepage();

    @When("user clicks on first slider")
    public void clicks_on_first_slider(){
        homepage.slider.get(1).click();
    }

    @Then("check if url is nokia url")
    public void check_nokia_url(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(3));
        boolean sign =wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(sign);

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    @When("user clicks on second slider")
    public void click_on_second_slider(){
        homepage.slider.get(2).click();
    }

    @Then("check if url is iphone url")
    public void check_iphone_url(){

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
}
