package com.turkcell.service;

import com.turkcell.model.Campaign;
import com.turkcell.model.Sale;

public interface SaleService {
    void sellGame(Sale sale, Campaign campaign);
}
