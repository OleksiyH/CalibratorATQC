package steps;

import enums.ShowItemsEnum;
import enums.StatusEnum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import pages.FeeCreateEditPage;
import pages.FeesPage;
import pages.ProductForAssetPage;
import pages.formModels.FeeCreateEditForm;
import pages.tableModels.FeeTableModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static pages.FeeCreateEditPage.CURRENCY_ALREADY_EXISTS;


/**
 * Created by Oleksiy on 23.04.2016.
 */
public class FeesSteps extends ScenarioSteps {

    private ProductForAssetPage productForAssetPage() {
        return getPages().currentPageAt(ProductForAssetPage.class);
    }

    private FeesPage feesPage() {
        return getPages().currentPageAt(FeesPage.class);
    }

    private FeeCreateEditPage feeCreateEditPage() {
        return getPages().currentPageAt(FeeCreateEditPage.class);
    }

    @Step("Go to Create Fee page")
    public void goToCreateNewFeePage() {
        feesPage().createNewFeeButtonClick();
    }

    @Step("Fill Fee form data")
    public void fillFeeForm(FeeCreateEditForm form) {
        feeCreateEditPage().fillForm(form);
    }

    @Step("Submit Fee form")
    public void submitFeeForm() {
        feeCreateEditPage().clickSubmitButton();
    }

    @Step("Cancel Fee form")
    public void cancelFeeForm() {
        feeCreateEditPage().clickCancelButton();
    }

    @Step("Go back to fee page")
    public void goBackToFeePage() {
        feeCreateEditPage().goBackToFeesPage();
    }

    @Step("Select number of assets to show")
    public void selectNumberOfElementToShow(ShowItemsEnum items) throws InterruptedException {
        feesPage().selectNumberOfElementToShow(items);
    }

    @Step("Search for Fee by Currency, Rate or Type")
    public void searchForFee(String query) {
        feesPage().searchByTaxRateCurrencyOrType(query);
    }

    @Step("Edit Fee Configuration")
    public void editFeeConfiguration(FeeCreateEditForm form) {
        feesPage().searchByTaxRateCurrencyOrType(form.getTaxRate().toString().substring(2));
        FeeTableModel feeTable = new FeeTableModel(feesPage().getFeesTable());
        feeTable.getFeeByRate(form.getTaxRate()).editFee();
    }

    @Step("Delete Fee")
    public void deleteFee(FeeCreateEditForm form) {
        feesPage().searchByTaxRateCurrencyOrType(form.getTaxRate().toString().substring(2));
        FeeTableModel feeTable = new FeeTableModel(feesPage().getFeesTable());
        feeTable.getFeeByRate(form.getTaxRate()).editFee();
        feeCreateEditPage().setStatusDropdown(StatusEnum.DELETED);
        feeCreateEditPage().clickSubmitButton();
    }

    @Step("Verify that Fee Was Created and all data was captured")
    public void verifyFeeCreation(FeeCreateEditForm form) {
        feesPage().searchByTaxRateCurrencyOrType(form.getTaxRate().toString().substring(2));
        FeeTableModel feeTable = new FeeTableModel(feesPage().getFeesTable());
        feeTable.getFeeByRate(form.getTaxRate()).editFee();
        FeeCreateEditForm capturedForm = feeCreateEditPage().readForm();

        assertThat("Fee amount is different from expected." +
                        " Actual: " + capturedForm.getAmount() +
                        " Expected: " + form.getAmount(),
                capturedForm.getAmount().equals(form.getAmount()));

        assertThat("Fee currency is different from expected." +
                        " Actual: " + capturedForm.getCurrency() +
                        " Expected: " + form.getCurrency(),
                capturedForm.getCurrency().equals(form.getCurrency()));

        assertThat("Fee Tax Type is different from expected." +
                        " Actual: " + capturedForm.getTaxType() +
                        " Expected: " + form.getTaxType(),
                capturedForm.getTaxType().equals(form.getTaxType()));

        assertThat("Fee Tax Rate is different from expected." +
                        " Actual: " + capturedForm.getTaxRate() +
                        " Expected: " + form.getTaxRate(),
                capturedForm.getTaxRate().equals(form.getTaxRate()));

        assertThat("Fee is default Checkbox state is different from expected." +
                        " Actual: " + capturedForm.getDefaultCheckbox() +
                        " Expected: " + form.getDefaultCheckbox(),
                capturedForm.getDefaultCheckbox().equals(form.getDefaultCheckbox()));

        assertThat("Fee Status is different from expected." +
                        " Actual: " + capturedForm.getStatus() +
                        " Expected: " + form.getStatus(),
                capturedForm.getStatus().equals(form.getStatus()));

    }


    @Step("Verify Fee is not present in the table")
    public void verifyFeeNotPresent(FeeCreateEditForm form) {
        feesPage().searchByTaxRateCurrencyOrType(form.getTaxRate().toString().substring(2));
        assertThat("Fee is present in the table", !getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Verify Fee is present in the table")
    public void verifyFeePresent(FeeCreateEditForm form) {
        feesPage().searchByTaxRateCurrencyOrType(form.getTaxRate().toString().substring(2));
        assertThat("Fee is not present in the table", getDriver().findElements(By.className("dataTables_empty")).isEmpty());
    }

    @Step("Verify error message 'This currency already exists for this product' appears")
    public void verifyCurrencyErrorMessage() {
        assertThat("Message" + CURRENCY_ALREADY_EXISTS + " is not displayed", feeCreateEditPage().containsText(CURRENCY_ALREADY_EXISTS));
    }


}
