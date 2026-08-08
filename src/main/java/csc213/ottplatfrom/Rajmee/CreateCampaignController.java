package csc213.ottplatfrom.Rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateCampaignController {

    @FXML
    private TextField campaignNameField;

    @FXML
    private ComboBox<String> campaignTypeComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private RadioButton activeRadioButton;

    @FXML
    private RadioButton inactiveRadioButton;

    @FXML
    private Label messageLabel;

    @FXML
    private TableView<Campaign> campaignTable;

    @FXML
    private TableColumn<Campaign, Integer> idColumn;

    @FXML
    private TableColumn<Campaign, String> nameColumn;

    @FXML
    private TableColumn<Campaign, String> typeColumn;

    @FXML
    private TableColumn<Campaign, String> startColumn;

    @FXML
    private TableColumn<Campaign, String> endColumn;

    @FXML
    private TableColumn<Campaign, String> statusColumn;
    @FXML
    private ToggleGroup tg;

    @FXML
    public void initialize() {

        campaignTypeComboBox.getItems().addAll(
                "Email",
                "Social Media",
                "TV",
                "SMS",
                "Website"
        );

        idColumn.setCellValueFactory(new PropertyValueFactory<>("campaignId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        campaignTable.setItems(DataStore.campaigns);
    }

    @FXML
    public void handleSaveCampaign(ActionEvent actionEvent) {

        if (campaignNameField.getText().isBlank()
                || campaignTypeComboBox.getValue() == null
                || startDatePicker.getValue() == null
                || endDatePicker.getValue() == null
                || (!activeRadioButton.isSelected() && !inactiveRadioButton.isSelected())) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please fill all fields.");
            return;
        }

        String status = activeRadioButton.isSelected() ? "Active" : "Inactive";

        Campaign campaign = new Campaign(
                DataStore.nextCampaignId(),
                campaignNameField.getText(),
                campaignTypeComboBox.getValue(),
                startDatePicker.getValue().toString(),
                endDatePicker.getValue().toString(),
                status
        );

        DataStore.campaigns.add(campaign);

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Campaign saved successfully.");

        handleClear(null);
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {

        campaignNameField.clear();
        campaignTypeComboBox.setValue(null);
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        activeRadioButton.setSelected(false);
        inactiveRadioButton.setSelected(false);
        messageLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/rajmee/MarketingDashboard.fxml",
                "Marketing Dashboard"
        );
    }
}