package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class AddContentController
{
    @javafx.fxml.FXML
    private ComboBox <String>genreComboBox;
    @javafx.fxml.FXML
    private ComboBox <Integer>typeComboBox;
    @javafx.fxml.FXML
    private DatePicker releaseDatePicker;
    @javafx.fxml.FXML
    private TextField titleField;
    @javafx.fxml.FXML
    private TextArea descriptionField;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSaveContent(ActionEvent actionEvent) {
    }
}