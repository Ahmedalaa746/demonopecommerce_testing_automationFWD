package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

public class D03_currenciesStepDef {
    P03_Homepage homepage = new P03_Homepage();

    SoftAssert soft = new SoftAssert();

    // @When("select Euro currency from the dropdown list on the top left of home page")
    //public void select_euro_currency(){
    //  homepage.currencyList.click();
    //Select dselect =new Select(homepage.currencyList);
    //dselect.selectByVisibleText("Euro");
    //}

    //  @Then("Verify Euro symbol \\ (&) is shown on the 4 products displayed in home page ")
    //public void verify_euro_symbol(){
    //  for (int i=0;i<4;i++){
    //    String price= homepage.prices.get(i).getText();
    //  soft.assertTrue(price.contains("&"));

    // }
    //soft.assertAll();
    //}


    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrencyFromTheDropdownListOnTheTopLeftOfHomePage() {
        homepage.currencyList.click();
        Select dselect = new Select(homepage.currencyList);
        dselect.selectByVisibleText("Euro");
    }

    @Then("verify Euro Symbol \\(€) is shown on the {int} products displayed in Home page")
    public void verifyEuroSymbol€IsShownOnTheProductsDisplayedInHomePage(int arg0) {
        for (int i = 0; i < 4; i++) {
            String price = homepage.prices.get(i).getText();
            soft.assertTrue(price.contains("&"));
        }
        soft.assertAll();

    }

}