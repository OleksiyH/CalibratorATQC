package pages.formModels;

/**
 * Created by Oleksiy on 29.04.2016.
 */
public class CampaignProductModel {

    private String productName;
    private String internalProductName;
    private Integer position;
    private Boolean isDefault;

    public CampaignProductModel(String productName, String internalProductName, Integer position, Boolean isDefault) {
        this.productName = productName;
        this.internalProductName = internalProductName;
        this.position = position;
        this.isDefault = isDefault;
    }

    public String getInternalProductName() {
        return internalProductName;
    }

    public void setInternalProductName(String internalProductName) {
        this.internalProductName = internalProductName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
