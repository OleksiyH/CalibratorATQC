package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 29.04.2016.
 */
public class CampaignProductTableModel {

    private ArrayList<CampaignProductTableRowModel> productTable;

    public CampaignProductTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<CampaignProductTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            CampaignProductTableRowModel model = new CampaignProductTableRowModel(i);
            models.add(model);
        }
        this.productTable = models;
    }

    public List<CampaignProductTableRowModel> getProductTable() {
        return productTable;
    }

    public CampaignProductTableRowModel getProductByName(String name) {
        List<CampaignProductTableRowModel> productTable = this.getProductTable();
        CampaignProductTableRowModel result = null;
        for (CampaignProductTableRowModel i : productTable) {
            if (i.getProductName().getText().equals(name)) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Product with name " + name + " was not found on this page");
        return result;
    }

    public static class CampaignProductTableRowModel {

        private WebElement productPosition;
        private WebElement productInternalName;
        private WebElement productName;
        private WebElement makeDefaultLink;
        private WebElement removeProductLink;
        private Boolean isDefault = false;

        public CampaignProductTableRowModel(WebElement row) {
            this.productPosition = TableUtils.getAllCells(row).get(0);
            this.productInternalName = TableUtils.getAllCells(row).get(1);
            this.productName = TableUtils.getAllCells(row).get(2);
            this.makeDefaultLink = TableUtils.getAllCells(row).get(3);
            if (makeDefaultLink.getText().equals("X")) {
                this.isDefault = true;
            }
            this.removeProductLink = TableUtils.getAllCells(row).get(4).findElement(By.tagName("a"));
        }

        public WebElement getProductPosition() {
            return productPosition;
        }

        public WebElement getProductInternalName() {
            return productInternalName;
        }

        public WebElement getProductName() {
            return productName;
        }

        public WebElement getMakeDefaultLink() {
            return makeDefaultLink;
        }

        public WebElement getRemoveProductLink() {
            return removeProductLink;
        }

        public Boolean getIsDefault() {
            return isDefault;
        }

        //--------------------------------------
        //Business logic

       public void makeDefault(){
           getMakeDefaultLink().click();
       }

        public void removeProduct(){
            getRemoveProductLink().click();
        }




    }
}
