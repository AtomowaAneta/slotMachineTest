import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class GameTest extends BaseSlotMachineTestClass {
    @BeforeSuite
    protected void setUpDriverBeforeTestSuite(){ super.setUpDriverBeforeTestSuite(); }

    @BeforeTest
    protected void setUpBeforeTestCase(){ super.setUpBeforeTestCase(); }

    @AfterTest
    protected void doAfterTestCase(){
        super.doAfterTestCase();
    }


    @AfterMethod
    protected void doAfterMethod(){ driver.navigate().refresh(); }

    @AfterSuite
    protected void doAfterTestSuite(){ super.doAfterTestSuite(); }


}
