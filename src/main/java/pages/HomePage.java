package pages;

import enums.ShowItemsEnum;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.tableModels.AssetTableModel;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public class HomePage extends PageHeader {

    public static final String HOME_PAGE_LABEL = "Meter Calibrator Home Page";

    public static final String HOME_PAGE_URL = "http://paywallmasters.com:8080/calibrator/admin/property/list.html";

    @FindBy(id = "goToCreateProperty")
    private WebElement addNewAssetButton;

    @FindBy(partialLinkText = "Print Verification")
    private WebElement printVerificationButton;

    @FindBy(id = "sample_editable_1_new1")
    private WebElement changeLogButton;

    @FindBy(partialLinkText = "Tax Details")
    private WebElement taxDetailsButton;

    @FindBy(name = "propListTable_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "propListTable")
    private WebElement assetTable;

    //--------------------------------
    //Getters and Setters

    public WebElement getAddNewAssetButton() {
        return addNewAssetButton;
    }

    public WebElement getPrintVerificationButton() {
        return printVerificationButton;
    }

    public WebElement getChangeLogButton() {
        return changeLogButton;
    }

    public WebElement getTaxDetailsButton() {
        return taxDetailsButton;
    }

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getAssetTable() {
        return assetTable;
    }

    //--------------------------------
    //Business Logic

    public void addNewAssetButtonClick() {
        getAddNewAssetButton().click();
    }

    public void printVerificationButtonClick() {
        getPrintVerificationButton().click();
    }

    public void changeLogButtonClick() {
        getChangeLogButton().click();
    }

    public void taxDetailsButtonClick() {
        getTaxDetailsButton().click();
    }

    public void selectNumberOfElementToShow(ShowItemsEnum items) {
        Select select = new Select(getShowElementsDropdown());
        select.selectByValue(items.getValue());
    }

    public void searchByAssetName(String query) {
        getSearchField().clear();
        getSearchField().sendKeys(query);
    }
   }
