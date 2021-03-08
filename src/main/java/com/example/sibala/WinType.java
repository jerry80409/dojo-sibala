package com.example.sibala;

import lombok.Getter;

enum WinType {
    TIE(0),
    WIN(1);

    @Getter
    private final int value;

    WinType(int value) {
        this.value = value;
    }
}
