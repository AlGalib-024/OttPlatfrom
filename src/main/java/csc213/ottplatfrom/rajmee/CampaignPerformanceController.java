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

public class CampaignPerformanceController implements Initializable {

    @FXML
    private TableView<Campaign> campaignTable;
    @FXML private TableColumn<Campaign, Integer> idColumn;
    @FXML private TableColumn<Campaign, String> nameColumn;
    @FXML private TableColumn<Campaign, String> statusColumn;
    @FXML private Label engagementLabel;
    @FXML private Label conversionLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("campaignId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        campaignTable.setItems(DataStore.campaigns);
    }

    @FXML
    private void handleAnalyze(ActionEvent event) {
        // VR: verify campaign exists (a row was selected)
        Campaign selected = campaignTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            engagementLabel.setText("Please select a campaign first.");
            conversionLabel.setText("");
            return;
        }

        // DP: retrieve campaign analytics / calculate performance metrics (simulated)
        int engagement = DataStore.simulatedViews(selected.getCampaignId());
        double conversionRate = DataStore.simulatedRating(selected.getCampaignId()) * 4; // simple simulated %

        engagementLabel.setText("Total Engagement: " + engagement + " interactions");
        conversionLabel.setText(String.format("Conversion Rate: %.1f%%", conversionRate));
    }

    @FXML
    private void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene(event,"/csc213/ottplatfrom/rajmee/ManagePromotion.fxml","Marketing Dashboard");
    }
}