package io.keede.mylimbus.web.dto.response;

import io.keede.mylimbus.domains.personality.entity.PersonalitySkill;

import java.time.LocalDate;
import java.util.Set;

/**
* @author keede
* Created on 2025/04/13
*/
public record GetPersonalityResponseDto(
    Long id,
    String baseName,
    String personalityName,
    int rarity,
    String defend,

    PersonalitySkill firstSkill,
    PersonalitySkill secondSkill,
    PersonalitySkill thirdSkill,
    Set<PassiveDto> passives,

    LocalDate releaseDate,
    String imgUrl
) {}

