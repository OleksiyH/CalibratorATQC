package pages;

import enums.StatusEnum;
import enums.accessBoundaryEnums.SiteModeEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.formModels.AccessBoundaryCreateEditForm;

/**
 * Created by oha on 28.04.2016.
 */
public class AccessBoundaryCreateEditPage extends PageHeader {

    @FindBy(id = "type")
    private WebElement siteModeDropdown;

    @FindBy(id = "name")
    private WebElement accessBoundaryNameField;

    @FindBy(id = "assignedSector")
    private WebElement selectCampaignDropdown;

    @FindBy(id = "intersection")
    private WebElement currentCampaignLabel;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(), 'Back to Access Boundaries ')]")
    private WebElement backToAccessBoundaryPageButton;

    //------------------Elements Available only when editing
    @FindBy(id = "status")
    private WebElement selectStatusDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Pop Rule Testing Engine ')]")
    private WebElement goToPopRuleTestingEnginePageButton;

    @FindBy(id = "clientJavaScript")
    private WebElement clientJavaScriptField;

    @FindBy(id = "hecatePreCheckRule")
    private WebElement accessMeterRuleField;

    @FindBy(id = "iTunesSharedSecret")
    private WebElement iTunesAppKeyField;

    //--------------------------------
    //Getters and Setters


    public WebElement getSiteModeDropdown() {
        return siteModeDropdown;
    }

    public WebElement getAccessBoundaryNameField() {
        return accessBoundaryNameField;
    }

    public WebElement getSelectCampaignDropdown() {
        return selectCampaignDropdown;
    }

    public WebElement getCurrentCampaignLabel() {
        return currentCampaignLabel;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getBackToAccessBoundaryPageButton() {
        return backToAccessBoundaryPageButton;
    }

    public WebElement getSelectStatusDropdown() {
        return selectStatusDropdown;
    }

    public WebElement getGoToPopRuleTestingEnginePageButton() {
        return goToPopRuleTestingEnginePageButton;
    }

    public WebElement getClientJavaScriptField() {
        return clientJavaScriptField;
    }

    public WebElement getAccessMeterRuleField() {
        return accessMeterRuleField;
    }

    public WebElement getiTunesAppKeyField() {
        return iTunesAppKeyField;
    }

    //--------------------------------
    //Business Logic

    public void setSiteModeDropdown(SiteModeEnum siteMode) {
        (new Select(getSiteModeDropdown())).selectByValue(siteMode.getValue());
    }

    public void setAccessBoundaryName(String name) {
        getAccessBoundaryNameField().clear();
        getAccessBoundaryNameField().sendKeys(name);
    }

    public void setCampaignDropdown(String campaignName) {
        System.out.println(campaignName);
        (new Select(getSelectCampaignDropdown())).selectByVisibleText(campaignName);
    }

    public void submitButtonClick() {
        getSubmitButton().click();
    }

    public void goBackToAccessBoundariesPage() {
        getBackToAccessBoundaryPageButton().click();
    }

    public void setStatus(StatusEnum status) {
        (new Select(getSelectStatusDropdown())).selectByValue(status.getValue());
    }

    public void setGoToPopRuleTestingEnginePage() {
        getGoToPopRuleTestingEnginePageButton().click();
    }

    public void setClientJavaScript(String script) {
        getClientJavaScriptField().clear();
        getClientJavaScriptField().sendKeys(script);
    }

    public void setAccessmeterRule(String rule) {
        getAccessMeterRuleField().clear();
        getAccessMeterRuleField().sendKeys(rule);
    }

    public void setiTunesAppKey(String key) {
        getiTunesAppKeyField().clear();
        getiTunesAppKeyField().sendKeys(key);
    }

    public void fillFormForCreation(AccessBoundaryCreateEditForm form) {
        setSiteModeDropdown(form.getSiteMode());
        setAccessBoundaryName(form.getAccessBoundaryName());
        setCampaignDropdown(form.getCampaignName());
    }

    public void fillFormForEditing(AccessBoundaryCreateEditForm form) {
        fillFormForCreation(form);
        setStatus(form.getStatus());
        setClientJavaScript(form.getClientPageScript());
        //TODO find out rule proper format;
        //setAccessmeterRule(form.getAccessMeterRule());
        setiTunesAppKey(form.getiTunesAppKey());
    }

    public AccessBoundaryCreateEditForm readForm() {
        AccessBoundaryCreateEditForm form = new AccessBoundaryCreateEditForm();
        form.setSiteMode(SiteModeEnum.get((new Select(this.getSiteModeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setAccessBoundaryName(getAccessBoundaryNameField().getAttribute("value"));
        form.setCampaignName((new Select(this.getSelectCampaignDropdown())).getFirstSelectedOption().getAttribute("value").trim());
        form.setStatus(StatusEnum.get((new Select(this.getSelectStatusDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setClientPageScript(getClientJavaScriptField().getAttribute("value"));
        form.setAccessMeterRule(getAccessMeterRuleField().getAttribute("value"));
        form.setiTunesAppKey(getiTunesAppKeyField().getAttribute("value"));
        return form;
    }


}
