package csc213.ottplatfrom.NusratJahan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Simulates the platform's persistence layer using plain pipe-delimited text
 * files under ./data, instead of a real database. Also keeps track of the
 * signed-in user for the current session.
 */
public class DataStore {

    private static final String DATA_DIR = "data";

    private static AppUser currentUser;

    public static AppUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(AppUser user) {
        currentUser = user;
    }

    // ---------- setup ----------

    public static void init() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        seedIfMissing("users.txt",
                "ceo1|CEO|Nusrat Jahan",
                "acc1|Accountant|Munshi Abdulla Al Galib");

        seedIfMissing("subscribers.txt",
                "SUB001|Tanvir Ahmed|tanvir.ahmed@mail.com|Active|2025-01-12",
                "SUB002|Farzana Karim|farzana.karim@mail.com|Active|2025-03-20",
                "SUB003|Rakibul Hasan|rakibul.hasan@mail.com|Inactive|2024-11-05",
                "SUB004|Shirin Akter|shirin.akter@mail.com|Active|2026-06-02",
                "SUB005|Imran Chowdhury|imran.chowdhury@mail.com|Active|2026-07-10");

        seedIfMissing("content.txt",
                "CON001|Silent Horizon|Movie|Drama|2023|Active|Yes",
                "CON002|Night Circuit|Series|Thriller|2024|Active|No",
                "CON003|Coastal Dreams|Movie|Romance|2022|Active|No",
                "CON004|Retired Detective|Series|Crime|2021|Inactive|No",
                "CON005|Skyline Rush|Movie|Action|2025|Active|Yes");

        seedIfMissing("plans.txt",
                "Basic|4.99",
                "Standard|9.99",
                "Premium|14.99");

        seedIfMissing("feedback.txt",
                "FB001|Tanvir Ahmed|5|Great content library and smooth streaming.",
                "FB002|Farzana Karim|4|Would like more regional shows.",
                "FB003|Imran Chowdhury|3|App occasionally buffers on mobile data.");

        seedIfMissing("announcements.txt",
                "ANN001|Welcome to the New Season|We have added many new movies and series this month.");

        seedIfMissing("payments.txt",
                "PAY001|SUB001|Tanvir Ahmed|9.99|2026-07-24|Card|Verified",
                "PAY002|SUB002|Farzana Karim|14.99|2026-07-20|Card|Verified",
                "PAY003|SUB003|Rakibul Hasan|4.99|2026-07-10|Bank Transfer|Pending",
                "PAY004|SUB004|Shirin Akter|9.99|2026-06-15|Cash|Verified",
                "PAY005|SUB005|Imran Chowdhury|14.99|2026-05-02|Card|Verified",
                "PAY006|SUB001|Tanvir Ahmed|9.99|2026-06-24|Card|Verified");

