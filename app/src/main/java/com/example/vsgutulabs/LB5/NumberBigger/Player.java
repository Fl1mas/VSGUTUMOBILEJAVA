package com.example.vsgutulabs.LB5.NumberBigger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Player implements Serializable {
    private String name;
    private List<Integer> cards;
    private int pickcard;
    private int score;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.pickcard = 0;
        this.score = 0;
        Set<Integer> uniqueCards = new HashSet<>();
        Random random = new Random();
        while (uniqueCards.size() < 5) {
            uniqueCards.add(random.nextInt(20) + 1);
        }
        this.cards.addAll(uniqueCards);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public int getPickcard() {
        return pickcard;
    }

    public void setPickcard(int pickcard) {
        this.pickcard = pickcard;
    }

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    public void removeCard(int card) {
        cards.remove(Integer.valueOf(card));
    }
}
