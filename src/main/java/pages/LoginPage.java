package pages;

import data.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;


/**
 * Created by Oleksiy on 23.04.2016.
 */
@DefaultUrl("http://paywallmasters.com:8080/calibrator/login.html")
public class LoginPage extends PageObject {

    public static final String LOGIN_PAGE_LABEL = "Login to Calibrator";

    @FindBy(name = "j_username")
    private WebElement usernameField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(xpath= "//label/button[@type='submit']")
    private WebElement loginButton;

    @FindBy(className = "form-title")
    private WebElement loginTitle;

    //--------------------------------
    //Getters and Setters

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginTitle() {
        return loginTitle;
    }

    //--------------------------------
    //Business Logic

    public void loginToApp(User user){
        getUsernameField().clear();
        getUsernameField().sendKeys(user.getUsername());
        getPasswordField().clear();
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }

    public String getLoginPageLabelText(){
        return getLoginTitle().getText();
    }

}
