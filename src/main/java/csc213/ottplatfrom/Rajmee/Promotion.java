package csc213.ottplatfrom.Rajmee;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** MarketingManager *-- Promotion (Composition in the UML diagram). */
public class Promotion {

    private final IntegerProperty promotionId;
    private final StringProperty promotionName;
    private final StringProperty promotionType; // Discount / Coupon / Special Offer
    private final IntegerProperty discountPercentage;
    private final StringProperty startDate;
    private final StringProperty endDate;
    private final StringProperty targetAudience;
    private final StringProperty status;

    public Promotion(int promotionId, String promotionName, String promotionType, int discountPercentage,
                     String startDate, String endDate, String targetAudience, String status) {
        this.promotionId = new SimpleIntegerProperty(promotionId);
        this.promotionName = new SimpleStringProperty(promotionName);
        this.promotionType = new SimpleStringProperty(promotionType);
        this.discountPercentage = new SimpleIntegerProperty(discountPercentage);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.targetAudience = new SimpleStringProperty(targetAudience);
        this.status = new SimpleStringProperty(status);
    }

    public int getPromotionId() { return promotionId.get(); }
    public String getPromotionName() { return promotionName.get(); }
    public String getPromotionType() { return promotionType.get(); }
    public int getDiscountPercentage() { return discountPercentage.get(); }
    public String getStartDate() { return startDate.get(); }
    public String getEndDate() { return endDate.get(); }
    public String getTargetAudience() { return targetAudience.get(); }
    public String getStatus() { return status.get(); }

    public IntegerProperty promotionIdProperty() { return promotionId; }
    public StringProperty promotionNameProperty() { return promotionName; }
    public StringProperty promotionTypeProperty() { return promotionType; }
    public IntegerProperty discountPercentageProperty() { return discountPercentage; }
    public StringProperty statusProperty() { return status; }
}
