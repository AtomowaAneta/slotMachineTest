import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MachineBetTest extends BaseSlotMachineTestClass {
    private int expectedBetValue = 0;
    private int spinUpClicks = 0;
    private int spinDownClicks = 0;
    private int actualBetValue = 0;

    @Test
    public void testIfInitialBetValueIs1(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        expectedBetValue = 1;

        //when
        actualBetValue = slotMachinePOM.getBetValue();

        //then
        Assert.assertEquals(actualBetValue, expectedBetValue);
    }

    @Test
    public void testIfAfter4ClicksBetSpinUpBetValueIsNot4() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        spinUpClicks = 4;
        int notExpectedBetValue = 4;

        //when
        actualBetValue = slotMachinePOM.getBetValueSpinUpClicks(spinUpClicks);

        //then
        Assert.assertNotEquals(actualBetValue, notExpectedBetValue);
    }

    @Test
    public void testIf8ClicksBetSpinUpAnd3BetSpinDownBetValueIs6() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
         expectedBetValue = 6;
         spinUpClicks = 8;
         spinDownClicks = 3;
        //when
        actualBetValue = slotMachinePOM.getBetValueAfterSpinUpAndSpinDown(8,3);

        //then
        Assert.assertEquals(actualBetValue,expectedBetValue);
    }

    @Test
    public void testIf1IsTheMinimumBetValue() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        expectedBetValue = 1;

        //when
        actualBetValue = slotMachinePOM.getBetValueSpinDownClicks(3);

        //then
        Assert.assertEquals(actualBetValue,expectedBetValue);
    }

    @Test
    public void testIf10IsTheMaximumBetValue() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        expectedBetValue = 10;
        spinUpClicks = 11;

        actualBetValue = slotMachinePOM.getBetValueSpinUpClicks(spinUpClicks);
        //then
        Assert.assertEquals(actualBetValue,expectedBetValue);
    }

    @Test
    public void testIfAfterEachClickProperBetValueIsSet() throws InterruptedException {
        //given
        spinUpClicks = 10;
        int expectedSuccessCounter = 10;
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);

        //when
        int actualSuccessCounter = slotMachinePOM.getSuccessCounter(spinUpClicks);


        //then
        Assert.assertEquals(actualSuccessCounter,expectedSuccessCounter);
    }
}
