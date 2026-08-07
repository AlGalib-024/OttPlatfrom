package csc213.ottplatfrom.NusratJahan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * One controller for every CEO (User-1) goal from the CRA report: business
 * dashboard, manage users, featured content, content list, subscription
 * plan pricing, customer feedback, subscriber lookup and announcements.
 */
public class CeoDashboardController {

    @FXML
    private Label totalSubscribersLabel;

    private ObservableList<Subscriber> subscribers;
    private ObservableList<ContentItem> content;
    private ObservableList<Plan> plans;
    private List<Announcement> announcements;
    private String editingAnnouncementId;
    @FXML
    private Label totalContentLabel;
    @FXML
    private Label totalRevenueLabel;
    @FXML
    private Label pendingPaymentsLabel;
    @FXML
    private ComboBox periodBox;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Welcome");

        periodCombo.getItems().addAll("Daily", "Weekly", "Monthly", "Yearly");
        periodCombo.getSelectionModel().select("Monthly");

        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUserStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colFeatId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFeatTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colFeatStatus.setCellValueFactory(new PropertyValueFactory<>("featuredLabel"));

        colListId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colListTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colListType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colListGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colListYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        colListStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colPlanName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPlanPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        colFbId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFbSubscriber.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colFbRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        colFbComment.setCellValueFactory(new PropertyValueFactory<>("comment"));

