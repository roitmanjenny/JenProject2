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

    public InfoPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void insertName() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@id='friendName']/input")));

        sendKeysToElement(By.xpath("//label[@id='friendName']/input"), "myself");
    }

    public void pickEvent() {
        clickElement(By.xpath("//span[.='לאיזה אירוע?']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='יום הולדת']")));
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='יום הולדת']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    public void enterBlessing() {
        getWebElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea")).clear();
        sendKeysToElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea"), "happy birthday");
    }

    public void uploadPicture() {
        File image = new File("src/test/resources/images/Image.jpeg");
        //getWebElement(By.xpath("//label[@class='media-circle-btn ember-view bm-media-upload']//input")).sendKeys(image.getAbsolutePath());
        sendKeysToElement(By.xpath("//label[@class='media-circle-btn ember-view bm-media-upload']//input"),image.getAbsolutePath());
    }

    public void clickNext() {
        clickElement(By.xpath("//form[@id='gift-step-1']/div[3]/div[2]/button"));
    }

    public void pickMail() {
        clickElement(By.xpath("//div[@class='ember-view bm-sending-methods']/div[2]/div"));
    }

    public void enterMail() {
        sendKeysToElement(By.id("email"), email);
    }

    public void enterSender() {
        getWebElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input")).clear();
        sendKeysToElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input"), "Jen");
    }

    public void clickPay() {
        clickElement(By.xpath("//div[@class='mx-7 fields-section']/form/div[4]/div[2]/button"));
    }


}
