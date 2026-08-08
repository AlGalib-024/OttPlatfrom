package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerFeedbackController
{
    @javafx.fxml.FXML
    private TableColumn colFeedbackId;
    @javafx.fxml.FXML
    private TableColumn colSubscriberName;
    @javafx.fxml.FXML
    private TableColumn colRating;
    @javafx.fxml.FXML
    private TableView feedbackTable;
    @javafx.fxml.FXML
    private TableColumn colComment;

    @FXML
    public void initialize() {
        colFeedbackId.setCellValueFactory(new PropertyValueFactory<>("feedbackId"));
        colSubscriberName.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        colComment.setCellValueFactory(new PropertyValueFactory<>("comment"));

        feedbackTable.setItems(FXCollections.observableArrayList(DataStore.loadFeedback()));
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }
}