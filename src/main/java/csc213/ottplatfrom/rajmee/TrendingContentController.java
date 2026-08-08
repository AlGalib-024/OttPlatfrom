package csc213.ottplatfrom.rajmee;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TrendingContentController  {

    @FXML
    private ComboBox<String> periodComboBox;
    @FXML private Text reportTitleText;
    @FXML private TableView<TrendingRow> trendingTable;
    @FXML private TableColumn<TrendingRow, Integer> rankColumn;
    @FXML private TableColumn<TrendingRow, String> titleColumn;
    @FXML private TableColumn<TrendingRow, Integer> viewsColumn;
    @FXML private TableColumn<TrendingRow, Double> ratingColumn;


    public void initialize() {
        periodComboBox.setItems(FXCollections.observableArrayList(
                "Last 7 Days", "Last 30 Days", "Last 3 Months", "Last 6 Months"
        ));
        rankColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().rank).asObject());
        titleColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().title));
        viewsColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().views).asObject());
        ratingColumn.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().rating).asObject());
    }

    @FXML
    private void handleGenerateReport(ActionEvent event) {
        // VL: validate selected period
        if (periodComboBox.getValue() == null) {
            reportTitleText.setText("Please select an analysis period first.");
            return;
        }

        // DP: retrieve viewing statistics, rank content by popularity
        ObservableList<TrendingRow> rows = FXCollections.observableArrayList(
                DataStore.contentList.stream()
                        .map(c -> new TrendingRow(c.getTitle(),
                                DataStore.simulatedViews(c.getContentId()),
                                DataStore.simulatedRating(c.getContentId())))
                        .sorted(Comparator.comparingInt((TrendingRow r) -> r.views).reversed())
                        .collect(Collectors.toList())
        );
        for (int i = 0; i < rows.size(); i++) rows.get(i).rank = i + 1;

        trendingTable.setItems(rows);
        reportTitleText.setText("Trending content report generated successfully (" + periodComboBox.getValue() + ")");
    }

    @FXML
    private void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene(
                event,
                "/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml",
                "Content Manager Dashboard"
        );
    }

    /** Simple row holder for the trending table (not part of DataStore). */
    public static class TrendingRow {
        int rank;
        final String title;
        final int views;
        final double rating;

        TrendingRow(String title, int views, double rating) {
            this.title = title;
            this.views = views;
            this.rating = rating;
        }
    }
}