package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class TableUtils {


    // get all rows from the table
    public static List<WebElement> getAllRows(WebElement table) {
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        List<WebElement> withoutHeaderRow = allRows.subList(1, allRows.size());
        return withoutHeaderRow;
    }

    // get row by Number
    public static WebElement getRowByNumber(WebElement table, Integer row) {
        return table.findElements(By.tagName("tr")).get(row - 1);
    }

    // get all cells from row
    public static List<WebElement> getAllCells(WebElement row) {
        return row.findElements(By.tagName("td"));
    }

    // get cel by row and column numbers
    public static WebElement getCellsByRowAndColumn(WebElement table, Integer row, Integer column) {
        return getAllCells(getRowByNumber(table, row)).get(column - 1);
    }

    // get table size
    public static Integer getTableSize(WebElement table) {
        return getAllRows(table).size();
    }

}

