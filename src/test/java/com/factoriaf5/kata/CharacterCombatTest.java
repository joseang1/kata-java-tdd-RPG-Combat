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
        target.healDamageTo(target, 200);

        assertEquals(400, target.getHealth());
    }

    @Test
    public void healingCannotExceedHealth1000() {
        
        target.setHealth(800);
        target.healDamageTo(target, 400);

        assertEquals(1000, target.getHealth());
    }
    
    @Test
    public void deadCharactersCannotBeHealed() {

        attacker.dealDamageTo(target, 1000);
        attacker.healDamageTo(target, 100);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void cannotDealDamageToItself() {

        attacker.dealDamageTo(attacker, 100);

        assertEquals(1000, attacker.getHealth());
    }
    
    @Test
    public void cannotHealOthers() {

        attacker.setHealth(800);
        target.healDamageTo(attacker, 100);

        assertEquals(800, attacker.getHealth());
    }

    @Test
    public void damageReducedFiftyPercentAttacker5LevelsAbove() {

        attacker.setLevel(3);
        target.setLevel(8);

        attacker.dealDamageTo(target, 200);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void damageRisedFiftyPercentTarget5LevelsBelow() {

        attacker.setLevel(8);
        target.setLevel(3);

        attacker.dealDamageTo(target, 100);

        assertEquals(850, target.getHealth());
    }

    @Test
    public void ifTargetOutOfRangeMeleeNoDamageDealt() {
        Character attacker = new MeleeCharacter();
        Character target = new Character();

        target.setLocation(5);

        attacker.dealDamageTo(target, 100);

        assertEquals(1000, target.getHealth());
    }

    @Test
    public void ifTargetInRangeMeleeDamageIsDealt() {
        Character attacker = new MeleeCharacter();
        Character target = new Character();

        target.setLocation(1);

        attacker.dealDamageTo(target, 100);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void ifTargetInRangeRangedDamageIsDealt() {
        Character attacker = new RangedCharacter();
        Character target = new Character();

        target.setLocation(20);

        attacker.dealDamageTo(target, 100);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void ifTargetIsOutOfRangeRangedDamageIsDealt() {
        Character attacker = new RangedCharacter();
        Character target = new Character();

        target.setLocation(21);
        attacker.dealDamageTo(target, 100);

        assertEquals(1000, target.getHealth());
    }
}
