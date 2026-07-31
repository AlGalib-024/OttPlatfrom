package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MarkFeaturedController implements Initializable {

    @FXML
    private TableView<Content> contentTable;

    @FXML
    private TableColumn<Content, Integer> idColumn;

    @FXML
    private TableColumn<Content, String> titleColumn;

    @FXML
    private TableColumn<Content, String> typeColumn;

    @FXML
    private TableColumn<Content, String> featuredColumn;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        featuredColumn.setCellValueFactory(new PropertyValueFactory<>("featuredLabel"));

        contentTable.setItems(DataStore.contentList);
    }

    @FXML
    public void handleMarkFeatured(ActionEvent actionEvent) {

        Content selected = contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select a content.");
            return;
        }

        if (!selected.getStatus().equalsIgnoreCase("Available")) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Only available content can be featured.");
            return;
        }

        selected.setFeatured(true);
        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Content marked as Featured.");
    }

    @FXML
    public void handleUnmarkFeatured(ActionEvent actionEvent) {

        Content selected = contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please select a content.");
            return;
        }

        selected.setFeatured(false);
        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Content removed from Featured list.");
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/rajmee/MarketingDashboard.fxml",
                "Marketing Dashboard"
        );
    }
}