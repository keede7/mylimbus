package io.keede.mylimbus.domains.personality.entity;

import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personality_keywords")
    private List<PersonalityKeyword> keywords;

    @Column(name = "base_name")
    private String baseName;

    @Column(nullable = false, name = "personality_name")
    private String personalityName; // 인격 이름

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "first_skill_sequence")),
                    @AttributeOverride(name = "sinType", column = @Column(name = "first_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "first_skill_attack_type")),
            }
    )
    private PersonalitySkill firstSkill;

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "second_skill_sequence")),
                    @AttributeOverride(name = "sinType", column = @Column(name = "second_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "second_skill_attack_type")),
            }
    )
    private PersonalitySkill secondSkill;

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "third_skill_sequence")),
                    @AttributeOverride(name = "sinType", column = @Column(name = "third_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "third_skill_attack_type")),
            }
    )
    private PersonalitySkill thirdSkill;

    private Affinity affinity;

    private int rarity;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "personality")
    private Set<Passive> passives = new HashSet<>();

    private String defend;

    private LocalDate releaseDate;

    private String imgUrl;

    public Personality(
            int rarity,
            String baseName,
            String personalityName,
            List<PersonalityKeyword> keywords,
            PersonalitySkill firstSkill,
            PersonalitySkill secondSkill,
            PersonalitySkill thirdSkill,
            Affinity affinity,
            String defend,
            Set<Passive> passives,
            LocalDate releaseDate,
            String imgUrl
    ) {
        this.rarity = rarity;
        this.baseName = baseName;
        this.personalityName = personalityName;
        this.keywords = keywords;
        this.firstSkill = firstSkill;
        this.secondSkill = secondSkill;
        this.thirdSkill = thirdSkill;
        this.affinity = affinity;
        this.defend = defend;
        this.passives.addAll(passives);
        this.releaseDate = releaseDate;
        this.imgUrl = imgUrl;
    }

    public GetPersonalityResponseDto toDto() {
        return new GetPersonalityResponseDto(
                this.id,
                this.baseName,
                this.personalityName,
                this.rarity,
                this.defend,
                this.firstSkill,
                this.secondSkill,
                this.thirdSkill,
                this.affinity,
                this.passives.stream()
                        .map(Passive::toDto)
                        .collect(Collectors.toSet()),
                this.releaseDate,
                this.imgUrl
        );
    }

    public boolean isMatchKeyword(String keyword) {
        return this.keywords
                .stream()
                .anyMatch(personalityKeyword -> keyword.contains(personalityKeyword.getName()));
    }

    public boolean isMatchAffinity(List<Affinity> targetAffinities) {
        if(targetAffinities.isEmpty()) {
            return true;
        }

        return targetAffinities.stream()
                .anyMatch(targetAffinity -> this.affinity == targetAffinity);
    }

    public boolean isMatchSkillSin(Sin sin) {
        return this.firstSkill.isMatchSin(sin)
                || this.secondSkill.isMatchSin(sin)
                || this.thirdSkill.isMatchSin(sin);
    }

    public boolean isMatchSkillSin(List<Sin> sins) {
        if(sins.isEmpty()) {
            return true;
        }

        return sins.stream()
                .anyMatch(this::isMatchSkillSin);
    }

    public boolean isMatchSkillType(List<AttackType> attackTypes) {
        if(attackTypes.isEmpty()) {
            return true;
        }

        return attackTypes.stream()
                .anyMatch(s -> this.firstSkill.getAttackType() == s || this.secondSkill.getAttackType() == s || this.thirdSkill.getAttackType() == s);
    }

    public boolean isMatchName(String name) {
        return this.baseName.equals(name);
    }

}
