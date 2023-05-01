package com.turkcell;

import com.turkcell.model.Campaign;
import com.turkcell.model.Game;
import com.turkcell.model.Player;
import com.turkcell.model.Sale;
import com.turkcell.service.*;
import com.turkcell.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(1,"Engin","Demiroğ",1985,"3052145126");
        Game game1 = new Game(1,"Cs2","counter strike",600);
        Game game2 = new Game(2,"half-life3","half layf",600);
        Campaign campaign = new Campaign(1,"%10 indirim",10);

        PlayerService playerService = new PlayerServiceImpl();
        GameService gameService = new GameServiceImpl();
        CampaignService campaignService = new CampaignServiceImpl();


        playerService.addPlayer(player);
        gameService.addGames(game1,game2);
        campaignService.addCampaign(campaign);

        List<Logger> loggers = new ArrayList<>();

        loggers.add(new EmailLoggerImpl());
        loggers.add(new FileLoggerImpl());

        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        SaleService saleService = new SaleServiceImpl(loggers);
        Sale sale = new Sale(1,games,player, LocalDate.now());

        saleService.sellGame(sale,campaign);
    }
}