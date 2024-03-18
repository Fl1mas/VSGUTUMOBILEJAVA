package com.example.vsgutulabs.LB4.RussianRoulette;

public class Revolver {
    private int chamber;
    private int bullets;
    private final int MAX_BULLETS = 6;

    public Revolver(int chamber, int bullets) {
        this.chamber = chamber;
        this.bullets = bullets;
    }

    public void load() {
        if (bullets < MAX_BULLETS) {
            bullets++;
        } else {
            System.out.println("The cylinder is already full.");
        }
    }

    public void reload() {
        if (bullets < MAX_BULLETS) {
            bullets++;
            System.out.println("Reloading...");
            nextChamber();
        } else {
            System.out.println("The cylinder is already full.");
        }
    }

    public void nextChamber() {
        chamber = (chamber + 1) % MAX_BULLETS;
    }

    public boolean isLoaded() {
        return bullets > 0 && chamber == 0;
    }

    public boolean fire() {
        if (isLoaded()) {
            bullets--;
            System.out.println("Bang!");
        } else {
            System.out.println("Click!");
        }
        nextChamber();
        return false;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getChamber() {
        return chamber;
    }

    public void setChamber(int chamber) {
        this.chamber = chamber;
    }
}