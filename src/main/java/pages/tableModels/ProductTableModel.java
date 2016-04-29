package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class ProductTableModel {

    private ArrayList<ProductTableRowModel> productTable;

    public ProductTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<ProductTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            ProductTableRowModel model = new ProductTableModel.ProductTableRowModel(i);
            models.add(model);
        }
        this.productTable = models;
    }

    public List<ProductTableRowModel> getProductTable() {
        return productTable;
    }

    public ProductTableRowModel getProductByName(String name) {
        List<ProductTableRowModel> productTable = this.getProductTable();
        ProductTableRowModel result = null;
        for (ProductTableRowModel i : productTable) {
            if (i.getProductNameLink().getText().equals(name)) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Product with name " + name + " was not found on this page");
        return result;
    }

    public static class ProductTableRowModel {

        private WebElement productTypeLink;
        private WebElement productNameLink;
        private WebElement productStatusLabel;
        private WebElement productLastUpdated;
        //TODO Those fields where deleted
        //private WebElement cloneToButton;

        public ProductTableRowModel(WebElement row) {
            this.productTypeLink = TableUtils.getAllCells(row).get(0).findElement(By.tagName("a"));
            this.productNameLink = TableUtils.getAllCells(row).get(1).findElement(By.tagName("a"));
            this.productStatusLabel = TableUtils.getAllCells(row).get(2).findElement(By.tagName("span"));
            this.productLastUpdated = TableUtils.getAllCells(row).get(3);
           // this.cloneToButton = TableUtils.getAllCells(row).get(4).findElement(By.tagName("a"));
        }

        public WebElement getProductTypeLink() {
            return productTypeLink;
        }

        public WebElement getProductNameLink() {
            return productNameLink;
        }

        public WebElement getProductStatusLabel() {
            return productStatusLabel;
        }

        public WebElement getProductLastUpdated() {
            return productLastUpdated;
        }

//        public WebElement getCloneToButton() {
//            return cloneToButton;
//        }
        //--------------------------------------
        //Business logic

        public void goToEditproductPage(){
            this.getProductNameLink().click();
        }

//        public void cloneThisProduct(){
//            this.getCloneToButton().click();
//        }

        public String getProductTypeText(){
            return this.getProductTypeLink().getText();
        }

        public String getProductStatusText(){
            return this.getProductStatusLabel().getText();
        }

        public String getLastUpdateTimeText(){
            return this.getProductLastUpdated().getText();
        }




    }
}
