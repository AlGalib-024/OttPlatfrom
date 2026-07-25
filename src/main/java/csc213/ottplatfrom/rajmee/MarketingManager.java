package csc213.ottplatfrom.rajmee;

import csc213.ottplatfrom.NusratJahan.AppUser;

public class MarketingManager extends AppUser {

    private int managerId;
    private String department;

    public Campaign createCampaign(Campaign campaign) {
        return campaign;
    }

    public boolean editCampaign(int campaignId) {
        return true;
    }

    public boolean sendNotification(Notification notification) {
        return true;
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotion;
    }

    public MarketingReport generateMarketingReport(String reportType) {
        return new MarketingReport();
    }

    public CampaignPerformance analyzeCampaign(int campaignId) {
        return new CampaignPerformance();
    }
}
