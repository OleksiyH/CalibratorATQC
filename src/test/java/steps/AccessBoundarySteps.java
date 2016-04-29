package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.AccessBoundaryCreateEditPage;
import pages.AccessBoundaryForAssetPage;
import pages.CampaignCreateEditPage;
import pages.CampaignForAssetPage;
import pages.formModels.AccessBoundaryCreateEditForm;
import pages.formModels.CampaignCreateEditForm;
import pages.tableModels.AccessBoundaryTableModel;
import pages.tableModels.CampaignTableModel;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class AccessBoundarySteps extends ScenarioSteps {

    private AccessBoundaryCreateEditPage accessBoundaryCreateEditPage() {
        return getPages().currentPageAt(AccessBoundaryCreateEditPage.class);
    }
    private AccessBoundaryForAssetPage accessBoundaryForAssetPage() {
        return getPages().currentPageAt(AccessBoundaryForAssetPage.class);
    }


    @Step("Go to Create Access Boundary page")
    public void goToCreateNewAccessBoundaryPage() {
        accessBoundaryForAssetPage().createNewAccessBoundaryButtonClick();
    }

    @Step("Fill Create Access Boundary data")
    public void fillCreateAccessBoundaryForm(AccessBoundaryCreateEditForm form) {
        accessBoundaryCreateEditPage().fillFormForCreation(form);
    }

    @Step("Fill Edit Access Boundary data")
    public void fillEditAccessBoundaryForm(AccessBoundaryCreateEditForm form) {
        accessBoundaryCreateEditPage().fillFormForEditing(form);
    }

    @Step("Submit Access Boundary form")
    public void submitAccessBoundaryForm() {
        accessBoundaryCreateEditPage().submitButtonClick();
    }


    @Step("Go back to Access Boundary page")
    public void goBackToAccessBoundaryPage() {
        accessBoundaryCreateEditPage().goBackToAccessBoundariesPage();
    }


    @Step("Edit Access Boundary Configuration")
    public void editAccessBoundaryConfiguration(AccessBoundaryCreateEditForm form) {
        AccessBoundaryTableModel accessBoundaryTable = new AccessBoundaryTableModel(accessBoundaryForAssetPage().getAccessBoundaryTable());
        accessBoundaryTable.getByBoundaryName(form.getAccessBoundaryName()).editAccessBoundary();
    }

    @Step("Delete AccessBoundary")
    public void deleteAccessBoundary(AccessBoundaryCreateEditForm form) {
        AccessBoundaryTableModel accessBoundaryTable = new AccessBoundaryTableModel(accessBoundaryForAssetPage().getAccessBoundaryTable());
        accessBoundaryTable.getByBoundaryName(form.getAccessBoundaryName()).editAccessBoundary();
        accessBoundaryCreateEditPage().setStatus(StatusEnum.DELETED);
        accessBoundaryCreateEditPage().submitButtonClick();
    }

    @Step("Verify that Access Boundary Was Created and all data was captured")
    public void verifyAccessBoundaryCreation(AccessBoundaryCreateEditForm form) {

        AccessBoundaryTableModel accessBoundaryTable = new AccessBoundaryTableModel(accessBoundaryForAssetPage().getAccessBoundaryTable());
        accessBoundaryTable.getByBoundaryName(form.getAccessBoundaryName()).editAccessBoundary();
        AccessBoundaryCreateEditForm capturedForm = accessBoundaryCreateEditPage().readForm();

        assertThat("Access Boundary SiteMode is different from expected." +
                        " Actual: " + capturedForm.getSiteMode() +
                        " Expected: " + form.getSiteMode(),
                capturedForm.getSiteMode().equals(form.getSiteMode()));

        assertThat("AccessBoundaryName is different from expected." +
                        " Actual: " + capturedForm.getAccessBoundaryName() +
                        " Expected: " + form.getAccessBoundaryName(),
                capturedForm.getAccessBoundaryName().equals(form.getAccessBoundaryName()));

        assertThat("CampaignName is different from expected." +
                        " Actual: " + capturedForm.getCampaignName() +
                        " Expected: " + form.getCampaignName(),
                capturedForm.getCampaignName().equals(form.getCampaignName()));

    }

    @Step("Verify that Access Boundary Was Edited and all data was captured")
    public void verifyAccessBoundaryEdition(AccessBoundaryCreateEditForm form) {
        verifyAccessBoundaryCreation(form);
        AccessBoundaryCreateEditForm capturedForm = accessBoundaryCreateEditPage().readForm();

        assertThat("Status is different from expected." +
                        " Actual: " + capturedForm.getStatus() +
                        " Expected: " + form.getStatus(),
                capturedForm.getStatus().equals(form.getStatus()));

        assertThat("ClientPageScript  is different from expected." +
                        " Actual: " + capturedForm.getClientPageScript() +
                        " Expected: " + form.getClientPageScript(),
                capturedForm.getClientPageScript().equals(form.getClientPageScript()));


        assertThat("AccessMeterRule  is different from expected." +
                        " Actual: " + capturedForm.getAccessMeterRule() +
                        " Expected: " + form.getAccessMeterRule(),
                capturedForm.getAccessMeterRule().equals(form.getAccessMeterRule()));

        assertThat("iTunesAppKey  is different from expected." +
                        " Actual: " + capturedForm.getiTunesAppKey() +
                        " Expected: " + form.getAccessMeterRule(),
                capturedForm.getiTunesAppKey().equals(form.getiTunesAppKey()));
    }


}
