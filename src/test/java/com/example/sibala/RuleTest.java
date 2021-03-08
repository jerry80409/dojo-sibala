package com.example.sibala;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    private Rule rule;

    @BeforeEach
    void setUp() {
        rule = new Rule();
    }

    @Test
    void cal_point_all_the_same_kind() {
        int point = rule.calPoint(new Dice(Lists.list(1, 1, 1, 1)));
        assertEquals(1, point);
    }

    @Test
    void cal_point_normal_point_two_pair() {
        int point = rule.calPoint(new Dice(Lists.list(1, 1, 2, 2)));
        assertEquals(4, point);
    }

    @Test
    void cal_point_normal_point() {
        int point = rule.calPoint(new Dice(Lists.list(1, 2, 3, 3)));
        assertEquals(3, point);
    }

    @Test
    void cal_point_no_point_1() {
        int point = rule.calPoint(new Dice(Lists.list(1, 2, 3, 4)));
        assertEquals(0, point);
    }

    @Test
    void cal_point_no_point_2() {
        int point = rule.calPoint(new Dice(Lists.list(1, 1, 1, 2)));
        assertEquals(0, point);
    }
}