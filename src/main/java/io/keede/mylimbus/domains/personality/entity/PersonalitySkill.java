package io.keede.mylimbus.domains.personality.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

@Embeddable
public final class PersonalitySkill {

    private int skillSequence;

    @Enumerated
    private Sin sin;

    @Enumerated
    private AttackType attackType;

}
