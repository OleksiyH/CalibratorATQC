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
import pages.formModels.ProductCreateEditForm;
import steps.*;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag(name = "Asset Product Management")
@RunWith(SerenityRunner.class)
public class CreateNewAssetProductTest {

    @Managed
    public WebDriver webdriver;
    @Steps
    public GeneralSteps generalSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public CreateEditAssetPageSteps assetPageSteps;
    @Steps
    public ProductForAssetSteps productForAssetSteps;
    @Steps
    public CreateEditProductPageSteps createEditProductPageSteps;

    public Boolean before = false;
    public AssetCreateEditForm newAsset;

    @Before
    public void loginToApplication() {
        generalSteps.openPage();
        generalSteps.loginToApplication(UserRepository.getTestUser());

        if (!before) {

            // Creating test asset for all Asset Product Tests
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
    @Title("Create new Asset Product Test")
    public void createNewProductTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        createEditProductPageSteps.verifyProductCreation(newProduct);
    }

    @Test
    @Title("Back to Products page when Creating new Product Test")
    public void backToProductPageTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.backToProductPage();
        productForAssetSteps.verifyProductNotPresent(newProduct.getProductName());
    }

    @Test
    @Title("Edit Existing Product Configuration Test")
    public void editProductConfigurationTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        ProductCreateEditForm editProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(editProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        createEditProductPageSteps.verifyProductCreation(editProduct);
    }

}
