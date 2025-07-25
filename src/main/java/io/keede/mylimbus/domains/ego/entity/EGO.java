package io.keede.mylimbus.domains.ego.entity;

import io.keede.mylimbus.domains.personality.enums.AttackType;
import io.keede.mylimbus.domains.personality.enums.Sin;
import io.keede.mylimbus.web.dto.response.GetEGOResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ego")
    private List<EGOUseCondition> egoUseConditions = new ArrayList<>();

    private Sin sin;

    public EGO(
            String characterName,
            String egoName,
            String imgUrl,
            RiskLevel riskLevel,
            Sin sin,
            AttackType attackType,
            List<EGOUseCondition> egoUseConditions
    ) {
        this.characterName = characterName;
        this.egoName = egoName;
        this.imgUrl = imgUrl;
        this.riskLevel = riskLevel;
        this.sin = sin;
        this.attackType = attackType;
//        this.egoUseConditions = egoUseConditions;
        this.egoUseConditions.addAll(egoUseConditions);
    }

    public GetEGOResponseDto toDto() {
        return new GetEGOResponseDto(
                this.id,
                this.egoName,
                this.sin,
                this.riskLevel,
                this.attackType,
                this.imgUrl,
                this.egoUseConditions
                        .stream()
                        .map(EGOUseCondition::toDto)
                        .toList()
        );
    }

    public void sync() {
        this.egoUseConditions.forEach(
                egoUseCondition -> egoUseCondition.sync(this)
        );
    }
}
