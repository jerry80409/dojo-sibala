package com.example.sibala.game;

import lombok.Getter;

/**
 * 勝利類型
 */
enum WinType {
    TIE(0),
    WIN(1);

    @Getter
    private final int value;

    WinType(int value) {
        this.value = value;
    }
}
