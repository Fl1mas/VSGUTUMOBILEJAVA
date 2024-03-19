package com.example.vsgutulabs.LB4.RussianRoulette;

import java.util.Random;


public class Revolver {
    private static final int NUM_CHAMBERS = 6;
    private static final int BULLET_CHAMBER = 0;
    private int[] chambers;
    private int currentChamber;
    private Random random;

    public Revolver() {
        chambers = new int[NUM_CHAMBERS];
        for (int i = 0;i < NUM_CHAMBERS; i++) {
            chambers[i] = (i == BULLET_CHAMBER) ? 1 : 0;
        }
        currentChamber = 0;
        random = new Random();
    }

    public boolean shoot() {
        if (chambers[currentChamber] == 1) {
            // Bullet in the chamber
            chambers[currentChamber] = 0;
            currentChamber = (currentChamber + 1) % NUM_CHAMBERS;
            return true;
        } else {
            // No bullet in the chamber
            currentChamber = (currentChamber + 1) % NUM_CHAMBERS;
            return false;
        }
    }
    public void reload() {
        // Reset the state of the chambers
        for (int i = 0; i < NUM_CHAMBERS; i++) {
            chambers[i] = 0;
        }

        // Place a bullet in a random chamber
        int randomChamber = random.nextInt(NUM_CHAMBERS);
        chambers[randomChamber] = 1;

        // Reset the current chamber to the first chamber
        currentChamber = 0;
    }
}

