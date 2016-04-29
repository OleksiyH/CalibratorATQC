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
import pages.formModels.*;
import steps.*;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag("feature:AccessBoundary")
@RunWith(SerenityRunner.class)
public class CampaignProductsTest {
    public static boolean before = false;

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
    @Steps
    public ProductForAssetSteps productForAssetSteps;
    @Steps
    public CreateEditProductPageSteps createEditProductPageSteps;
    @Steps
    public CampaignProductsSteps campaignProductsSteps;

    public AssetCreateEditForm newAsset;
    public CampaignCreateEditForm newCampaign;
    public ProductCreateEditForm newProduct1;
    public String newProduct1InternalName;
    public ProductCreateEditForm newProduct2;
    public String newProduct2InternalName;
    public ProductCreateEditForm newProduct3;
    public String newProduct3InternalName;



    @Before
    public void prepareTestData() throws InterruptedException {
        if (!before) {

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

            homePageSteps.editProductConfiguration(newAsset.getAssetName());
            productForAssetSteps.goToCreateNewProductPage();
            newProduct1 = ProductCreateEditForm.getRandomProductData();
            createEditProductPageSteps.fillCreateNewProductForm(newProduct1);
            createEditProductPageSteps.submitCreateNewProductForm();
            newProduct1InternalName = productForAssetSteps.getInternalProductName(newProduct1);

//            homePageSteps.editProductConfiguration(newAsset.getAssetName());
//            productForAssetSteps.goToCreateNewProductPage();
//            newProduct2 = ProductCreateEditForm.getRandomProductData();
//            createEditProductPageSteps.fillCreateNewProductForm(newProduct2);
//            createEditProductPageSteps.submitCreateNewProductForm();
//            newProduct2InternalName = productForAssetSteps.getInternalProductName(newProduct2);
//
//            homePageSteps.editProductConfiguration(newAsset.getAssetName());
//            productForAssetSteps.goToCreateNewProductPage();
//            newProduct3 = ProductCreateEditForm.getRandomProductData();
//            createEditProductPageSteps.fillCreateNewProductForm(newProduct3);
//            createEditProductPageSteps.submitCreateNewProductForm();
//            newProduct3InternalName = productForAssetSteps.getInternalProductName(newProduct3);


            generalSteps.logOut();

            before = true;
        }


    }

    @After
    public void logout() {
        generalSteps.logOut();
    }

    @Test
    @Title("Add Campaign Product 1")
    public void addCampaignProduct1Test() throws InterruptedException {
        generalSteps.openPage();
        generalSteps.loginToApplication(UserRepository.getTestUser());
        homePageSteps.editCampaignProductConfiguration(newAsset.getAssetName());
        CampaignProductModel product1 = new CampaignProductModel(newProduct1.getProductName(),newProduct1InternalName, 1, true);
        campaignProductsSteps.editCampaignProductsConfiguration(newCampaign);
        campaignProductsSteps.addProductToTable(product1);
        campaignProductsSteps.verifyProductData(product1);

    }

}
