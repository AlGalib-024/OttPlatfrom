package csc213.ottplatfrom.Rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class DeleteContentController {

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
    private Label messageLabel;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        contentTable.setItems(DataStore.contentList);
    }

    @FXML
    public void handleDeleteContent(ActionEvent actionEvent) {

        Content selected = contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select a content item first.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Content");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this content?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            DataStore.contentList.remove(selected);

            messageLabel.setStyle("-fx-text-fill:green;");
            messageLabel.setText("Content deleted successfully.");
        }
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