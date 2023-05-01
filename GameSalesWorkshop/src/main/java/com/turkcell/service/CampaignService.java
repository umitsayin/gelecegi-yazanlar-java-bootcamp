package com.turkcell.service;

import com.turkcell.model.Campaign;

import java.util.List;

public interface CampaignService {
    Campaign getCampaignById(int id);
    Campaign addCampaign (Campaign campaign);
    Campaign updateCampaignById(int id,Campaign campaign);
    boolean deleteCampaignById(int id);
    List<Campaign> getCampaign();
}
