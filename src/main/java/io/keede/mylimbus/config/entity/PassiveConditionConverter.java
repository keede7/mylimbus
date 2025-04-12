package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.entity.PassiveCondition;
import io.keede.mylimbus.domains.personality.entity.Sin;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author keede
 * Created on 2025/04/11
 */
@Converter(autoApply = true)
public class PassiveConditionConverter
        implements AttributeConverter<PassiveCondition, String> {

    @Override
    public String convertToDatabaseColumn(PassiveCondition attribute) {
        return attribute != null ? attribute.getType() : null;
    }

    @Override
    public PassiveCondition convertToEntityAttribute(String dbData) {
        return PassiveCondition.match(dbData);
    }

}
