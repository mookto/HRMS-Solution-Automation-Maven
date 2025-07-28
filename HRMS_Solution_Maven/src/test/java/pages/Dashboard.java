package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

public class Dashboard {
    WebDriver driver;
    String actualTitle;
    Utils utils;

    Actions action;

    @FindBy(xpath = "//p[contains(text(),'Dashboard')]")
    WebElement dashboardTab;

    @FindBy(xpath = "//p[contains(text(),'Employee Management')]")
    WebElement employeeManagementTab;

    @FindBy(xpath = "//p[contains(text(),'Employees')]")
    WebElement btnEmployee;

    @FindBy(xpath = "//p[contains(text(),'Supervisors')]")
    WebElement btnSupervisor;

    @FindBy(xpath = "//p[contains(text(),'Employment Close')]")
    WebElement btnEmploymentClose;

    @FindBy(xpath = "//span[contains(text(),'My-dashboard')]")
    WebElement myDashboard;

    @FindBy(xpath = "//p[contains(text(),'Supervisor Dashboard')]")
    WebElement supervisorDashboard;

    @FindBy(xpath = "//p[contains(text(),'Official Letter')]")
    WebElement officialLetterTab;

    @FindBy(xpath = "//p[contains(text(),'Letter Types')]")
    WebElement btnLetterType;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEmployeeManagementTab() {
        employeeManagementTab.click();
    }

    public void clickEmployeeBtn() {
        Utils.waitForElement(driver, By.xpath("//p[contains(text(),'Employees')]"), 10);
        btnEmployee.click();
    }

    public void clickSupervisorBtn() throws InterruptedException {
        Utils.waitForElement(driver, By.xpath("//p[contains(text(),'Supervisors')]"), 10);
        btnSupervisor.click();
    }

    public void clickEmploymentCloseBtn() {
        Utils.waitForElement(driver, By.xpath("//p[contains(text(),'Employment Close')]"), 10);
        btnEmploymentClose.click();
    }

    public void clickOfficialLetterTab() {
        Utils.scrollInto(driver, officialLetterTab);
        officialLetterTab.click();
    }

    public void clickLetterTypeBtn() {
        Utils.scrollInto(driver, btnLetterType);
        btnLetterType.click();
    }

    public void assertEmployeeDashboard(String expectedTitle) {
        actualTitle = myDashboard.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void assertSupervisorDashboard(String expectedTitle) {
        actualTitle = supervisorDashboard.getText();
    }
}