        annListView.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> handleAnnouncementSelected());

        loadAllData();
    }

    private void loadAllData() {
        subscribers = FXCollections.observableArrayList(DataStore.loadSubscribers());
        usersTable.setItems(subscribers);

        content = FXCollections.observableArrayList(DataStore.loadContent());
        featuredTable.setItems(content);
        contentListTable.setItems(content);

        plans = FXCollections.observableArrayList(DataStore.loadPlans());
        plansTable.setItems(plans);

        feedbackTable.setItems(FXCollections.observableArrayList(DataStore.loadFeedback()));

        announcements = DataStore.loadAnnouncements();
        refreshAnnouncementList();

        handleViewDashboard();
    }

    private void refreshAnnouncementList() {
        List<String> titles = new ArrayList<>();
        for (Announcement a : announcements) {
            titles.add(a.getTitle());
        }
        annListView.setItems(FXCollections.observableArrayList(titles));
    }

    @Deprecated
    private void handleSignOut(ActionEvent event) throws IOException {
        DataStore.setCurrentUser(null);
        csc213.ottplatfrom.SceneSwitcher.switchTo(event, "login.fxml", "OTT Platform - Sign In");
    }

    // ---------- Goal 1: View Business Dashboard ----------

    @FXML
    private void handleViewDashboard() {
        String period = periodCombo.getValue();
        if (period == null) period = "Monthly";

        int daysBack;
        if (period.equals("Daily")) {
            daysBack = 0;
        } else if (period.equals("Weekly")) {
            daysBack = 6;
        } else if (period.equals("Yearly")) {
            daysBack = 364;
        } else {
            daysBack = 29;
        }

        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(daysBack);

        int newSubscriberCount = 0;
        for (Subscriber s : subscribers) {
            LocalDate joinDate = LocalDate.parse(s.getJoinDate());
            if (!joinDate.isBefore(start) && !joinDate.isAfter(today)) {
                newSubscriberCount++;
            }
        }

        double revenue = 0;
        for (PaymentRecord p : DataStore.loadPayments()) {
            if (p.getStatus().equals("Pending")) continue;
            LocalDate paymentDate = LocalDate.parse(p.getDate());
            if (!paymentDate.isBefore(start) && !paymentDate.isAfter(today)) {
                revenue = revenue + p.getAmount();
            }
        }

        int activeContentCount = 0;
        for (ContentItem c : content) {
            if (c.getStatus().equals("Active")) {
                activeContentCount++;
            }
        }

        totalSubscribersLabel.setText("Total Subscribers: " + subscribers.size());
        newSubscribersLabel.setText("New Subscribers: " + newSubscriberCount);
        revenueLabel.setText(String.format("Revenue: $%.2f", revenue));
        activeContentLabel.setText("Active Content: " + activeContentCount);
    }

    // ---------- Goal 2: Manage User Accounts ----------

    @FXML
    private void handleActivateUser() {
        Subscriber selected = usersTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            usersStatusLabel.setText("Select a subscriber first.");
            return;
        }
        selected.setStatus("Active");
        DataStore.saveSubscribers(subscribers);
        usersTable.refresh();
        usersStatusLabel.setText("User account status updated successfully.");
    }

    @FXML
    private void handleDeactivateUser() {
        Subscriber selected = usersTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            usersStatusLabel.setText("Select a subscriber first.");
            return;
        }
        selected.setStatus("Inactive");
        DataStore.saveSubscribers(subscribers);
        usersTable.refresh();
        usersStatusLabel.setText("User account status updated successfully.");
    }

    // ---------- Goal 3: Manage Featured Content ----------

    @FXML
    private void handleMarkFeatured() {
        ContentItem selected = featuredTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            featuredStatusLabel.setText("Select a content item first.");
            return;
        }
        selected.setFeaturedLabel("Yes");
        DataStore.saveContent(content);
        featuredTable.refresh();
        contentListTable.refresh();
        featuredStatusLabel.setText("Featured status updated successfully.");
    }

    @FXML
    private void handleRemoveFeatured() {
        ContentItem selected = featuredTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            featuredStatusLabel.setText("Select a content item first.");
            return;
        }
        selected.setFeaturedLabel("No");
        DataStore.saveContent(content);
        featuredTable.refresh();
        contentListTable.refresh();
        featuredStatusLabel.setText("Featured status updated successfully.");
    }

    // ---------- Goal 5: Update subscription plan price ----------

    @FXML
    private void handleUpdatePlanPrice() {
        Plan selected = plansTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            planStatusLabel.setText("Select a plan first.");
            return;
        }

        double newPrice;
        try {
            newPrice = Double.parseDouble(newPriceField.getText());
        } catch (NumberFormatException e) {
            planStatusLabel.setText("Enter a valid price.");
            return;
        }
        if (newPrice <= 0) {
            planStatusLabel.setText("Price must be greater than zero.");
            return;
        }

        selected.setPrice(newPrice);
        DataStore.savePlans(plans);
        plansTable.refresh();
        newPriceField.clear();
        planStatusLabel.setText("Subscription plan price updated successfully.");
    }

    // ---------- Goal 7: View Subscriber Details ----------

    @FXML
    private void handleSearchSubscriber() {
        String id = subSearchField.getText().trim();
        if (id.isEmpty()) {
            subSearchStatusLabel.setText("Enter a Subscriber ID.");
            return;
        }

        Subscriber found = null;
        for (Subscriber s : subscribers) {
            if (s.getId().equalsIgnoreCase(id)) {
                found = s;
                break;
            }
        }

        if (found == null) {
            subSearchStatusLabel.setText("No subscriber found with ID " + id + ".");
            clearSubscriberProfile();
            return;
        }

        subSearchStatusLabel.setText("");
        subNameLabel.setText("Name: " + found.getName());
        subEmailLabel.setText("Email: " + found.getEmail());
        subStatusLabel.setText("Status: " + found.getStatus());
        subJoinDateLabel.setText("Joined: " + found.getJoinDate());
    }

    @FXML
    private void handleClearSubscriberSearch() {
        subSearchField.clear();
        subSearchStatusLabel.setText("");
        clearSubscriberProfile();
    }

    private void clearSubscriberProfile() {
        subNameLabel.setText("");
        subEmailLabel.setText("");
        subStatusLabel.setText("");
        subJoinDateLabel.setText("");
    }

    // ---------- Goal 8: Manage Announcements ----------

    @FXML
    private void handleSaveAnnouncement() {
        String title = annTitleField.getText().trim();
        String body = annBodyArea.getText().trim();
        if (title.isEmpty() || body.isEmpty()) {
            annStatusLabel.setText("Title and announcement text are required.");
            return;
        }

        String id = "ANN" + (announcements.size() + 1);
        announcements.add(new Announcement(id, title, body));
        DataStore.saveAnnouncements(announcements);
        refreshAnnouncementList();
        handleClearAnnouncement();
        annStatusLabel.setText("Announcement saved successfully.");
    }

    @FXML
    private void handleUpdateAnnouncement() {
        if (editingAnnouncementId == null) {
            annStatusLabel.setText("Select an announcement from the list first.");
            return;
        }
        String title = annTitleField.getText().trim();
        String body = annBodyArea.getText().trim();
        if (title.isEmpty() || body.isEmpty()) {
            annStatusLabel.setText("Title and announcement text are required.");
            return;
        }

        for (int i = 0; i < announcements.size(); i++) {
            if (announcements.get(i).getId().equals(editingAnnouncementId)) {
                announcements.set(i, new Announcement(editingAnnouncementId, title, body));
                break;
            }
        }
        DataStore.saveAnnouncements(announcements);
        refreshAnnouncementList();
        handleClearAnnouncement();
        annStatusLabel.setText("Announcement updated successfully.");
    }

    @FXML
    private void handleClearAnnouncement() {
        annTitleField.clear();
        annBodyArea.clear();
        editingAnnouncementId = null;
        annListView.getSelectionModel().clearSelection();
    }

    private void handleAnnouncementSelected() {
        int index = annListView.getSelectionModel().getSelectedIndex();
        if (index < 0 || index >= announcements.size()) return;
        Announcement selected = announcements.get(index);
        editingAnnouncementId = selected.getId();
        annTitleField.setText(selected.getTitle());
        annBodyArea.setText(selected.getBody());
        annStatusLabel.setText("");
    }

    @FXML
    public void goCustomerFeedback(ActionEvent actionEvent) {
    }

    @FXML
    public void goAnnouncements(ActionEvent actionEvent) {
    }

    @FXML
    public void goSubscriberDetails(ActionEvent actionEvent) {
    }

    @FXML
    public void goSubscriptionPlans(ActionEvent actionEvent) {
    }

    @FXML
    public void goFeaturedContent(ActionEvent actionEvent) {
    }

    @FXML
    public void goContentList(ActionEvent actionEvent) {
    }

    @FXML
    public void goManageUsers(ActionEvent actionEvent) {
    }
}
