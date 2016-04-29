package pages.formModels;

import enums.StatusEnum;
import enums.accessBoundaryEnums.SiteModeEnum;
import utils.DefaultCommonUtils;

/**
 * Created by oha on 28.04.2016.
 */
public class AccessBoundaryCreateEditForm {

    private SiteModeEnum siteMode;
    private String accessBoundaryName;
    private String campaignName;
    private String currentCampaignName;
    private StatusEnum status;
    private String clientPageScript;
    private String accessMeterRule;
    private String iTunesAppKey;

    public SiteModeEnum getSiteMode() {
        return siteMode;
    }

    public void setSiteMode(SiteModeEnum siteMode) {
        this.siteMode = siteMode;
    }

    public String getAccessBoundaryName() {
        return accessBoundaryName;
    }

    public void setAccessBoundaryName(String accessBoundaryName) {
        this.accessBoundaryName = accessBoundaryName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCurrentCampaignName() {
        return currentCampaignName;
    }

    public void setCurrentCampaignName(String currentCampaignName) {
        this.currentCampaignName = currentCampaignName;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getClientPageScript() {
        return clientPageScript;
    }

    public void setClientPageScript(String clientPageScript) {
        this.clientPageScript = clientPageScript;
    }

    public String getAccessMeterRule() {
        return accessMeterRule;
    }

    public void setAccessMeterRule(String accessMeterRule) {
        this.accessMeterRule = accessMeterRule;
    }

    public String getiTunesAppKey() {
        return iTunesAppKey;
    }

    public void setiTunesAppKey(String iTunesAppKey) {
        this.iTunesAppKey = iTunesAppKey;
    }
    //----------------------------------------

    public static AccessBoundaryCreateEditForm getRandomAccessBoundaryForCreationData(String campaignName){
        AccessBoundaryCreateEditForm form = new AccessBoundaryCreateEditForm();
        form.setSiteMode(DefaultCommonUtils.randomEnum(SiteModeEnum.class));
        form.setAccessBoundaryName("New access boundary "+DefaultCommonUtils.generateAlphabeticalString(5));
        form.setCampaignName(campaignName);
        form.setStatus(StatusEnum.UNRELEASED);
        form.setClientPageScript("ClientPageScript "+DefaultCommonUtils.generateAlphabeticalString(5));
        form.setiTunesAppKey("iTunesAppKey "+DefaultCommonUtils.generateAlphabeticalString(5));
        return form;
    }



}
