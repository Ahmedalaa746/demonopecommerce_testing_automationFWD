package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.P01_Register;

public class D01_RegisterStepDef {
    // create new object from register page

    P01_Register register =new P01_Register();
    SoftAssert soft =new SoftAssert();

    @Given("user go to register page")
    public void register_page()
    {register.registerBtn.click();}

    @When("user select gender type")
    public void gender_male_select()
    {register.maleCheckBox.click();}

    @And("user enter first name \"automation\"and last name \"tester\"")
    public void enter_names(){
        register.fNameField.sendKeys("automation");
        register.lNameField.sendKeys("tester");

    }
    @And("user enter date of birth")
    public void enter_dob(){
        register.DList.click();
        Select dselect = new Select(register.DList);
        dselect.selectByVisibleText("15");

        register.MList.click();
        Select mSelect =new Select(register.MList);
        mSelect.selectByVisibleText("January");

        register.YList.click();
        Select ySelect = new Select(register.YList);
        ySelect.selectByVisibleText("2005");


    }

    @And("user enter email \"test@example.com\" fields")
    public void enter_email(){
        register.EmailField.sendKeys("test@example.com");

    }

    @And("user fills Password fields \"P@sswOrd\" \"P@sswOrd\"")
    public void enter_passwords(){
        register.PassField.sendKeys("P@sswOrd");
        register.ConfirmField.sendKeys("P@sswOrd");

    }

    @And("user clicks on register button")
    public void click_register_button(){
        register.finishregisterBtn.click();
    }
    @Then("success message is displayed")
    public void check_success_message(){
        String color= register.registermessage.getCssValue("color");
        if (color.equals("green"))
            soft.assertTrue(register.registermessage.getText().contains("your registration completed"),"the registration assertion failed ");
        soft.assertAll();
    }

}
