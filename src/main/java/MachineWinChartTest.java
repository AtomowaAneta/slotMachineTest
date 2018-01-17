import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class MachineWinChartTest extends BetTest {
    double[] valuesArray = {3,2};

    @Test
    public void testIfInitialValueForTrPrize32Is200() {
        //given
        double expectedValue = 200.00;
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);

        //when
        double actualValue = slotMachinePOM.getTrPrize32Value();
        //then
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testIfInitialValueForTrPrize33IsNot100() {
        //given
        double expectedValue = 100.00;
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);

        //when
        double actualValue = slotMachinePOM.getTrPrize33Value();
        //then
        Assert.assertNotEquals(actualValue, expectedValue);
    }

    @Test
    public void testIfInitialValuesInWinChartAreCorrect() {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        int expectedSuccessCounter = 9;
        int actualSuccessCounter = 0;
        List < WebElement > tdPayoutList = driver.findElements(By.className("tdPayout"));

        //when
        actualSuccessCounter = slotMachinePOM.checkAllWinChartValues(tdPayoutList);


        //then
        Assert.assertEquals(actualSuccessCounter, expectedSuccessCounter);
    }

    @Test
    public void testIfWhenBetIs3AllValuesFromWinChartAreTripled() throws InterruptedException {
        //given
        SlotMachinePOM slotMachinePOM = new SlotMachinePOM(driver);
        int expectedSuccessCounter = 9;
        int actualSuccessCounter = 0;
        List < WebElement > tdPayoutList = driver.findElements(By.className("tdPayout"));
        //when

        actualSuccessCounter = slotMachinePOM.getTripledValues(tdPayoutList);

        //then
        Assert.assertEquals(actualSuccessCounter, expectedSuccessCounter);
    }



}