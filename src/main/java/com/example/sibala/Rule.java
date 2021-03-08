package com.example.sibala;

import java.util.List;

/**
 * 遊戲規則計算
 */
class Rule {

    /**
     * 計算分數
     *
     * @param dice
     * @return
     */
    int calPoint(List<Dice> dice) {
        return 0;
    }

    /**
     * 比大小
     *
     * @param players
     * @return
     */
    Winner compareTo(List<Player> players) {
        return new Winner(null, null, 0);
    }
}
