package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreateCampaignController
{
    @javafx.fxml.FXML
    private TableColumn  endColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField campaignNameField;
    @javafx.fxml.FXML
    private RadioButton activeRadioButton;
    @javafx.fxml.FXML
    private TableColumn typeColumn;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableView<String> campaignTable;
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private TableColumn startColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private ComboBox campaignTypeComboBox;
    @javafx.fxml.FXML
    private RadioButton inactiveRadioButton;
    @javafx.fxml.FXML
    private TableColumn idColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSaveCampaign(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleClear(ActionEvent actionEvent) {
    }
}