package com.turkcell.service.impl;

import com.turkcell.model.Player;
import com.turkcell.service.PlayerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerServiceImpl implements PlayerService {

    private Map<Integer,Player> players;

    public PlayerServiceImpl() {
        players = new HashMap<>();
    }

    @Override
    public Player getPlayerById(int id) {
        return players.get(id);
    }

    @Override
    public Player addPlayer(Player player) {
        return players.put(player.getId(), player);
    }

    @Override
    public Player updatePlayerById(int id, Player player) {
        Player temp = getPlayerById(id);
        temp.setBirthYear(player.getBirthYear());
        temp.setFirstName(player.getFirstName());
        temp.setLastName(player.getLastName());
        temp.setNationalIdentity(player.getNationalIdentity());
        players.put(temp.getId(), temp);

        return temp;
    }

    @Override
    public boolean deletePlayerById(int id) {
        Player player = getPlayerById(id);
        return players.remove(id,player);
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }
}
