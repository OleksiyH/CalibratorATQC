package pages;

import enums.ShowItemsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Oleksiy on 29.04.2016.
 */
public class CampaignProductPage extends PageHeader {

    @FindBy(name = "sample_1_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "campaignMiniTable")
    private WebElement campaignMiniTable;

    @FindBy(xpath = "//a[contains(text(), 'Back to Calibrator ')]")
    private WebElement backToHomePageButton;

    //--------------------------------
    //Business Logic

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getCampaignMiniTable() {
        return campaignMiniTable;
    }

    public WebElement getBackToHomePageButton() {
        return backToHomePageButton;
    }

    //-------------------------------
    //--Business logic

    public void selectNumberOfElementToShow(ShowItemsEnum items) {
        Select select = new Select(getShowElementsDropdown());
        select.selectByValue(items.getValue());
    }

    public void searchForCampaign(String query) {
        getSearchField().clear();
        getSearchField().sendKeys(query);
    }

    public void goBackToHomePage() {
        getBackToHomePageButton().click();
    }

}
