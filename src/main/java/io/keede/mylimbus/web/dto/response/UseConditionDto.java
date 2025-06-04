package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.personality.enums.Sin;

/**
 * @author keede
 * Created on 2025/05/02
 */
public record UseConditionDto(
        Long id,
        Sin sinType,
        int consumedQuantity
) {
}
