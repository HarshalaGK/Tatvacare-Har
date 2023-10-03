package datafactory;

import dataobjects.AdminLogin;
import dataobjects.Login;

public class AdminLoginData {
    public AdminLogin getAdminLoginData() {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setAdminMobileNumber("9871434312");
        adminLogin.setAdminPassword("Dhspl@123");
        return adminLogin;
    }
}
