package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.personality.entity.Sin;

public record UseConditionDto(
        Long id,
        Sin sin,
        int consumedQuantity
) {
}
