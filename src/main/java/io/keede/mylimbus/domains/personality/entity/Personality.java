package io.keede.mylimbus.domains.personality.entity;

import io.keede.mylimbus.domains.personality.enums.Affinity;
import io.keede.mylimbus.domains.personality.enums.AttackType;
import io.keede.mylimbus.domains.personality.enums.PersonalityGroup;
import io.keede.mylimbus.domains.personality.enums.Sin;
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
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Column(name = "personality_groups")
    private List<PersonalityGroup> groups;

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

//    private Affinity affinity;

    private int rarity;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "personality")
    private Set<Passive> passives = new HashSet<>();

    private Set<Affinity> affinities = new HashSet<>();

    private String defend;

    private LocalDate releaseDate;

    private String imgUrl;

    public Personality(
            int rarity,
            String baseName,
            String personalityName,
            List<PersonalityGroup> groups,
            PersonalitySkill firstSkill,
            PersonalitySkill secondSkill,
            PersonalitySkill thirdSkill,
            String defend,
            Set<Passive> passives,
            LocalDate releaseDate,
            String imgUrl
    ) {
        this.rarity = rarity;
        this.baseName = baseName;
        this.personalityName = personalityName;
        this.groups = groups;
        this.firstSkill = firstSkill;
        this.secondSkill = secondSkill;
        this.thirdSkill = thirdSkill;
        this.defend = defend;
        this.passives.addAll(passives);
        this.releaseDate = releaseDate;
        this.imgUrl = imgUrl;
    }

    public Personality(
            int rarity,
            String baseName,
            String personalityName,
            List<PersonalityGroup> groups,
            PersonalitySkill firstSkill,
            PersonalitySkill secondSkill,
            PersonalitySkill thirdSkill,
            Set<Affinity> affinities,
            String defend,
            Set<Passive> passives,
            LocalDate releaseDate,
            String imgUrl
    ) {
        this.rarity = rarity;
        this.baseName = baseName;
        this.personalityName = personalityName;
        this.groups = groups;
        this.firstSkill = firstSkill;
        this.secondSkill = secondSkill;
        this.thirdSkill = thirdSkill;
        this.affinities = affinities;
        this.defend = defend;
        this.passives.addAll(passives);
        this.releaseDate = releaseDate;
        this.imgUrl = imgUrl;
    }

    public void sync() {
        this.passives.forEach(
                passive -> passive.sync(this)
        );
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
                this.affinities.stream()
                        .map(Enum::name)
                        .collect(Collectors.joining(", ")),
                this.passives.stream()
                        .map(Passive::toDto)
                        .collect(Collectors.toSet()),
                this.releaseDate,
                this.imgUrl
        );
    }

    public boolean isMatchGroupKeyword(String groupKeyword) {
        return this.groups
                .stream()
                .anyMatch(group -> groupKeyword.contains(group.getName()));
    }

    public boolean isMatchAffinity(List<Affinity> targetAffinities) {
        if(targetAffinities.isEmpty()) {
            return true;
        }

        String affinity = this.affinities.stream()
                .map(Enum::name)
                .collect(Collectors.joining());

        return targetAffinities.stream()
                .anyMatch(targetAffinity -> affinity.contains(targetAffinity.name()));
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

//    public boolean isMatchSkillType(List<AttackType> attackTypes) {
//        if(attackTypes.isEmpty()) {
//            return true;
//        }
//
//        // 공격속성과, 공격속성의 개수가 들어온다.
//        // 해당 인격이 가진 공격속성을 찾는다.
//        // 공격속성은 여러개가 들어올수가 있다.
//        // 그러므로,, 여러 인격이 나올 가능성은 존재한다.
//        // 해당 캐릭터의 각 공격속성의 개수를 파악해둔다.
//        // 선택한 공격속성이 있고 && 그 공격속성이 일정개수 이상이면, 통과시켜준다.
//        // 대신 개수를 지정하지 않는다면? 공격속성의 여부만으로 판단해서 준다.
//        // 사실 1개라도 있는 경우 현재 필터링과 동일하게 결과가 나오는게 맞다
//        //
//
//        Map<AttackType, Integer> collect = Stream.of(this.firstSkill.getAttackType(), this.secondSkill.getAttackType(), this.thirdSkill.getAttackType())
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.summingInt(e -> 1)
//                ));
//
//        System.out.println("collect = " + collect);
//
//        return attackTypes.stream()
//                .anyMatch(this::isMatchAttackType);
//    }

//    private boolean isMatchAttackType(AttackType attackType) {
//        return this.firstSkill.isMatchAttackType(attackType)
//                || this.secondSkill.isMatchAttackType(attackType)
//                || this.thirdSkill.isMatchAttackType(attackType);
//    }

    public boolean isMatchName(String name) {
        return this.baseName.equals(name);
    }

    public boolean isMatchSkillType(List<AttackType> attackTypes, int attackTypeQuantity) {
        if(attackTypes.isEmpty()) {
            return true;
        }

        // 각 공격속성의 개수를 종합한다.
        Map<AttackType, Integer> personalityAttackTypeStatistics =
                Stream.of(
                        this.firstSkill.getAttackType(),
                                this.secondSkill.getAttackType(),
                                this.thirdSkill.getAttackType()
                )
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(e -> 1)
                ));

        // 선택한 공격속성을 가지고 존재여부와 개수를 파악해본다.
        return attackTypes.stream()
                .filter(personalityAttackTypeStatistics::containsKey)
                .anyMatch(attackType -> personalityAttackTypeStatistics.get(attackType) >= attackTypeQuantity);
    }
}
