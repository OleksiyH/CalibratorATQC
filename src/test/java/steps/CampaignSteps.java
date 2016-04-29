package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.*;
import pages.formModels.CampaignCreateEditForm;
import pages.formModels.FeeCreateEditForm;
import pages.tableModels.CampaignTableModel;
import pages.tableModels.FeeTableModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static pages.FeeCreateEditPage.CURRENCY_ALREADY_EXISTS;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class CampaignSteps extends ScenarioSteps {


    private CampaignForAssetPage campaignForAssetPage() {
        return getPages().currentPageAt(CampaignForAssetPage.class);
    }

    private CampaignCreateEditPage campaignCreateEditPage() {
        return getPages().currentPageAt(CampaignCreateEditPage.class);
    }


    @Step("Go to Create Campaign page")
    public void goToCreateNewCampaignPage() {
        campaignForAssetPage().createNewCampaignButtonClick();
    }

    @Step("Fill Create Campaign form data")
    public void fillCampaignForm(CampaignCreateEditForm form) {
        campaignCreateEditPage().fillForm(form);
    }

    @Step("Submit Campaign form")
    public void submitCampaignForm() {
        campaignCreateEditPage().submitForm();
    }

    @Step("Cancel Campaign form")
    public void cancelCampaignForm() {
        campaignCreateEditPage().cancelClick();
    }

    @Step("Go back to Campaign page")
    public void goBackToCampaignPage() {
        campaignCreateEditPage().goBackToCampaignsPage();
    }

    @Step("Select number of Campaigns to show")
    public void selectNumberOfElementToShow(ShowItemsEnum items) throws InterruptedException {
        campaignForAssetPage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Campaigns")
    public void searchForCampaigns(String query) {
        campaignForAssetPage().searchForCampaign(query);
    }

    @Step("Edit Campaign Configuration")
    public void editCampaignConfiguration(CampaignCreateEditForm form) {
        campaignForAssetPage().searchForCampaign(form.getCampaignName().toString());
        CampaignTableModel campaignTable = new CampaignTableModel(campaignForAssetPage().getCampaignTable());
        campaignTable.getCampaignByName(form.getCampaignName()).editCampaign();
    }

    @Step("Delete Campaign")
    public void deleteCampaign(CampaignCreateEditForm form) {
        campaignForAssetPage().searchForCampaign(form.getCampaignName().toString());
        CampaignTableModel campaignTable = new CampaignTableModel(campaignForAssetPage().getCampaignTable());
        campaignTable.getCampaignByName(form.getCampaignName()).editCampaign();
        campaignCreateEditPage().setStatusDropdown(StatusEnum.DELETED);
        campaignCreateEditPage().submitForm();
    }

    @Step("Verify that Campaign Was Created and all data was captured")
    public void verifyCampaignCreation(CampaignCreateEditForm form) {
        campaignForAssetPage().searchForCampaign(form.getCampaignName().toString());
        CampaignTableModel campaignTable = new CampaignTableModel(campaignForAssetPage().getCampaignTable());
        campaignTable.getCampaignByName(form.getCampaignName()).editCampaign();
        CampaignCreateEditForm capturedForm = campaignCreateEditPage().readForm();

        assertThat("Campaign Name is different from expected." +
                        " Actual: " + capturedForm.getCampaignName() +
                        " Expected: " + form.getCampaignName(),
                capturedForm.getCampaignName().equals(form.getCampaignName()));

        assertThat("LightBoxLogoUrl is different from expected." +
                        " Actual: " + capturedForm.getLightBoxLogoUrl() +
                        " Expected: " + form.getLightBoxLogoUrl(),
                capturedForm.getLightBoxLogoUrl().equals(form.getLightBoxLogoUrl()));

        assertThat("OriginSiteUrl is different from expected." +
                        " Actual: " + capturedForm.getOriginSiteUrl() +
                        " Expected: " + form.getOriginSiteUrl(),
                capturedForm.getOriginSiteUrl().equals(form.getOriginSiteUrl()));

//        assertThat("CustomCss is different from expected." +
//                        " Actual: " + capturedForm.getCustomCss() +
//                        " Expected: " + form.getCustomCss(),
//                capturedForm.getCustomCss().equals(form.getCustomCss()));

        assertThat("getStatus state is different from expected." +
                        " Actual: " + capturedForm.getStatus() +
                        " Expected: " + form.getStatus(),
                capturedForm.getStatus().equals(form.getStatus()));

    }


    @Step("Verify Campaign is not present in the table")
    public void verifyCampaignNotPresent(CampaignCreateEditForm form) {
        campaignForAssetPage().searchForCampaign(form.getCampaignName());
        assertThat("Campaign is present in the table", !getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Verify Campaign is  present in the table")
    public void verifyCampaignPresent(CampaignCreateEditForm form) {
        campaignForAssetPage().searchForCampaign(form.getCampaignName());
        assertThat("Campaign is not present in the table", getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

}
