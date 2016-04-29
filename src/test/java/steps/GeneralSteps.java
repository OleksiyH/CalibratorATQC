package steps;

import data.User;
import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.AssetCreateEditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PageHeader;
import pages.formModels.AssetCreateEditForm;
import pages.tableModels.AssetTableModel;
import utils.TableUtils;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class GeneralSteps extends ScenarioSteps {

    private LoginPage loginPage() {
        return getPages().currentPageAt(LoginPage.class);
    }

    private PageHeader pageHeader() {
        return getPages().currentPageAt(PageHeader.class);
    }

    private HomePage homePage() {
        return getPages().currentPageAt(HomePage.class);
    }


    @Step("Open Login Page Step")
    public void openPage() {
        loginPage().open();
        assertThat("Login Page title is wrong or missing",
                LoginPage.LOGIN_PAGE_LABEL.equals(loginPage().getLoginPageLabelText()));
    }

    @Step("Login to Application")
    public void loginToApplication(User user) {
        loginPage().loginToApp(user);
    }

    @Step("Logout from application")
    public void logOut() {
        pageHeader().logOut();
        assertThat("Login Page title is wrong or missing",
                LoginPage.LOGIN_PAGE_LABEL.equals(loginPage().getLoginPageLabelText()));
    }

    @Step("Go to Home page")
    public void goToHomePage() throws InterruptedException {
        pageHeader().goToHomePage();
      //  assertThat("User is not redirected to Home Page or Label " + HomePage.HOME_PAGE_LABEL + " has changed or missing", homePage().containsText(HomePage.HOME_PAGE_LABEL));
        assertThat("User is not redirected to Home Page or URL " + HomePage.HOME_PAGE_URL + " ,or URL has changed", getDriver().getCurrentUrl().equals(HomePage.HOME_PAGE_URL));
    }


}
