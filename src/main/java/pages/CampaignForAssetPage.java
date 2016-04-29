package pages;

import enums.ShowItemsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oha on 26.04.2016.
 */
public class CampaignForAssetPage extends PageHeader {

    @FindBy(xpath = "//a[contains(text(), 'Create New Campaign')]")
    private WebElement createNewCampaignButton;

    @FindBy(name = "sample_1_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "campaignList")
    private WebElement campaignTable;

    @FindBy(xpath = "//a[contains(text(), 'Back to Calibrator ')]")
    private WebElement backToHomePageButton;

    //--------------------------------
    //Getters and Setters

    public WebElement getCreateNewCampaignButton() {
        return createNewCampaignButton;
    }

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getCampaignTable() {
        return campaignTable;
    }

    public WebElement getBackToHomePageButton() {
        return backToHomePageButton;
    }

    //--------------------------------
    //Business Logic

    public void createNewCampaignButtonClick() {
        getCreateNewCampaignButton().click();
    }

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
