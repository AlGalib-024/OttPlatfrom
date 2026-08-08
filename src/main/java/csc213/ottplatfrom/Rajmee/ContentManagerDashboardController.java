package csc213.ottplatfrom.Rajmee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ContentManagerDashboardController {

    @FXML
    public void goAddContent(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/AddContent.fxml",
                "Add Content");
    }

    @FXML
    public void goEditContent(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/EditContent.fxml",
                "Edit Content");
    }

    @FXML
    public void goDeleteContent(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/DeleteContent.fxml",
                "Delete Content");
    }

    @FXML
    public void goUploadSubtitle(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/UploadSubtitle.fxml",
                "Upload Subtitle");
    }

    @FXML
    public void goAddEpisode(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/AddEpisode.fxml",
                "Add Episode");
    }

    @FXML
    public void goAssignGenre(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/AssignGenre.fxml",
                "Assign Genre");
    }

    @FXML
    public void goMarkFeatured(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/MarkManageFeaturedConten.fxml",

                "Mark Featured Content");
    }

    @FXML
    public void goContentAnalytics(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/ContentAnalytics.fxml",
                "Content Analytics");
    }

    @FXML
    public void goLogout(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/csc213/ottplatfrom/rajmee/Login.fxml",
                "OTT Platform - Login");
    }
}