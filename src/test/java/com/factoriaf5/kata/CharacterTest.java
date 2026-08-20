package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

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
    public void whenRangedCharacterIsCreatedDefaultStats() {
        Character Aerith = new RangedCharacter();

        assertEquals(1000, Aerith.getHealth());
        assertEquals(1, Aerith.getLevel());
        assertTrue(Aerith.isAlive());
        assertEquals(1, Aerith.getLocation());
        assertEquals(20, Aerith.getMaxRange());
    }

    @Test
    public void whenMeleeCharacterIsCreatedDefaultStats() {
        Character Tifa = new MeleeCharacter();

        assertEquals(1000, Tifa.getHealth());
        assertEquals(1, Tifa.getLevel());
        assertTrue(Tifa.isAlive());
        assertEquals(1, Tifa.getLocation());
        assertEquals(2, Tifa.getMaxRange());
    }
}