package com.turkcell.service.impl;

import com.turkcell.model.Campaign;
import com.turkcell.model.Game;
import com.turkcell.model.Sale;
import com.turkcell.service.Logger;
import com.turkcell.service.SaleService;
import com.turkcell.util.EDevletSystem;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    private List<Logger> loggers;

    public SaleServiceImpl(List<Logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void sellGame(Sale sale, Campaign campaign) {
        if(EDevletSystem.verifyPlayer(sale.getPlayer())){
            double totalPrice = 0;
            for (Game game:sale.getGames()) {
                totalPrice += game.getPrice();
            }
            double totalPriceAfterDiscount = totalPrice * (100- campaign.getDiscount())/100;
            String message = sale.getPlayer().getFirstName()+" isimli kullanıcı "+campaign.getName()+" " +
                    "kampanyası ile "+totalPriceAfterDiscount+" Tl ödeyip oyunları satın aldı.";
            for (Logger logger : loggers){
                logger.log(message);
            }
        }else{
            System.out.println("Kullanıcı doğrulanamadı.");
        }
    }
}
