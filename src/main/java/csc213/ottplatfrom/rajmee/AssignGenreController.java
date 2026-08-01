package csc213.ottplatfrom.rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AssignGenreController {

    @FXML
    private TableView<Content> contentTable;

    @FXML
    private TableColumn<Content, Integer> idColumn;

    @FXML
    private TableColumn<Content, String> titleColumn;

    @FXML
    private TableColumn<Content, String> typeColumn;

    @FXML
    private TableColumn<Content, Genre> genreColumn;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        contentTable.setItems(DataStore.contentList);

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
    public void handleAssignGenre(ActionEvent event) {

        Content selected = contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select content.");
            return;
        }

        if (genreComboBox.getValue() == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select a genre.");
            return;
        }

        Genre genre = DataStore.findGenreByName(genreComboBox.getValue());

        if (genre == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Genre not found.");
            return;
        }

        selected.setGenre(genre);

        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Genre assigned successfully.");
    }

    @FXML
    public void handleBack(ActionEvent event) {

        SceneSwitcher.switchScene(
                event,
                "/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml",
                "Content Manager Dashboard"
        );
    }
}