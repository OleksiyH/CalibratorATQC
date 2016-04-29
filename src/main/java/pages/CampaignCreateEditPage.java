package pages;

import enums.FeesEnums.TaxTypeEnum;
import enums.StatusEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.formModels.CampaignCreateEditForm;

/**
 * Created by oha on 26.04.2016.
 */
public class CampaignCreateEditPage extends PageHeader {

    @FindBy(name = "name")
    private WebElement campaignNameField;

    @FindBy(id = "logoUrl")
    private WebElement lightBoxLogoUrlField;

    @FindBy(id = "denyUrl")
    private WebElement originSiteUrlField;

    @FindBy(id = "planOptionsCustomCSS")
    private WebElement customCssField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[contains(text(), 'Back to Campaigns ')]")
    private WebElement backToCampaignsButton;

    @FindBy(id = "status") //NOTE: This field is only available when editing asset.
    private WebElement statusDropdown;


    //--------------------------------
    //Getters and Setters

    public WebElement getCampaignNameField() {
        return campaignNameField;
    }

    public WebElement getLightBoxLogoUrlField() {
        return lightBoxLogoUrlField;
    }

    public WebElement getOriginSiteUrlField() {
        return originSiteUrlField;
    }

    public WebElement getCustomCssField() {
        return customCssField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getBackToCampaignsButton() {
        return backToCampaignsButton;
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    //--------------------------------
    //Business Logic

    public void setCampaignName(String name) {
        getCampaignNameField().clear();
        getCampaignNameField().sendKeys(name);
    }

    public void setLightBoxLogoUrl(String url) {
        getLightBoxLogoUrlField().clear();
        getLightBoxLogoUrlField().sendKeys(url);
    }

    public void setOriginSiteUrl(String url) {
        getOriginSiteUrlField().clear();
        getOriginSiteUrlField().sendKeys(url);
    }

    public void setCustomCss(String css) {
        getCustomCssField().clear();
        getCustomCssField().sendKeys(css);
    }

    public void setStatusDropdown(StatusEnum status) {
        (new Select(getStatusDropdown())).selectByValue(status.getValue());
    }

    public void submitForm() {
        getSaveButton().click();
    }

    public void cancelClick() {
        getCancelButton().click();
    }

    public void goBackToCampaignsPage() {
        getBackToCampaignsButton().click();
    }

    public void fillForm(CampaignCreateEditForm form) {
        setCampaignName(form.getCampaignName());
        setLightBoxLogoUrl(form.getLightBoxLogoUrl());
        setOriginSiteUrl(form.getOriginSiteUrl());
       //TODO ths field is now missing
        // setCustomCss(form.getCustomCss());
        if (this.containsText("Status")) {
            setStatusDropdown(form.getStatus());
        }
    }

    public CampaignCreateEditForm readForm() {
        CampaignCreateEditForm form = new CampaignCreateEditForm();
        form.setCampaignName(getCampaignNameField().getAttribute("value"));
        form.setLightBoxLogoUrl(getLightBoxLogoUrlField().getAttribute("value"));
        form.setOriginSiteUrl(getOriginSiteUrlField().getAttribute("value"));
       // form.setCustomCss(getCustomCssField().getAttribute("value"));
        form.setStatus(StatusEnum.get((new Select(this.getStatusDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        return form;
    }


}