        seedIfMissing("refunds.txt",
                "REF001|Rakibul Hasan|4.99|Accidental duplicate charge|Pending",
                "REF002|Farzana Karim|14.99|Service was unavailable in her area|Approved");
    }

    /*
     * Writes the seed rows if the file is missing, and also rewrites it if an
     * existing copy doesn't match the expected column count (for example a
     * leftover file from an older version of this project). This way a stale
     * data file left over from copying/zipping the project can never keep the
     * app broken - it just repairs itself on the next run.
     */
    private static void seedIfMissing(String fileName, String... rows) {
        File file = new File(DATA_DIR, fileName);
        if (file.exists() && matchesExpectedShape(file, rows[0])) return;
        writeLines(fileName, rows);
    }

    private static boolean matchesExpectedShape(File file, String sampleRow) {
        int expectedColumns = sampleRow.split("\\|").length;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                if (!line.isBlank() && !line.startsWith("#") && line.split("\\|").length != expectedColumns) {
                    reader.close();
                    return false;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    // ---------- generic file helpers ----------

    private static List<String[]> readRows(String fileName) {
        List<String[]> rows = new ArrayList<>();
        File file = new File(DATA_DIR, fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                if (!line.isBlank() && !line.startsWith("#")) {
                    rows.add(line.split("\\|"));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    private static void writeRows(String fileName, List<String> rows) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DATA_DIR, fileName)));
            for (String row : rows) {
                writer.write(row);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLines(String fileName, String[] rows) {
        List<String> list = new ArrayList<>();
        for (String row : rows) list.add(row);
        writeRows(fileName, list);
    }

    // ---------- users ----------

    public static List<AppUser> loadUsers() {
        List<AppUser> users = new ArrayList<>();
        for (String[] r : readRows("users.txt")) {
            users.add(new AppUser(r[0], r[1], r[2]));
        }
        return users;
    }

    // ---------- subscribers ----------

    static List<Subscriber> loadSubscribers() {
        List<Subscriber> list = new ArrayList<>();
        for (String[] r : readRows("subscribers.txt")) {
            list.add(new Subscriber(r[0], r[1], r[2], r[3], r[4]));
        }
        return list;
    }

    static void saveSubscribers(List<Subscriber> subscribers) {
        List<String> rows = new ArrayList<>();
        for (Subscriber s : subscribers) {
            rows.add(s.getId() + "|" + s.getName() + "|" + s.getEmail() + "|" + s.getStatus() + "|" + s.getJoinDate());
        }
        writeRows("subscribers.txt", rows);
    }

    // ---------- content ----------

    static List<ContentItem> loadContent() {
        List<ContentItem> list = new ArrayList<>();
        for (String[] r : readRows("content.txt")) {
            list.add(new ContentItem(r[0], r[1], r[2], r[3], Integer.parseInt(r[4]), r[5], r[6]));
        }
        return list;
    }

    static void saveContent(List<ContentItem> content) {
        List<String> rows = new ArrayList<>();
        for (ContentItem c : content) {
            rows.add(c.getId() + "|" + c.getTitle() + "|" + c.getType() + "|" + c.getGenre() + "|"
                    + c.getReleaseYear() + "|" + c.getStatus() + "|" + c.getFeaturedLabel());
        }
        writeRows("content.txt", rows);
    }

    // ---------- plans ----------

    static List<Plan> loadPlans() {
        List<Plan> list = new ArrayList<>();
        for (String[] r : readRows("plans.txt")) {
            list.add(new Plan(r[0], Double.parseDouble(r[1])));
        }
        return list;
    }

    static void savePlans(List<Plan> plans) {
        List<String> rows = new ArrayList<>();
        for (Plan p : plans) {
            rows.add(p.getName() + "|" + p.getPrice());
        }
        writeRows("plans.txt", rows);
    }

    // ---------- feedback ----------

    static List<Feedback> loadFeedback() {
        List<Feedback> list = new ArrayList<>();
        for (String[] r : readRows("feedback.txt")) {
            list.add(new Feedback(r[0], r[1], Integer.parseInt(r[2]), r[3]));
        }
        return list;
    }

    // ---------- announcements ----------

    static List<Announcement> loadAnnouncements() {
        List<Announcement> list = new ArrayList<>();
        for (String[] r : readRows("announcements.txt")) {
            list.add(new Announcement(r[0], r[1], r[2]));
        }
        return list;
    }

    static void saveAnnouncements(List<Announcement> announcements) {
        List<String> rows = new ArrayList<>();
        for (Announcement a : announcements) {
            rows.add(a.getId() + "|" + a.getTitle() + "|" + a.getBody());
        }
        writeRows("announcements.txt", rows);
    }

    // ---------- payments ----------

    static List<PaymentRecord> loadPayments() {
        List<PaymentRecord> list = new ArrayList<>();
        for (String[] r : readRows("payments.txt")) {
            list.add(new PaymentRecord(r[0], r[1], r[2], Double.parseDouble(r[3]), r[4], r[5], r[6]));
        }
        return list;
    }

    static void savePayments(List<PaymentRecord> payments) {
        List<String> rows = new ArrayList<>();
        for (PaymentRecord p : payments) {
            rows.add(p.getId() + "|" + p.getSubscriberId() + "|" + p.getSubscriberName() + "|"
                    + p.getAmount() + "|" + p.getDate() + "|" + p.getMethod() + "|" + p.getStatus());
        }
        writeRows("payments.txt", rows);
    }

    // ---------- refunds ----------

    static List<RefundRequest> loadRefunds() {
        List<RefundRequest> list = new ArrayList<>();
        for (String[] r : readRows("refunds.txt")) {
            list.add(new RefundRequest(r[0], r[1], Double.parseDouble(r[2]), r[3], r[4]));
        }
        return list;
    }
}
