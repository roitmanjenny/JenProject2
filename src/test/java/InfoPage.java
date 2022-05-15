import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class InfoPage extends BasePage {
    private WebDriver driver;

    public InfoPage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void insertName() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@id='friendName']/input")));
        sendKeysToElement(By.xpath("//label[@id='friendName']/input"), "myself");
    }

    public void pickEvent() throws Exception {
        clickElement(By.xpath("//span[.='לאיזה אירוע?']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='יום הולדת']")));
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='יום הולדת']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    public void enterBlessing() throws Exception {
        getWebElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea")).clear();
        sendKeysToElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea"), "happy birthday");
    }

    public void uploadPicture() throws Exception {
        File image = new File("src/test/resources/images/Image.jpeg");
        sendKeysToElement(By.xpath("//label[@class='media-circle-btn ember-view bm-media-upload']//input"),image.getAbsolutePath());
    }

    public void clickNext() throws Exception {
        clickElement(By.xpath("//form[@id='gift-step-1']/div[3]/div[2]/button"));
    }

    public void pickMail() throws Exception {
        clickElement(By.xpath("//div[@class='ember-view bm-sending-methods']/div[2]/div"));
    }

    public void enterMail() throws Exception {
        sendKeysToElement(By.id("email"), email);
    }

    public void enterSender() throws Exception {
        getWebElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input")).clear();
        sendKeysToElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input"), "Jen");
    }

    public void clickPay() throws Exception {
        clickElement(By.xpath("//div[@class='mx-7 fields-section']/form/div[4]/div[2]/button"));
    }


}
