package csc213.ottplatfrom.rajmee;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TrendingContentController
{
    @javafx.fxml.FXML
    private TableColumn rankColumn;
    @javafx.fxml.FXML
    private TableColumn ratingColumn;
    @javafx.fxml.FXML
    private TableView trendingTable;
    @javafx.fxml.FXML
    private TableColumn viewsColumn;
    @javafx.fxml.FXML
    private Text reportTitleText;
    @javafx.fxml.FXML
    private TableColumn titleColumn;
    @javafx.fxml.FXML
    private ComboBox periodComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleGenerateReport(ActionEvent actionEvent) {
    }
}