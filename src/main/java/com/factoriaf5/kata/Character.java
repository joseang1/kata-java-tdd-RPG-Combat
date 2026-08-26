package com.factoriaf5.kata;

import java.util.HashSet;
import java.util.Set;

public class Character {
    
    private int health;
    private int level;
    private boolean alive;
    protected int maxRange;
    private int location;
    private Set<Faction> factions;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
        this.location = 0;
        this.factions = new HashSet<>();
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getLocation() {
        return location;
    }

    public Set<Faction> getFactions() {
        return factions;
    }

    public void dealDamageTo(Character target, int damage) {
        if(this == target) {
            return;
        }
        if (Math.abs(this.getLocation() - target.getLocation()) > this.getMaxRange()) {
            return;
        }
        if(this.isAllyOf(target)) {
            return;
        }
        if (target.getLevel() - this.getLevel() >= 5) {
            target.receiveDamage(damage /2);
        } else if (target.getLevel() - this.getLevel() <= -5) {
            target.receiveDamage(damage + damage /2);
        } else {
            target.receiveDamage(damage);
        }
    }

    private void receiveDamage(int damage) {
        if(!alive) {
            return;
        }
        if(damage >= health) {
            health = 0;
            alive = false;
        } else {
            health -= damage; /* health = health - damage */
        }
    }

    public void healDamageTo(Character target, int heal) {
        if(this != target && !this.isAllyOf(target)) {
            return;
        }
        target.receiveHealing(heal);
    }

    private void receiveHealing(int heal) {
        if(!alive) {
            return;
        }
        if(heal + health >= 1000) {
            health = 1000;
        } else {
            health += heal;
        }
    }

    public void joinFaction(Faction faction) {
        factions.add(faction);
    }

    public void leaveFaction(Faction faction) {
        factions.remove(faction);
    }

    public boolean isAllyOf(Character target) {
        for(Faction faction : factions) {
            if(target.getFactions().contains(faction)) {
                return true;
            }
        }
        return false;
    }

    public int maxRange(Character target, int range) {
        return range;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setFactions(Set<Faction> factions) {
        this.factions = factions;
    }
}
