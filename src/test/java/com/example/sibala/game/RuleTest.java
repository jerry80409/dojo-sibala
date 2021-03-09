package com.example.sibala.game;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.sibala.game.WinType.TIE;
import static com.example.sibala.game.WinType.WIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleTest {

    private Rule rule;

    @BeforeEach
    void setUp() {
        rule = new Rule();
    }

    @Test
    void cal_point_all_the_same_kind() {
        int point = rule.calPoint(new Dice(List.of(1, 1, 1, 1)));
        assertEquals(1, point);
    }

    @Test
    void cal_point_normal_point_two_pair() {
        int point = rule.calPoint(new Dice(List.of(1, 1, 2, 2)));
        assertEquals(4, point);
    }

    @Test
    void cal_point_normal_point() {
        int point = rule.calPoint(new Dice(List.of(1, 2, 3, 3)));
        assertEquals(3, point);
    }

    @Test
    void cal_point_no_point_1() {
        int point = rule.calPoint(new Dice(List.of(1, 2, 3, 4)));
        assertEquals(0, point);
    }

    @Test
    void cal_point_no_point_2() {
        int point = rule.calPoint(new Dice(List.of(1, 1, 1, 2)));
        assertEquals(0, point);
    }

    @Test
    void compare_to_first_player_win_no_point() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(2, 2, 2, 2)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(1, 2, 3, 4)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals("Amy", winner.getName());
        assertEquals(2, winner.getPoint());
        assertEquals(WIN, winner.getWinType());
    }

    @Test
    void compare_to_first_player_win_all_kind_the_same() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(2, 2, 2, 2)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(1, 1, 1, 1)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals("Amy", winner.getName());
        assertEquals(2, winner.getPoint());
        assertEquals(WIN, winner.getWinType());
    }

    @Test
    void compare_to_first_player_win_normal_point() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(2, 3, 4, 4)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(1, 2, 3, 3)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals("Amy", winner.getName());
        assertEquals(5, winner.getPoint());
        assertEquals(WIN, winner.getWinType());
    }

    @Test
    void compare_to_first_player_win_two_pair() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(3, 3, 4, 4)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(1, 1, 3, 3)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals("Amy", winner.getName());
        assertEquals(8, winner.getPoint());
        assertEquals(WIN, winner.getWinType());
    }

    @Test
    void compare_to_second_player_win_no_point() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(1, 2, 3, 4)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(1, 1, 2, 2)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals("Lin", winner.getName());
        assertEquals(4, winner.getPoint());
        assertEquals(WIN, winner.getWinType());
    }

    @Test
    void compare_to_balance_no_point() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(1, 2, 3, 4)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(2, 3, 4, 5)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals(0, winner.getPoint());
        assertEquals(TIE, winner.getWinType());
    }

    @Test
    void compare_to_balance_two_pair() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(2, 2, 3, 3)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(2, 3, 2, 3)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals(6, winner.getPoint());
        assertEquals(TIE, winner.getWinType());
    }

    @Test
    void compare_to_balance_normal_point() {
        val first = Player.builder().name("Amy")
            .dice(new Dice(List.of(2, 2, 3, 4)))
            .build();

        val second = Player.builder().name("Lin")
            .dice(new Dice(List.of(3, 3, 5, 2)))
            .build();

        val winner = rule.compareTo(List.of(first, second));
        assertEquals(7, winner.getPoint());
        assertEquals(TIE, winner.getWinType());
    }
}