package testrunner;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.OfficialLetter;
import setup.Setup;

public class OfficialLetterTestRunner extends Setup {

    OfficialLetter letter;

    @Test(priority = 20, description = "User can create new letter type")
    public void testLetterType() throws InterruptedException {
        letter = new OfficialLetter(driver);
        Faker faker = new Faker();
        driver.get("https://staging.smartoffice.ai/company/official-letter/letter-types");
        Thread.sleep(2000);
        letter.LtrBtn();
        letter.title(faker.name().title());
        letter.description();
        letter.button();
    }

    @Test(priority = 3, description = "User can create new letter template")
    public void testLetterTemplate() throws InterruptedException {
        letter = new OfficialLetter(driver);
        driver.get("https://staging.smartoffice.ai/company/official-letter/templates");
        Thread.sleep(2000);
        letter.TemplateBtn();
        letter.Type();
        letter.name();
        letter.selectOption();
        letter.SubBtn();

    }

}
