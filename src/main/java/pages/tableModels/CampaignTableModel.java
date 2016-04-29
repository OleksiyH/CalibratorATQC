package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class CampaignTableModel {

    private ArrayList<CampaignTableRowModel> campaignTable;

    public CampaignTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<CampaignTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            CampaignTableRowModel model = new CampaignTableRowModel(i);
            models.add(model);
        }
        this.campaignTable = models;
    }

    public List<CampaignTableRowModel> getCampaignTable() {
        return campaignTable;
    }

    public CampaignTableRowModel getCampaignByName(String name) {
        List<CampaignTableRowModel> campaignTable = this.getCampaignTable();
        CampaignTableRowModel result = null;
        for (CampaignTableRowModel i : campaignTable) {
            if (i.getCampaignNameLink().getText().equals(name)) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Campaign with name " + name + " was not found on this page");
        return result;
    }

    public static class CampaignTableRowModel {

        private WebElement campaignId;
        private WebElement campaignNameLink;
        private WebElement campaignUUID;
        private WebElement campaignMeterConfigurationLink;
        private WebElement campaignStatusLabel;
        private WebElement lastUpdatedTime;
        private WebElement mirrorCloneButton;
        private WebElement cloneToButton;


        public CampaignTableRowModel(WebElement row) {
            this.campaignId = TableUtils.getAllCells(row).get(0);
            this.campaignNameLink = TableUtils.getAllCells(row).get(1).findElement(By.tagName("a"));
            this.campaignUUID = TableUtils.getAllCells(row).get(2);
            this.campaignMeterConfigurationLink = TableUtils.getAllCells(row).get(3).findElement(By.tagName("a"));
            this.campaignStatusLabel = TableUtils.getAllCells(row).get(4).findElement(By.tagName("span"));
            this.lastUpdatedTime = TableUtils.getAllCells(row).get(5);
            this.mirrorCloneButton = TableUtils.getAllCells(row).get(6).findElement(By.tagName("a"));
            this.cloneToButton = TableUtils.getAllCells(row).get(7).findElement(By.tagName("a"));

        }

        public WebElement getCampaignNameLink() {
            return campaignNameLink;
        }

        public WebElement getCampaignUUID() {
            return campaignUUID;
        }

        public WebElement getCampaignMeterConfigurationLink() {
            return campaignMeterConfigurationLink;
        }

        public WebElement getCampaignStatusLabel() {
            return campaignStatusLabel;
        }

        public WebElement getCampaignId() {
            return campaignId;
        }

        public WebElement getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public WebElement getMirrorCloneButton() {
            return mirrorCloneButton;
        }

        public WebElement getCloneToButton() {
            return cloneToButton;
        }

        //--------------------------------------
        //Business logic

        public String getCampaignNameText() {
            return getCampaignNameLink().getText();
        }

        public void editCampaign(){
            getCampaignNameLink().click();
        }

        public void goToConfigureMeterPage(){
            getCampaignMeterConfigurationLink().click();
        }
        public void dublicateThisCampaignForThisAsset(){
            getMirrorCloneButton().click();
        }
        public void goToCloneToPage(){
            getCloneToButton().click();
        }


    }
}
