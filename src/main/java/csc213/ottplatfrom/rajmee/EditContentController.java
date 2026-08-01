package csc213.ottplatfrom.rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class EditContentController {

    @FXML
    private TableView<Content> contentTable;

    @FXML
    private TableColumn<Content, Integer> idColumn;

    @FXML
    private TableColumn<Content, String> titleColumn;

    @FXML
    private TableColumn<Content, String> typeColumn;

    @FXML
    private TableColumn<Content, String> statusColumn;

    @FXML
    private TextField titleField;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private DatePicker releaseDatePicker;

    @FXML
    private Label messageLabel;

    private Content selectedContent;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

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

        contentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {

            if (newValue != null) {

                selectedContent = newValue;

                titleField.setText(newValue.getTitle());

                if (newValue.getGenre() != null)
                    genreComboBox.setValue(newValue.getGenre().getGenreName());

                try {
                    releaseDatePicker.setValue(LocalDate.parse(newValue.getReleaseDate()));
                } catch (Exception e) {
                    releaseDatePicker.setValue(null);
                }

                messageLabel.setText("");
            }
        });

    }

    @FXML
    public void handleUpdateContent(ActionEvent actionEvent) {

        if (selectedContent == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select a content first.");
            return;
        }

        if (titleField.getText().isBlank()
                || genreComboBox.getValue() == null
                || releaseDatePicker.getValue() == null) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please fill all fields.");
            return;
        }

        selectedContent.setTitle(titleField.getText());

        Genre genre = DataStore.findGenreByName(genreComboBox.getValue());

        selectedContent.setGenre(genre);

        selectedContent.setReleaseDate(releaseDatePicker.getValue().toString());

        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Content updated successfully.");
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