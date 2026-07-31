package csc213.ottplatfrom.rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GenerateMarketingReportController implements Initializable {

    @FXML
    private ComboBox<String> reportTypeComboBox;
    @FXML private ComboBox<String> reportPeriodComboBox;
    @FXML private Text reportText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportTypeComboBox.setItems(FXCollections.observableArrayList(
                "Campaign Summary", "Subscriber Engagement", "Content Promotion", "Overall Marketing"
        ));
        reportPeriodComboBox.setItems(FXCollections.observableArrayList(
                "This Week", "This Month", "This Quarter", "This Year"
        ));
    }

    @FXML
    private void handleGenerateReport(ActionEvent event) {
        // VL: validate report parameters
        if (reportTypeComboBox.getValue() == null || reportPeriodComboBox.getValue() == null) {
            reportText.setText("Please select both a report type and a report period.");
            return;
        }

        // DP: retrieve marketing data / generate report (simulated using in-memory data)
        int totalCampaigns = DataStore.campaigns.size();
        int featuredCount = (int) DataStore.contentList.stream().filter(c -> c.isFeatured()).count();

        reportText.setText("Marketing Report (" + reportTypeComboBox.getValue() + " - " + reportPeriodComboBox.getValue() + ")\n"
                + "Total Active Campaigns: " + totalCampaigns + "\n"
                + "Featured Content Items: " + featuredCount + "\n"
                + "Report generated successfully.");
    }

    @FXML
    private void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene(event,"/csc213/ottplatfrom/rajmee/ManagePromotion.fxml","Marketing Dashboard");
    }
}