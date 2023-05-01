package com.turkcell.service.impl;

import com.turkcell.model.Game;
import com.turkcell.service.GameService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameServiceImpl implements GameService {

    private Map<Integer, Game> games;

    public GameServiceImpl() {
        this.games = new HashMap<>();
    }

    @Override
    public Game getGameById(int id) {
        return games.get(id);
    }

    @Override
    public void addGames(Game... games) {
        for (Game game : games) {
            this.games.put(game.getId(), game);
        }
    }


    @Override
    public Game updateGameById(int id, Game game) {
        Game temp = getGameById(id);
        temp.setName(game.getName());
        temp.setDescription(game.getDescription());
        temp.setPrice(game.getPrice());
        games.put(id,temp);

        return temp;
    }

    @Override
    public boolean deleteGameById(int id) {
        Game game = getGameById(id);
        return games.remove(id, game);
    }

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(games.values());
    }
}
