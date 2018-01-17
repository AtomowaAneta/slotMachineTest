import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MachineCheckTest extends MachineTestClass {

    @Test
    public void testIfMachine1IsSelectedAfterVisitingWebsite(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        String expectedClassName = "slotMachine1";
        //when
        String actualClassName = slotMachinePOM.getslotsSelectorClassAttribute();

        //then
        Assert.assertTrue(actualClassName.contains(expectedClassName));
    }

    @Test
    public void testIfMachine4IsNotSelectedAfterVisitingWebSite(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        String notExpectedClassName = "slotMachine4";

        //when
        String actualClassName = slotMachinePOM.getslotsSelectorClassAttribute();

        //then
        Assert.assertFalse(actualClassName.contains(notExpectedClassName));
    }

}
