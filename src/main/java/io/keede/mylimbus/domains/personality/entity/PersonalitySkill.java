package io.keede.mylimbus.domains.personality.entity;

import io.keede.mylimbus.domains.personality.enums.AttackType;
import io.keede.mylimbus.domains.personality.enums.Sin;
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

    private Sin sinType;

    private AttackType attackType;

    public PersonalitySkill(
            int skillSequence,
            Sin sinType,
            AttackType attackType
    ) {
        this.sinType = sinType;
        this.attackType = attackType;
    }

    public boolean isMatchSin(Sin sin) {
        return this.sinType == sin;
    }

}
