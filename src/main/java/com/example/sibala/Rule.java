package com.example.sibala;

import lombok.NonNull;
import lombok.val;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

import static com.example.sibala.DiceType.ALL_THE_SAME_KIND;
import static com.example.sibala.DiceType.NORMAL_POINT;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 遊戲規則計算
 */
class Rule {

    private static final int ZERO_POINT = 0;

    /**
     * 計算分數
     *
     * @param dice
     * @return
     */
    int calPoint(@NonNull Dice dice) {
        // all_the_same_kind 取第一個骰子點數
        if (ALL_THE_SAME_KIND == dice.getDiceType()) {
            return dice.getNumbers().get(0);
        }

        if (NORMAL_POINT == dice.getDiceType()) {
            val pointCountMap = dice.getNumbers().stream().collect(groupingBy(Function.identity(), counting()));
            val diffDiceTypeCount = pointCountMap.size();

            // Dice(1, 1, 2, 2) -> return 2 + 2 = 4
            int twoPair = 2;
            if (twoPair == diffDiceTypeCount) {
                val maxPair = pointCountMap.entrySet().stream()
                    .max(Comparator.comparingInt(Entry::getKey))
                    .orElseGet(() -> pointCountMap.entrySet().stream().findFirst().get());
                return maxPair.getKey() * maxPair.getValue().intValue();

            } else {
                // Dice(3, 3, 1, 2) -> return 1 + 2 = 3
                return pointCountMap.entrySet().stream()
                    .filter(entry -> 1 == entry.getValue())
                    .map(Entry::getKey)
                    .reduce(0, Integer::sum);
            }
        }

        return ZERO_POINT;
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
