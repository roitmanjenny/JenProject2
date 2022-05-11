import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverSingleton.getDriverInstance();

    }

    public void selectPrice() {
        clickElement(By.xpath("//span[.='סכום']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@value='2']")));
        WebElement elementToClick2 = driver.findElement(By.xpath("//li[@value='2']"));
        new Actions(driver).moveToElement(elementToClick2).click().perform();
    }

    public void selectRegion() {
        clickElement(By.xpath("//span[.='אזור']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@value='14']")));
        WebElement elementToClick = driver.findElement(By.xpath("//li[@value='14']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    public void selectCategory() {
        clickElement(By.xpath("//span[.='קטגוריה']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@value='359']")));
        WebElement elementToClick = driver.findElement(By.xpath("//li[@value='359']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    public void clickSearch() {
        clickElement(By.id("ember1188"));
    }
}
