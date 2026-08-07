package csc213.ottplatfrom.Munshi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Subtitle;

public class SubscriberDownloadSubtitleController {

    @FXML
    private ComboBox<String> contentComboBox;

    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    private ComboBox<String> formatComboBox;

    @FXML
    private CheckBox autoDownloadCheckBox;

    @FXML
    private TableView<Subtitle> subtitleTableView;

    @FXML
    private TableColumn<Subtitle, String> languageColumn;

    @FXML
    private TableColumn<Subtitle, String> formatColumn;

    @FXML
    private TableColumn<Subtitle, String> sizeColumn;

    @FXML
    public void initialize() {

        contentComboBox.getItems().addAll(
                "Movie A",
                "Movie B",
                "Series X",
                "Series Y"
        );

        languageComboBox.getItems().addAll(
                "English",
                "Bangla",
                "Hindi",
                "Spanish"
        );

        formatComboBox.getItems().addAll(
                "SRT",
                "VTT",
                "ASS"
        );

        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("fileSize"));

        ObservableList<Subtitle> subtitleList = FXCollections.observableArrayList();

        subtitleList.add(new Subtitle(
                "SUB001",
                "Movie A",
                "English",
                "SRT",
                "2.5 MB",
                "2026-08-01",
                120
        ));

        subtitleList.add(new Subtitle(
                "SUB002",
                "Movie A",
                "Bangla",
                "SRT",
                "2.3 MB",
                "2026-08-02",
                85
        ));

        subtitleList.add(new Subtitle(
                "SUB003",
                "Series X",
                "Hindi",
                "VTT",
                "3.1 MB",
                "2026-08-03",
                45
        ));

        subtitleTableView.setItems(subtitleList);

    }

    @FXML
    private void downloadOnClick(ActionEvent event) {

        if (contentComboBox.getValue() == null) {
            showAlert("Please select a movie or series.");
            return;
        }

        if (languageComboBox.getValue() == null) {
            showAlert("Please select a language.");
            return;
        }

        if (formatComboBox.getValue() == null) {
            showAlert("Please select a subtitle format.");
            return;
        }

        if (subtitleTableView.getSelectionModel().getSelectedItem() == null) {
            showAlert("Please select a subtitle.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Subtitle downloaded successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        contentComboBox.setValue(null);
        languageComboBox.setValue(null);
        formatComboBox.setValue(null);
        autoDownloadCheckBox.setSelected(false);
        subtitleTableView.getSelectionModel().clearSelection();

    }

    @FXML
    private void backOnClick(ActionEvent event) {

        System.out.println("Back to Subscriber Dashboard");

    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}