package io.keede.mylimbus.domains.personality.entity;

import io.keede.mylimbus.domains.personality.enums.PassiveCondition;
import io.keede.mylimbus.domains.personality.enums.PassiveType;
import io.keede.mylimbus.domains.personality.enums.Sin;
import io.keede.mylimbus.web.dto.response.PassiveDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author keede
 * Created on 2025/04/11
 */
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Passive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personality_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Personality personality;

    private Sin sin;

    @Column(name = "active_Condition_count")
    private int activeConditionCount;

    @Enumerated(EnumType.STRING)
    private PassiveType passiveType;

    private PassiveCondition passiveCondition;

    public Passive(
            Sin sin,
            int activeConditionCount,
            PassiveType passiveType,
            PassiveCondition passiveCondition
    ) {
        this.sin = sin;
        this.activeConditionCount = activeConditionCount;
        this.passiveType = passiveType;
        this.passiveCondition = passiveCondition;
    }

    public PassiveDto toDto() {
        return new PassiveDto(
                this.id,
                this.sin,
                this.activeConditionCount,
                this.passiveType,
                this.passiveCondition
        );
    }
}
