import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class MachineTestClass extends BaseSlotMachineTestClass {

    @BeforeSuite
    protected void setUpDriverBeforeTestSuite(){ super.setUpDriverBeforeTestSuite(); }
    @BeforeTest
    protected void setUpBeforeTestCase(){
        super.setUpBeforeTestCase();
    }

    @AfterTest
    protected void doAfterTestCase(){
        super.doAfterTestCase();
    }

    @AfterSuite
    protected void doAfterTestSuite(){ super.doAfterTestSuite(); }
}
