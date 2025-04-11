package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.entity.AttackType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author keede
 * Created on 2025/04/11
 */
@Converter(autoApply = true)
public class AttackTypeConverter
        implements AttributeConverter<AttackType, String> {

    @Override
    public String convertToDatabaseColumn(AttackType attribute) {
        return attribute != null ? attribute.getType() : null;
    }

    @Override
    public AttackType convertToEntityAttribute(String dbData) {
        return AttackType.match(dbData);
    }

}
