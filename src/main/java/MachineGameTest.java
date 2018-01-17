import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MachineGameTest extends BaseSlotMachineTestClass {

    @Test
    public void testWhenGameIsInProgressSpinButtonCanNotBeClicked() throws InterruptedException {
        //given
        String expectedState = "disabled";
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);

        //when
        String actualState = slotMachinePOM.getSpinButtonAttribute();

        //then

        Assert.assertEquals(actualState,expectedState);
    }

    @Test
    public void testWhenBetValueIs1AfterSpinClickTotalSpinCounterWillBeChangedBy1(){
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        boolean isChangedByOne = true;
        boolean actualChange = false;

       //when
        actualChange = slotMachinePOM.getBetValueAfterSpinClick();

        //then
        Assert.assertEquals(actualChange,isChangedByOne);
    }

    @Test
    public void testWhenBetValueIs4AfterSpinClickTotalSpinCounterWillNotBeChangedBy2(){
        //given
        WebElement creditsBefore = driver.findElement(By.id("credits"));
        WebElement spinButton = driver.findElement(By.id("spinButton"));
        WebElement betSpinUp = driver.findElement(By.id("betSpinUp"));
        int creditsValueBefore = Integer.parseInt(creditsBefore.getText());
        int creditsValueAfter = 0;
        int spinUpClicks = 3;

        //when
        for (int i=0;i<spinUpClicks;i++){
            betSpinUp.click();
        }
        spinButton.click();

        //then
        WebElement creditsAfter = driver.findElement(By.id("credits"));
        creditsValueAfter = Integer.parseInt(creditsAfter.getText());
        Assert.assertFalse((creditsValueAfter == creditsValueBefore -2) ||
                (creditsValueAfter == creditsValueBefore +2) );
    }

    @Test
    public void testIfWinLastWinFieldWillNotBeEmpty(){
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        boolean expected = false;
        boolean actual= false;
        WebElement spinButton = driver.findElement(By.id("spinButton"));
        WebElement lastWin = driver.findElement(By.id("lastWin"));
        while (lastWin.getText().isEmpty()){
            spinButton.click();
        }

        actual = slotMachinePOM.getLastWinFieldState();

        Assert.assertEquals(actual,expected);

    }
}
