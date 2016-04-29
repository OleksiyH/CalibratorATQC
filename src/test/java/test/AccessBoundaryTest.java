package test;

import data.UserRepository;
import enums.StatusEnum;
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
import pages.formModels.AccessBoundaryCreateEditForm;
import pages.formModels.AssetCreateEditForm;
import pages.formModels.CampaignCreateEditForm;
import pages.formModels.ProductCreateEditForm;
import steps.*;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag("feature:AccessBoundary")
@RunWith(SerenityRunner.class)
public class AccessBoundaryTest {
    public boolean before = false;

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
    @Steps
    public AccessBoundarySteps accessBoundarySteps;

    public AssetCreateEditForm newAsset;
    public CampaignCreateEditForm newCampaign;


    @Before
    public void loginToApplication() throws InterruptedException {
        generalSteps.openPage();
        generalSteps.loginToApplication(UserRepository.getTestUser());
        homePageSteps.goToCreateNewAssetPage();
        newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.submitCreateNewAssetForm();
        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
        campaignSteps.goToCreateNewCampaignPage();
        newCampaign = CampaignCreateEditForm.getRandomCampaignData();
        campaignSteps.fillCampaignForm(newCampaign);
        campaignSteps.submitCampaignForm();
        generalSteps.goToHomePage();


    }

    @After
    public void logout() {
        generalSteps.logOut();
    }

    @Test
    @Title("Create new Access Boundary Configuration Test")
    public void createNewAccessBoundaryTest() throws InterruptedException {
        homePageSteps.editAccessBoundaryConfiguration(newAsset.getAssetName());
        accessBoundarySteps.goToCreateNewAccessBoundaryPage();
        AccessBoundaryCreateEditForm newAccessBoundary = AccessBoundaryCreateEditForm.getRandomAccessBoundaryForCreationData(newCampaign.getCampaignName());
        accessBoundarySteps.fillCreateAccessBoundaryForm(newAccessBoundary);
        accessBoundarySteps.submitAccessBoundaryForm();
        accessBoundarySteps.verifyAccessBoundaryCreation(newAccessBoundary);
    }

    @Test
    @Title("Delete Access Boundary Test")
    public void deleteAccessBoundaryTest() throws InterruptedException {
        homePageSteps.editAccessBoundaryConfiguration(newAsset.getAssetName());
        accessBoundarySteps.goToCreateNewAccessBoundaryPage();
        AccessBoundaryCreateEditForm newAccessBoundary = AccessBoundaryCreateEditForm.getRandomAccessBoundaryForCreationData(newCampaign.getCampaignName());
        accessBoundarySteps.fillCreateAccessBoundaryForm(newAccessBoundary);
        accessBoundarySteps.submitAccessBoundaryForm();
        accessBoundarySteps.deleteAccessBoundary(newAccessBoundary);
    }

    @Test
    @Title("Back to Access Boundary page when Creating new Access Boundary Test")
    public void backToProductPageTest() throws InterruptedException {
        homePageSteps.editAccessBoundaryConfiguration(newAsset.getAssetName());
        accessBoundarySteps.goToCreateNewAccessBoundaryPage();
        AccessBoundaryCreateEditForm newAccessBoundary = AccessBoundaryCreateEditForm.getRandomAccessBoundaryForCreationData(newCampaign.getCampaignName());
        accessBoundarySteps.fillCreateAccessBoundaryForm(newAccessBoundary);
        accessBoundarySteps.goBackToAccessBoundaryPage();
    }

//
//    @Test
//    @Title("Cancel when Creating new Campaign Test")
//    public void cancelCampaignCreationTest() throws InterruptedException {
//        homePageSteps.editCampaignConfiguration(newAsset.getAssetName());
//        campaignSteps.goToCreateNewCampaignPage();
//        CampaignCreateEditForm newCampaign = CampaignCreateEditForm.getRandomCampaignData();
//        campaignSteps.fillCampaignForm(newCampaign);
//        campaignSteps.cancelCampaignForm();
//        campaignSteps.verifyCampaignNotPresent(newCampaign);
//    }

    @Test
    @Title("Edit Existing Campaign Test")
    public void editCampaignConfigurationTest() throws InterruptedException {
        homePageSteps.editAccessBoundaryConfiguration(newAsset.getAssetName());
        accessBoundarySteps.goToCreateNewAccessBoundaryPage();
        AccessBoundaryCreateEditForm newAccessBoundary = AccessBoundaryCreateEditForm.getRandomAccessBoundaryForCreationData(newCampaign.getCampaignName());
        accessBoundarySteps.fillCreateAccessBoundaryForm(newAccessBoundary);
        accessBoundarySteps.submitAccessBoundaryForm();
        accessBoundarySteps.editAccessBoundaryConfiguration(newAccessBoundary);
        AccessBoundaryCreateEditForm editAccessBoundary = AccessBoundaryCreateEditForm.getRandomAccessBoundaryForCreationData(newCampaign.getCampaignName());
        accessBoundarySteps.fillEditAccessBoundaryForm(editAccessBoundary);
        accessBoundarySteps.submitAccessBoundaryForm();
        accessBoundarySteps.verifyAccessBoundaryEdition(editAccessBoundary);

    }

}
