package io.keede.mylimbus.domains.personality.enums;


import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/10
 */
@AllArgsConstructor
public enum Sin {

    WRATH("분노"),
    LUST("색욕"),
    SLOTH("나태"),
    GLUTTONY("탐식"),
    GLOOM("우울"),
    PRIDE("오만"),
    ENVY("질투"),
    ;

    private final String type;

    public static Sin match(String type) {
        return Arrays.stream(values())
                .filter(sin -> sin.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    public static Sin match(Sin type) {
        return Arrays.stream(values())
                .filter(sin -> sin == type)
                .findFirst()
                .orElse(null);
    }

    public String getType() {
        return this.type;
    }
}
