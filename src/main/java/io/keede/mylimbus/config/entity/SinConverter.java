package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.entity.Sin;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author keede
 * Created on 2025/04/11
 */
@Converter(autoApply = true)
public class SinConverter
        implements AttributeConverter<Sin, String> {

    @Override
    public String convertToDatabaseColumn(Sin attribute) {
        return attribute != null ? attribute.getType() : null;
    }

    @Override
    public Sin convertToEntityAttribute(String dbData) {
        return Sin.match(dbData);
    }

}
