import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoPage extends BasePage{
    private WebDriver driver;

    public InfoPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void insertName(){
        sendKeysToElement(By.id("ember1362"),"myself");
    }
    public void pickEvent(){
        clickElement(By.xpath("//span[.='לאיזה אירוע?']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='יום הולדת']")));
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='יום הולדת']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }
    public void enterBlessing(){
       getWebElement(By.xpath("//label [@id='ember1373']/textarea")).clear();
       sendKeysToElement(By.xpath("//label [@id='ember1373']/textarea"),"happy birthday");
    }
    public void uploadPicture(){

        getWebElement(By.id("ember1382")).sendKeys("/Users/jennyroitman/Library/CloudStorage/OneDrive-IgentifyLtd/JennyR/IdeaProjects/JenProject2/Image.jpeg");

    }
    public void clickNext(){
        clickElement(By.id("ember1383"));

    }

}
