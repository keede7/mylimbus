package io.keede.mylimbus.domains.ego.entity;

import io.keede.mylimbus.domains.personality.entity.AttackType;

import java.util.Map;

/**
 * @author keede
 * Created on 2025/04/29
 */
public class EGO {

    private Long id;

    private String characterName;

    private String egoName;

    private String imgUrl;

    // 테스 알프레 등등
    private RiskLevel riskLevel;

    private AttackType attackType;

    // 필요한 자원
    private Map<String, Integer> useCondition;

    public EGO(
            String characterName,
            String egoName,
            String imgUrl,
            RiskLevel riskLevel,
            AttackType attackType,
            Map<String, Integer> useCondition
    ) {
        this.characterName = characterName;
        this.egoName = egoName;
        this.imgUrl = imgUrl;
        this.riskLevel = riskLevel;
        this.attackType = attackType;
        this.useCondition = useCondition;
    }
}
