package jantriQa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	  WebDriver driver;

	    @FindBy(id = "formEmail")
	    WebElement userIdInput;

	    @FindBy(id = "formPassword")
	    WebElement passwordInput;

	    @FindBy(className = "login-button")
	    WebElement loginButton;

	    @FindBy(className = "password-visible") 
	    WebElement eyeIcon;

	    @FindBy(className = "invalid-credential-div")
	    WebElement errorMsg;

	    public Loginpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void clearFields() {
	        userIdInput.clear();
	        passwordInput.clear();
	    }

	    public boolean isLoginButtonDisabled() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        return (Boolean) js.executeScript("return arguments[0].disabled;", loginButton);
	    }

	    public boolean isPasswordMasked() {
	        return passwordInput.getAttribute("type").equals("password");
	    }

	    public void enterInvalidCredentials(String user, String pass) {
	        clearFields();
	        userIdInput.sendKeys(user);
	        passwordInput.sendKeys(pass);
	        loginButton.click();
	    }

	    public String getErrorMessage() {
	        return errorMsg.isDisplayed() ? errorMsg.getText() : "Error message not visible";
	    }

	    public boolean isEyeIconVisible() {
	        return eyeIcon.isDisplayed();
	    }

}
