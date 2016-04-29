package steps;

import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.AssetCreateEditPage;
import pages.HomePage;
import pages.ProductCreateEditPage;
import pages.ProductForAssetPage;
import pages.formModels.AssetCreateEditForm;
import pages.formModels.ProductCreateEditForm;
import pages.tableModels.AssetTableModel;
import pages.tableModels.ProductTableModel;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class CreateEditProductPageSteps extends ScenarioSteps {

    private HomePage homePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    private AssetCreateEditPage assetCreateEditPage() {
        return getPages().currentPageAt(AssetCreateEditPage.class);
    }

    private ProductCreateEditPage productCreateEditPage() {
        return getPages().currentPageAt(ProductCreateEditPage.class);
    }

    private ProductForAssetPage productForAssetPage() {
        return getPages().currentPageAt(ProductForAssetPage.class);
    }

    @Step("Fill Create new Product form")
    public void fillCreateNewProductForm(ProductCreateEditForm form) {
        productCreateEditPage().fillForm(form);
    }

    @Step("Configure Fees for Products")
    public void configureFees() {
        productCreateEditPage().clickFeesButton();
    }

    @Step("Submit Create new Product form")
    public void submitCreateNewProductForm() {
        productCreateEditPage().clickSubmitButton();
    }

    @Step("Go Back to Product Page")
    public void backToProductPage() {
        productCreateEditPage().goBackToProductPage();
    }


    @Step("Verify that Product Was Created and all data was captured")
    public void verifyProductCreation(ProductCreateEditForm form) {
        productForAssetPage().searchByProductName(form.getProductName());
        ProductTableModel tableModel = new ProductTableModel(productForAssetPage().getProductTable());
        tableModel.getProductByName(form.getProductName()).goToEditproductPage();
        ProductCreateEditForm capturedForm = productCreateEditPage().readForm();

        assertThat("Product name is different from expected." +
                        " Actual: " + capturedForm.getProductName() +
                        " Expected: " + form.getProductName(),
                capturedForm.getProductName().equals(form.getProductName()));

        assertThat("Product Description is different from expected." +
                        " Actual: " + capturedForm.getProductDescription() +
                        " Expected: " + form.getProductDescription(),
                capturedForm.getProductDescription().equals(form.getProductDescription()));

        assertThat("Product Type is different from expected." +
                        " Actual: " + capturedForm.getProductType() +
                        " Expected: " + form.getProductType(),
                capturedForm.getProductType().equals(form.getProductType()));

        assertThat("Print Type is different from expected." +
                        " Actual: " + capturedForm.getPrintType() +
                        " Expected: " + form.getPrintType(),
                capturedForm.getPrintType().equals(form.getPrintType()));

        assertThat("Product Processor is different from expected." +
                        " Actual: " + capturedForm.getProcessor() +
                        " Expected: " + form.getProcessor(),
                capturedForm.getProcessor().equals(form.getProcessor()));

        assertThat("Period type is different from expected." +
                        " Actual: " + capturedForm.getPeriodType() +
                        " Expected: " + form.getPeriodType(),
                capturedForm.getPeriodType().equals(form.getPeriodType()));

        assertThat("Cycle count is different from expected." +
                        " Actual: " + capturedForm.getCycleCount() +
                        " Expected: " + form.getCycleCount(),
                capturedForm.getCycleCount().equals(form.getCycleCount()));
//TODO Those fields where deleted
//
//        assertThat("Trial Display Type is different from expected." +
//                        " Actual: " + capturedForm.getTrialDisplayType() +
//                        " Expected: " + form.getTrialDisplayType(),
//                capturedForm.getTrialDisplayType().equals(form.getTrialDisplayType()));
//
//        assertThat("Free Trial Amount Display is different from expected." +
//                        " Actual: " + capturedForm.getFreeTrialAmountDisplay() +
//                        " Expected: " + form.getFreeTrialAmountDisplay(),
//                capturedForm.getFreeTrialAmountDisplay().equals(form.getFreeTrialAmountDisplay()));
    }


}
