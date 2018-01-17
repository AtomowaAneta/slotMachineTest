import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MachineIconTest extends BetTest{
    @Test
    public void testIfAfterPageIsVisitedInitialMachineIconIsReelSet1(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        String expectedReelSet = "reelSet1";

        //when
        String actualReelSet = slotMachinePOM.getslotsSelectorClassAttribute();

        //then
        Assert.assertTrue(actualReelSet.contains(expectedReelSet));
    }

    @Test
    public void testIfAfterPageIsVisitedInitialMachineIconIsNotReelSet3(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        String notExpectedReelSet = "reelSet3";

        //when
        String actualReelSet = slotMachinePOM.getslotsSelectorClassAttribute();

        //then
        Assert.assertFalse(actualReelSet.contains(notExpectedReelSet));
    }
    /**

    @Test
    public void testWhenChangeIconButtonIsClickedIconsWillChangeToReelSet2() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        String expectedReelSet = "reelSet2";

        //when
        String actualReelSet = slotMachinePOM.getSlotsSelectorWrapperAfterClicks(1);
        System.out.println(actualReelSet);

        //then
        Assert.assertTrue(actualReelSet.contains(expectedReelSet));
    }

    @Test
    public void testWhenChangeIconButtonIsClicked3TimesReelSetWilNotBe4() throws InterruptedException{
        //given
        int numberOfClicks = 3;
        String notExpectedReelSet = "reelSet4";
        WebElement slotsSelectorWrapper = driver.findElement(By.id("slotsSelectorWrapper"));
        WebElement btnChangeReels = driver.findElement(By.className("btnChangeReels"));

        //when
        for (int i=0;i<numberOfClicks;i++){
            btnChangeReels.click();
            thread.sleep(1000);
        }
        String actualReelSet = slotsSelectorWrapper.getAttribute("class");

        //then
        Assert.assertFalse(actualReelSet.contains(notExpectedReelSet));
    }
    **/
}
