package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

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
        assertEquals(0, Aerith.getLocation());
        assertEquals(20, Aerith.getMaxRange());
    }

    @Test
    public void whenMeleeCharacterIsCreatedDefaultStats() {
        Character Tifa = new MeleeCharacter();

        assertEquals(1000, Tifa.getHealth());
        assertEquals(1, Tifa.getLevel());
        assertTrue(Tifa.isAlive());
        assertEquals(0, Tifa.getLocation());
        assertEquals(2, Tifa.getMaxRange());
    }

    @Test
    public void whenNewCharacterIsCreatedNoFactionAssigned() {
        Character Aerith = new Character();

        assertTrue(Aerith.getFactions().isEmpty());
    }

    @Test
    public void aCharacterMayJoinAFaction() {
        Character Aerith = new Character();
        Faction Shinra = new Faction("Shinra");

        Aerith.joinFaction(Shinra);

        assertTrue(Aerith.getFactions().contains(Shinra));
    }

    @Test
    public void aCharacterMayBelongToOneOrMoreFactions() {
        Character Aerith = new Character();
        Faction Shinra = new Faction("Shinra");
        Faction ZanarkandAbes = new Faction("Zanarkand Abes");

        Aerith.joinFaction(ZanarkandAbes);
        Aerith.joinFaction(Shinra);

        assertEquals(2, Aerith.getFactions().size());
        assertTrue(Aerith.getFactions().containsAll(Set.of(ZanarkandAbes, Shinra)));
    }

    @Test
    public void aCharacterMayLeaveTheFaction() {
        Character Aerith = new Character();
        Faction Shinra = new Faction("Shinra");
        Faction ZanarkandAbes = new Faction("Zanarkand Abes");


        Aerith.joinFaction(Shinra);
        Aerith.joinFaction(ZanarkandAbes);
        Aerith.leaveFaction(Shinra);

        assertTrue(Aerith.getFactions().contains(ZanarkandAbes));
    }

    @Test
    public void charactersBelongingToTheSameFactionAreConsideredAllies() {
        Character Aerith = new Character();
        Character Tifa = new Character();
        Character Sephiroth = new Character();

        Faction Avalanche = new Faction("Avalanche");
        Faction Shinra = new Faction("Shinra");

        Aerith.joinFaction(Avalanche);
        Tifa.joinFaction(Avalanche);
        Sephiroth.joinFaction(Shinra);

        assertTrue(Aerith.isAllyOf(Tifa));
    }

    @Test
    public void charactersNotBelongingToTheSameFactionAreNotAllies() {
        Character Aerith = new Character();
        Character Tifa = new Character();
        Character Sephiroth = new Character();

        Faction Avalanche = new Faction("Avalanche");
        Faction Shinra = new Faction("Shinra");

        Aerith.joinFaction(Avalanche);
        Tifa.joinFaction(Avalanche);
        Sephiroth.joinFaction(Shinra);

        assertFalse(Aerith.isAllyOf(Sephiroth));
    }
}