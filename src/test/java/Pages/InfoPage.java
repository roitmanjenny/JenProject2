package Pages;

import Utils.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class InfoPage extends BasePage {
    private WebDriver driver;

    public InfoPage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
    }

    //insert sender name
    public void insertName() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@id='friendName']/input")));
        sendKeysToElement(By.xpath("//label[@id='friendName']/input"), "myself");
    }

    //pick automated event
    public void pickEvent() throws Exception {
        clickElement(By.xpath("//span[.='לאיזה אירוע?']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='יום הולדת']")));
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='יום הולדת']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    //delete the site blessing and insert mine
    public void enterBlessing() throws Exception {
        getWebElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea")).clear();
        sendKeysToElement(By.xpath("//form [@id='gift-step-1']/div[2]/div[4]/label/textarea"), "happy birthday");
    }

    //upload a pic
    public void uploadPicture() throws Exception {
        File image = new File("src/test/resources/images/Image.jpeg");
        sendKeysToElement(By.xpath("//label[@class='media-circle-btn ember-view bm-media-upload']//input"), image.getAbsolutePath());
    }

    //click next
    public void clickNext() throws Exception {
        clickElement(By.xpath("//form[@id='gift-step-1']/div[3]/div[2]/button"));
    }

    //pick the email option
    public void pickMail() throws Exception {
        clickElement(By.xpath("//div[@class='ember-view bm-sending-methods']/div[2]/div"));
    }

    //insert sender email
    public void enterMail() throws Exception {
        sendKeysToElement(By.id("email"), email);
    }

    //enter sender name
    public void enterSender() throws Exception {
        getWebElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input")).clear();
        sendKeysToElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input"), "Jen");
        assertEquals(getWebElement(By.xpath("//div[@class='mx-6 md-12 bottom-sm']/label/input")).getAttribute("value"), "Jen");
    }

    //click pay button
    public void clickPay() throws Exception {
        clickElement(By.xpath("//div[@class='mx-7 fields-section']/form/div[4]/div[2]/button"));
    }


}
