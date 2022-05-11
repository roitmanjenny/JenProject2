import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage extends BasePage{
    private WebDriver driver;

    public InfoPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void InsertName(){
        sendKeysToElement(By.id("ember1362"),"myself");
    }
    public void PickEvent(){

    }
    public void EnterBlessing(){

    }
    public void UploadPicture(){

    }
    public void ClickNext(){

    }

}
