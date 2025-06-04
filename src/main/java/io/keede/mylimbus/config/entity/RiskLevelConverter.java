package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.ego.entity.RiskLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author keede
 * Created on 2025/05/02
 */
@Converter(autoApply = true)
public class RiskLevelConverter
        implements AttributeConverter<RiskLevel, String> {

    @Override
    public String convertToDatabaseColumn(RiskLevel attribute) {
        return attribute != null ? attribute.getType() : null;
    }

    @Override
    public RiskLevel convertToEntityAttribute(String dbData) {
        return RiskLevel.match(dbData);
    }

}
