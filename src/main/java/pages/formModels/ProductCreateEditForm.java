package pages.formModels;

import enums.productEnums.*;
import utils.DefaultCommonUtils;

/**
 * Created by oha on 25.04.2016.
 */
public class ProductCreateEditForm {

    private String productName;
    private String productDescription;
    private ProductTypeEnum productType;
    private PrintTypeEnum printType;
    private ProcessorEnum processor;
    private PeriodTypeEnum periodType;
    private CycleCountEnum cycleCount;
    private TrialDisplayTypeEnum trialDisplayType;
    private FreeTrialAmountDisplayEnum freeTrialAmountDisplay;

    //-----------------------------------------
    //Getters and Setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductTypeEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEnum productType) {
        this.productType = productType;
    }

    public PrintTypeEnum getPrintType() {
        return printType;
    }

    public void setPrintType(PrintTypeEnum printType) {
        this.printType = printType;
    }

    public ProcessorEnum getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorEnum processor) {
        this.processor = processor;
    }

    public PeriodTypeEnum getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodTypeEnum periodType) {
        this.periodType = periodType;
    }

    public CycleCountEnum getCycleCount() {
        return cycleCount;
    }

    public void setCycleCount(CycleCountEnum cycleCount) {
        this.cycleCount = cycleCount;
    }

    public TrialDisplayTypeEnum getTrialDisplayType() {
        return trialDisplayType;
    }

    public void setTrialDisplayType(TrialDisplayTypeEnum trialDisplayType) {
        this.trialDisplayType = trialDisplayType;
    }

    public FreeTrialAmountDisplayEnum getFreeTrialAmountDisplay() {
        return freeTrialAmountDisplay;
    }

    public void setFreeTrialAmountDisplay(FreeTrialAmountDisplayEnum freeTrialAmountDisplay) {
        this.freeTrialAmountDisplay = freeTrialAmountDisplay;
    }

    //-----------------------------------------

    public static ProductCreateEditForm getRandomProductData(){
        ProductCreateEditForm form = new ProductCreateEditForm();
        form.setProductName("New Test product " + DefaultCommonUtils.generateAlphabeticalString(7));
        form.setProductDescription("Test product description" + DefaultCommonUtils.generateAlphabeticalString(7));
        form.setProductType(DefaultCommonUtils.randomEnum(ProductTypeEnum.class));
        form.setPrintType(PrintTypeEnum.DIGITAL);
        form.setProductType(ProductTypeEnum.AUTO_RENEW);

//        if(form.getProductType().equals(ProductTypeEnum.TRIAL)){
//            form.setPrintType(PrintTypeEnum.TRIAL_PRINT_TYPE);
//        }
//        form.setPrintType(DefaultCommonUtils.randomEnum(PrintTypeEnum.class));
//        if(form.getPrintType().equals(PrintTypeEnum.TRIAL_PRINT_TYPE)){
//            form.setProductType(ProductTypeEnum.TRIAL);
//        }
        form.setProcessor(DefaultCommonUtils.randomEnum(ProcessorEnum.class));
        form.setPeriodType(DefaultCommonUtils.randomEnum(PeriodTypeEnum.class));
        form.setCycleCount(DefaultCommonUtils.randomEnum(CycleCountEnum.class));
        form.setTrialDisplayType(DefaultCommonUtils.randomEnum(TrialDisplayTypeEnum.class));
        form.setFreeTrialAmountDisplay(DefaultCommonUtils.randomEnum(FreeTrialAmountDisplayEnum.class));
        return form;
    }

}
