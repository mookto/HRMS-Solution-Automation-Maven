package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class PayrollManagement {
    WebDriver driver;

    @FindBy(xpath = "//p[contains(text(),'Payroll Management')]")
    WebElement payrollManagementMenu;

    @FindBy(xpath = "//p[normalize-space()='Salary']")
    WebElement salaryMenu;

    @FindBy(xpath = "//p[contains(text(),'Generate Salary')]")
    WebElement generateSalary;

    @FindBy(xpath = "//input[@placeholder='Select month']")
    WebElement selectMonth;

    @FindBy(xpath = "//div[contains(text(),'Jan')]")
    WebElement selectAprMonth;

    @FindBy(xpath = "//button[text()=\"Generate\"]")
    WebElement generateConfirm;

    @FindBy(xpath = "//thead/tr[1]/th[2]/div[1]/div[1]/div[1]/label[1]/input[1]")
    WebElement withoutAttendance;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement confirm;

    @FindBy(xpath = "//button[contains(@class,'css-umuwd1')]")
    WebElement viewBtn;

    @FindBy(xpath = "//button[normalize-space()='Approve']")
    WebElement approve;

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    WebElement pressYes;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement backBtn;

    @FindBy(xpath = "(//button[contains(@class,'css-5xkobu')])[1]")
    WebElement payBtnClick;

    @FindBy(xpath = "//td[normalize-space()='740,736.00']")
    WebElement netPayable;

    @FindBy(xpath = "//button[normalize-space()='Download']")
    WebElement downloadBtn;

    @FindBy(xpath = "//li[normalize-space()='Salary Sheet as PDF']")
    WebElement salarySheetPDF;

    @FindBy(xpath = "//li[normalize-space()='Bank Statement as PDF']")
    WebElement bankStatementPDF;

    @FindBy(xpath = "//p[normalize-space()='Dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "//p[normalize-space()='My Dashboard']")
    WebElement myDashboard;

    @FindBy(xpath = "//h5[normalize-space()='123456']")
    WebElement payableAmount;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    WebElement responseMessage;

    @FindBy(xpath = "//button[contains(@aria-label,'More Actions')]//*[name()='svg']")
    WebElement moreActionBtn;

    @FindBy(xpath = "//li[@role='menuitem']")
    WebElement deleteSalary;

    @FindBy(xpath = "//span[normalize-space()='January 2025']")
    WebElement payslip;

    @FindBy(xpath = "//button[contains(@class,'css-codus5')]")
    WebElement regenerateBtn;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteBtn;

    public PayrollManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Generate_salary() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {

        Utils.switchUser(driver, 2);  //login with supervisor to generate and approve salary

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(generateSalary)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectMonth)).click();
        Thread.sleep(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(selectAprMonth)).click();
        selectAprMonth.click();
        wait.until(ExpectedConditions.elementToBeClickable(generateConfirm)).click();
        wait.until(ExpectedConditions.elementToBeClickable(withoutAttendance)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_department_supervisor() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Scroll down smoothly
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();
        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_verticel_head() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Utils.switchUser(driver, 3);

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Smooth scrolling
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();
        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_Div_Supervisor() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Utils.switchUser(driver, 4);  //login with division supervisor approve salary

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Smooth scrolling down by 500 pixels
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();

        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_HR() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait for better stability
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Utils.switchUser(driver, 5);  //login with HR supervisor to approve salary

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Smooth scrolling down by 500 pixels
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();

        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_Accountant() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {

        Utils.switchUser(driver, 6);  //login with Accountant to approve salary

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 10 seconds timeout

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Scroll down using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();

        Thread.sleep(1000);
        responseMessage.click();
    }

    public void Approve_salary_top_management() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Set explicit wait time
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Utils.switchUser(driver, 7);  //login with top management  to approve salary

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0, 500);");

        wait.until(ExpectedConditions.elementToBeClickable(approve)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pressYes)).click();

        Thread.sleep(1000);
        responseMessage.click();
    }

    public void assertion_of_salary() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        Utils.switchUser(driver, 2);  //login with HR supervisor to approve salary
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10 seconds timeout

        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();
        String actualPayableElement = netPayable.getText().trim();
        String expectedNetPayble = "740,736.00";
        Assert.assertEquals(actualPayableElement, expectedNetPayble);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboard)).click();
        wait.until(ExpectedConditions.elementToBeClickable(myDashboard)).click();

        wait.until(ExpectedConditions.elementToBeClickable(payslip)).click();
        Thread.sleep(2000);

        String actualPayableAmount = payableAmount.getText().trim();
        System.out.printf("user net payable amount is " + actualPayableAmount);
        String expectedNetPayableAmount = "123456";
        Assert.assertEquals(actualPayableAmount, expectedNetPayableAmount);
        wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(payrollManagementMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salaryMenu)).click();

        wait.until(ExpectedConditions.elementToBeClickable(regenerateBtn)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(withoutAttendance)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
        Thread.sleep(1000);
        responseMessage.click();
        wait.until(ExpectedConditions.elementToBeClickable(moreActionBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteSalary)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

        Thread.sleep(1000);
        responseMessage.click();

        Utils.switchUser(driver, 1);
    }
}
