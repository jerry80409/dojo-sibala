package com.example.sibala;

import lombok.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PROTECTED)
class Winner extends Player {

    /**
     * 贏家的點數
     */
    private int point;

    /**
     * 贏的類型
     */
    private WinType winType;

    /**
     * constructor
     *
     * @param name
     * @param dice
     */
    @Builder(builderMethodName = "winnerBuilder")
    Winner(String name, Dice dice, int point, WinType winType) {
        super(name, dice);
        this.point = point;
        this.winType = winType;
    }
}
