package com.example.sibala.game;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private Player convertor;

    @BeforeEach
    void setUp() {
        convertor = new Player();
    }

    @Test
    void one_from() {
        val player = convertor.oneFrom("Amy: 1 1 2 2");
        assertEquals("Amy", player.getName());
        assertEquals(new Dice(List.of(1, 1, 2, 2)), player.getDice());
    }

    @Test
    void list_from() {
        val players = convertor.listFrom("Amy: 1 1 2 2  Lin: 1 2 3 4");
        val amy = players.get(0);
        val lin = players.get(1);

        assertEquals("Amy", amy.getName());
        assertEquals(new Dice(List.of(1, 1, 2, 2)), amy.getDice());

        assertEquals("Lin", lin.getName());
        assertEquals(new Dice(List.of(1, 2, 3, 4)), lin.getDice());
    }
}