package pages;

import enums.ShowItemsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oha on 26.04.2016.
 */
public class AccessBoundaryForAssetPage extends PageHeader {

    @FindBy(xpath = "//a[contains(text(), 'Create New Access Boundary')]")
    private WebElement createNewAccessBoundary;

    @FindBy(id = "sample_1")
    private WebElement accessBoundaryTable;

    @FindBy(xpath = "//a[contains(text(), 'Back to Calibrator ')]")
    private WebElement backToHomePageButton;

    //--------------------------------
    //Getters and Setters

    public WebElement getCreateNewAccessBoundary() {
        return createNewAccessBoundary;
    }

    public WebElement getAccessBoundaryTable() {
        return accessBoundaryTable;
    }

    public WebElement getBackToHomePageButton() {
        return backToHomePageButton;
    }

    //--------------------------------
    //Business Logic

    public void createNewAccessBoundaryButtonClick() {
        getCreateNewAccessBoundary().click();
    }

    public void goBackToHomePage() {
        getBackToHomePageButton().click();
    }
}
