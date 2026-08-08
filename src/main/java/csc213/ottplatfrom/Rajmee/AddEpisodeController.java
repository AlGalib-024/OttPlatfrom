package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.stream.Collectors;

public class AddEpisodeController {

    @FXML
    private ComboBox<String> seriesComboBox;

    @FXML
    private TextField episodeTitleField;

    @FXML
    private TextField episodeNumberField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Label fileNameLabel;

    @FXML
    private Label messageLabel;

    private File chosenFile;

    @FXML
    public void initialize() {

        seriesComboBox.setItems(FXCollections.observableArrayList(

                DataStore.contentList.stream()
                        .filter(c -> c instanceof Series)
                        .map(Content::getTitle)
                        .collect(Collectors.toList())
        ));
    }

    @FXML
    public void handleChooseFile(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Episode Video");

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Video Files",
                        "*.mp4",
                        "*.mkv",
                        "*.mov"
                )
        );

        chosenFile = chooser.showOpenDialog(fileNameLabel.getScene().getWindow());

        if (chosenFile != null) {
            fileNameLabel.setText(chosenFile.getName());
        }
    }

    @FXML
    public void handleSaveEpisode(ActionEvent actionEvent) {

        if (seriesComboBox.getValue() == null
                || episodeTitleField.getText().isBlank()
                || episodeNumberField.getText().isBlank()) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Fill in all required fields.");
            return;
        }

        int episodeNumber;

        try {
            episodeNumber = Integer.parseInt(episodeNumberField.getText());
        } catch (NumberFormatException e) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Episode number must be numeric.");
            return;
        }

        Series selectedSeries = null;

        for (Content c : DataStore.contentList) {
            if (c instanceof Series &&
                    c.getTitle().equals(seriesComboBox.getValue())) {

                selectedSeries = (Series) c;
                break;
            }
        }

        if (selectedSeries == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Series not found.");
            return;
        }

        String fileName = "";

        if (chosenFile != null) {
            fileName = chosenFile.getName();
        }

        Episode episode = new Episode(
                DataStore.nextEpisodeId(),
                episodeTitleField.getText(),
                episodeNumber,
                fileName
        );

        selectedSeries.addEpisode(episode);

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Episode added successfully.");

        episodeTitleField.clear();
        episodeNumberField.clear();
        descriptionField.clear();
        seriesComboBox.setValue(null);
        fileNameLabel.setText("No file selected");
        chosenFile = null;
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml",
                "Content Manager Dashboard"
        );
    }
}