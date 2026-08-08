package csc213.ottplatfrom.Rajmee;

import javafx.event.ActionEvent;

public class MarketingDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goCreateCampaign(ActionEvent actionEvent) {
          SceneSwitcher.switchScene(actionEvent,"/csc213/ottplatfrom/rajmee/CreateCampaign.fxml","Create Campaign");
    }

    @javafx.fxml.FXML
    public void goCampaignPerformance(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,"/csc213/ottplatfrom/rajmee/CampaignPerformance.fxml","Campaign Performance");
    }

    @javafx.fxml.FXML
    public void goSendNotifications(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/SendNotification.fxml",
                "Send Notifications");
    }

    @javafx.fxml.FXML
    public void goGenerateReport(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/GenerateMarketingReport.fxml",

                "Generate Report");
    }


    @javafx.fxml.FXML
    public void goFeaturedContent(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/FeaturedContent.fxml",
                "Featured Content");
    }

    @javafx.fxml.FXML
    public void goTrendingContent(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/TrendingContent.fxml",
                "Trending Content");
    }

    @javafx.fxml.FXML
    public void goEditCampaign(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/EditCampaign.fxml",
                "Edit Campaign");

    }

    @javafx.fxml.FXML
    public void goLogout(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/Login.fxml",
                "OTT Platform - Login");

    }

    @javafx.fxml.FXML
    public void goManagePromotions(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
            "/csc213/ottplatfrom/rajmee/ManagePromotion.fxml",

            "Manage Promotions");
    }
}