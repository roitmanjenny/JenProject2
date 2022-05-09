import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class RegistrationPage extends BasePage {
    private WebDriver driver;

    public RegistrationPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickRegisterLogin(){
        clickElement(By.className("notSigned"));
    }
    public void clickRegister(){
        clickElement(By.xpath("//span[@class='text-link theme']"));
    }
    public void fillRegistrationForm(){
        //fillField(By.id("ember1794"),"firstname");
        sendKeysToElement(By.id("ember1794"),"firstname");
        sendKeysToElement(By.id("ember1801"),"jen@email.com");
        sendKeysToElement(By.id("valPass"),"Q1w2e3r4");
        sendKeysToElement(By.id("ember1815"),"Q1w2e3r4");
    }
    public void assertFields(){
        assertEquals(getWebElement(By.id("ember1794")).getAttribute("value"),"firstname");
        assertEquals(getWebElement(By.id("ember1801")).getAttribute("value"),"jen@email.com");
    }
    public void clickRegister2(){
        clickElement(By.id("ember1821"));
    }
//    public void fillField(By locator, String text){
//        sendKeysToElement(locator,text);
//    }


}
