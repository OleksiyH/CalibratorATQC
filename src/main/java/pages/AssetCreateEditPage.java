package pages;

import enums.OverlayColorEnum;
import enums.StatusEnum;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.formModels.AssetCreateEditForm;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class AssetCreateEditPage extends PageHeader {

    @FindBy(id = "name")
    private WebElement assetNameField;

    @FindBy(partialLinkText = "Asset Print Verification FTP Credential")
    private WebElement ftpPrintCredentialsButton;

    @FindBy(id = "overlayColor")
    private WebElement overlayColorDropdown;

    @FindBy(id = "campaignColor")
    private WebElement campaignColorPicker;

    @FindBy(id = "buttonCampaignColor")
    private WebElement buttonCampaignColorPicker;

    @FindBy(id = "summaryHeader")
    private WebElement summaryHeaderText;

    @FindBy(id = "uniform-def0")
    private WebElement useDefaultSummaryHeaderCheckbox;

    @FindBy(id = "termsAndConditions")
    private WebElement termsAndConditionsText;

    @FindBy(id = "uniform-def1")
    private WebElement useDefaultTermsAndConditionsCheckbox;

    @FindBy(id = "summaryPSCHeader")
    private WebElement summaryPSCHeaderText;

    @FindBy(id = "uniform-def2")
    private WebElement useDefaultSummaryPSCHeaderCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButton;

    @FindBy(partialLinkText = "Back to Calibrator")
    private WebElement backToHomePageButton;

    //NOTE: This element only becomes visible after Asset was created.
    @FindBy(id = "status")
    private WebElement statusDropdown;

    //-----------------------------------------
    //Getters and Setters


    public WebElement getAssetNameField() {
        return assetNameField;
    }

    public WebElement getFtpPrintCredentialsButton() {
        return ftpPrintCredentialsButton;
    }

    public WebElement getOverlayColorDropdown() {
        return overlayColorDropdown;
    }

    public WebElement getCampaignColorPicker() {
        return campaignColorPicker;
    }

    public WebElement getButtonCampaignColorPicker() {
        return buttonCampaignColorPicker;
    }

    public WebElement getSummaryHeaderText() {
        return summaryHeaderText;
    }

    public WebElement getUseDefaultSummaryHeaderCheckbox() {
        return useDefaultSummaryHeaderCheckbox;
    }

    public WebElement getTermsAndConditionsText() {
        return termsAndConditionsText;
    }

    public WebElement getUseDefaultTermsAndConditionsCheckbox() {
        return useDefaultTermsAndConditionsCheckbox;
    }

    public WebElement getSummaryPSCHeaderText() {
        return summaryPSCHeaderText;
    }

    public WebElement getUseDefaultSummaryPSCHeaderCheckbox() {
        return useDefaultSummaryPSCHeaderCheckbox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getBackToHomePageButton() {
        return backToHomePageButton;
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    //-----------------------------------------
    //Business logic

    public void setAssetNameField(String assetName) {
        getAssetNameField().clear();
        getAssetNameField().sendKeys(assetName);
    }

    public void setOverlayColor(OverlayColorEnum color) {
        Select select = new Select(getOverlayColorDropdown());
        select.selectByValue(color.getValue());
    }

    public void setUseDefaultSummaryHeaderCheckbox(Boolean condition) {
        if (!getUseDefaultSummaryHeaderCheckbox().findElements(By.className("checked")).isEmpty() != condition) {
            getUseDefaultSummaryHeaderCheckbox().click();
        }
    }

    public void setSummaryHeaderText(String description) {
        if (!getUseDefaultSummaryHeaderCheckbox().findElement(By.tagName("span").)) {
            System.out.println("Use Default text checkbox is selected");
        } else {
            getSummaryHeaderText().clear();
            getSummaryHeaderText().sendKeys(description);
        }
    }

    public void setUseDefaultTermsAndConditionsCheckbox(Boolean condition) {
        if (!getUseDefaultTermsAndConditionsCheckbox().findElements(By.className("checked")).isEmpty() != condition) {
            getUseDefaultTermsAndConditionsCheckbox().click();
        }
    }

    public void setTermsAndConditionsText(String description) {
        if (!getUseDefaultTermsAndConditionsCheckbox().findElements(By.className("checked")).isEmpty()) {
            System.out.println("Use Default text checkbox is selected");
        } else {
            getTermsAndConditionsText().clear();
            getTermsAndConditionsText().sendKeys(description);
        }
    }

    public void setUseDefaultSummaryPSCHeaderCheckbox(Boolean condition) {
        if (!getUseDefaultSummaryPSCHeaderCheckbox().findElements(By.className("checked")).isEmpty() != condition) {
            getUseDefaultSummaryPSCHeaderCheckbox().click();
        }
    }

    public void setSummaryPSCHeaderText(String description) {
        if (!getUseDefaultSummaryPSCHeaderCheckbox().findElements(By.className("checked")).isEmpty()) {
            System.out.println("Use Default text checkbox is selected");
        } else {
            getSummaryPSCHeaderText().clear();
            getSummaryPSCHeaderText().sendKeys(description);
        }
    }

    public void clickSubmit() {
        getSubmitButton().click();
    }

    public void clickCancel() {
        getCancelButton().click();
    }

    public void goBackToHomePage() {
        getBackToHomePageButton().click();
    }

    public void fillForm(AssetCreateEditForm form) {
        setAssetNameField(form.getAssetName());
        setOverlayColor(form.getColor());
        setUseDefaultSummaryHeaderCheckbox(form.getUseDefaultSummaryHeader());
        setUseDefaultTermsAndConditionsCheckbox(form.getUseDefaultTermsAndConditions());
        setUseDefaultSummaryPSCHeaderCheckbox(form.getUseDefaultSummaryPSCHeader());
        setSummaryHeaderText(form.getSummaryHeaderText());
        setTermsAndConditionsText(form.getTermsAndConditionsText());
        setSummaryPSCHeaderText(form.getSummaryPSCHeaderText());
    }

    public AssetCreateEditForm readForm() {
        AssetCreateEditForm form = new AssetCreateEditForm();
        form.setAssetName(this.getAssetNameField().getAttribute("value"));
        Select select = new Select(this.getOverlayColorDropdown());
        String selectedValue = select.getFirstSelectedOption().getAttribute("value").trim();
        form.setColor(OverlayColorEnum.get(selectedValue));
        form.setSummaryHeaderText(this.getSummaryHeaderText().getText());
        form.setUseDefaultSummaryHeader(!this.getUseDefaultSummaryHeaderCheckbox().findElements(By.className("checked")).isEmpty());
        form.setTermsAndConditionsText(this.getTermsAndConditionsText().getText());
        form.setUseDefaultTermsAndConditions(!this.getUseDefaultTermsAndConditionsCheckbox().findElements(By.className("checked")).isEmpty());
        form.setSummaryPSCHeaderText(this.getSummaryPSCHeaderText().getText());
        form.setUseDefaultSummaryPSCHeader(!this.getUseDefaultSummaryPSCHeaderCheckbox().findElements(By.className("checked")).isEmpty());
        return form;
    }


    public void setAssetStatus(StatusEnum status) {
        Select select = new Select(getStatusDropdown());
        select.selectByValue(status.getValue());
    }

    public void deleteAsset() {
        setAssetStatus(StatusEnum.DELETED);
        getSubmitButton().click();
    }


}
