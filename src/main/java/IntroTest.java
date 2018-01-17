import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Calendar;


/**
 * Created by stycz on 13.09.17.
 */
public class IntroTest {
     private WebElement webElement;
     private WebDriver driver;
     private String baseURL = "";
     private String expected = null;
     private String actual = null;

    @BeforeSuite
    public void initialize(){
        System.setProperty("webdriver.gecko.driver", "/home/stycz/Documents/geckodriverr");
        driver = new FirefoxDriver();
        baseURL = "http://slotmachinescript.com/";
        driver.get(baseURL);
    }

    @Test(groups = "intro")
    public void testIfPageIsSlotMachineGamePage(){
        expected = "http://slotmachinescript.com/";
        actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
    }
    @Test(groups = "intro")
    public void testIfPageTitleIsCorrect(){
        expected = "Add a HTML5 Slot Machine to your Site";
        actual = driver.getTitle();
        Assert.assertEquals(actual,expected);
    }
    @Test(groups = "intro")
    public void testIfPageYearIsActualToCurrentYear(){
        Calendar currentYear = Calendar.getInstance();
        expected = Integer.toString(currentYear.get(Calendar.YEAR));
        webElement = driver.findElement(new By.ByXPath("//*[@id=\"footer\"]/div/p"));
        actual = webElement.getText();
        Assert.assertTrue(actual.contains(expected));
    }

    @AfterSuite
    public void terminateBrowser(){
        driver.close();
    }
}
