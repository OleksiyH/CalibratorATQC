package pages.formModels;

import enums.FeesEnums.CurrencyEnum;
import enums.FeesEnums.TaxTypeEnum;
import enums.StatusEnum;
import utils.DefaultCommonUtils;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class FeeCreateEditForm {

    private Double amount;
    private CurrencyEnum currency;
    private Boolean isDefaultCheckbox;
    private StatusEnum status;
    private TaxTypeEnum taxType;
    private Double taxRate;

    //-----------------------------------------
    //Getters and Setters

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Boolean getDefaultCheckbox() {
        return isDefaultCheckbox;
    }

    public void setDefaultCheckbox(Boolean defaultCheckbox) {
        isDefaultCheckbox = defaultCheckbox;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public TaxTypeEnum getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxTypeEnum taxType) {
        this.taxType = taxType;
    }
    //--------------------------------------

    public static FeeCreateEditForm getRandomFeeData() {
        FeeCreateEditForm form = new FeeCreateEditForm();
        form.setAmount(Double.parseDouble(DefaultCommonUtils.genNumericString(3) + "." + DefaultCommonUtils.genNumericString(2)));
        form.setCurrency(DefaultCommonUtils.randomEnum(CurrencyEnum.class));
        form.setDefaultCheckbox(DefaultCommonUtils.randomBoolean());
        form.setStatus(StatusEnum.UNRELEASED);
        form.setTaxRate(Double.parseDouble("0."+DefaultCommonUtils.genNumericString(2)));
        form.setTaxType(DefaultCommonUtils.randomEnum(TaxTypeEnum.class));
        return form;
    }
}
