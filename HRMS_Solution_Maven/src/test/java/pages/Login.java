package pages;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
public class Login {
    public WebDriver driver;
    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(css = "[type=password]")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//এই মেথডটি একটি JSON ফাইল থেকে একটি ইউজারের তথ্য (userName ও password) নেয়,
//তারপর সেটি লগইন ফর্মে username ইনপুট ফিল্ডে টাইপ করে দেয়।
    public void doLogin(int userIndex) throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
       // Users.json নামের ফাইলটি থেকে ডেটা (JSONArray) পড়ে
        //🔹 সেটাকে List আকারে data ভেরিয়েবলে রাখে।
        List<?> data = Utils.readJSONArray("./src/test/resources/Users.json");
// data লিস্ট থেকে userIndex অনুযায়ী ইউজার ডেটা নেয়।
//🔹 ধরো userIndex = 0 হলে প্রথম ইউজারের ডেটা আসবে।
        JSONObject userObj = (JSONObject) data.get(userIndex);
      //🔹 JSON object থেকে userName এবং password আলাদা করে String হিসেবে বের করা হয়।
        String userName = (String) userObj.get("userName");
        String passwd = (String) userObj.get("password");

        // Set username
        txtUserName.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);
        txtUserName.sendKeys(userName);
        Thread.sleep(1000);

        // Set password
        txtPassword.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);
        txtPassword.sendKeys(passwd);
        Thread.sleep(1000);

        // Click submit button
        btnSubmit.click();
        Thread.sleep(1000);


        try {
            Utils.changePassPopupHandler();
        } catch (Exception ignored) {}
    }
    }

    // This will try to close the Chrome browser's "Change Your Password" pop-up


