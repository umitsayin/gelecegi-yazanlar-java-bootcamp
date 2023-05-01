package com.turkcell.service.impl;

import com.turkcell.model.Campaign;
import com.turkcell.service.CampaignService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaignServiceImpl implements CampaignService {

    private Map<Integer, Campaign> campaigns;

    public CampaignServiceImpl() {
        campaigns = new HashMap<>();
    }

    @Override
    public Campaign getCampaignById(int id) {
        return campaigns.get(id);
    }

    @Override
    public Campaign addCampaign(Campaign campaign) {
        return campaigns.put(campaign.getId(),campaign);
    }

    @Override
    public Campaign updateCampaignById(int id, Campaign campaign) {
        Campaign temp = getCampaignById(id);
        temp.setName(campaign.getName());
        temp.setDiscount(campaign.getDiscount());
        campaigns.put(id,temp);
        return temp;
    }

    @Override
    public boolean deleteCampaignById(int id) {
        Campaign campaign = getCampaignById(id);
        return campaigns.remove(id,campaign);
    }

    @Override
    public List<Campaign> getCampaign() {
        return new ArrayList<>(campaigns.values());
    }
}
