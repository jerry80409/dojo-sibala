package com.example.sibala;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

/**
 * 骰子
 */
@Getter
@Setter
@AllArgsConstructor(access = PROTECTED)
class Dice {

    private static final int DEFAULT_COUNT = 4;

    /**
     * 骰子的數字
     */
    private final List<Integer> numbers;
    /**
     * 幾個骰子
     */
    private Integer count;

    /**
     * constructor
     */
    Dice() {
        numbers = new ArrayList<>(DEFAULT_COUNT);
    }

    /**
     * constructor
     *
     * @param count
     */
    Dice(Integer count) {
        numbers = new ArrayList<>(count);
    }
}