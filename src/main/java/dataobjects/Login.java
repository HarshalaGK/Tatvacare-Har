package dataobjects;

public class Login {

 private String mobileNumber;
 private String password;

 private String invalidMobileNumber;
    private String invalidPassword;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInvalidMobileNumber(){ return invalidMobileNumber;}
    public void setInvalidMobileNumber(String invalidMobileNumber){this.invalidMobileNumber=invalidMobileNumber;}
    public String getInvalidPassword(){return invalidPassword;}
    public void setInvalidPassword(String invalidPassword){this.invalidPassword=invalidPassword;}


}
