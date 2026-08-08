package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ManagePromotionController  {

    @FXML
    private TextField promotionNameField;
    @FXML private RadioButton discountRadio;
    @FXML private RadioButton couponRadio;
    @FXML private RadioButton specialOfferRadio;
    @FXML private TextField discountField;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox<String> audienceComboBox;
    @FXML private Label messageLabel;

    private static int promotionIdCounter = 1;
    @FXML
    private ToggleGroup tg;

    public void initialize() {
        audienceComboBox.getItems().addAll(
                "All Subscribers", "Premium Subscribers", "Basic Subscribers", "New Users"
        );
    }

    @FXML
    private void handleSavePromotion(ActionEvent event) {
        String name = promotionNameField.getText();
        String type = getSelectedType();
        String discountText = discountField.getText();
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();

        // VL: check required fields / verify discount percentage range / verify promotion duration
        if (name == null || name.isBlank() || discountText == null || discountText.isBlank()
                || start == null || end == null || !start.isBefore(end) || audienceComboBox.getValue() == null) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("All fields are required and start date must be before end date.");
            return;
        }

        int discount;
        try {
            discount = Integer.parseInt(discountText.trim());
        } catch (NumberFormatException e) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Discount percentage must be a number.");
            return;
        }
        if (discount <= 0 || discount > 100) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Discount percentage must be between 1 and 100.");
            return;
        }

        // DP: save promotion, generate Promotion ID, activate promotion
        int promotionId = promotionIdCounter++;
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Promotion created and activated successfully. Promotion ID: " + promotionId
                + " (" + type + ", " + discount + "% off, for " + audienceComboBox.getValue() + ")");

        promotionNameField.clear();
        discountField.clear();
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        audienceComboBox.setValue(null);
    }

    private String getSelectedType() {
        if (discountRadio.isSelected()) return "Discount";
        if (couponRadio.isSelected()) return "Coupon";
        if (specialOfferRadio.isSelected()) return "Special Offer";
        return "Discount";
    }

    @FXML
    private void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene(
                event,
                "/csc213/ottplatfrom/rajmee/MarketingDashboard.fxml",

                "Marketing Dashboard"
        );
    }
}