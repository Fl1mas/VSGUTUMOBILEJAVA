package com.example.vsgutulabs.LB4.RussianRoulette;

import java.util.Random;

public class Revolver {
    private boolean[] chambers;
    private int currentChamber;
    private Random random;

    public Revolver(int numChambers) {
        this.chambers = new boolean[numChambers];
        this.currentChamber = 0;
        this.random = new Random();
        // Load one chamber with a bullet
        this.chambers[random.nextInt(numChambers)] = true;
    }

    public boolean spin() {
        this.currentChamber = (this.currentChamber + 1) % this.chambers.length;
        return this.chambers[currentChamber];
    }

    public boolean shoot() {
        boolean hasBullet = this.spin();
        if (hasBullet) {
            this.chambers[currentChamber] = false;
            return true;
        }
        return false;
    }

    public void reload() {
        this.chambers[random.nextInt(chambers.length)] = true;
    }
}
