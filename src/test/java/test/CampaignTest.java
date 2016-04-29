package test;

import data.UserRepository;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.formModels.AssetCreateEditForm;
import pages.formModels.CampaignCreateEditForm;
import pages.formModels.ProductCreateEditForm;
import steps.*;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag(name = "Asset Product Management")
@RunWith(SerenityRunner.class)
public class CampaignTest {

    @Managed
    public WebDriver webdriver;
    @Steps
    public GeneralSteps generalSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public CreateEditAssetPageSteps assetPageSteps;
    @Steps
    public CampaignSteps campaignSteps;


    public Boolean before = false;
    public AssetCreateEditForm newAsset;

    @Before
    public void loginToApplication() {
        generalSteps.openPage();
        generalSteps.loginToApplication(UserRepository.getTestUser());

        if (!before) {

            // Creating test asset for all Campaign Tests
            homePageSteps.goToCreateNewAssetPage();
            newAsset = AssetCreateEditForm.getRandomAssetData();
            assetPageSteps.fillCreateNewAssetForm(newAsset);
            assetPageSteps.submitCreateNewAssetForm();

            before = true;
        }
    }

    @After
    public void logout() {
        generalSteps.logOut();
    }

    @Test
    @Title("Create new Campaign Test")
    public void createNewCampaignTest() throws InterruptedException {
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.submitCampaignForm();
        campaignSteps.verifyCampaignCreation(newCampaign);
    }

    @Test
    @Title("Delete Campaign Test")
    public void deleteCampaignTest() throws InterruptedException {
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.submitCampaignForm();
        campaignSteps.deleteCampaign(newCampaign);
        campaignSteps.verifyCampaignNotPresent(newCampaign);
    }

    @Test
    @Title("Back to Campaign page when Creating new Campaign Test")
    public void backToProductPageTest() throws InterruptedException {
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.goBackToCampaignPage();
        campaignSteps.verifyCampaignNotPresent(newCampaign);
    }


    @Test
    @Title("Cancel when Creating new Campaign Test")
    public void cancelCampaignCreationTest() throws InterruptedException {
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.cancelCampaignForm();
        campaignSteps.verifyCampaignNotPresent(newCampaign);
    }

    @Test
    @Title("Edit Existing Campaign Test")
    public void editCampaignConfigurationTest() throws InterruptedException {
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.submitCampaignForm();

        campaignSteps.editCampaignConfiguration(newCampaign);
        CampaignCreateEditForm editCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(editCampaign);
        campaignSteps.submitCampaignForm();
        campaignSteps.verifyCampaignCreation(editCampaign);

    }

}
