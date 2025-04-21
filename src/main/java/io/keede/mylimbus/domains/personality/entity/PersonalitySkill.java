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

    private Sin sinType;

    private AttackType attackType;

    public PersonalitySkill(
            int skillSequence,
            Sin sinType,
            AttackType attackType
    ) {
//        this.skillSequence = skillSequence;
        this.sinType = sinType;
        this.attackType = attackType;
    }

    public boolean isMatchSin(Sin sin) {
        return this.sinType == sin;
    }

}
