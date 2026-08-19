package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterCombatTest {
    private Character attacker;
    private Character target;

    @BeforeEach
    void setup() {
        attacker = new Character();
        target = new Character();
    }


    @Test
    public void whenDamageDealtHealthDecrease() {
        
        attacker.dealDamageTo(target, 300);

        assertEquals(700, target.getHealth());
        assertTrue(target.isAlive());
    }

    @Test
    public void whenDamageEqualsHealthTargetDiesWithZeroHealth() {

        attacker.dealDamageTo(target, 1000);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void whenDamageExceedsHealthTargetDiesWithZeroHealth() {

        attacker.dealDamageTo(target, 1001);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void healingDamage() {

        target.setHealth(200);
        attacker.healDamageTo(target, 200);

        assertEquals(400, target.getHealth());
    }

    @Test
    public void healingCannotExceedHealth1000() {
        
        target.setHealth(800);
        attacker.healDamageTo(target, 400);

        assertEquals(1000, target.getHealth());
    }
    
    @Test
    public void deadCharactersCannotBeHealed() {

        target.setAlive(false);
        attacker.healDamageTo(target, 100);

        assertFalse(target.isAlive());
    }
}
