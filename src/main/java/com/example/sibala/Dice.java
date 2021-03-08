package com.example.sibala;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.util.List;
import java.util.function.Function;

import static com.example.sibala.DiceType.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 骰子
 */
@Getter
@Setter
class Dice {

    private static final int ALL_THE_SAME = 1;

    private final int diceCount;

    private final List<Integer> numbers;

    /**
     * constructor
     *
     * @param numbers
     */
    Dice(List<Integer> numbers) {
        this.numbers = numbers;
        this.diceCount = numbers.size();
    }

    /**
     * 依據骰子點數, 取得類型
     *
     * @return
     */
    DiceType getDiceType() {
        val diceTypeMap = numbers.stream().collect(groupingBy(Function.identity(), counting()));
        val diceTypeCount = diceTypeMap.size();

        // 清一色
        if (ALL_THE_SAME == diceTypeCount) {
            return ALL_THE_SAME_KIND;
        }

        // 沒有點數 (1, 2, 3, 4)
        if (diceCount == diceTypeCount) {
            return NO_POINT;
        }

        // 沒有點數 (1, 1, 1, 2)
        val threeTheSame = diceTypeMap.entrySet().stream().anyMatch(entry -> 3 == entry.getValue());
        if (threeTheSame) {
            return NO_POINT;
        }

        return NORMAL_POINT;
    }
}