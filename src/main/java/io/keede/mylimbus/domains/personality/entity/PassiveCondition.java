package io.keede.mylimbus.domains.personality.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/11
 */
@Getter
@AllArgsConstructor
public enum PassiveCondition {

    POSSESSION("보유"),
    RESONANCE("공명"),
    ;

    private final String type;

    public static PassiveCondition match(String type) {
        return Arrays.stream(values())
                .filter(condition -> condition.type.equals(type))
                .findFirst()
                .orElse(null);
    }

}
