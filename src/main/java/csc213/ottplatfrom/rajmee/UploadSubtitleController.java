package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;

public class UploadSubtitleController {

    @FXML
    private TableView<Content> contentTable;

    @FXML
    private TableColumn<Content, Integer> idColumn;

    @FXML
    private TableColumn<Content, String> titleColumn;

    @FXML
    private TableColumn<Content, String> typeColumn;

    @FXML
    private RadioButton srtRadio;

    @FXML
    private RadioButton vttRadio;

    @FXML
    private Label fileNameLabel;

    @FXML
    private Label messageLabel;

    private File chosenFile;
    @FXML
    private ToggleGroup tg;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        contentTable.setItems(DataStore.contentList);
    }

    @FXML
    public void handleChooseFile(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Subtitle File");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Subtitle Files", "*.srt", "*.vtt")
        );

        chosenFile = chooser.showOpenDialog(fileNameLabel.getScene().getWindow());

        if (chosenFile != null) {
            fileNameLabel.setText(chosenFile.getName());
        }
    }

    @FXML
    public void handleUpload(ActionEvent actionEvent) {

        Content selected = contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select content first.");
            return;
        }

        if (chosenFile == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please choose a subtitle file first.");
            return;
        }

        String format;

        if (srtRadio.isSelected()) {
            format = "SRT";
        } else if (vttRadio.isSelected()) {
            format = "VTT";
        } else {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select subtitle format.");
            return;
        }

        Subtitle subtitle = new Subtitle(
                DataStore.nextSubtitleId(),
                "English",
                format,
                chosenFile.getName()
        );

        selected.addSubtitle(subtitle);

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Subtitle uploaded successfully.");

        fileNameLabel.setText("No file selected");
        chosenFile = null;
        srtRadio.setSelected(false);
        vttRadio.setSelected(false);

        contentTable.refresh();
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