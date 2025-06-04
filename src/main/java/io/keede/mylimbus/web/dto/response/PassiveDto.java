package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.personality.enums.PassiveCondition;
import io.keede.mylimbus.domains.personality.enums.PassiveType;
import io.keede.mylimbus.domains.personality.enums.Sin;

public record PassiveDto(
        Long passiveId,
        Sin sin,
        int activeConditionCount,
        PassiveType passiveType,
        PassiveCondition passiveCondition
) {}
