package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Login;
import pages.Logout;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//এই method টা একটি .json ফাইল থেকে JSONArray data পড়ে সেটিকে List হিসেবে return করে।
    public static List<?> readJSONArray(String filename) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            return (JSONArray) parser.parse(reader);
        }
    }


    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInput); //ফাইল থেকে ডেটা পড়ে, properties object-এ সেট করে।
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }
    //ফাইলের মধ্যে "base_url" নামে যেটা আছে, সেটা রিটার্ন করে।
    public static String getBaseUrl() {
        return properties.getProperty("base_url");
    }

    public static void sleep(int i) {
    }

    // This method is used for switch from existing user to a new user
    public static void switchUser (WebDriver driver, int userIndex) throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        Logout logout = new Logout(driver);
        Login login = new Login(driver);

        try { // In case user is already logged out
            logout.clickLogout();
        } catch (Exception ignored) {}

        login.doLogin(userIndex);
    }


    // Using this method will wait for specific webElement to be visible to a specific time
    public static void waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // This method will scroll the screen to a specific available webElement
    public static void scrollInto (WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    // This method will assert all response messages across the system
    public static void assertAlertMessage (WebDriver driver, String expectedMessage){
        Utils.waitForElement(driver, By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"), 5);
        String actualMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    // This method is used for handling browser popup that appears for weak password
    public static void changePassPopupHandler () {

        try { // In case the pop not appeared
            Robot robot = new Robot();
            robot.mouseMove(1143, 342); // move to x=500, y=300
            Thread.sleep(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
