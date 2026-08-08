package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FeaturedContentController {

    @FXML
    private TableColumn<Content, Integer> idColumn;

    @FXML
    private TableColumn<Content, String> titleColumn;

    @FXML
    private TableColumn<Content, String> typeColumn;

    @FXML
    private TableColumn<Content, String> genreColumn;

    @FXML
    private TableColumn<Content, String> featuredColumn;

    @FXML
    private TableView<Content> contentTable;

    @FXML
    private ComboBox<String> positionComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Label messageLabel;


    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("contentId")
        );

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );

        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>("type")
        );

        genreColumn.setCellValueFactory(
                new PropertyValueFactory<>("genre")
        );

        featuredColumn.setCellValueFactory(
                new PropertyValueFactory<>("featuredLabel")
        );

        contentTable.setItems(DataStore.contentList);

        positionComboBox.setItems(
                FXCollections.observableArrayList(
                        "Top Banner",
                        "Homepage Carousel",
                        "Category Highlight"
                )
        );
    }


    @FXML
    public void handleSaveFeatured(ActionEvent event) {

        Content selected =
                contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showError("Please select a content item first.");
            return;
        }

        if (!"Available".equals(selected.getStatus())) {
            showError("Only available content can be featured.");
            return;
        }

        if (positionComboBox.getValue() == null) {
            showError("Please select a featured position.");
            return;
        }

        if (startDatePicker.getValue() == null ||
                endDatePicker.getValue() == null) {

            showError("Please select start and end dates.");
            return;
        }

        if (endDatePicker.getValue()
                .isBefore(startDatePicker.getValue())) {

            showError("End date cannot be before start date.");
            return;
        }

        selected.setFeatured(true);

        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill: green;");

        messageLabel.setText(
                selected.getTitle()
                        + " is now featured at "
                        + positionComboBox.getValue()
                        + " from "
                        + startDatePicker.getValue()
                        + " to "
                        + endDatePicker.getValue()
                        + "."
        );
    }


    @FXML
    public void handleRemoveFeatured(ActionEvent event) {

        Content selected =
                contentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showError("Please select a content item first.");
            return;
        }

        selected.setFeatured(false);

        contentTable.refresh();

        messageLabel.setStyle("-fx-text-fill: green;");

        messageLabel.setText(
                selected.getTitle()
                        + " removed from featured content."
        );
    }


    @FXML
    public void handleBack(ActionEvent event) {

        try {

            SceneSwitcher.switchScene(
                    event,
                    "/csc213/ottplatfrom/Rajmee/MarketingDashboard.fxml",
                    "Marketing Manager Dashboard"
            );

        } catch (Exception e) {

            showError("Unable to return to Marketing Dashboard.");

            e.printStackTrace();
        }
    }


    private void showError(String message) {

        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(message);
    }
}