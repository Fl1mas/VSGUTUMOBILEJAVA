package com.example.vsgutulabs.LB4.RussianRoulette;

import java.util.List;

public class Player {
    private String name;
    private int missedTurns;
    private int reloads;

    public Player(String name, int missedTurns, int reloads) {
        this.name = name;
        this.missedTurns = missedTurns;
        this.reloads = reloads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMissedTurns() {
        return missedTurns;
    }

    public void addMissedTurn() {
        missedTurns++;
    }

    public int getReloads() {
        return reloads;
    }

    public void addReload() {
        reloads++;
    }
}
