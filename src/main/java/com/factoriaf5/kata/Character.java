package com.factoriaf5.kata;

public class Character {
    
    private int health;
    private int level;
    private boolean alive;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
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

    public void dealDamageTo(Character target, int damage) {
        if(this == target) {
            return;
        }
        target.receiveDamage(damage);
    }

    private void receiveDamage(int damage) {
        if(!alive) {
            return;
        }
        if(damage >= health) {
            health = 0;
            alive = false;
        } else {
            health -= damage;
        }
    }

    public void healDamageTo(Character target, int heal) {
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
