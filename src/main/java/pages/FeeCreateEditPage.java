package pages;

import enums.FeesEnums.CurrencyEnum;
import enums.FeesEnums.TaxTypeEnum;
import enums.StatusEnum;
import enums.productEnums.ProductTypeEnum;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.formModels.FeeCreateEditForm;

/**
 * Created by Oleksiy on 25.04.2016.
 */
public class FeeCreateEditPage extends PageHeader {

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "currency")
    private WebElement currencyDropdown;

    @FindBy(id = "uniform-defaultFee1")
    private WebElement isDefaultCheckbox;

    @FindBy(id = "status")
    private WebElement statusDropdown;

    @FindBy(id = "productTaxTypeId")
    private WebElement taxTypeDropdown;

    @FindBy(id = "taxRate")
    private WebElement taxRate;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[contains(text(), 'Back to Fees')]")
    private WebElement backToFeespageButton;
    //----------Error Messages
    @FindBy(id = "amount.errors")
    private WebElement currencyAlreadyExistsMessage;
    public static final String CURRENCY_ALREADY_EXISTS = "This currency already exists for this product";


    //--------------------------------
    //Getters and Setters

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getCurrencyDropdown() {
        return currencyDropdown;
    }

    public WebElement getIsDefaultCheckbox() {
        return isDefaultCheckbox;
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    public WebElement getTaxTypeDropdown() {
        return taxTypeDropdown;
    }

    public WebElement getTaxRate() {
        return taxRate;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getBackToFeespageButton() {
        return backToFeespageButton;
    }

    public WebElement getCurrencyAlreadyExistsMessage() {
        return currencyAlreadyExistsMessage;
    }

    //--------------------------------
    //Business Logic
    public void setAmount(Double amount) {
        getAmount().clear();
        getAmount().sendKeys(amount.toString());
    }

    public void setCurrencyDropdown(CurrencyEnum currency) {
        (new Select(getCurrencyDropdown())).selectByValue(currency.getValue());
    }

    public void setIsDefaultCheckbox(Boolean condition) {
        if (!getIsDefaultCheckbox().findElements(By.className("checked")).isEmpty() != condition) {
            getIsDefaultCheckbox().click();
        }
    }

    public void setStatusDropdown(StatusEnum status) {
        (new Select(getStatusDropdown())).selectByValue(status.getValue());
    }

    public void setTaxTypeDropdown(TaxTypeEnum taxType) {
        (new Select(getTaxTypeDropdown())).selectByValue(taxType.getValue());
    }

    public void setTaxRate(Double taxRate) {
        getTaxRate().clear();
        getTaxRate().sendKeys(taxRate.toString());
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    public void goBackToFeesPage() {
        getBackToFeespageButton().click();
    }

    public void fillForm(FeeCreateEditForm form) {
        setAmount(form.getAmount());
        setCurrencyDropdown(form.getCurrency());
        setIsDefaultCheckbox(form.getDefaultCheckbox());
        setStatusDropdown(form.getStatus());
        setTaxTypeDropdown(form.getTaxType());
        setTaxRate(form.getTaxRate());
    }

    public FeeCreateEditForm readForm() {
        FeeCreateEditForm form = new FeeCreateEditForm();
        form.setAmount(Double.parseDouble(this.getAmount().getAttribute("value")));
        form.setCurrency(CurrencyEnum.get((new Select(this.getCurrencyDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setDefaultCheckbox(!this.getIsDefaultCheckbox().findElements(By.className("checked")).isEmpty());
        form.setStatus(StatusEnum.get((new Select(this.getStatusDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setTaxType(TaxTypeEnum.get((new Select(this.getTaxTypeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setTaxRate(Double.parseDouble(this.getTaxRate().getAttribute("value")));
        return form;
    }

    public String getCurrencyErrorText(){
        return getCurrencyAlreadyExistsMessage().getText();
    }


}
