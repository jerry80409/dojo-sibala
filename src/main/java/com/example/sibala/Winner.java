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
class Winner extends Player {

    /**
     * 贏家的點數
     */
    private int point;

    /**
     * constructor
     *
     * @param name
     * @param dice
     */
    Winner(String name, List<Dice> dice) {
        super(name, dice);
    }
}
