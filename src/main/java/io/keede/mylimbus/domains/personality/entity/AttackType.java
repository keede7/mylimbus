package io.keede.mylimbus.domains.personality.entity;


import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/10
 */
@AllArgsConstructor
public enum AttackType {

    SLASH("참격"),
    PIERCE("관통"),
    BLUNT("타격"),
    ;

    private final String type;

    public static AttackType match(String type) {
        return Arrays.stream(values())
                .filter(attackType -> attackType.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    public String getType() {
        return this.type;
    }
}
