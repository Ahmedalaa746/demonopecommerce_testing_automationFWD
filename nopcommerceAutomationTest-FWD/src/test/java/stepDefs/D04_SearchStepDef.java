package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

import java.util.List;

public class D04_SearchStepDef {
    P03_Homepage homepage = new P03_Homepage();

    SoftAssert soft = new SoftAssert();

    @Given("user types (.*) in search box and presses the search button$")
    public void search_by_name(String name) {
        homepage.searchbox.sendKeys(name);
        homepage.searchBtn.click();
    }
    // @And("the url contains search url ")
    // public void check_search_url(){
    //   soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));

    //}
    //  @Then("^Search shows relevant results that contains(.*)$")
    //public void check_results_by_name(String name){
    //  List<WebElement> results= Hooks.driver.findElements(By.className("product-title"));
    //int count =results.size();
    //for (int i=0; i<count;i++){
    //  soft.assertTrue(results.get(i).getText().toLowerCase().contains(name));

    //}
    // soft.assertAll();
    //}

    @Given("^user typed (.*) in search box and pressed search$")
    public void search_by_sku(String sku) {
        homepage.searchbox.sendKeys(sku);
        homepage.searchBtn.click();

    }

    @When("user clicks on the product in search result")
    public void click_on_result() {
        homepage.product.click();
    }

    @Then("^the sku shown in this page contains the (.*) that was used in search$")
    public void check_sku(String sku) {
        Assert.assertTrue(homepage.productsku.getText().contains(sku));
    }


    @And("the url contains search url")
    public void theUrlContainsSearchUrl() {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

    @Then("search shows relevant results that contain <name>")
    public void searchShowsRelevantResultsThatContainName(String name) {
        List<WebElement> results = Hooks.driver.findElements(By.className("product-title"));
        int count = results.size();
        for (WebElement result : results) {
            soft.assertTrue(result.getText().toLowerCase().contains(name));
        }

        soft.assertAll();
    }
}

