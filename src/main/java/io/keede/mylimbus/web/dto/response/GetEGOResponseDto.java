package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.ego.entity.RiskLevel;
import io.keede.mylimbus.domains.personality.enums.AttackType;
import io.keede.mylimbus.domains.personality.enums.Sin;

import java.util.List;

/**
 * @author keede
 * Created on 2025/05/02
 */
public record GetEGOResponseDto (
        Long id,
        String egoName,
        Sin sinType,
        RiskLevel riskLevel,
        AttackType attackType,
        String imgUrl,
        List<UseConditionDto> useConditions
) {
}
