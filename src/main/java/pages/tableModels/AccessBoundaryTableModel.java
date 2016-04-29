package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class AccessBoundaryTableModel {

    private ArrayList<AccessBoundaryTableRowModel> accessBoundaryTable;

    public AccessBoundaryTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<AccessBoundaryTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            AccessBoundaryTableRowModel model = new AccessBoundaryTableRowModel(i);
            models.add(model);
        }
        this.accessBoundaryTable = models;
    }

    public List<AccessBoundaryTableRowModel> getAccessBoundaryTable() {
        return accessBoundaryTable;
    }

    public AccessBoundaryTableRowModel getByBoundaryName(String name) {
        List<AccessBoundaryTableRowModel> table = this.getAccessBoundaryTable();
        AccessBoundaryTableRowModel result = null;
        for (AccessBoundaryTableRowModel i : table) {
            if (i.getAccessBoundaryNameText().equals(name)) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Access Boundary with name " + name + " was not found on this page");
        return result;
    }

    public static class AccessBoundaryTableRowModel {

        private WebElement accessBoundaryNameLink;
        private WebElement accessBoundaryUUID;
        private WebElement ipExclutionsLink;
        private WebElement promotionsLink;
        private WebElement campaignStatusLabel;
        private WebElement lastUpdatedTime;



        public AccessBoundaryTableRowModel(WebElement row) {
            this.accessBoundaryNameLink = TableUtils.getAllCells(row).get(0).findElement(By.tagName("a"));
            this.accessBoundaryUUID = TableUtils.getAllCells(row).get(1);
            this.ipExclutionsLink = TableUtils.getAllCells(row).get(2).findElement(By.tagName("a"));
            this.promotionsLink = TableUtils.getAllCells(row).get(3).findElement(By.tagName("a"));
            this.campaignStatusLabel = TableUtils.getAllCells(row).get(4).findElement(By.tagName("span"));
            this.lastUpdatedTime = TableUtils.getAllCells(row).get(5);

        }

        public WebElement getAccessBoundaryNameLink() {
            return accessBoundaryNameLink;
        }

        public WebElement getAccessBoundaryUUID() {
            return accessBoundaryUUID;
        }

        public WebElement getIpExclutionsLink() {
            return ipExclutionsLink;
        }

        public WebElement getPromotionsLink() {
            return promotionsLink;
        }

        public WebElement getCampaignStatusLabel() {
            return campaignStatusLabel;
        }

        public WebElement getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        //--------------------------------------
        //Business logic

       public String getAccessBoundaryNameText(){
           return getAccessBoundaryNameLink().getText();
       }

        public void editAccessBoundary(){
            getAccessBoundaryNameLink().click();
        }

        public void configureIpExclutions(){
            getIpExclutionsLink().click();
        }
        public void configurePromotions(){
            getPromotionsLink().click();
        }

    }
}
