package jantriQa;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Attempt_login_with_blank_fields_and_verify_UI_behavior extends BasePage {
    Loginpage loginpage;
    WebDriverWait wait;

    @BeforeMethod
    public void init() {
        loginpage = new Loginpage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test(description = "Verify password field is masked by default")
    public void testPasswordMaskedButton() {
        wait.until(ExpectedConditions.visibilityOf(loginpage.passwordInput));
        Assert.assertTrue(loginpage.isPasswordMasked(), "Password field should be masked");
    }

    @Test(description = "Verify error message appears on invalid login")
    public void testInvalidLoginShowErrorMsg() {
        loginpage.enterInvalidCredentials("wrongUser", "wrongPass");
        String error = loginpage.getErrorMessage();
        System.out.println("Error Message: " + error);
        Assert.assertFalse(error.isEmpty(), "Error message should be displayed");
    }

    @Test(description = "Verify presence of all required UI elements on the login page")
    public void testPageElementsVisible() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginpage.userIdInput.isDisplayed(), "User ID input should be visible");
        softAssert.assertTrue(loginpage.passwordInput.isDisplayed(), "Password input should be visible");
        softAssert.assertTrue(loginpage.loginButton.isDisplayed(), "Login button should be visible");
        softAssert.assertTrue(loginpage.isEyeIconVisible(), "Eye icon should be visible");
        softAssert.assertAll();
    }
}
	


