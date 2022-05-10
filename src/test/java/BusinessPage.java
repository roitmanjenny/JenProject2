import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusinessPage extends BasePage{
    private WebDriver driver;

    public BusinessPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickCategory(){
        clickElement(By.className("product-card-bg"));
    }
    public void clickBusiness(){
        clickElement(By.xpath("//ul[@class='grid bm-product-cards']/div/a"));
    }
    public void insertPrice(String price){
        sendKeysToElement(By.xpath("//form[@action='submitMoney']/div/label"),price);
    }
    public void clickChoose(){
        clickElement(By.xpath("//form[@action='submitMoney']/div[2]/button"));
    }
}
