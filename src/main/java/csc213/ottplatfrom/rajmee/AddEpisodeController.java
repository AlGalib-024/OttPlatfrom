package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEpisodeController
{
    @javafx.fxml.FXML
    private TextField episodeTitleField;
    @javafx.fxml.FXML
    private Label fileNameLabel;
    @javafx.fxml.FXML
    private TextField episodeNumberField;
    @javafx.fxml.FXML
    private ComboBox seriesComboBox;
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
    public void handleSaveEpisode(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleChooseFile(ActionEvent actionEvent) {
    }
}