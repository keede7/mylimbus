package io.keede.mylimbus.domains.personality.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/22
 */
@Getter
@AllArgsConstructor
public enum Affinity {

    BURN("화상"),
    BLEED("출혈"),
    TREMOR("진동"),
    RUPTURE("파열"),
    SINKING("침잠"),
    POISE("호흡"),
    CHARGE("충전"),
    NONE("일반")
    ;

    private final String name;

    public static Affinity match(String word) {
        return Arrays.stream(values())
                .filter(keyword -> keyword.name.equals(word))
                .findFirst()
                .orElse(null);
    }

    public static Affinity match(Affinity word) {
        return Arrays.stream(values())
                .filter(keyword -> keyword == word)
                .findFirst()
                .orElse(null);
    }

}
