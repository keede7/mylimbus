package io.keede.mylimbus.domains.ego.entity;

import io.keede.mylimbus.domains.personality.entity.AttackType;
import io.keede.mylimbus.domains.personality.entity.Sin;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Map;

/**
 * @author keede
 * Created on 2025/04/29
 */
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"egoUseConditions"})
public class EGO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String characterName;

    private String egoName;

    private String imgUrl;

    // 테스 알프레 등등
    private RiskLevel riskLevel;

    private AttackType attackType;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ego_id")
    private List<EGOUseCondition> egoUseConditions;

    public EGO(
            String characterName,
            String egoName,
            String imgUrl,
            RiskLevel riskLevel,
            AttackType attackType,
            List<EGOUseCondition> egoUseConditions
    ) {
        this.characterName = characterName;
        this.egoName = egoName;
        this.imgUrl = imgUrl;
        this.riskLevel = riskLevel;
        this.attackType = attackType;
        this.egoUseConditions = egoUseConditions;
    }
}
