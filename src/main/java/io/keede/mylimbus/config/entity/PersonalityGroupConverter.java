package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.enums.PersonalityGroup;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class PersonalityGroupConverter
        implements AttributeConverter<List<PersonalityGroup>, String> {

    @Override
    public String convertToDatabaseColumn(List<PersonalityGroup> attribute) {

        return attribute.stream()
                .map(PersonalityGroup::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public List<PersonalityGroup> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(", "))
                .map(PersonalityGroup::match)
                .toList();
    }
}
