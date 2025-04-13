package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.personality.entity.PassiveCondition;
import io.keede.mylimbus.domains.personality.entity.PassiveType;
import io.keede.mylimbus.domains.personality.entity.Sin;

public record PassiveDto(
        Long passiveId,
        Sin sin,
        int activeConditionCount,
        PassiveType passiveType,
        PassiveCondition passiveCondition
) {}
