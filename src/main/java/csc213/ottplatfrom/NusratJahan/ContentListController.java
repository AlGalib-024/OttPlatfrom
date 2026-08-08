package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContentListController {

    @FXML
    private TableView<ContentItem> contentTable;
    @FXML
    private TableColumn<ContentItem, String> colContentId;
    @FXML
    private TableColumn<ContentItem, String> colTitle;
    @FXML
    private TableColumn<ContentItem, String> colType;
    @FXML
    private TableColumn<ContentItem, String> colGenre;
    @FXML
    private TableColumn<ContentItem, String> colYear;
    @FXML
    private TableColumn<ContentItem, String> colStatus;

    @FXML
    public void initialize() {
        colContentId.setCellValueFactory(new PropertyValueFactory<>("contentId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        contentTable.setItems(FXCollections.observableArrayList(DataStore.loadAllContent()));
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }
}