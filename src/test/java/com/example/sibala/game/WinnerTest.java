package com.example.sibala.game;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.sibala.game.WinType.TIE;
import static com.example.sibala.game.WinType.WIN;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void test_to_string_win() {
        val winner = Winner.winnerBuilder()
            .name("Amy")
            .dice(new Dice(List.of(1, 1, 1, 1)))
            .winType(WIN)
            .point(1)
            .build();
        assertEquals("Amy Wins. ALL_THE_SAME_KIND: 1", winner.toString());
    }

    @Test
    void test_to_string_tie() {
        val winner = Winner.winnerBuilder()
            .name(null)
            .dice(new Dice(List.of(1, 1, 1, 1)))
            .winType(TIE)
            .point(0)
            .build();
        assertEquals("Tie.", winner.toString());
    }
}