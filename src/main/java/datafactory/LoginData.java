package datafactory;

import dataobjects.Login;

public class LoginData {
    public Login getLoginData() {
        Login login = new Login();
        login.setMobileNumber("7000131472");
        login.setPassword("Hlink@123");
        return login;
    }
    public Login getInvalidLoginData() {
        Login login = new Login();
        login.setInvalidMobileNumber("7000676372");
        login.setInvalidPassword("hllnk@123");
        return login;
    }
    public Login getOneFilledData(){
        Login login = new Login();
        login.setMobileNumber("7000131452");
        return login;
    }

}
