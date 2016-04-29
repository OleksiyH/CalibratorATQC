package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class AssetTableModel {

    private ArrayList<AssetModel> assetTable;

    public AssetTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<AssetModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            AssetModel model = new AssetTableModel.AssetModel(i);
            models.add(model);
        }
        this.assetTable = models;
    }

    public List<AssetModel> getAssetTable() {
        return assetTable;
    }

    public AssetModel getAssetByName(String name) {
        List<AssetModel> assetModels = this.getAssetTable();
        AssetModel result = null;
        for (AssetModel i : assetModels) {
            if (i.getAssetNameLink().getText().equals(name)) {
                result = i;
                break;
            }

        }
        if (result == null)
            System.out.println("Asset with name " + name + " was not found on this page");
        return result;
    }

    public static class AssetModel {

        private WebElement assetNameLink;
        private WebElement productConfigurationLink;
        private WebElement campaignConfigurationLink;
        private WebElement campaignProductConfigurationLink;
        private WebElement accessBoundaryConfigurationLink;
        private WebElement assetStatusLabel;


        public AssetModel(WebElement row) {
            this.assetNameLink = TableUtils.getAllCells(row).get(0).findElement(By.tagName("a"));
            this.productConfigurationLink = TableUtils.getAllCells(row).get(1).findElement(By.tagName("a"));
            this.campaignConfigurationLink = TableUtils.getAllCells(row).get(2).findElement(By.tagName("a"));
            this.campaignProductConfigurationLink = TableUtils.getAllCells(row).get(3).findElement(By.tagName("a"));
            this.accessBoundaryConfigurationLink = TableUtils.getAllCells(row).get(4).findElement(By.tagName("a"));
            this.assetStatusLabel = TableUtils.getAllCells(row).get(5);

        }

        public WebElement getAssetNameLink() {
            return assetNameLink;
        }

        public WebElement getProductConfigurationLink() {
            return productConfigurationLink;
        }

        public WebElement getCampaignConfigurationLink() {
            return campaignConfigurationLink;
        }

        public WebElement getCampaignProductConfigurationLink() {
            return campaignProductConfigurationLink;
        }

        public WebElement getAccessBoundaryConfigurationLink() {
            return accessBoundaryConfigurationLink;
        }

        public WebElement getAssetStatusLabel() {
            return assetStatusLabel;
        }

        //--------------------------------------
        //Business logic

        public void goToAssetConfiguration(){
            this.getAssetNameLink().click();
        }

        public void goToProductConfiguration(){
            this.getProductConfigurationLink().click();
        }

        public void goToCampaignConfiguration(){
            this.getCampaignConfigurationLink().click();
        }

        public void goToCampaignProductConfiguration(){
            this.getCampaignProductConfigurationLink().click();
        }

        public void goToAccessBoundaryConfiguration(){
            this.getAccessBoundaryConfigurationLink().click();
        }

        public String getAssetStatus(){
            return this.getAssetStatusLabel().getText();
        }


    }
}
