package csc213.ottplatfrom.Rajmee;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** MarketingManager ..> ReportSummary (Dependency: generates but doesn't own long-term). */
public class ReportSummary {

    private final IntegerProperty reportId;
    private final StringProperty reportType;
    private final StringProperty period;
    private final StringProperty generatedDate;

    public ReportSummary(int reportId, String reportType, String period, String generatedDate) {
        this.reportId = new SimpleIntegerProperty(reportId);
        this.reportType = new SimpleStringProperty(reportType);
        this.period = new SimpleStringProperty(period);
        this.generatedDate = new SimpleStringProperty(generatedDate);
    }

    public int getReportId() { return reportId.get(); }
    public String getReportType() { return reportType.get(); }
    public String getPeriod() { return period.get(); }
    public String getGeneratedDate() { return generatedDate.get(); }

    public IntegerProperty reportIdProperty() { return reportId; }
    public StringProperty reportTypeProperty() { return reportType; }
    public StringProperty periodProperty() { return period; }
    public StringProperty generatedDateProperty() { return generatedDate; }
}
