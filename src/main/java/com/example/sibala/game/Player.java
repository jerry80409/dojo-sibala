package com.example.sibala.game;

import lombok.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

/**
 * 玩家
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PROTECTED)
class Player {

    /**
     * 玩家名字
     */
    private String name;

    /**
     * 骰子
     */
    private Dice dice;

    /**
     * 轉換 from input
     *
     * @param str example: Amy: 1 1 2 2
     * @return player
     */
    public Player oneFrom(String str) {
        val nameAndDice = str.split(":");
        val diceArray = str.split(":")[1].replaceAll("^\\s+", "").split("\\s+");
        val diceList = Stream.of(diceArray).map(Integer::parseInt).collect(toList());

        return Player.builder()
            .name(nameAndDice[0])
            .dice(new Dice(diceList))
            .build();
    }

    /**
     * 轉換 from input
     *
     * @param str example: Amy: 1 1 2 2__Lin: 1 2 3 4
     * @return List collection of players
     */
    public List<Player> listFrom(String str) {
        val twoSpaceRegex = " {2}";
        return Stream.of(str.split(twoSpaceRegex)).map(this::oneFrom).collect(toList());
    }
}
