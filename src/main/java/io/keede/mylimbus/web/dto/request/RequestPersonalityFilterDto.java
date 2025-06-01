package io.keede.mylimbus.web.dto.request;

import io.keede.mylimbus.domains.personality.entity.Affinity;
import io.keede.mylimbus.domains.personality.entity.AttackType;
import io.keede.mylimbus.domains.personality.entity.Sin;

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
        Affinity[] personalityAffinities,
        AttackType[] personalitySkillTypes,
        Sin[] personalitySkillSins
) {

    public List<Affinity> toAffinitiesEffects() {
        if(this.personalityAffinities == null || this.personalityAffinities.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(this.personalityAffinities)
                .map(Affinity::match)
                .filter(Objects::nonNull)
                .toList();
    }

    public List<AttackType> toSkillTypes() {
        if(this.personalitySkillTypes == null || this.personalitySkillTypes.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(this.personalitySkillTypes)
                .map(AttackType::match)
                .filter(Objects::nonNull)
                .toList();
    }

    public List<Sin> toSkillSin() {
        if(this.personalitySkillSins == null || this.personalitySkillSins.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(this.personalitySkillSins)
                .map(Sin::match)
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public String toString() {
        return "RequestPersonalityFilterDto{" +
                "personalityKRName='" + personalityKRName + '\'' +
                ", personalityAffinities=" + Arrays.toString(personalityAffinities) +
                ", personalitySkillTypes=" + Arrays.toString(personalitySkillTypes) +
                ", personalitySkillSins=" + Arrays.toString(personalitySkillSins) +
                '}';
    }
}
