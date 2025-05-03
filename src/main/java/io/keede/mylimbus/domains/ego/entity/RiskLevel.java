package io.keede.mylimbus.domains.ego.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/29
 */
@Getter
@AllArgsConstructor
public enum RiskLevel {

    ZAYIN("ZAYIN"),
    HE("HE"),
    TETH("TETH"),
    WAW("WAW"),
    ALEPH("ALEPH");

    private String type;

    public static RiskLevel match(String type) {
        return Arrays.stream(values())
                .filter(riskLevel -> riskLevel.type.equals(type))
                .findFirst()
                .orElse(null);
    }

}
