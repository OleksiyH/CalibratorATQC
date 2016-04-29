package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public class PageHeader extends PageObject {



    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/a/img")
    private WebElement pageLogo;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/ul/li[2]")
    private WebElement userLogo;

    @FindBy(className = "icon-key")
    private WebElement logOutButton;



    //--------------------------------
    //Getters and Setters

    public WebElement getPageLogo() {
        return pageLogo;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getUserLogo() {
        return userLogo;
    }


    //--------------------------------
    //Business Logic

    public LoginPage logOut() {
//TODO Find out proper locator for logout
//        getUserLogo().click();
//        getUserLogo().click();
//        getLogOutButton().click();
        getDriver().get("http://paywallmasters.com:8080/calibrator/j_spring_security_logout");
        return new LoginPage();
    }

    public void goToHomePage() {
        getPageLogo().click();
    }

}
