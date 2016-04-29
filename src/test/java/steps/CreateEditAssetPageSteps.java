package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.AssetCreateEditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PageHeader;
import pages.formModels.AssetCreateEditForm;
import pages.tableModels.AssetTableModel;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class CreateEditAssetPageSteps extends ScenarioSteps {

    private HomePage homePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    private AssetCreateEditPage assetCreateEditPage() {
        return getPages().currentPageAt(AssetCreateEditPage.class);
    }


    @Step("Fill Create new Asset form")
    public void fillCreateNewAssetForm(AssetCreateEditForm form) {
        assetCreateEditPage().fillForm(form);
    }

    @Step("Submit Create new Asset form")
    public void submitCreateNewAssetForm() {
        assetCreateEditPage().clickSubmit();
        assertThat("User is not redirected to Home Page or URL " + HomePage.HOME_PAGE_URL + " ,or URL has changed", getDriver().getCurrentUrl().equals(HomePage.HOME_PAGE_URL));
    }

    @Step("Verify that Asset Was Created and all data was captured")
    public void verifyAssetCreation(AssetCreateEditForm form) {
        homePage().searchByAssetName(form.getAssetName());
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(form.getAssetName()).goToAssetConfiguration();

        AssetCreateEditForm capturedForm = assetCreateEditPage().readForm();

        assertThat("Asset name is different from expected. Expected: " + form.getAssetName() + " Actual: " + capturedForm.getAssetName(),
                capturedForm.getAssetName().equals(form.getAssetName()));
        assertThat("Asset overlay color is different from expected. Expected: " + form.getColor() + " Actual: " + capturedForm.getColor(),
                capturedForm.getColor().getValue().equals(form.getColor().getValue()));

        assertThat("Asset SummaryHeader Default Checkbox is different from expected. Expected: " + form.getUseDefaultSummaryHeader() + " Actual: " + capturedForm.getUseDefaultSummaryHeader(),
                capturedForm.getUseDefaultSummaryHeader().equals(form.getUseDefaultSummaryHeader()));
        if (!form.getUseDefaultSummaryHeader()) {
            assertThat("Asset SummaryHeaderText is different from expected. Expected: " + form.getSummaryHeaderText() + " Actual: " + capturedForm.getSummaryHeaderText(),
                    capturedForm.getSummaryHeaderText().equals(form.getSummaryHeaderText()));
        }

        assertThat("Asset TermsAndConditions Default Checkbox is different from expected. Expected: " + form.getUseDefaultTermsAndConditions() + " Actual: " + capturedForm.getUseDefaultTermsAndConditions(),
                capturedForm.getUseDefaultTermsAndConditions().equals(form.getUseDefaultTermsAndConditions()));
        if (!form.getUseDefaultTermsAndConditions()) {
            assertThat("Asset TermsAndConditionsText is different from expected. Expected: " + form.getTermsAndConditionsText() + " Actual: " + capturedForm.getTermsAndConditionsText(),
                    capturedForm.getTermsAndConditionsText().equals(form.getTermsAndConditionsText()));
        }

        assertThat("Asset SummaryPSCHeader Default Checkbox  is different from expected. Expected: " + form.getUseDefaultSummaryPSCHeader() + " Actual: " + capturedForm.getUseDefaultSummaryPSCHeader(),
                capturedForm.getUseDefaultSummaryPSCHeader().equals(form.getUseDefaultSummaryPSCHeader()));
        if (!form.getUseDefaultSummaryPSCHeader()) {
            assertThat("Asset SummaryPSCHeaderText is different from expected. Expected: " + form.getSummaryPSCHeaderText() + " Actual: " + capturedForm.getSummaryPSCHeaderText(),
                    capturedForm.getSummaryPSCHeaderText().equals(form.getSummaryPSCHeaderText()));
        }
    }

    @Step("Cancel Create new Asset form")
    public void cancelCreateNewAssetForm() {
        assetCreateEditPage().clickCancel();
        assertThat("User is not redirected to Home Page or URL " + HomePage.HOME_PAGE_URL + " ,or URL has changed", getDriver().getCurrentUrl().equals(HomePage.HOME_PAGE_URL));
    }

    @Step("Change Asset Status")
    public void changeAssetStatus(StatusEnum status) {
        assetCreateEditPage().setAssetStatus(status);
    }

    @Step("Go Back to Home Page")
    public void backToHomePage() {
        assetCreateEditPage().goBackToHomePage();
        assertThat("User is not redirected to Home Page or URL " + HomePage.HOME_PAGE_URL + " ,or URL has changed", getDriver().getCurrentUrl().equals(HomePage.HOME_PAGE_URL));
    }


    @Step("Delete Asset by Name")
    public void deleteAssetByName(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToAssetConfiguration();
        assetCreateEditPage().deleteAsset();
        homePage().searchByAssetName(assetName);
        assertThat("Asset is still present in the table", !getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }
}
