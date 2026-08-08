package csc213.ottplatfrom.NusratJahan;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataStore {

    private static final String DATA_DIR = "data";

    public static void init() {
        try {
            Path dir = Paths.get(DATA_DIR);
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readLines(String fileName, String[] sampleLines) {
        try {
            Path dir = Paths.get(DATA_DIR);
            if (!Files.exists(dir)) Files.createDirectories(dir);
            Path file = dir.resolve(fileName);
            if (!Files.exists(file)) {
                Files.write(file, Arrays.asList(sampleLines));
            }
            return Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void writeLines(String fileName, List<String> lines) {
        try {
            Path dir = Paths.get(DATA_DIR);
            if (!Files.exists(dir)) Files.createDirectories(dir);
            Files.write(dir.resolve(fileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PlatformUser> loadAllUsers() {
        String[] sample = {
                "U001|Rafiq Islam|rafiq@example.com|Active",
                "U002|Nadia Karim|nadia@example.com|Active",
                "U003|Sabbir Ahmed|sabbir@example.com|Inactive"
        };
        List<PlatformUser> list = new ArrayList<>();
        for (String line : readLines("users.txt", sample)) {
            String[] p = line.split("\\|");
            if (p.length == 4) list.add(new PlatformUser(p[0], p[1], p[2], p[3]));
        }
        return list;
    }

    public static void updateUserStatus(String userId, String newStatus) {
        List<PlatformUser> users = loadAllUsers();
        List<String> lines = new ArrayList<>();
        for (PlatformUser u : users) {
            if (u.getUserId().equals(userId)) u.setStatus(newStatus);
            lines.add(u.toLine());
        }
        writeLines("users.txt", lines);
    }

    public static List<ContentItem> loadAllContent() {
        String[] sample = {
                "C001|The Long Road|Movie|Drama|2023|Available|false",
                "C002|City Lights|Series|Thriller|2022|Available|true",
                "C003|Ocean Deep|Movie|Documentary|2024|Available|false"
        };
        List<ContentItem> list = new ArrayList<>();
        for (String line : readLines("content.txt", sample)) {
            String[] p = line.split("\\|");
            if (p.length == 7) list.add(new ContentItem(p[0], p[1], p[2], p[3], p[4], p[5], Boolean.parseBoolean(p[6])));
        }
        return list;
    }

    public static void updateFeaturedStatus(String contentId, boolean featured) {
        List<ContentItem> items = loadAllContent();
        List<String> lines = new ArrayList<>();
        for (ContentItem c : items) {
            if (c.getContentId().equals(contentId)) c.setFeatured(featured);
            lines.add(c.toLine());
        }
        writeLines("content.txt", lines);
    }

    public static List<SubscriptionPlan> loadPlans() {
        String[] sample = {
                "P001|Basic|4.99",
                "P002|Standard|9.99",
                "P003|Premium|14.99"
        };
        List<SubscriptionPlan> list = new ArrayList<>();
        for (String line : readLines("plans.txt", sample)) {
            String[] p = line.split("\\|");
            if (p.length == 3) list.add(new SubscriptionPlan(p[0], p[1], Double.parseDouble(p[2])));
        }
        return list;
    }

    public static void updatePlanPrice(String planId, double newPrice) {
        List<SubscriptionPlan> plans = loadPlans();
        List<String> lines = new ArrayList<>();
        for (SubscriptionPlan pl : plans) {
            if (pl.getPlanId().equals(planId)) pl.setPrice(newPrice);
            lines.add(pl.toLine());
        }
        writeLines("plans.txt", lines);
    }

    public static List<FeedbackEntry> loadFeedback() {
        String[] sample = {
                "F001|Nadia Karim|5|Excellent streaming quality.",
                "F002|Sabbir Ahmed|3|App crashes sometimes on tablet."
        };
        List<FeedbackEntry> list = new ArrayList<>();
        for (String line : readLines("feedback.txt", sample)) {
            String[] p = line.split("\\|", 4);
            if (p.length == 4) list.add(new FeedbackEntry(p[0], p[1], p[2], p[3]));
        }
        return list;
    }

    public static List<SubscriberProfile> loadAllSubscribers() {
        String[] sample = {
                "S001|Nadia Karim|nadia@example.com|01710000001|Bangladesh|Standard|2026-12-01",
                "S002|Sabbir Ahmed|sabbir@example.com|01710000002|Bangladesh|Premium|2026-09-15"
        };
        List<SubscriberProfile> list = new ArrayList<>();
        for (String line : readLines("subscribers.txt", sample)) {
            String[] p = line.split("\\|");
            if (p.length == 7) list.add(new SubscriberProfile(p[0], p[1], p[2], p[3], p[4], p[5], p[6]));
        }
        return list;
    }

    public static SubscriberProfile findSubscriberById(String subscriberId) {
        for (SubscriberProfile s : loadAllSubscribers()) {
            if (s.getSubscriberId().equalsIgnoreCase(subscriberId)) return s;
        }
        return null;
    }

    public static void saveAnnouncement(String title, String text) {
        List<String> lines = new ArrayList<>(readLines("announcements.txt", new String[0]));
        lines.add(title + "|" + text.replace("\n", " "));
        writeLines("announcements.txt", lines);
    }

    public static List<PaymentRecord> loadAllPayments() {
        String[] sample = {
                "PAY001|S001|Nadia Karim|9.99|2026-07-01|Verified|Card",
                "PAY002|S002|Sabbir Ahmed|14.99|2026-07-03|Pending|Mobile Banking"
        };
        List<PaymentRecord> list = new ArrayList<>();
        for (String line : readLines("payments.txt", sample)) {
            String[] p = line.split("\\|");
            if (p.length == 7) list.add(new PaymentRecord(p[0], p[1], p[2], Double.parseDouble(p[3]), p[4], p[5], p[6]));
        }
        return list;
    }

    public static List<PaymentRecord> loadPendingPayments() {
        List<PaymentRecord> pending = new ArrayList<>();
        for (PaymentRecord p : loadAllPayments()) {
            if (p.getStatus().equalsIgnoreCase("Pending")) pending.add(p);
        }
        return pending;
    }

    public static void verifyPayment(String paymentId) {
        List<PaymentRecord> all = loadAllPayments();
        List<String> lines = new ArrayList<>();
        for (PaymentRecord p : all) {
            if (p.getPaymentId().equals(paymentId)) p.setStatus("Verified");
            lines.add(p.toLine());
        }
        writeLines("payments.txt", lines);
    }

    public static void savePayment(PaymentRecord newPayment) {
        List<String> lines = new ArrayList<>();
        for (PaymentRecord p : loadAllPayments()) lines.add(p.toLine());
        lines.add(newPayment.toLine());
        writeLines("payments.txt", lines);
    }

    public static PaymentRecord findPaymentById(String paymentId) {
        for (PaymentRecord p : loadAllPayments()) {
            if (p.getPaymentId().equalsIgnoreCase(paymentId)) return p;
        }
        return null;
    }

    public static List<PaymentRecord> findPaymentsBySubscriber(String subscriberId) {
        List<PaymentRecord> result = new ArrayList<>();
        for (PaymentRecord p : loadAllPayments()) {
            if (p.getSubscriberId().equalsIgnoreCase(subscriberId)) result.add(p);
        }
        return result;
    }

    public static void deletePayment(String paymentId) {
        List<PaymentRecord> all = loadAllPayments();
        List<String> lines = new ArrayList<>();
        for (PaymentRecord p : all) {
            if (!p.getPaymentId().equals(paymentId)) lines.add(p.toLine());
        }
        writeLines("payments.txt", lines);
    }

    public static String generateNextPaymentId() {
        List<PaymentRecord> all = loadAllPayments();
        int max = 0;
        for (PaymentRecord p : all) {
            try {
                int n = Integer.parseInt(p.getPaymentId().replaceAll("[^0-9]", ""));
                if (n > max) max = n;
            } catch (NumberFormatException ignored) {}
        }
        return String.format("PAY%03d", max + 1);
    }

    public static List<RefundRequest> loadRefundRequests() {
        String[] sample = {
                "R001|Sabbir Ahmed|14.99|Accidental duplicate charge|Pending",
                "R002|Nadia Karim|4.99|Did not receive service|Pending"
        };
        List<RefundRequest> list = new ArrayList<>();
        for (String line : readLines("refunds.txt", sample)) {
            String[] p = line.split("\\|", 5);
            if (p.length == 5) list.add(new RefundRequest(p[0], p[1], Double.parseDouble(p[2]), p[3], p[4]));
        }
        return list;
    }

    private static AppUser currentUser;

    public static List<AppUser> loadUsers() {
        List<AppUser> list = new ArrayList<>();
        list.add(new AppUser("U100", "CEO Account", "CEO"));
        list.add(new AppUser("U200", "Accountant Account", "Accountant"));
        return list;
    }

    public static void setCurrentUser(AppUser user) {
        currentUser = user;
    }

    public static AppUser getCurrentUser() {
        return currentUser;
    }
}