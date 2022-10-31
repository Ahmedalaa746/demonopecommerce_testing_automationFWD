package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver =null;

    @Before
    public static void OpenBrowser(){

        //1- set system property
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Alameya\\IdeaProjects\\nopcommerceAutomationTest-FWD\\Drivers\\chromedriver.exe" );

        //2-create new object from webdriver
        driver=new ChromeDriver();

        //3-configuration
           //3.1 - maximize window
        driver.manage().window().maximize();

           //3.2 - Implicate wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4-Navigate to Url

        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After

    public static void QuitDriver()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
