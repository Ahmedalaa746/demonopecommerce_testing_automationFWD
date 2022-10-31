package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.P03_Homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hovercategoriesStepDef {
    P03_Homepage hoverCategory =new P03_Homepage();
    SoftAssert softAssert =new SoftAssert();
    Actions actions = new Actions(Hooks.driver);
    public static int selectedCategory;
    int selectedSubCategory ;
    List<WebElement> subCategoryLinks;
    List<WebElement>maincategorries ;
    String locator;
    String selectedSubCategoryText;
    String selectedMainCategoryText;

    @Given("user hover on one of the main categories")
    public void hoverMainCategories()throws InterruptedException{
        maincategorries = hoverCategory.getMainCategories();
        int count = maincategorries.size();
        int min = 0;
        int max =count - 1 ;
        selectedCategory =(int) Math.floor(Math.random() *(max - min + 1)+ min);
        actions.moveToElement(maincategorries.get(selectedCategory)).perform();
        selectedMainCategoryText = maincategorries.get(selectedCategory).getText();
        System.out.println("Main category is selected: "+ selectedMainCategoryText);
        Thread.sleep(2000);

    }

    @When("user can view sub category if exist")
    public void setSelectedSubCategory(){
        selectedCategory=selectedCategory + 1 ;
        locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
        Hooks.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Then("user can select sub category or open main category")
    public void selectSubOrMaincategory() throws InterruptedException{
        if (selectedCategory > 0 && selectedCategory <= 3) {
            int count = subCategoryLinks.size();
            int min = 0;
            int max = count - 1;
            selectedSubCategory = (int) Math.floor(Math.random() * ( max - min + 1 ) + min);
            actions.moveToElement(subCategoryLinks.get(selectedSubCategory)).perform();
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            System.out.println("Sub category is selected:   " + selectedSubCategoryText);
            Thread.sleep(2000);
            subCategoryLinks.get(selectedSubCategory).click();
            softAssert.assertEquals(hoverCategory.get_page_title().getText().toLowerCase().trim(), selectedSubCategoryText.toLowerCase().trim());
            softAssert.assertAll();

        } else {
            maincategorries.get(selectedCategory - 1).click();
            softAssert.assertEquals(hoverCategory.get_page_title().getText().toLowerCase().trim(), selectedMainCategoryText.toLowerCase().trim());
            softAssert.assertAll();
        }
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

}
