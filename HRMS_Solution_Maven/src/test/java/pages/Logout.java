package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {


    WebDriver driver;

    @FindBy(xpath = "//header/div[1]/div[3]/button[1]/div[1]/div[1]")
    WebElement userCornerAvatar;

    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    WebElement btnLogout;

    public Logout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(userCornerAvatar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout)).click();

    }
}
