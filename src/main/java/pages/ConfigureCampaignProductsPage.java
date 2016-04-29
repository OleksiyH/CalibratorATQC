package pages;

import enums.ShowItemsEnum;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Oleksiy on 29.04.2016.
 */
public class ConfigureCampaignProductsPage extends PageHeader {

    //----Product Options
    @FindBy(name = "sample_1_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "campaignProduct")
    private WebElement productsOptionsTable;

    //----Add / Update Products
    @FindBy(id = "productId")
    private WebElement availableProductsDropdown;

    @FindBy(id = "sort")
    private WebElement setPositionField;

    @FindBy(id = "defaultSelected1")
    private WebElement setDefaultCheckbox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveButton;


    @FindBy(xpath = "//a[contains(text(), 'Back to Campaigns ')]")
    private WebElement backToCampaignsPageButton;

    //--------------------------------
    //Getters and Setters

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getProductsOptionsTable() {
        return productsOptionsTable;
    }

    public WebElement getAvailableProductsDropdown() {
        return availableProductsDropdown;
    }

    public WebElement getSetPositionField() {
        return setPositionField;
    }

    public WebElement getSetDefaultCheckbox() {
        return setDefaultCheckbox;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getBackToCampaignsPageButton() {
        return backToCampaignsPageButton;
    }

    //--------------------------------
    //Business Logic

    public void selectNumberOfElementToShow(ShowItemsEnum items) {
        Select select = new Select(getShowElementsDropdown());
        select.selectByValue(items.getValue());
    }

    public void searchForProduct(String query) {
        getSearchField().clear();
        getSearchField().sendKeys(query);
    }


    public void selectProductFromDropdown(String internalName) {
        (new Select(getAvailableProductsDropdown())).deselectByVisibleText(internalName);
    }

    public void setProductPosition(Integer position) {
        getSetPositionField().clear();
        getSetPositionField().sendKeys(position.toString());
    }

    public void setIsDefaultOption(Boolean condition) {
        if (!getSetDefaultCheckbox().findElements(By.className("checked")).isEmpty() != condition) {
            getSetDefaultCheckbox().click();
        }
    }

    public void addProductButtonClick() {
        getSaveButton().click();
    }

    public void goBackToCampaignsPage() {
        getBackToCampaignsPageButton().click();
    }

}
