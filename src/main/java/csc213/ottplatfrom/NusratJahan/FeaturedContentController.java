package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FeaturedContentController
{
    @javafx.fxml.FXML
    private TableColumn colContentId;
    @javafx.fxml.FXML
    private TableView contentTable;
    @javafx.fxml.FXML
    private TableColumn colFeaturedStatus;
    @javafx.fxml.FXML
    private TableColumn colTitle;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        colContentId.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colFeaturedStatus.setCellValueFactory(new PropertyValueFactory<>("featuredStatus"));

        contentTable.setItems(FXCollections.observableArrayList(DataStore.loadAllContent()));
    }

    @javafx.fxml.FXML
    public void handleMarkFeatured(ActionEvent actionEvent) {
        ContentItem selected = (ContentItem) contentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            statusLabel.setText("Please select a content item first.");
            return;
        }
        selected.setFeatured(true);
        DataStore.updateFeaturedStatus(selected.getContentId(), true);
        contentTable.refresh();
        statusLabel.setText("Content marked as featured.");
    }

    @javafx.fxml.FXML
    public void handleRemoveFeatured(ActionEvent actionEvent) {
        ContentItem selected = (ContentItem) contentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            statusLabel.setText("Please select a content item first.");
            return;
        }
        selected.setFeatured(false);
        DataStore.updateFeaturedStatus(selected.getContentId(), false);
        contentTable.refresh();
        statusLabel.setText("Content removed from featured.");
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }
}