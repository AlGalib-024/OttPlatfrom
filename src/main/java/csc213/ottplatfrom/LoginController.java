package csc213.ottplatfrom;

import csc213.ottplatfrom.NusratJahan.AppUser;
import csc213.ottplatfrom.NusratJahan.DataStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.util.List;

/**
 * Handles sign-in for the two implemented roles (CEO and Accountant) and
 * routes to the matching dashboard using SceneSwitcher. The CRA report does
 * not specify a sign-in/sign-out workflow, so this is a minimal one built
 * for this app: pick a role, type any password.
 */
public class LoginController {

    @FXML
    private ComboBox<String> userCombo;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        userCombo.getItems().addAll("CEO", "Accountant");
    }

    @FXML
    private void handleSignIn(ActionEvent event) throws IOException {
        String selectedRole = userCombo.getValue();
        if (selectedRole == null) {
            statusLabel.setText("Please select a user.");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            statusLabel.setText("Please enter a password.");
            return;
        }

        List<AppUser> users = DataStore.loadUsers();
        AppUser selectedUser = null;
        for (AppUser user : users) {
            if (user.getRole().equals(selectedRole)) {
                selectedUser = user;
                break;
            }
        }
        if (selectedUser == null) {
            statusLabel.setText("No account found for this role.");
            return;
        }

        DataStore.setCurrentUser(selectedUser);

        if (selectedRole.equals("CEO")) {
            SceneSwitcher.switchTo(event, "NusratJahan/ceo-dashboard.fxml", "OTT Platform - CEO");
        } else {
            SceneSwitcher.switchTo(event, "NusratJahan/accountant-dashboard.fxml", "OTT Platform - Accountant");
        }
    }
}
