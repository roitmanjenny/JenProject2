import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void selectPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='form ember-view']//label[1]//div")));
        WebElement elementToClick = driver.findElement(By.xpath("//form[@class='form ember-view']//label[1]//div"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
        clickElement(By.xpath("//form[@class='form ember-view']//label[1]//li[2]"));
    }

    public void selectRegion(String value) {
        clickElement(By.xpath("//form[@class='form ember-view']//label[2]"));
        Select region = new Select(driver.findElement(By.xpath("//form[@class='form ember-view']//label[2]//select")));
        region.selectByValue(value);
    }

    public void selectCategory(String value) {
        clickElement(By.xpath("//form[@class='form ember-view']//label[3]"));
        Select cathegory = new Select(driver.findElement(By.xpath("//form[@class='form ember-view']//label[3]//select")));
        cathegory.selectByValue(value);
    }

    public void clickSearch() {
        clickElement(By.id("ember1188"));
    }
}
