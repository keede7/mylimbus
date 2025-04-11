package io.keede.mylimbus.domains.personality.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class PersonalitySkill {

//    private int skillSequence;

    private Sin sin;

    private AttackType attackType;

    public PersonalitySkill(
            int skillSequence,
            Sin sin,
            AttackType attackType
    ) {
//        this.skillSequence = skillSequence;
        this.sin = sin;
        this.attackType = attackType;
    }

}
