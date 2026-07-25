package csc213.ottplatfrom;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Loads a new FXML view into the current window's Stage, replacing whatever
 * is currently shown. Used to move between the login screen and the two
 * dashboards.
 */
public class SceneSwitcher {

    public static void switchTo(ActionEvent event, String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlPath));
        Parent root = loader.load();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle(title);
    }
}
