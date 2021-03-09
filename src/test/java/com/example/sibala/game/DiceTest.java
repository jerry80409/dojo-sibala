package com.example.sibala.game;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.sibala.game.DiceType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceTest {

    @Test
    void get_dice_type_all_the_same_kind() {
        val dice = new Dice(List.of(1, 1, 1, 1));
        assertEquals(ALL_THE_SAME_KIND, dice.getDiceType());
    }

    @Test
    void get_dice_type_no_point_1() {
        val dice = new Dice(List.of(1, 2, 3, 4));
        assertEquals(NO_POINT, dice.getDiceType());
    }

    @Test
    void get_dice_type_no_point_2() {
        val dice = new Dice(List.of(1, 1, 1, 2));
        assertEquals(NO_POINT, dice.getDiceType());
    }

    @Test
    void get_dice_type_normal_point_1() {
        val dice = new Dice(List.of(1, 1, 2, 2));
        assertEquals(NORMAL_POINT, dice.getDiceType());
    }

    @Test
    void get_dice_type_normal_point_2() {
        val dice = new Dice(List.of(1, 2, 2, 1));
        assertEquals(NORMAL_POINT, dice.getDiceType());
    }
}