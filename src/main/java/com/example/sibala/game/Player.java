package com.example.sibala.game;

import lombok.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

/**
 * 玩家
 */
@Getter
@Setter
@Builder
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

}
