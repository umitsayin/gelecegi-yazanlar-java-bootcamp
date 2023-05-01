package com.turkcell.service;

import com.turkcell.model.Game;

import java.util.List;

public interface GameService {
    Game getGameById(int id);
    void addGames(Game... games);
    Game updateGameById(int id,Game game);
    boolean deleteGameById(int id);
    List<Game> getGames();
}
