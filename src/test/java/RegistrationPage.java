import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private WebDriver driver;

    public RegistrationPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickRegister(){
        clickElement(By.className("notSigned"));
    }

}
