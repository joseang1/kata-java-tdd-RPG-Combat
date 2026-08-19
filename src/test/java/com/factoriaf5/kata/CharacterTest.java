package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void whenCharacterIsCreatedDefaultStats() {
        Character character = new Character();

        assertEquals(1000, character.getHealth());
        assertEquals(1, character.getLevel());
        assertTrue(character.isAlive());
    }

    @Test
    public void whenDamageDealtHealthDecrease() {
        Character attacker = new Character();
        Character target = new Character();
        
        attacker.dealDamageTo(target, 300);

        assertEquals(700, target.getHealth());
        assertTrue(target.isAlive());
    }
}
