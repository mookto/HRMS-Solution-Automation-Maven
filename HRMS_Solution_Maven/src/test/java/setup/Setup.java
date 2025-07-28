package setup;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Login;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
public class Setup {



    public static WebDriver driver; //static variable used to share this webDriver to multiple test suites
    @BeforeSuite
    public void setup() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {

        if (driver == null) { // This will prevent reinitialization of the driver if already set.
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.get(Utils.getBaseUrl());
        }

        Login login = new Login(driver);
        login.doLogin(1); // userIndex 1 is admin
    }

// This method will quite/close the browser after finishing executing the test case(s)
    @AfterSuite
    public void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            driver.close();
        }
    }
}
