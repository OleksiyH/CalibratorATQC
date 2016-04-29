package test;

import data.UserRepository;
import enums.FeesEnums.CurrencyEnum;
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
import pages.formModels.FeeCreateEditForm;
import pages.formModels.ProductCreateEditForm;
import steps.*;

/**
 * Created by Oleksiy on 24.04.2016.
 */

@WithTag(name = "Asset Product Fees Management")
@RunWith(SerenityRunner.class)
public class FeeTest {

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
    @Steps
    public FeesSteps feesSteps;


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
    @Title("Create new Fee Test")
    public void createNewProductTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee = FeeCreateEditForm.getRandomFeeData();
        feesSteps.fillFeeForm(newFee);
        feesSteps.submitFeeForm();
        feesSteps.verifyFeeCreation(newFee);
    }

    @Test
    @Title("Cancel when Creating new Fee Test")
    public void cancelFeeTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee = FeeCreateEditForm.getRandomFeeData();
        feesSteps.fillFeeForm(newFee);
        feesSteps.goBackToFeePage();
        feesSteps.verifyFeeNotPresent(newFee);
    }

    @Test
    @Title("Back to Fee page when Creating new Fee Test")
    public void backToFeePageTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee = FeeCreateEditForm.getRandomFeeData();
        feesSteps.fillFeeForm(newFee);
        feesSteps.goBackToFeePage();
        feesSteps.verifyFeeNotPresent(newFee);
    }

    @Test
    @Title("Edit Existing Fee Configuration Test")
    public void editFeeConfigurationTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee = FeeCreateEditForm.getRandomFeeData();
        newFee.setCurrency(CurrencyEnum.CA_DOLLAR);
        feesSteps.fillFeeForm(newFee);
        feesSteps.submitFeeForm();
        feesSteps.editFeeConfiguration(newFee);
        FeeCreateEditForm editFee = FeeCreateEditForm.getRandomFeeData();
        editFee.setCurrency(CurrencyEnum.ARGENTINE_PESO);
        editFee.setStatus(StatusEnum.RELEASED);
        feesSteps.fillFeeForm(editFee);
        feesSteps.submitFeeForm();
        feesSteps.verifyFeeCreation(editFee);
    }

    @Test
    @Title("Create two Fees with same currency Test")
    public void sameCurrencyFeesTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee1 = FeeCreateEditForm.getRandomFeeData();
        feesSteps.fillFeeForm(newFee1);
        feesSteps.submitFeeForm();

        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee2 = FeeCreateEditForm.getRandomFeeData();
        newFee2.setCurrency(newFee1.getCurrency());
        feesSteps.fillFeeForm(newFee2);
        feesSteps.submitFeeForm();
        feesSteps.verifyCurrencyErrorMessage();

    }

    @Test
    @Title("Edit Fees currency to match  other Fees currency Test")
    public void sameCurrencyFeesEditTest() throws InterruptedException {
        homePageSteps.editProductConfiguration(newAsset.getAssetName());
        productForAssetSteps.goToCreateNewProductPage();
        ProductCreateEditForm newProduct = ProductCreateEditForm.getRandomProductData();
        createEditProductPageSteps.fillCreateNewProductForm(newProduct);
        createEditProductPageSteps.submitCreateNewProductForm();
        productForAssetSteps.editProductConfiguration(newProduct.getProductName());
        createEditProductPageSteps.configureFees();
        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee1 = FeeCreateEditForm.getRandomFeeData();
        newFee1.setCurrency(CurrencyEnum.EU_EURO);
        feesSteps.fillFeeForm(newFee1);
        feesSteps.submitFeeForm();

        feesSteps.goToCreateNewFeePage();
        FeeCreateEditForm newFee2 = FeeCreateEditForm.getRandomFeeData();
        newFee2.setCurrency(CurrencyEnum.ARGENTINE_PESO);
        feesSteps.fillFeeForm(newFee2);
        feesSteps.submitFeeForm();

        feesSteps.editFeeConfiguration(newFee2);
        newFee2.setCurrency(newFee1.getCurrency());
        feesSteps.fillFeeForm(newFee2);
        feesSteps.submitFeeForm();
        feesSteps.verifyCurrencyErrorMessage();

    }

}
