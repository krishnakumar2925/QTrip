package Crio.QTrip.PageObject;

public class RegisterPage {
	RemoteWebDriver driver;
    String URL;
    SeleniumWrapper wrapper;
    static String uniqueEmail;
    static String PWD;
    public RegisterPage(RemoteWebDriver driver,String mainURL) {
        this.driver=driver;
        this.URL=mainURL;
        wrapper = new SeleniumWrapper(driver);
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
    PageFactory.initElements(factory,this);
    }
    @FindBy(xpath="//a[text()='Register']")
    WebElement registerButton;

    @FindBy(css="#floatingInput")
    WebElement userName;
    
    @FindBy(name="password")
    WebElement password;

    @FindBy(name="confirmpassword")
    WebElement confirmPassword;

    @FindBy(xpath="//button[normalize-space(text())='Register Now']")
    WebElement regButton;

    public String navigateToRegisterPage() {
       try{ 
        //wrapper class
        //wrapper.navigateToURL(URL);
         // Wait until the Register button is clickable
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        // //wrapper class
        wrapper.click(registerButton);  
        Wait(driver, "register");
       }
       catch(Exception e){
        e.printStackTrace();
       }
       return driver.getCurrentUrl();
    }
    public void Wait(RemoteWebDriver driver,String Url){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains(Url));
        
    }
    public LoginPage registerUser(Method m, String string2) {
        String randomDigits = UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0, 5);
        uniqueEmail = m.getName() + randomDigits + "@gmail.com";
        PWD=string2;
        System.out.println("User eamil address: "+uniqueEmail);
        //Wrapper class
        wrapper.sendKeys(userName, uniqueEmail);
       // userName.sendKeys();
        wrapper.sendKeys(password, PWD);
        //password.sendKeys();
        wrapper.sendKeys(confirmPassword, PWD);
        //confirmPassword.sendKeys(PWD);
        wrapper.click(regButton);
        //regButton.click();
        Wait(driver, "login");
        LoginPage login =new LoginPage(driver,URL);
        return login;
    }

}
