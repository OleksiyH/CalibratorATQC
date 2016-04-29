package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.CampaignProductPage;
import pages.ConfigureCampaignProductsPage;
import pages.formModels.CampaignCreateEditForm;
import pages.formModels.CampaignProductModel;
import pages.tableModels.CampaignProductTableModel;
import pages.tableModels.CampaignTableModel;
import pages.tableModels.MiniCampaignTableModel;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Oleksiy on 29.04.2016.
 */
public class CampaignProductsSteps extends ScenarioSteps {

    private CampaignProductPage campaignProductPage() {
        return getPages().currentPageAt(CampaignProductPage.class);
    }

    private ConfigureCampaignProductsPage configureCampaignProductsPage() {
        return getPages().currentPageAt(ConfigureCampaignProductsPage.class);
    }



    //-----------------------------------------------------------------------------------------------------------------
    @Step("Select number of Campaigns to show")
    public void selectNumberOfCampaignsToShow(ShowItemsEnum items) {
        campaignProductPage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Campaigns")
    public void searchForCampaigns(String query) {
        campaignProductPage().searchForCampaign(query);
    }

    @Step("Configure Campaign Configuration")
    public void editCampaignConfiguration(CampaignCreateEditForm form) {
        campaignProductPage().searchForCampaign(form.getCampaignName().toString());
        MiniCampaignTableModel campaignTable = new MiniCampaignTableModel(campaignProductPage().getCampaignMiniTable());
        campaignTable.getCampaignByName(form.getCampaignName()).configureCampaign();
    }

    @Step("Configure Campaign Products Configuration")
    public void editCampaignProductsConfiguration(CampaignCreateEditForm form) {
        campaignProductPage().searchForCampaign(form.getCampaignName().toString());
        MiniCampaignTableModel campaignTable = new MiniCampaignTableModel(campaignProductPage().getCampaignMiniTable());
        campaignTable.getCampaignByName(form.getCampaignName()).configureCampaignsProducts();
    }

    @Step("Go back to Home page")
    public void goBackToHomePage() {
        campaignProductPage().goToHomePage();
    }

    //--- Campaign Product Configuration Page
    @Step("Select number of Product to show")
    public void selectNumberOfProductsToShow(ShowItemsEnum items) {
        configureCampaignProductsPage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Product")
    public void searchForProducts(String query) {
        configureCampaignProductsPage().searchForProduct(query);
    }

    @Step("Add Product to the table")
    public void addProductToTable(CampaignProductModel productModel) {
        configureCampaignProductsPage().selectProductFromDropdown(productModel.getInternalProductName());
        configureCampaignProductsPage().setProductPosition(productModel.getPosition());
        configureCampaignProductsPage().setIsDefaultOption(productModel.getDefault());
        configureCampaignProductsPage().addProductButtonClick();
    }

    @Step("Make product Default")
    public void makeProductDefault(String productName) {
        CampaignProductTableModel table = new CampaignProductTableModel(configureCampaignProductsPage().getProductsOptionsTable());
        table.getProductByName(productName).makeDefault();
    }

    @Step("Remove Product")
    public void removeProduct(String productName) {
        CampaignProductTableModel table = new CampaignProductTableModel(configureCampaignProductsPage().getProductsOptionsTable());
        table.getProductByName(productName).removeProduct();
    }

    @Step("Verify Product Data")
    public void verifyProductData(CampaignProductModel productModel) {
        CampaignProductTableModel table = new CampaignProductTableModel(configureCampaignProductsPage().getProductsOptionsTable());
        CampaignProductTableModel.CampaignProductTableRowModel product = table.getProductByName(productModel.getProductName());
        assertThat("Product Position is different from expected." +
                        " Actual: " + product.getProductPosition().getText() +
                        " Expected: " + productModel.getPosition().toString(),
                product.getProductPosition().getText().equals(productModel.getPosition().toString()));

        assertThat("Product Internal Name is different from expected." +
                        " Actual: " + product.getProductInternalName().getText() +
                        " Expected: " + productModel.getInternalProductName(),
                product.getProductInternalName().getText().equals(productModel.getInternalProductName()));

        assertThat("Default product is different from expected." +
                        " Actual: " + product.getIsDefault() +
                        " Expected: " + productModel.getDefault(),
                product.getIsDefault().equals(productModel.getDefault()));

    }

    @Step("Verify Product Not Present")
    public void verifyProductNotPresent(String productName) {
        assertThat("Product "+productName+" is present, but should not be",configureCampaignProductsPage().containsText(productName));
    }
}
