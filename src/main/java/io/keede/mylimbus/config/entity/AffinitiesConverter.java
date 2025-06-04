package io.keede.mylimbus.config.entity;

import io.keede.mylimbus.domains.personality.enums.Affinity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 인격 키워드로 사용 Affinity
 * @author keede
 * Created on 2025/05/13
 */
@Converter(autoApply = true)
public class AffinitiesConverter
        implements AttributeConverter<Set<Affinity>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Affinity> attribute) {

        return attribute == null || attribute.isEmpty() ? "" : attribute.stream()
                .map(Affinity::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Set<Affinity> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(", "))
                .map(Affinity::match)
                .collect(Collectors.toSet());
    }
}
