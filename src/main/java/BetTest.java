import org.testng.annotations.*;


public class BetTest extends BaseSlotMachineTestClass {

        @BeforeClass
        protected void setUpDriverBeforeTestSuite(){ super.setUpDriverBeforeTestSuite(); }

        @BeforeMethod
        protected void setUpBeforeTestCase(){
            super.setUpBeforeTestCase();
        }

        @AfterTest
        protected void doAfterTestCase(){
            super.doAfterTestCase();
        }

        /**
        @AfterMethod
        protected void doAfterMethod(){ driver.navigate().refresh(); }
**/
        @AfterSuite
        protected void doAfterTestSuite(){ super.doAfterTestSuite(); }


    }


