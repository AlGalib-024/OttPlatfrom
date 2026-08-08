package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnnouncementsController
{
    @FXML
    private TextField titleField;
    @FXML
    private TextArea announcementArea;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        titleField.clear();
        announcementArea.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleSave(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    @FXML
    public void handleUpdate(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    private void saveOrUpdate() {
        String title = titleField.getText().trim();
        String text = announcementArea.getText().trim();

        if (title.isEmpty() || text.isEmpty()) {
            statusLabel.setText("Title and announcement cannot be empty.");
            return;
        }

        DataStore.saveAnnouncement(title, text);
        statusLabel.setText("Announcement saved successfully.");
    }
}