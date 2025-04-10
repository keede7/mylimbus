package io.keede.mylimbus.config;

import io.keede.mylimbus.domains.personality.entity.PersonalityKeyword;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PersonalityKeywordConverter
        implements AttributeConverter<PersonalityKeyword, String> {

    @Override
    public String convertToDatabaseColumn(PersonalityKeyword attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public PersonalityKeyword convertToEntityAttribute(String dbData) {
        return PersonalityKeyword.match(dbData);
    }
}
