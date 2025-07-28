package testrunner;

import org.testng.annotations.Test;
import pages.PayrollManagement;
import setup.Setup;

import java.io.IOException;
import java.text.ParseException;

public class PayrollManagementTestRunner extends Setup {

    PayrollManagement Payroll;

    @Test(priority = 9,description = "Salary ")

    public void salary_generation() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        Payroll = new PayrollManagement(driver);

        // Generate salary
        Payroll.Generate_salary();

        // Approval flow through different roles
        Payroll.Approve_salary_department_supervisor();

        //Payroll.Approve_salary_verticel_head();
        Payroll.Approve_salary_Div_Supervisor();

        Payroll.Approve_salary_HR();
        Payroll.Approve_salary_Accountant();
        Payroll.Approve_salary_top_management();
        Payroll.assertion_of_salary();

    }


}
