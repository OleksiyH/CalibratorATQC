package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class MiniCampaignTableModel {

    private ArrayList<MiniCampaignTableRowModel> campaignTable;

    public MiniCampaignTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<MiniCampaignTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            MiniCampaignTableRowModel model = new MiniCampaignTableRowModel(i);
            models.add(model);
        }
        this.campaignTable = models;
    }

    public List<MiniCampaignTableRowModel> getCampaignTable() {
        return campaignTable;
    }

    public MiniCampaignTableRowModel getCampaignByName(String name) {
        List<MiniCampaignTableRowModel> campaignTable = this.getCampaignTable();
        MiniCampaignTableRowModel result = null;
        for (MiniCampaignTableRowModel i : campaignTable) {
            if (i.getCampaignNameLink().getText().equals(name)) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Campaign with name " + name + " was not found on this page");
        return result;
    }

    public static class MiniCampaignTableRowModel {

        private WebElement campaignNameLink;
        private WebElement campaignProductsLink;
        private WebElement lastUpdatedTime;


        public MiniCampaignTableRowModel(WebElement row) {
            this.campaignNameLink = TableUtils.getAllCells(row).get(0).findElement(By.tagName("a"));
            this.campaignProductsLink = TableUtils.getAllCells(row).get(1).findElement(By.tagName("a"));
            this.lastUpdatedTime = TableUtils.getAllCells(row).get(2);

        }

        public WebElement getCampaignNameLink() {
            return campaignNameLink;
        }

        public WebElement getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public WebElement getCampaignProductsLink() {
            return campaignProductsLink;
        }

        //--------------------------------------
        //Business logic

        public String getCampaignNameText() {
            return getCampaignNameLink().getText();
        }

        public void configureCampaign() {
            getCampaignNameLink().click();
        }

        public void configureCampaignsProducts() {
            getCampaignProductsLink().click();
        }



    }
}
