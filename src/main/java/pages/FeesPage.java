package pages;

import enums.ShowItemsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oha on 25.04.2016.
 */
public class FeesPage extends PageHeader {

    @FindBy(xpath = "//a[contains(text(), 'Create New Fee')]")
    private WebElement createNewFeeButton;

    @FindBy(name = "sample_1_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "sample_1")
    private WebElement feesTable;

    @FindBy(xpath = "//a[contains(text(), 'Back to Products ')]")
    private WebElement backToProductsPageButton;


    //--------------------------------
    //Getters and Setters

    public WebElement getCreateNewFeeButton() {
        return createNewFeeButton;
    }

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getFeesTable() {
        return feesTable;
    }

    public WebElement getBackToProductsPageButton() {
        return backToProductsPageButton;
    }



    //--------------------------------
    //Business Logic

    public void createNewFeeButtonClick() {
        getCreateNewFeeButton().click();
    }

    public void selectNumberOfElementToShow(ShowItemsEnum items) {
        Select select = new Select(getShowElementsDropdown());
        select.selectByValue(items.getValue());
    }

    public void searchByTaxRateCurrencyOrType(String query) {
        getSearchField().clear();
        getSearchField().sendKeys(query);
    }

    public void goBackToProductPage() {
        getBackToProductsPageButton().click();
    }

}
