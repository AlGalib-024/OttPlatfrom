package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.util.Optional;
import java.util.stream.Collectors;

public class ContentAnalyticsController {

    @FXML
    private ComboBox<String> contentComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Text reportText;

    @FXML
    public void initialize() {

        contentComboBox.setItems(
                FXCollections.observableArrayList(
                        DataStore.contentList.stream()
                                .map(Content::getTitle)
                                .collect(Collectors.toList())
                )
        );
    }

    @FXML
    public void handleGenerateReport(ActionEvent event) {

        if (contentComboBox.getValue() == null) {
            reportText.setText("Please select a content item.");
            return;
        }

        if (startDatePicker.getValue() != null
                && endDatePicker.getValue() != null
                && !startDatePicker.getValue().isBefore(endDatePicker.getValue())) {

            reportText.setText("Start date must be before end date.");
            return;
        }

        Optional<Content> match = DataStore.contentList.stream()
                .filter(c -> c.getTitle().equals(contentComboBox.getValue()))
                .findFirst();

        if (match.isEmpty()) {
            reportText.setText("Content not found.");
            return;
        }

        Content c = match.get();

        int views = DataStore.simulatedViews(c.getContentId());
        double rating = DataStore.simulatedRating(c.getContentId());
        int engagement = views / 10;

        reportText.setText(
                "========== CONTENT ANALYTICS ==========\n\n" +
                        "Title : " + c.getTitle() + "\n" +
                        "Type : " + c.getType() + "\n" +
                        "Views : " + views + "\n" +
                        "Rating : " + rating + " / 5.0\n" +
                        "Engagement Score : " + engagement
        );
    }

    @FXML
    public void handleBack(ActionEvent event) {

        SceneSwitcher.switchScene(
                event,
                "/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml",
                "Content Manager Dashboard"
        );
    }
}