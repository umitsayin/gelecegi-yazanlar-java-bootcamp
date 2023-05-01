package com.turkcell.model;

import java.time.LocalDate;
import java.util.List;

public class Sale {
    private int id;
    private List<Game> games;
    private Player player;
    private LocalDate saleDate;

    public Sale() {
    }

    public Sale(int id, List<Game> games, Player player, LocalDate saleDate) {
        this.id = id;
        this.games = games;
        this.player = player;
        this.saleDate = saleDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
