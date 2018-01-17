import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

abstract class BaseSlotMachineTestClass {
    WebDriver driver;
    Thread thread;

    public String getDriverPath() {
        return driverPath;
    }

    public static void setDriverPath(String driverPath) {
        BaseSlotMachineTestClass.driverPath = driverPath;
    }

    static String driverPath = "";

    @BeforeClass
    protected void setUpDriverBeforeTestSuite(){
        System.setProperty("webdriver.gecko.driver", getDriverPath());
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    protected void setUpBeforeTestCase(){
        thread = new Thread();
        String baseURL = "http://slotmachinescript.com/";
        driver.get(baseURL);
    }

    /**
    @AfterMethod
    protected void doAfterTestMethod(){
        driver.navigate().refresh();
    }
    **/
    @AfterTest
    protected void doAfterTestCase(){
        driver.close();
    }

    @AfterSuite
    protected void doAfterTestSuite(){
    }

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add(args[0]);
        setDriverPath(args[1]);
        testng.setTestSuites(suites);
        testng.run();
    }
}
