import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SlotMachinePOM {
    WebDriver webDriver;
    Thread thread;
    By slotsSelectorWrapper = By.id("slotsSelectorWrapper");
    By bet = By.id("bet");
    By betSpinUp = By.id("betSpinUp");
    By betSpinDown = By.id("betSpinDown");
    By btnChangeReels = (By.id("btnChangeReels"));
    By trPrize32 = By.xpath("//*[@id=\"trPrize_32\"]/span");
    By trPrize33 = By.xpath("//*[@id=\"trPrize_33\"]/span");
    By tdPayoutList = By.className("tdPayout");
    By spinButton = By.id("spinButton");
    By creditsAfter = By.id("credits");
    By lastWin = By.id("lastWin");

    double[] valuesArray = {
            200.00,
            50.00,
            20.00,
            16.00,
            15.00,
            14.00,
            12.00,
            7.00,
            4.00
    };
    public SlotMachinePOM(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public boolean getLastWinFieldState(){

        while (webDriver.findElement(lastWin).getText().isEmpty()){
            webDriver.findElement(spinButton).click();
        }

        return webDriver.findElement(lastWin).getText().isEmpty();
    }

    public boolean getBetValueAfterSpinClick(){
        int creditsValueAfter=0;
        int creditsValueBefore = Integer.parseInt(webDriver.findElement(creditsAfter).getText());
        webDriver.findElement(spinButton).click();
        creditsValueAfter = Integer.parseInt(webDriver.findElement(creditsAfter).getText());

        return ((creditsValueAfter == creditsValueBefore -1) ||
        (creditsValueAfter == creditsValueBefore +1));

    }

    public String getSpinButtonAttribute(){
        webDriver.findElement(spinButton).click();
        return webDriver.findElement(spinButton).getAttribute("class");
    }

    public int getTripledValues(List<WebElement> list){
        double actualTrPrize = 0;
        int actualSuccessCounter = 0;
        double[] tripledArray = new double[10];
        for (int i = 0; i < valuesArray.length; i++) {
            tripledArray[i] = valuesArray[i] * 3;
        }
        //when
        webDriver.findElement(betSpinUp).click();
        webDriver.findElement(betSpinUp).click();

        for (int i = 0; i < tripledArray.length - 1; i++) {
            actualTrPrize = Double.parseDouble(list.get(i).getText());

            if (tripledArray[i] == actualTrPrize) {
                actualSuccessCounter++;
            }
        }
        return actualSuccessCounter;
    }

    public int checkAllWinChartValues(List<WebElement> list){
        int actualSuccessCounter = 0;

        for (int i = 0; i <= valuesArray.length - 1; i++) {
            double actualTrPrize = Double.parseDouble(list.get(i).getAttribute("data-basepayout"));
            if (valuesArray[i] == actualTrPrize) {
                actualSuccessCounter++;
            }
        }
        return  actualSuccessCounter;
    }

    public double getTrPrize32Value(){
        return Double.parseDouble(webDriver.findElement(trPrize32).getAttribute("data-basepayout"));
    }
    public double getTrPrize33Value(){
        return Double.parseDouble(webDriver.findElement(trPrize33).getAttribute("data-basepayout"));
    }
    public String getslotsSelectorClassAttribute(){
      return  webDriver.findElement(slotsSelectorWrapper).getAttribute("class");
    }

    public int getBetValue(){
        return Integer.parseInt(webDriver.findElement(bet).getText());
    }

    public int getBetValueSpinUpClicks(int spinUpClicks) throws InterruptedException {
        for (int i=0; i<spinUpClicks; i++){
            webDriver.findElement(betSpinUp).click();
            thread.sleep(1000);
        }
        return Integer.parseInt(webDriver.findElement(bet).getText());
    }
    public int getBetValueSpinDownClicks(int spinDownClicks) throws InterruptedException {
        for (int i=0; i<spinDownClicks; i++){
            webDriver.findElement(betSpinDown).click();
            thread.sleep(1000);
        }
        return Integer.parseInt(webDriver.findElement(bet).getText());
    }

    public int getBetValueAfterSpinUpAndSpinDown(int spinUp, int spinDown) throws InterruptedException {
        for (int i=0; i<spinUp; i++){
            webDriver.findElement(betSpinUp).click();
            thread.sleep(1000);
        }

        for (int i=0;i<spinDown; i++){
           webDriver.findElement(betSpinDown).click();
            thread.sleep(2000);
        }
       return Integer.parseInt(webDriver.findElement(bet).getText());
    }

    public int getSuccessCounter(int spinUpClicks) throws InterruptedException {
        int actualSuccessCounter = 0;
        int[] betValues = {1,2,3,4,5,6,7,8,9,10};
        for (int i=0;i<spinUpClicks;i++){
            if(betValues[i] == Integer.parseInt(webDriver.findElement(bet).getText())){
                actualSuccessCounter++;
            }
            webDriver.findElement(betSpinUp).click();
            thread.sleep(500);
        }
        return actualSuccessCounter;
    }
    /**
    protected String getSlotsSelectorWrapperAfterClicks(int spinUpClicks) throws InterruptedException {
        String actual = webDriver.findElement(slotsSelectorWrapper).getAttribute("class");
        for (int i=0; i<spinUpClicks; i++){
            webDriver.findElement(betSpinUp).click();
            thread.sleep(1000);
            actual= webDriver.findElement(slotsSelectorWrapper).getAttribute("class");
        }

         return actual;


    }
     **/

}

