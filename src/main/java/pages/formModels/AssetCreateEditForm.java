package pages.formModels;

import enums.OverlayColorEnum;
import utils.DefaultCommonUtils;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class AssetCreateEditForm {

    private String assetName;
    private OverlayColorEnum color;
    private Boolean useDefaultSummaryHeader;
    private String summaryHeaderText;
    private Boolean useDefaultTermsAndConditions;
    private String termsAndConditionsText;
    private Boolean useDefaultSummaryPSCHeader;
    private String summaryPSCHeaderText;

    //-----------------------------------------
    //Getters and Setters
    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public OverlayColorEnum getColor() {
        return color;
    }

    public void setColor(OverlayColorEnum color) {
        this.color = color;
    }

    public Boolean getUseDefaultSummaryHeader() {
        return useDefaultSummaryHeader;
    }

    public void setUseDefaultSummaryHeader(Boolean useDefaultSummaryHeader) {
        this.useDefaultSummaryHeader = useDefaultSummaryHeader;
    }

    public String getSummaryHeaderText() {
        return summaryHeaderText;
    }

    public void setSummaryHeaderText(String summaryHeaderText) {
        this.summaryHeaderText = summaryHeaderText;
    }

    public Boolean getUseDefaultTermsAndConditions() {
        return useDefaultTermsAndConditions;
    }

    public void setUseDefaultTermsAndConditions(Boolean useDefaultTermsAndConditions) {
        this.useDefaultTermsAndConditions = useDefaultTermsAndConditions;
    }

    public String getTermsAndConditionsText() {
        return termsAndConditionsText;
    }

    public void setTermsAndConditionsText(String termsAndConditionsText) {
        this.termsAndConditionsText = termsAndConditionsText;
    }

    public Boolean getUseDefaultSummaryPSCHeader() {
        return useDefaultSummaryPSCHeader;
    }

    public void setUseDefaultSummaryPSCHeader(Boolean useDefaultSummaryPSCHeader) {
        this.useDefaultSummaryPSCHeader = useDefaultSummaryPSCHeader;
    }

    public String getSummaryPSCHeaderText() {
        return summaryPSCHeaderText;
    }

    public void setSummaryPSCHeaderText(String summaryPSCHeaderText) {
        this.summaryPSCHeaderText = summaryPSCHeaderText;
    }

    //--------------------------------------

    public static AssetCreateEditForm getRandomAssetData() {
        AssetCreateEditForm form = new AssetCreateEditForm();
        form.setAssetName("Asset " + DefaultCommonUtils.generateAlphaNumericString(5));
        form.setColor(DefaultCommonUtils.randomEnum(OverlayColorEnum.class));
        form.setUseDefaultSummaryHeader(DefaultCommonUtils.randomBoolean());
        form.setUseDefaultTermsAndConditions(DefaultCommonUtils.randomBoolean());
        form.setUseDefaultSummaryPSCHeader(DefaultCommonUtils.randomBoolean());
        form.setSummaryHeaderText("Some random text " + DefaultCommonUtils.generateAlphabeticalString(20));
        form.setTermsAndConditionsText("Some random text " + DefaultCommonUtils.generateAlphabeticalString(20));
        form.setSummaryPSCHeaderText("Some random text " + DefaultCommonUtils.generateAlphabeticalString(20));
        return form;
    }
}
