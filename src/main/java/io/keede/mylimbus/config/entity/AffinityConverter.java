package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.entity.Affinity;
import io.keede.mylimbus.domains.personality.entity.PersonalityKeyword;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keede
 * Created on 2025/04/22
 */
@Converter(autoApply = true)
public class AffinityConverter
        implements AttributeConverter<Affinity, String> {

    @Override
    public String convertToDatabaseColumn(Affinity attribute) {

        return attribute.getName();
    }

    @Override
    public Affinity convertToEntityAttribute(String dbData) {
        return Affinity.match(dbData);
    }
}
