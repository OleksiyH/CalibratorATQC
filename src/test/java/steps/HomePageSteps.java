package steps;

import data.User;
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
import utils.TableUtils;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class HomePageSteps extends ScenarioSteps {


    private HomePage homePage() {
        return getPages().currentPageAt(HomePage.class);
    }


    @Step("Go to Create new Asset page")
    public void goToCreateNewAssetPage() {
        homePage().addNewAssetButtonClick();
    }

    @Step("Go to Print Verification page")
    public void goToPrintVerificationPage() {
        homePage().printVerificationButtonClick();
    }

    @Step("Go to Change Log page")
    public void goToChangeLogPage() {
        homePage().changeLogButtonClick();
    }

    @Step("Go to Tax Details page")
    public void goToTaxDetails() {
        homePage().taxDetailsButtonClick();
    }

    @Step("Select number of assets to show")
    public void selectNumberOfElementToShow(ShowItemsEnum items) throws InterruptedException {
        homePage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Asset by Name")
    public void searchByAssetName(String query) {
        homePage().searchByAssetName(query);
    }

    @Step("Edit Asset Configuration by Name")
    public void editAssetConfiguration(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToAssetConfiguration();
    }

    @Step("Edit Asset Product Configuration by Name")
    public void editProductConfiguration(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToProductConfiguration();
    }

    @Step("Edit Asset Campaign Configuration by Name")
    public void editCampaignConfiguration(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToCampaignConfiguration();
    }

    @Step("Edit Asset Campaign Product Configuration by Name")
    public void editCampaignProductConfiguration(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToCampaignProductConfiguration();
    }

    @Step("Edit Asset Access Boundary Configuration by Name")
    public void editAccessBoundaryConfiguration(String assetName) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        assetTable.getAssetByName(assetName).goToAccessBoundaryConfiguration();
    }

    @Step("Verify Asset Status in the table")
    public void verifyAssetStatus(String assetName, StatusEnum expectedStatus) {
        homePage().searchByAssetName(assetName);
        AssetTableModel assetTable = new AssetTableModel(homePage().getAssetTable());
        String actualStatus = assetTable.getAssetByName(assetName).getAssetStatus();
        assertThat("Status in the table is different from expected. Expected: " + expectedStatus.toString() + " Actual: " + actualStatus, expectedStatus.toString().equals(actualStatus.trim()));
    }

    @Step("Verify Asset is not present in the table")
    public void verifyAssetNotPresent(String assetName) {
        homePage().searchByAssetName(assetName);
        assertThat("Asset is present in the table", !getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Verify Asset is present in the table")
    public void verifyAssetPresent(String assetName) {
        homePage().searchByAssetName(assetName);
        assertThat("Asset is present in the table", getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }


}
