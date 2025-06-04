package io.keede.mylimbus.domains.ego.entity;

import io.keede.mylimbus.domains.personality.enums.Sin;
import io.keede.mylimbus.web.dto.response.UseConditionDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author keede
 * Created on 2025/04/30
 */
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ego_use_condition")
@ToString(exclude = {"ego"})
public class EGOUseCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private EGO ego;

    private Sin sinType;

    private int consumedQuantity;

    public EGOUseCondition(
            Sin sinType,
            int consumedQuantity
    ) {
        this.sinType = sinType;
        this.consumedQuantity = consumedQuantity;
    }

    public UseConditionDto toDto() {
        return new UseConditionDto(
                this.id,
                this.sinType,
                this.consumedQuantity
        );
    }
}
