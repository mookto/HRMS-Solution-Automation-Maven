package testrunner;

import org.testng.annotations.Test;
import pages.Dashboard;
import pages.Login;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;

public class LoginTestRunner extends Setup {

    Login login;
    Dashboard dashboard;

    @Test(priority = 10, description = "User can login with valid credential")
    public void doLogin() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        login = new Login(driver);
        dashboard = new Dashboard(driver);

        dashboard.assertEmployeeDashboard("My-dashboard");

        Utils.switchUser(driver, 2);
        dashboard.assertSupervisorDashboard("Supervisor dashboard");

        Utils.switchUser(driver, 1);
    }
}