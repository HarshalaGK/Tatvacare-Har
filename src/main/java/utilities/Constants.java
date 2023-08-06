package utilities;

public class Constants
{
	public static final String PROPERTY_FILE ="src/main/resources/constants.properties";

	//Environment i.e. Dev,QA,Prod etc
	public static final String ENV = JavaHelpers.setSystemVariable(PROPERTY_FILE,"Env");
	
	//Setting up the URLs
	public static final String URL = JavaHelpers.getPropertyValue(PROPERTY_FILE,"url_" + ENV);

	//Selenium constants
	public static final int WEBDRIVER_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE,"WebDriverWaitDuration"));
	public static final int MINIMUM_WEBDRIVER_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE,"MinimumWebDriverWaitDuration"));
	public static final int PAGEFACTORY_WAIT_DURATION= Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE,"PageFactoryWaitDuration"));
	public static final String SCREENSHOT_LOCATION= JavaHelpers.getPropertyValue(PROPERTY_FILE,"ScreenshotLocation");

	//App Data
	public static final String MobileNumber = JavaHelpers.getPropertyValue(PROPERTY_FILE,"mobileNumber");
	public static final String Password = JavaHelpers.getPropertyValue(PROPERTY_FILE,"password");

	public static final String StoreFrontMobileNumber = JavaHelpers.getPropertyValue(PROPERTY_FILE,"storeFrontMobileNumber");
	public static final String StoreFrontPassword = JavaHelpers.getPropertyValue(PROPERTY_FILE,"storeFrontPassword");

	// Email constants
	public static final String MAILINATORNAME = "mailinator";
	public static final String MAILINATORURL =
			"https://www.mailinator.com/v4/public/inboxes.jsp?to=";

	private Constants() 
	{
	    throw new IllegalStateException("Constants class");
	}

}


