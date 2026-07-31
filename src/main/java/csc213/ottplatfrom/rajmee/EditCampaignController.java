package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditCampaignController implements Initializable {

    @FXML
    private TableView<Campaign> campaignTable;
    @FXML private TableColumn<Campaign, Integer> idColumn;
    @FXML private TableColumn<Campaign, String> nameColumn;
    @FXML private TableColumn<Campaign, String> statusColumn;

    @FXML private TextField campaignNameField;
    @FXML private TextArea descriptionField;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private Label messageLabel;

    private Campaign selectedCampaign;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("campaignId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        campaignTable.setItems(DataStore.campaigns);

        campaignTable.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                selectedCampaign = newV;
                campaignNameField.setText(newV.getCampaignName());
                descriptionField.setText(newV.getDescription());
                startDatePicker.setValue(safeParse(newV.getStartDate()));
                endDatePicker.setValue(safeParse(newV.getEndDate()));
                messageLabel.setText("");
            }
        });
    }

    private LocalDate safeParse(String date) {
        try { return LocalDate.parse(date); } catch (Exception e) { return null; }
    }

    @FXML
    private void handleUpdateCampaign(ActionEvent event) {
        if (selectedCampaign == null) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Please select a campaign from the table first.");
            return;
        }

        String name = campaignNameField.getText();
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();

        if (name == null || name.isBlank() || start == null || end == null || !start.isBefore(end)) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Campaign name is required and start date must be before end date.");
            return;
        }

        selectedCampaign.setCampaignName(name);
        selectedCampaign.setDescription(descriptionField.getText());
        selectedCampaign.setStartDate(start.toString());
        selectedCampaign.setEndDate(end.toString());
        campaignTable.refresh();

        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Campaign updated successfully.");
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
