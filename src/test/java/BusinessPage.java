import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusinessPage extends BasePage{
    private WebDriver driver;
    public BusinessPage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickBusiness(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='grid bm-product-cards']/div[1]/a/div/div[3]")));
        WebElement elementToClick = driver.findElement(By.xpath("//ul[@class='grid bm-product-cards']/div[1]/a/div/div[3]"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }
    public void insertPrice(String price) throws Exception {
        sendKeysToElement(By.xpath("//form[@action='submitMoney']/div/label"),price);
    }
    public void clickChoose() throws Exception {
        clickElement(By.xpath("//form[@action='submitMoney']/div[2]/button"));
    }
}
