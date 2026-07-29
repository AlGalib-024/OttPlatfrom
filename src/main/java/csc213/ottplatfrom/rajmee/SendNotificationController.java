package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendNotificationController
{
    @javafx.fxml.FXML
    private TextArea messageField;
    @javafx.fxml.FXML
    private ComboBox typeComboBox;
    @javafx.fxml.FXML
    private TextField titleField;
    @javafx.fxml.FXML
    private ComboBox audienceComboBox;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSend(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePreview(ActionEvent actionEvent) {
    }
}