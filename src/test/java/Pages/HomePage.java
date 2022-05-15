package Pages;

import Utils.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();

    }

    //select the price filter
    public void selectPrice() throws Exception {
        clickElement(By.xpath("//span[.='סכום']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-label-wrapper']//span[contains(text(), '100-199')]")));
        WebElement elementToClick2 = driver.findElement(By.xpath("//div[@class='input-label-wrapper']//span[contains(text(), '100-199')]"));
        new Actions(driver).moveToElement(elementToClick2).click().perform();
    }

    //select the region filter
    public void selectRegion() throws Exception {
        clickElement(By.xpath("//span[.='אזור']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@value='14']")));
        WebElement elementToClick3 = driver.findElement(By.xpath("//li[@value='14']"));
        new Actions(driver).moveToElement(elementToClick3).click().perform();
    }

    //select the category filter
    public void selectCategory() throws Exception {
        clickElement(By.xpath("//span[.='קטגוריה']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@value='359']")));
        WebElement elementToClick = driver.findElement(By.xpath("//li[@value='359']"));
        new Actions(driver).moveToElement(elementToClick).click().perform();
    }

    //click search button
    public void clickSearch() throws Exception {
        clickElement(By.id("ember1188"));
    }
}
