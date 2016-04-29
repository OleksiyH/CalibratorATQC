package pages.formModels;

import enums.StatusEnum;
import utils.DefaultCommonUtils;

/**
 * Created by oha on 26.04.2016.
 */
public class CampaignCreateEditForm {

    private String campaignName;
    private String lightBoxLogoUrl;
    private String originSiteUrl;
    private String customCss;
    private StatusEnum status;

    //--------------------------------
    //Getters and Setters
    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getLightBoxLogoUrl() {
        return lightBoxLogoUrl;
    }

    public void setLightBoxLogoUrl(String lightBoxLogoUrl) {
        this.lightBoxLogoUrl = lightBoxLogoUrl;
    }

    public String getOriginSiteUrl() {
        return originSiteUrl;
    }

    public void setOriginSiteUrl(String originSiteUrl) {
        this.originSiteUrl = originSiteUrl;
    }

    public String getCustomCss() {
        return customCss;
    }

    public void setCustomCss(String customCss) {
        this.customCss = customCss;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    //---------------------------------

    public static CampaignCreateEditForm getRandomCampaignData(){
        CampaignCreateEditForm form = new CampaignCreateEditForm();
        form.setCampaignName(DefaultCommonUtils.generateAlphabeticalString(5));
        form.setLightBoxLogoUrl(DefaultCommonUtils.genUrlLikeString());
        form.setOriginSiteUrl(DefaultCommonUtils.genUrlLikeString());
        form.setCustomCss(DefaultCommonUtils.generateAlphabeticalString(50));
        form.setStatus(StatusEnum.UNRELEASED);
        return form;
    }
}
