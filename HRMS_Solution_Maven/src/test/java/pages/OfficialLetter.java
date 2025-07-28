package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfficialLetter {

    WebDriver driver;

    @FindBy(xpath = "//button[.//p[contains(text(), 'Create letter type')]]")
    WebElement CreateLtrBtn;

    @FindBy(xpath = "//input[@name='title']")
    WebElement TxtTitle;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement TxtDesc;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    WebElement responseMessage;

    @FindBy(xpath = "//button[.//p[contains(text(), 'Create Template')]]")
    WebElement CreateTemplateBtn;

    @FindBy(name = "template_type")
    WebElement TemplateTypeDropdown;

    @FindBy(className = "MuiAutocomplete-option")
    List<WebElement> selectType;

    @FindBy(css = "input[name=\"template_name\"][type=\"text\"]")
    WebElement TemplateName;

    @FindBy(xpath = "//span[normalize-space()='Employee Name']")
    WebElement option;

    @FindBy(xpath = "//button[normalize-space()='Submit Form']")
    WebElement SubmitBtn;

    // Initialize elements
    public OfficialLetter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Letter Type
    public void LtrBtn() throws InterruptedException {
        CreateLtrBtn.click();
        Thread.sleep(2000);
    }

    public void title(String LetterTitle) throws InterruptedException {
        TxtTitle.sendKeys(LetterTitle);
        Thread.sleep(2000);
    }

    public void description() throws InterruptedException {
        TxtDesc.sendKeys("This is a test letter type");
        Thread.sleep(2000);
    }

    public void button() throws InterruptedException {
        SaveBtn.click();
        Thread.sleep(1000);
        responseMessage.click();
    }

    //Letter Template
    public void TemplateBtn() throws InterruptedException {
        CreateTemplateBtn.click();
        Thread.sleep(2000);
    }

    public void Type() throws InterruptedException {
        TemplateTypeDropdown.click();
        Thread.sleep(2000);
        selectType.get(2).click();
        Thread.sleep(2000);
    }

    public void name() throws InterruptedException {
        TemplateName.sendKeys("Offer Letter Template");
        Thread.sleep(2000);
    }

    public void selectOption() throws InterruptedException {
        option.click();
        Thread.sleep(2000);

        //Using Scroller to click Submit button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0, 500);");
    }

    public void SubBtn() throws InterruptedException {
        SubmitBtn.click();
        Thread.sleep(1000);
        responseMessage.click();
    }
}
