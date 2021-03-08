package com.example.sibala;

import lombok.Getter;

/**
 * 骰子類型
 */
enum DiceType {
    NO_POINT(0),
    NORMAL_POINT(1),
    ALL_THE_SAME_KIND(2);

    @Getter
    private int value;

    DiceType(int value) {
        this.value = value;
    }
}
