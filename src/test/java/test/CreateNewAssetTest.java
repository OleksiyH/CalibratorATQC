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
import pages.formModels.AssetCreateEditForm;
import steps.CreateEditAssetPageSteps;
import steps.GeneralSteps;
import steps.HomePageSteps;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag(name = "AssetManagement")
@RunWith(SerenityRunner.class)
public class CreateNewAssetTest {

    @Managed
    public WebDriver webdriver;
    @Steps
    public GeneralSteps generalSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public CreateEditAssetPageSteps assetPageSteps;


    @Before
    public void loginToApplication() {
        generalSteps.openPage();
        generalSteps.loginToApplication(UserRepository.getTestUser());
    }

    @After
    public void logout() {
        generalSteps.logOut();
    }

    @Test
    @Title("Create new Asset Test")
    public void createNewAssetTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.submitCreateNewAssetForm();
        assetPageSteps.verifyAssetCreation(newAsset);
    }

    @Test
    @Title("Cancel Create new Asset Test")
    public void cancelCreateNewAssetTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.cancelCreateNewAssetForm();
        homePageSteps.verifyAssetNotPresent(newAsset.getAssetName());
    }

    @Test
    @Title("Back to calibrator page when Creating new Asset Test")
    public void backToHomePageTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.backToHomePage();
        homePageSteps.verifyAssetNotPresent(newAsset.getAssetName());
    }

    @Test
    @Title("Edit Existing Assets Configuration Test")
    public void editAssetConfigurationTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.submitCreateNewAssetForm();
        homePageSteps.editAssetConfiguration(newAsset.getAssetName());
        AssetCreateEditForm editAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(editAsset);
        assetPageSteps.submitCreateNewAssetForm();
        assetPageSteps.verifyAssetCreation(editAsset);
    }


    @Test
    @Title("Edit Existing Assets Status Test")
    public void editAssetStatusTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.submitCreateNewAssetForm();
        homePageSteps.editAssetConfiguration(newAsset.getAssetName());
        assetPageSteps.changeAssetStatus(StatusEnum.RELEASED);
        assetPageSteps.submitCreateNewAssetForm();
        homePageSteps.verifyAssetStatus(newAsset.getAssetName(), StatusEnum.RELEASED);
    }


    @Test
    @Title("Delete Assets Test")
    public void deleteAssetTest() throws InterruptedException {
        homePageSteps.goToCreateNewAssetPage();
        AssetCreateEditForm newAsset = AssetCreateEditForm.getRandomAssetData();
        assetPageSteps.fillCreateNewAssetForm(newAsset);
        assetPageSteps.submitCreateNewAssetForm();
        assetPageSteps.deleteAssetByName(newAsset.getAssetName());
    }


}
