package pages;

import enums.productEnums.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.formModels.ProductCreateEditForm;

/**
 * Created by oha on 25.04.2016.
 */
public class ProductCreateEditPage extends PageHeader {

    @FindBy(id = "product.name")
    private WebElement productName;

    @FindBy(id = "product.description")
    private WebElement productDescription;

    @FindBy(id = "product.type")
    private WebElement productTypeDropdown;

    @FindBy(id = "product.printType")
    private WebElement printTypeDropdown;

    @FindBy(id = "product.processor")
    private WebElement processorDropdown;

    @FindBy(id = "product.period")
    private WebElement periodTypeDropdown;

    @FindBy(id = "product.cycles")
    private WebElement cycleCountDropdown;

    @FindBy(id = "product.trigger")
    private WebElement conversionProductDropdown;

    @FindBy(id = "product.pscTrigger")
    private WebElement printVerificationConversionProductDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Fee')]")
    private WebElement feesButton;

    @FindBy(id = "trial")
    private WebElement trialDisplayTypeDropdown;

    @FindBy(id = "trialPrice")
    private WebElement freeTrialAmountDisplayDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(partialLinkText = "Back to Products")
    private WebElement backToProductsPageButton;

    //-----------------------------------------
    //Getters and Setters


    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getProductTypeDropdown() {
        return productTypeDropdown;
    }

    public WebElement getPrintTypeDropdown() {
        return printTypeDropdown;
    }

    public WebElement getProcessorDropdown() {
        return processorDropdown;
    }

    public WebElement getPeriodTypeDropdown() {
        return periodTypeDropdown;
    }

    public WebElement getCycleCountDropdown() {
        return cycleCountDropdown;
    }

    public WebElement getConversionProductDropdown() {
        return conversionProductDropdown;
    }

    public WebElement getPrintVerificationConversionProductDropdown() {
        return printVerificationConversionProductDropdown;
    }

    public WebElement getFeesButton() {
        return feesButton;
    }

    public WebElement getTrialDisplayTypeDropdown() {
        return trialDisplayTypeDropdown;
    }

    public WebElement getFreeTrialAmountDisplayDropdown() {
        return freeTrialAmountDisplayDropdown;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getBackToProductsPageButton() {
        return backToProductsPageButton;
    }

    //-----------------------------------------
    //Business logic

    public void setProductName(String productName) {
        getProductName().clear();
        getProductName().sendKeys(productName);
    }

    public void setProductDescription(String productDescription) {
        getProductDescription().clear();
        getProductDescription().sendKeys(productDescription);
    }

    public void setProductTypeDropdown(ProductTypeEnum productType) {
        Select select = new Select(getProductTypeDropdown());
        select.selectByValue(productType.getValue());

    }

    public void setPrintTypeDropdown(PrintTypeEnum printType) {
        Select select = new Select(getPrintTypeDropdown());
        select.selectByValue(printType.getValue());
    }

    public void setProcessorDropdown(ProcessorEnum processor) {
        Select select = new Select(getProcessorDropdown());
        select.selectByValue(processor.getValue());
    }

    public void setPeriodTypeDropdown(PeriodTypeEnum periodType) {
        Select select = new Select(getPeriodTypeDropdown());
        select.selectByValue(periodType.getValue());
    }

    public void setCycleCountDropdown(CycleCountEnum cycleCount) {
        Select select = new Select(getCycleCountDropdown());
        select.selectByValue(cycleCount.getValue());
    }

//TODO Find out about those two dropdowns and where the values are received from
//    public void setConversionProductDropdown() {
//    }
//    public void setPrintVerificationConversionProductDropdown() {
//    }

    public void clickFeesButton() {
        getFeesButton().click();
    }

    public void setTrialDisplayTypeDropdown(TrialDisplayTypeEnum trialDisplayType) {
        Select select = new Select(getTrialDisplayTypeDropdown());
        select.selectByValue(trialDisplayType.getValue());
    }

    public void setFreeTrialAmountDisplayDropdown(FreeTrialAmountDisplayEnum freeTrialAmountDisplay) {
        Select select = new Select(getFreeTrialAmountDisplayDropdown());
        select.selectByValue(freeTrialAmountDisplay.getValue());
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }

    public void goBackToProductPage() {
        getBackToProductsPageButton().click();
    }
    //-----------------------------------

    public void fillForm(ProductCreateEditForm form) {
        setProductName(form.getProductName());
        setProductDescription(form.getProductDescription());
        setProductTypeDropdown(form.getProductType());
        setPrintTypeDropdown(form.getPrintType());
        setProcessorDropdown(form.getProcessor());
        setPeriodTypeDropdown(form.getPeriodType());
        setCycleCountDropdown(form.getCycleCount());
//TODO Those fields where deleted
//        setTrialDisplayTypeDropdown(form.getTrialDisplayType());
  //      setFreeTrialAmountDisplayDropdown(form.getFreeTrialAmountDisplay());
    }

    public ProductCreateEditForm readForm() {
        ProductCreateEditForm form = new ProductCreateEditForm();
        form.setProductName(this.getProductName().getAttribute("value"));
        form.setProductDescription(this.getProductDescription().getAttribute("value"));
        form.setProductType(ProductTypeEnum.get((new Select(this.getProductTypeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setPrintType(PrintTypeEnum.get((new Select(this.getPrintTypeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setProcessor(ProcessorEnum.get((new Select(this.getProcessorDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setPeriodType(PeriodTypeEnum.get((new Select(this.getPeriodTypeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        form.setCycleCount(CycleCountEnum.get((new Select(this.getCycleCountDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        //TODO Those fields where deleted
        //  form.setTrialDisplayType(TrialDisplayTypeEnum.get((new Select(this.getTrialDisplayTypeDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
     //   form.setFreeTrialAmountDisplay(FreeTrialAmountDisplayEnum.get((new Select(this.getFreeTrialAmountDisplayDropdown())).getFirstSelectedOption().getAttribute("value").trim()));
        return form;
    }


}
