package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

import java.awt.*;
import java.time.Duration;

import static stepDefs.Hooks.driver;

public class D08_WishListStepDef {
    P03_Homepage homepage = new P03_Homepage();
    SoftAssert soft = new SoftAssert();

    @When("user clicks on wishlist button on product")

    public void click_wishlistBtn(){
        homepage.wishlistBtns.get(2).click();
    }
    @Then("user will see a green success message")

    public void check_successmsg() throws InterruptedException {
        Thread.sleep(2000);
        soft.assertTrue(homepage.successmsg.getText().contains("the product has been added to your wishlist"),"First Assertion");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(homepage.wishlistBtn));
        String color= Color.fromString(homepage.bg.getCssValue("background-color")).asHex();
        soft.assertEquals(color,"#4bb07a","second Assertion");
        soft.assertAll();
    }

    @And("user clicks on wishlist")
    public void wait_and_click(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homepage.bg));
        homepage.wishlistBtn.click();
    }

    @Then("user will see product in wishlist")

    public void verify_qty(){
        soft.assertNotEquals(homepage.wishlistBtn.getText(),"0");
        soft.assertAll();
    }
}
