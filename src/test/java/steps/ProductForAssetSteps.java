package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.ProductForAssetPage;
import pages.formModels.ProductCreateEditForm;
import pages.tableModels.AssetTableModel;
import pages.tableModels.ProductTableModel;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class ProductForAssetSteps extends ScenarioSteps {

    private ProductForAssetPage productForAssetPage() {
        return getPages().currentPageAt(ProductForAssetPage.class);
    }


    @Step("Go to Create new Product page")
    public void goToCreateNewProductPage() {
        productForAssetPage().createNewProductButtonClick();
    }

    @Step("Select number of assets to show")
    public void selectNumberOfElementToShow(ShowItemsEnum items) throws InterruptedException {
        productForAssetPage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Product by Name")
    public void searchByProductName(String name) {
        productForAssetPage().searchByProductName(name);
    }

    @Step("Edit Product Configuration by Name")
    public void editProductConfiguration(String name) {
        productForAssetPage().searchByProductName(name);
        ProductTableModel productTable = new ProductTableModel(productForAssetPage().getProductTable());
        productTable.getProductByName(name).goToEditproductPage();
    }

    @Step("Verify Product Status in the table")
    public void verifyProductStatus(String name, StatusEnum expectedStatus) {
        productForAssetPage().searchByProductName(name);
        ProductTableModel productTable = new ProductTableModel(productForAssetPage().getProductTable());
        String actualStatus = productTable.getProductByName(name).getProductStatusText();
        assertThat("Status in the table is different from expected. Expected: " + expectedStatus.toString() + " Actual: " + actualStatus,
                expectedStatus.toString().equals(actualStatus.trim()));
    }

    @Step("Verify Product is not present in the table")
    public void verifyProductNotPresent(String name) {
        productForAssetPage().searchByProductName(name);
        assertThat("Product is present in the table", !getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Verify Product is present in the table")
    public void verifProductPresent(String name) {
        productForAssetPage().searchByProductName(name);
        assertThat("Product is present in the table", getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Get internal Product name")
    public String getInternalProductName(ProductCreateEditForm form) {
        productForAssetPage().searchByProductName(form.getProductName());
        ProductTableModel productTable = new ProductTableModel(productForAssetPage().getProductTable());
        return productTable.getProductByName(form.getProductName()).getProductTypeText();

    }



}
