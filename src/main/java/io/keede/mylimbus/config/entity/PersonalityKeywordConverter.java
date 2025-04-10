package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.entity.PersonalityKeyword;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class PersonalityKeywordConverter
        implements AttributeConverter<List<PersonalityKeyword>, String> {

    @Override
    public String convertToDatabaseColumn(List<PersonalityKeyword> attribute) {

        return attribute.stream()
                .map(PersonalityKeyword::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public List<PersonalityKeyword> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(", "))
                .map(PersonalityKeyword::match)
                .toList();
    }
}
