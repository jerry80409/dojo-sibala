package com.example.sibala.game;

import lombok.*;

import static com.example.sibala.game.WinType.WIN;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

/**
 * 勝利玩家
 */
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
    @NonNull
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

    @Override
    public String toString() {
        if (WIN == winType) {
            return String.format("%s Wins. %s: %d", getName(), getDice().getDiceType(), point);
        } else {
            return "Tie.";
        }
    }
}
