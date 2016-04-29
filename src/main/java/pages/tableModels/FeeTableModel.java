package pages.tableModels;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import utils.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class FeeTableModel {

    private ArrayList<FeeTableRowModel> feesTable;

    public FeeTableModel(WebElement table) {
        List<WebElement> rows = TableUtils.getAllRows(table);
        ArrayList<FeeTableRowModel> models = new ArrayList<>();
        for (WebElement i : rows) {
            FeeTableRowModel model = new FeeTableModel.FeeTableRowModel(i);
            models.add(model);
        }
        this.feesTable = models;
    }

    public List<FeeTableRowModel> getFeesTable() {
        return feesTable;
    }

    public FeeTableRowModel getFeeByRate(Double rate) {
        List<FeeTableRowModel> feesTable = this.getFeesTable();
        FeeTableRowModel result = null;
        for (FeeTableRowModel i : feesTable) {
            if (i.getTaxRateLabel().getText().contains(rate.toString().substring(2))) {
                result = i;
                break;
            }
        }
        if (result == null)
            System.out.println("Fee by rate " + rate.toString().substring(2) + " was not found on this page");
        return result;
    }

    public static class FeeTableRowModel {

        private WebElement amountLink;
        private WebElement taxRateLabel;
        private WebElement currencyLabel;
        private WebElement statusLabel;
        private WebElement defaultState;
        private WebElement taxTypeLabel;

        public FeeTableRowModel(WebElement row) {
            this.amountLink = TableUtils.getAllCells(row).get(0).findElement(By.tagName("a"));
            this.taxRateLabel = TableUtils.getAllCells(row).get(1);
            this.currencyLabel = TableUtils.getAllCells(row).get(2);
            this.statusLabel = TableUtils.getAllCells(row).get(3).findElement(By.tagName("span"));
            this.defaultState = TableUtils.getAllCells(row).get(4);
            this.taxTypeLabel = TableUtils.getAllCells(row).get(5);
        }

        public WebElement getAmountLink() {
            return amountLink;
        }

        public WebElement getTaxRateLabel() {
            return taxRateLabel;
        }

        public WebElement getCurrencyLabel() {
            return currencyLabel;
        }

        public WebElement getStatusLabel() {
            return statusLabel;
        }

        public WebElement getDefaultState() {
            return defaultState;
        }

        public WebElement getTaxTypeLabel() {
            return taxTypeLabel;
        }

        //--------------------------------------
        //Business logic

        public void editFee(){
            getAmountLink().click();
        }





    }
}
