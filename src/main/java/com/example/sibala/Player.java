package com.example.sibala;

import lombok.*;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

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
    private List<Dice> dice;
}
