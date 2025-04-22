package io.keede.mylimbus.web.dto.request;

import io.keede.mylimbus.domains.personality.entity.AttackType;
import io.keede.mylimbus.domains.personality.entity.PersonalityKeyword;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author keede
 * Created on 2025/04/22
 */
public record RequestPersonalityFilterDto(
        String personalityKRName,
        PersonalityKeyword[] personalityAttackKeyword,
        AttackType[] personalityAttackTypes
) {

    public List<PersonalityKeyword> toAttackKeyword() {
        if(this.personalityAttackKeyword == null || this.personalityAttackKeyword.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(this.personalityAttackKeyword)
                .map(PersonalityKeyword::match)
                .filter(Objects::nonNull)
                .toList();
    }

    public List<AttackType> toSkillKeyword() {
        if(this.personalityAttackTypes == null || this.personalityAttackTypes.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(this.personalityAttackTypes)
                .map(AttackType::match)
                .filter(Objects::nonNull)
                .toList();
    }
}
