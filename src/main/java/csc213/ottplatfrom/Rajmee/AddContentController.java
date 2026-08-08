package csc213.ottplatfrom.Rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddContentController {

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private DatePicker releaseDatePicker;

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {

        typeComboBox.getItems().addAll(
                "Movie",
                "Series"
        );

        genreComboBox.getItems().addAll(
                "Action",
                "Drama",
                "Comedy",
                "Sci-Fi",
                "Horror",
                "Documentary",
                "Romance",
                "Thriller"
        );
    }

    @FXML
    public void handleSaveContent(ActionEvent actionEvent) {

        String title = titleField.getText();
        String type = typeComboBox.getValue();
        String genre = genreComboBox.getValue();

        if (title == null || title.isBlank()
                || type == null
                || genre == null
                || releaseDatePicker.getValue() == null) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please fill up all fields.");
            return;
        }

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Content saved successfully!");

        titleField.clear();
        descriptionField.clear();
        typeComboBox.setValue(null);
        genreComboBox.setValue(null);
        releaseDatePicker.setValue(null);
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml",
                "Content Manager Dashboard"
        );
}}