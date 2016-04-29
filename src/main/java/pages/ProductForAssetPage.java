package pages;

import enums.ShowItemsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oha on 25.04.2016.
 */
public class ProductForAssetPage extends PageHeader {

    @FindBy(xpath = "//a[contains(text(), 'Create New Product')]")
    private WebElement createNewProductButton;

    @FindBy(name = "productList_length")
    private WebElement showElementsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(id = "productList")
    private WebElement productTable;

    @FindBy(xpath = "//a[contains(text(), 'Back to Calibrator')]")
    private WebElement backToHomePageButton;


    //--------------------------------
    //Getters and Setters

    public WebElement getCreateNewProductButton() {
        return createNewProductButton;
    }

    public WebElement getShowElementsDropdown() {
        return showElementsDropdown;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getProductTable() {
        return productTable;
    }

    public WebElement getBackToHomePageButton() {
        return backToHomePageButton;
    }

    //--------------------------------
    //Business Logic

    public void createNewProductButtonClick() {
        getCreateNewProductButton().click();
    }

    public void selectNumberOfElementToShow(ShowItemsEnum items) {
        Select select = new Select(getShowElementsDropdown());
        select.selectByValue(items.getValue());
    }

    public void searchByProductName(String query) {
        getSearchField().clear();
        getSearchField().sendKeys(query);
    }

    public void goBackToHomePage() {
        getBackToHomePageButton().click();
    }

}
