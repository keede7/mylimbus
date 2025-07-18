package io.keede.mylimbus.domains.personality;

import io.keede.mylimbus.domains.personality.entity.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.keede.mylimbus.domains.Characters.*;
import static io.keede.mylimbus.domains.personality.enums.Affinity.*;
import static io.keede.mylimbus.domains.personality.enums.AttackType.*;
import static io.keede.mylimbus.domains.personality.enums.PassiveCondition.*;
import static io.keede.mylimbus.domains.personality.enums.PassiveType.*;
import static io.keede.mylimbus.domains.personality.enums.PersonalityGroup.*;
import static io.keede.mylimbus.domains.personality.enums.Sin.*;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Component
public class PersonalityInitializer {

    private final PersonalityRepository personalityRepository;

    public PersonalityInitializer(
            final PersonalityRepository personalityRepository
    ) {
        this.personalityRepository = personalityRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {

//        if (!this.personalityRepository.findPersonalities().isEmpty()) {
//                return;
//        }

        Map<String, Personality> isRegisterPersonalities = this.personalityRepository.findPersonalities()
                    .stream()
                    .collect(Collectors.toMap(
                            Personality::getPersonalityName,
                            Function.identity()
                    ));

        List<Personality> personalities = List.of(
                new Personality(1, YISANG, "LCB 수감자 이상", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/yisang/125px-LCB_Sinner_Yi_Sang.webp"
                ), // 우울4 공명, 우울4 보유, 230227
                new Personality(3, YISANG, "검계 살수 이상", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, RESONANCE),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/yisang/125px-Blade_Lineage_Salsu_Yi_Sang_Uptied.webp"
                ), // 오만4 보유, 오만4 보유, 230227
                new Personality(3, YISANG, "W사 3등급 정리 요원 이상", List.of(W사),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(CHARGE, RUPTURE),
                        "우울",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11, 9),
                        "/sinners/yisang/125px-W_Corp.webp"
                ), // 탐식4보유, 탐식4보유 , 231109
                new Personality(2, YISANG, "LCE E.G.O::초롱 이상", List.of(LCE, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1, 23),
                        "/sinners/yisang/125px-LCE_E.webp"
                ), // 탐식3보유 , 탐식5보유, 250123
                new Personality(2, YISANG, "남부 세븐 협회 6과 이상", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/yisang/125px-Southern_Seven_Assoc.webp"
                ), // 탐식4공명, 탐식3공명 230227
                new Personality(2, YISANG, "어금니 사무소 해결사 이상", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9, 14),
                        "/sinners/yisang/125px-Molar_Office_Fixer_Yi_Sang_Uptied.webp"
                ), //나태3보유 , 나태3보유 , 230914
                new Personality(2, YISANG, "피쿼드호 일등 항해사 이상", List.of(피쿼드호),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(POISE, BLEED),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 12, 7),
                        "/sinners/yisang/125px-The_Pequod_First_Mate_Yi_Sang_Uptied.webp"
                ), //오만4보유, 오만4보유 , 231207
                new Personality(2, YISANG, "남부 디에치 협회 4과 이상", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(SINKING),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/yisang/125px-Dieci_Assoc.webp"
                ), //나태3보유, 나태4보유, 240125
                new Personality(3, YISANG, "개화 E.G.O::동백 이상", List.of(기술해방연합),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(TREMOR, SINKING),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 4, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6, 15),
                        "/sinners/yisang/125px-Effloresced_E.webp"
                ),// 나태4보유, 나태3공명, 230615
                new Personality(3, YISANG, "약지 점묘파 스튜던트 이상", List.of(조직, 약지),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, MAIN, POSSESSION)
                        ),
                        LocalDate.of(2024, 5, 16),
                        "/sinners/yisang/125px-The_Ring_Pointillist_Student_Yi_Sang_Uptied.webp"
                ),// 색욕4보유, 색욕4보유 , 240516
                new Personality(3, YISANG, "로보토미 E.G.O::엄숙한 애도 이상", List.of(로보토미_본사),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/yisang/125px-Lobotomy_E.webp"
                ), // 우울3공명, 우울6보유, 240905
                new Personality(3, YISANG, "남부 리우 협회 3과 이상", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(BURN),
                        "화상",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 2, 20),
                        "/sinners/yisang/125px-Liu_Assoc.webp"
                ),
                new Personality(3, YISANG, "N사 E.G.O::흉탄 이상", List.of(N사, EGO_장비),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE, BLEED),
                        "호흡",
                        Set.of(
                                new Passive(PRIDE, 6, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 7, 3),
                        "/sinners/yisang/125px-N_Corp.webp"
                ),
                new Personality(1, FAUST, "LCB 수감자 파우스트", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(NONE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/faust/125px-LCB_Sinner_Faust.webp"
                ), // 오만2공명, 오만3보유, 230227
                new Personality(3, FAUST, "쥐는 자 파우스트", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, RESONANCE),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 3, 23),
                        "/sinners/faust/125px-The_One_Who_Grips_Faust_Uptied.webp"
                ), // 색욕4공명, 색욕3공명, 230323
                new Personality(3, FAUST, "남부 세븐 협회 4과 파우스트", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(RUPTURE),
                        "색욕",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9, 7),
                        "/sinners/faust/125px-Seven_Assoc.webp"
                ), // 탐식3공명, 탐식4보유, 230907
                new Personality(3, FAUST, "로보토미 E.G.O::후회 파우스트", List.of(로보토미_본사),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(TREMOR),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 6, MAIN, POSSESSION),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 10, 26),
                        "/sinners/faust/125px-Lobotomy_E.webp"
                ), // 분노6보유, 분노5보유, 231026
                new Personality(3, FAUST, "검계 살수 파우스트", List.of(조직, 검계),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(POISE),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 22),
                        "/sinners/faust/125px-Blade_Lineage_Salsu_Faust_Uptied.webp"
                ), // 오만4보유, 오만4보유, 240222
                new Personality(2, FAUST, "워더링하이츠 버틀러 파우스트", List.of(해결사, 워더링하이츠),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4, 4),
                        "/sinners/faust/125px-Wuthering_Heights_Butler_Faust_Uptied.webp"
                ), //우울4보유 , 우울4보유, 240404
                new Personality(3, FAUST, "멀티크랙 사무소 대표 파우스트", List.of(해결사, 멀티크랙_사무소),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(CHARGE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/faust/125px-MultiCrack_Office_Rep_Faust_Uptied.webp"
                ), // 질투3보유, 질투5보유, 240808
                new Personality(3, FAUST, "LCE E.G.O::홍염살 파우스트", List.of(LCE, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BURN),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 1, 23),
                        "/sinners/faust/125px-LCE_E.webp"
                ), // 분노3보유, 분노3공명, 250123
                new Personality(2, FAUST, "살아남은 로보토미 직원 파우스트", List.of(로보토미_지부),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(POISE, RUPTURE),
                        "질투",
                        Set.of(
                                new Passive(LUST, 2, MAIN, RESONANCE),
                                new Passive(LUST, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/faust/125px-Lobotomy_Corp.webp"
                ), // 색욕2공명, 색욕2공명, 230227
                new Personality(2, FAUST, "남부 츠바이 협회 4과 파우스트", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(NONE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 8, 10),
                        "/sinners/faust/125px-Zwei_Assoc.webp"
                ), // 우울4보유, 우울2공명, 230810
                new Personality(2, FAUST, "W사 2등급 정리 요원 파우스트", List.of(W사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(CHARGE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/faust/125px-W_Corp.webp"
                ), // 질투4보유, 질투3보유, 230227
                new Personality(3, FAUST, "흑수-묘 필두 파우스트", List.of(흑수, 흑수_묘),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 5, 22),
                        "/sinners/faust/125px-Heishou_Pack_-_Mao_Branch_Adept_Faust_Uptied.webp"
                ),
                new Personality(1, DONQUIXOTE, "LCB 수감자 돈키호테", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/donquixote/125px-LCB_Sinner_Don_Quixote.webp"
                ), // 색욕3공명, 색욕5보유, 230227
                new Personality(3, DONQUIXOTE, "W사 3등급 정리 요원 돈키호테", List.of(W사),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(CHARGE, RUPTURE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/donquixote/125px-W_Corp.webp"
                ), // 우울3공명, 우울3공명, 230227
                new Personality(3, DONQUIXOTE, "중지 작은 아우 돈키호테", List.of(조직, 중지),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, PRIDE, BLUNT),
                        Set.of(BLEED),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/donquixote/125px-The_Middle_Little_Sister_Don_Quixote_Uptied.webp"
                ), // 질투4보유, 질투3보유, 231123
                new Personality(2, DONQUIXOTE, "검계 살수 돈키호테", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/donquixote/125px-Blade_Lineage_Salsu_Don_Quixote_Uptied.webp"
                ), // 오만2공명, 오만3보유 240222
                new Personality(3, DONQUIXOTE, "T사 3등급 징수직 직원 돈키호테", List.of(T사),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 6, 27),
                        "/sinners/donquixote/125px-T_Corp.webp"
                ), // 나태5보유, 나태3보유 240627
                new Personality(3, DONQUIXOTE, "라만차랜드 실장 돈키호테", List.of(제2권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 12, 12),
                        "/sinners/donquixote/125px-The_Manager_of_La_Manchaland_Don_Quixote_Uptied.webp"
                ), // 색욕4보유, 색욕3공명, 241212
                new Personality(3, DONQUIXOTE, "동부 섕크 협회 3과 돈키호테", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE, BURN),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 2, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3, 6),
                        "/sinners/donquixote/125px-Eastern_Cinq_Assoc.webp"
                ), // 분노오만2보유, 분노3공명, 250306
                new Personality(3, DONQUIXOTE, "남부 섕크 협회 3과 돈키호테", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 7, 20),
                        "/sinners/donquixote/125px-Southern_Cinq_Assoc.webp"
                ), // 분노오만2보유, 분노3공명, 250306
                new Personality(2, DONQUIXOTE, "N사 중간 망치 돈키호테", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 5, 3),
                        "/sinners/donquixote/125px-N_Corp.webp"
                ), // 색욕3보유, 색욕4보유, 230503
                new Personality(2, DONQUIXOTE, "로보토미 E.G.O::초롱 돈키호테", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/donquixote/125px-Lobotomy_E.webp"
                ), // 탐식4보유, 탐식5보유, 240111
                new Personality(2, DONQUIXOTE, "남부 시 협회 5과 부장 돈키호테", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(POISE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/donquixote/125px-Shi_Assoc.webp"
                ), // 분노3공명, 분노5보유, 230227
                new Personality(3, DONQUIXOTE, "로보토미 E.G.O::사랑과 증오의 이름으로 돈키호테", List.of(EGO_장비, 로보토미_본사),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        Set.of(RUPTURE, CHARGE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, RESONANCE),
                                new Passive(ENVY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 7, 17),
                        "/sinners/donquixote/125px-Lobotomy_E.G.O__In_the_Name_of_Love_and_Hate_Don_Quixote.webp"
                ),
                new Personality(1, RYOSHU, "LCB 수감자 료슈", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(POISE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ryoshu/125px-LCB_Sinner_Ryōshū.webp"
                ), // 탐식3공명, 탐식3공명, 230227
                new Personality(3, RYOSHU, "W사 3등급 정리 요원 료슈", List.of(W사),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(CHARGE),
                        "색욕",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8, 24),
                        "/sinners/ryoshu/125px-W_Corp.webp"
                ), // 오만5보유, 오만5보유, 230824
                new Personality(2, RYOSHU, "남부 리우 협회 4화 료슈", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(BURN),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, POSSESSION),
                                new Passive(WRATH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 27),
                        "/sinners/ryoshu/125px-Liu_Assoc.webp"
                ), // 분노4보유, 분노4보유, 240327
                new Personality(3, RYOSHU, "에드가 가문 치프 버틀러 료슈", List.of(해결사, 에드가_가문),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(POISE),
                        "색욕",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4, 18),
                        "/sinners/ryoshu/125px-Edgar_Family_Chief_Butler_Ryōshū_Uptied.webp"
                ), // 오만3보유, 오만4보유, 240418
                new Personality(3, RYOSHU, "로보토미 E.G.O::적안•참회 료슈", List.of(로보토미_본사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 9, 5),
                        "/sinners/ryoshu/125px-Lobotomy_E.webp"
                ), // 분노3우울3보유, 질투3공명, 240905
                new Personality(3, RYOSHU, "흑수-묘 료슈", List.of(흑수, 흑수_묘),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 3, 20),
                        "/sinners/ryoshu/125px-Heishou_Pack_-_Mao_Branch_Ryōshū_Uptied.webp"
                ), // 탐식3보유, 탐식5보유, 250320
                new Personality(2, RYOSHU, "남부 세븐 협회 6과 료슈", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ryoshu/125px-Seven_Assoc.webp"
                ), // 탐식5보유, 탐식4보유, 230227
                new Personality(2, RYOSHU, "LCCB 대리 료슈", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE, TREMOR, RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11, 16),
                        "/sinners/ryoshu/125px-LCCB_Assistant_Manager_Ryōshū_Uptied.webp"
                ), // 탐식2보유, 오만4보유, 231116
                new Personality(3, RYOSHU, "흑운회 와카슈 료슈", List.of(조직, 흑운회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ryoshu/125px-Kurokumo_Clan_Wakashu_Ryōshū_Uptied.webp"
                ), // 색욕3공명, 색욕4보유, 230227
                new Personality(3, RYOSHU, "료.고.파 주방장 료슈", List.of(뒷골목, 조직, 료고파),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 4, 20),
                        "/sinners/ryoshu/125px-R.webp"
                ), // 색욕5보유, 색욕5보유, 230420
                new Personality(2, RYOSHU, "20구 유로지비 료슈", List.of(조직, 유로지비),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 6, 13),
                        "/sinners/ryoshu/125px-District_20_Yurodivy_Ryōshū_Uptied.webp"
                ), // 나태3공명, 나태4보유, 240613
                new Personality(1, MEURSAULT, "LCB 수감자 뫼르소", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/meursault/125px-LCB_Sinner_Meursault.webp"
                ), // 나태2보유, 나태3보유, 230227
                new Personality(2, MEURSAULT, "남부 리우 협회 6과 뫼르소", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        Set.of(BURN),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/meursault/125px-Liu_Assoc.webp"
                ), // 색욕4보유, 색욕4보유, 230227
                new Personality(2, MEURSAULT, "중지 작은 아우 뫼르소", List.of(조직, 중지),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BLEED),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11, 23),
                        "/sinners/meursault/125px-The_Middle_Little_Brother_Meursault_Uptied.webp"
                ), // 질투3보유, 질투3보유, 231123
                new Personality(3, MEURSAULT, "검계 우두머리 뫼르소", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(POISE),
                        "질투",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 22),
                        "/sinners/meursault/125px-Blade_Lineage_Mentor_Meursault_Uptied.webp"
                ), // 오만3공명, 오만5보유, 240222
                new Personality(3, MEURSAULT, "남부 디에치 협회 4과 부장 뫼르소", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 2, MAIN, RESONANCE),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 7, 11),
                        "/sinners/meursault/125px-Dieci_Assoc.webp"
                ), // 우울2공명, 우울5보유, 240711
                new Personality(3, MEURSAULT, "서부 섕크 협회 3과 뫼르소", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(POISE, RUPTURE),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 10, 10),
                        "/sinners/meursault/125px-Cinq_Assoc.webp"
                ), // 오만2탐식2보유, 오만3공명, 241010
                new Personality(3, MEURSAULT, "R사 제4무리 코뿔소팀 뫼르소", List.of(R사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(CHARGE, BLEED),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7, 13),
                        "/sinners/meursault/125px-R_Corp.webp"
                ), // 질투5보유, 질투5보유, 230713
                new Personality(3, MEURSAULT, "N사 큰 망치 뫼르소", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(BLEED),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 3, 9),
                        "/sinners/meursault/125px-N_Corp.webp"
                ), // 분노4공명, 분노3공명, 230309
                new Personality(3, MEURSAULT, "W사 2등급 정리 요원 뫼르소", List.of(W사),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(CHARGE, RUPTURE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/meursault/125px-W_Corp.webp"
                ),// 질투3보유, 질투4보유, 230227
                new Personality(2, MEURSAULT, "장미스패너 공방 해결사 뫼르소", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(CHARGE, TREMOR),
                        "나태",
                        Set.of(
                                new Passive(GLOOM, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6, 1),
                        "/sinners/meursault/125px-Rosespanner_Workshop_Fixer_Meursault_Uptied.webp"
                ), // 우울5보유, 우울3공명, 230601
                new Personality(2, MEURSAULT, "데드레빗츠 보스 뫼르소", List.of(조직, 데드레빗츠),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 3, 28),
                        "/sinners/meursault/125px-Dead_Rabbits_Boss_Meursault_Uptied.webp"
                ), // 탐식3공명, 탐식3공명, 240328
                new Personality(3, MEURSAULT, "동부 엄지 카포IIII 뫼르소", List.of(조직, 엄지, 카포IIII),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(TREMOR, BURN),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 6, 19),
                        "/sinners/meursault/125px-The_Thumb_East_Capo_IIII_Meursault_Uptied.webp"
                ),
                new Personality(1, HONGLU, "LCB 수감자 홍루", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, SLOTH, SLASH),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(SINKING, RUPTURE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, RESONANCE),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/honglu/125px-LCB_Sinner_Hong_Lu.webp"
                ), // 나태2공명, 나태5보유, 230227
                new Personality(3, HONGLU, "K사 3등급 적출직 직원 홍루", List.of(K사),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6, 29),
                        "/sinners/honglu/125px-K_Corp.webp"
                ), // 탐식5보유, 탐식4공명, 230629
                new Personality(2, HONGLU, "갈고리 사무소 해결사 홍루", List.of(해결사, 갈고리_사무소),
                        new PersonalitySkill(1, WRATH, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(BLEED),
                        "오만",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 10, 26),
                        "/sinners/honglu/125px-Hook_Office_Fixer_Hong_Lu_Uptied.webp"
                ), // 색욕 5보유, 색욕5보유, 231026
                new Personality(3, HONGLU, "남부 디에치 협회 4과 홍루", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 25),
                        "/sinners/honglu/125px-Dieci_Assoc.webp"
                ), // 우울3공명, 우울4보유,240125
                new Personality(3, HONGLU, "20구 유로지비 홍루", List.of(조직, 유로지비),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 6, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 6, 13),
                        "/sinners/honglu/125px-District_20_Yurodivy_Hong_Lu_Uptied.webp"
                ), // 나태6보유, 나태3공명, 240613
                new Personality(3, HONGLU, "마침표 사무소 대표 홍루", List.of(해결사, 마침표_사무소),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1, 9),
                        "/sinners/honglu/125px-Full-Stop_Office_Rep_Hong_Lu_Uptied.webp"
                ),// 오만5보유, 오만5보유, 250109
                new Personality(2, HONGLU, "W사 2등급 정리 요원 홍루", List.of(W사),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(CHARGE, RUPTURE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8, 24),
                        "/sinners/honglu/125px-W_Corp.webp"
                ), // 오만3보유, 오만3보유, 230824
                new Personality(2, HONGLU, "남부 리우 협회 5과 홍루", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BURN),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, POSSESSION),
                                new Passive(WRATH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/honglu/125px-Liu_Assoc.webp"
                ), // 분노4보유, 분노4보유, 230406
                new Personality(2, HONGLU, "송곳니 사냥 사무소 홍루", List.of(해결사, 송곳니_사냥_사무소),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(RUPTURE),
                        "분노",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 17),
                        "/sinners/honglu/125px-Fanghunt_Office_Fixer_Hong_Lu_Uptied.webp"
                ), // 탐식4보유, 탐식4보유, 241017
                new Personality(2, HONGLU, "흑운회 와카슈 홍루", List.of(조직, 흑운회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        Set.of(BLEED),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/honglu/125px-Kurokumo_Clan_Wakashu_Hong_Lu_Uptied.webp"
                ), // 색욕3공명, 색욕4보유, 230227
                new Personality(3, HONGLU, "콩콩이파 두목 홍루", List.of(뒷골목, 조직, 콩콩이파),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(BLEED),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 2, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/honglu/125px-Tingtang_Gang_Gangleader_Hong_Lu_Uptied.webp"
                ),// 탐식2공명, 탐식5보유, 230227
                new Personality(3, HONGLU, "R사 제4무리 순록팀 홍루", List.of(R사),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(CHARGE, SINKING),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 4, 30),
                        "/sinners/honglu/125px-R_Corp.webp"
                ),// 탐식2공명, 탐식5보유, 230227
                new Personality(1, HEATHCLIFF, "LCB 수감자 히스클리프", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(TREMOR),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, RESONANCE),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/heathcliff/125px-LCB_Sinner_Heathcliff.webp"
                ), // 질투4공명, 질투5보유, 230227
                new Personality(3, HEATHCLIFF, "R사 제4무리 토끼팀 히스클리프", List.of(R사),
                        new PersonalitySkill(1, WRATH, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, ENVY, PIERCE),
                        Set.of(CHARGE, BLEED, RUPTURE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/heathcliff/125px-R_Corp.webp"
                ), // 분노3공명, 분노5보유, 230227
                new Personality(2, HEATHCLIFF, "남부 세븐 협회 4과 히스클리프", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(RUPTURE),
                        "분노",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/heathcliff/125px-Seven_Assoc.webp"
                ), // 탐식4보유, 탐식4보유, 230907
                new Personality(3, HEATHCLIFF, "피쿼드호 작살잡이 히스클리프", List.of(피쿼드호),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, ENVY, PIERCE),
                        Set.of(BLEED),
                        "분노",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 12, 7),
                        "/sinners/heathcliff/125px-The_Pequod_Harpooneer_Heathcliff_Uptied.webp"
                ), // 질투5보유, 질투5보유, 231207
                new Personality(2, HEATHCLIFF, "멀티크랙 사무소 해결사 히스클리프", List.of(해결사, 멀티크랙_사무소),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(CHARGE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 7, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 8, 8),
                        "/sinners/heathcliff/125px-MultiCrack_Office_Fixer_Heathcliff_Uptied.webp"
                ), // 질투3보유, 질투7보유, 240808
                new Personality(3, HEATHCLIFF, "와일드헌트 히스클리프", List.of(워더링하이츠, 와일드헌트),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(SINKING),
                        "색욕",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 8, 22),
                        "/sinners/heathcliff/125px-Wild_Hunt_Heathcliff_Uptied.webp"
                ), //질투5보유, 우울3공명, 240822
                new Personality(3, HEATHCLIFF, "마침표 사무소 해결사 히스클리프", List.of(해결사, 마침표_사무소),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1, 9),
                        "/sinners/heathcliff/125px-Full-Stop_Office_Fixer_Heathcliff_Uptied.webp"
                ),// 오만2공명, 오만5보유, 250109
                new Personality(3, HEATHCLIFF, "흑운회 와카슈 히스클리프", List.of(조직, 흑운회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 6),
                        "/sinners/heathcliff/125px-Kurokumo_Clan_Wakashu_Heathcliff_Uptied.webp"
                ), // 색욕3공명, 색욕5보유, 240206
                new Personality(2, HEATHCLIFF, "남부 시 협회 5과 히스클리프", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(POISE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/heathcliff/125px-Shi_Assoc.webp"
                ), // 분노3공명, 분노3공명, 230227
                new Personality(2, HEATHCLIFF, "N사 작은 망치 히스클리프", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(BLEED),
                        "우울",
                        Set.of(
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 3, 23),
                        "/sinners/heathcliff/125px-N_Corp.webp"
                ),// 질투2보유, 색욕4보유, 230323
                new Personality(3, HEATHCLIFF, "로보토미 E.G.O::여우비 히스클리프", List.of(로보토미_본사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        Set.of(SINKING, RUPTURE),
                        "분노",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6, 8),
                        "/sinners/heathcliff/125px-Lobotomy_E.webp"
                ),
                new Personality(3, HEATHCLIFF, "남부 외우피 협회 3과 히스클리프", List.of(해결사, 외우피_협회),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(TREMOR),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 21),
                        "/sinners/heathcliff/125px-Öufi_Assoc.webp"
                ), // 질투3보유, 질투3보유, 230608
                new Personality(1, ISHMAEL, "LCB 수감자 이스마엘", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(TREMOR),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ishmael/125px-LCB_Sinner_Ishmael.webp"
                ), // 분노3보유, 분노6보유, 230227
                new Personality(3, ISHMAEL, "남부 리우 협회 4과 이스마엘", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        Set.of(BURN),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7, 6),
                        "/sinners/ishmael/125px-Liu_Assoc.webp"
                ), //분노3공명, 분노6보유, 230706
                new Personality(3, ISHMAEL, "피쿼드호 선장 이스마엘", List.of(피쿼드호),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        Set.of(POISE, BURN, BLEED),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 2, 8),
                        "/sinners/ishmael/125px-The_Pequod_Captain_Ishmael_Uptied.webp"
                ), // 오만3공명, 오만3공명, 240208
                new Personality(3, ISHMAEL, "서부 츠바이 협회 3과 이스마엘", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        Set.of(TREMOR),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 3),
                        "/sinners/ishmael/125px-Zwei_Assoc.webp"
                ), // 오만5보유, 오만3보유, 241003
                new Personality(3, ISHMAEL, "흑운회 부조장 이스마엘", List.of(조직, 흑운회),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 2, 6),
                        "/sinners/ishmael/125px-Kurokumo_Clan_Captain_Ishmael_Uptied.webp"
                ), // 색욕3공명, 색욕3공명, 250206
                new Personality(3, ISHMAEL, "R사 제4무리 순록팀 이스마엘", List.of(R사),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(CHARGE, SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ishmael/125px-R_Corp.webp"
                ), // 우울3공명, 우울5보유, 230227
                new Personality(2, ISHMAEL, "에드가 가문 버틀러 이스마엘", List.of(해결사, 에드가_가문),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(POISE, SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 5, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4, 18),
                        "/sinners/ishmael/125px-Edgar_Family_Butler_Ishmael_Uptied.webp"
                ),// 우울5보유, 우울5보유, 240418
                new Personality(2, ISHMAEL, "LCCB 대리 이스마엘", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, PRIDE, BLUNT),
                        Set.of(TREMOR, RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ishmael/125px-LCCB_Assistant_Manager_Ishmael_Uptied.webp"
                ), // 탐식3공명, 탐식2공명, 230227
                new Personality(2, ISHMAEL, "남부 시 협회 5과 이스마엘", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(POISE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(ENVY, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/ishmael/125px-Shi_Assoc.webp"
                ), // 질투2보유, 질투2공명, 230227
                new Personality(2, ISHMAEL, "로보토미 E.G.O::출렁임 이스마엘", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        Set.of(TREMOR, RUPTURE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6, 15),
                        "/sinners/ishmael/125px-Lobotomy_E.webp"
                ), // 우울3보유, 우울4보유, 230615
                new Personality(3, ISHMAEL, "어금니 보트 센터 해결사 이스마엘", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(TREMOR, SINKING),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7, 27),
                        "/sinners/ishmael/125px-Molar_Boatworks_Fixer_Ishmael_Uptied.webp"
                ), // 오만3보유, 오만4보유, 230727
                new Personality(3, ISHMAEL, "가주 후보 이스마엘", List.of(가주_후보, 가씨_가문),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(RUPTURE, POISE),
                        "우울",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 6, 5),
                        "/sinners/ishmael/125px-Family_Hierarch_Candidate_Ishmael_Uptied.webp"
                ),
                new Personality(1, RODION, "LCB 수감자 로쟈", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(BLEED),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/rodion/125px-LCB_Sinner_Rodion.webp"
                ), // 분노5보유, 분노5보유, 230227
                new Personality(2, RODION, "T사 2등급 징수직 직원 로쟈", List.of(T사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 6, 27),
                        "/sinners/rodion/125px-T_Corp.webp"
                ),//나태5보유, 나태3공명, 240627
                new Personality(3, RODION, "북부 제바찌 협회 3과 로쟈", List.of(해결사, 제바찌_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 19),
                        "/sinners/rodion/125px-Devyat'_Assoc.webp"
                ),
                new Personality(3, RODION, "남부 디에치 협회 4과 로쟈", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9, 19),
                        "/sinners/rodion/125px-Dieci_Assoc.webp"
                ), // 탐식4보유, 탐식6보유, 240919
                new Personality(3, RODION, "라만차랜드 공주 로쟈", List.of(제2권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(BLEED, RUPTURE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 11, 14),
                        "/sinners/rodion/125px-The_Princess_of_La_Manchaland_Rodion_Uptied.webp"
                ), // 색욕3질투2보유, 색욕3질투3보유, 241114
                new Personality(2, RODION, "LCCB 대리 로쟈", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        Set.of(NONE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, RESONANCE),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/rodion/125px-LCCB_Assistant_Manager_Rodion_Uptied.webp"
                ), // 질투3공명, 질투5보유, 230227
                new Personality(2, RODION, "N사 중간 망치 로쟈", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BLEED),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 3, 9),
                        "/sinners/rodion/125px-N_Corp.webp"
                ), // 분노5보유, 분노3보유, 230309
                new Personality(3, RODION, "흑운회 와카슈 로쟈", List.of(조직, 흑운회),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(POISE, BLEED),
                        "오만",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/rodion/125px-Kurokumo_Clan_Wakashu_Rodion_Uptied.webp"
                ), // 색욕4보유, 우울5보유, 230227
                new Personality(3, RODION, "장미스패너 공방 대표 로쟈", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        Set.of(CHARGE, TREMOR),
                        "나태",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6, 1),
                        "/sinners/rodion/125px-Rosespanner_Workshop_Rep_Rodion_Uptied.webp"
                ), // 오만4보유, 오만4보유, 230601
                new Personality(2, RODION, "남부 츠바이 협회 5과 로쟈", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(POISE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/rodion/125px-Zwei_Assoc.webp"
                ), // 분노3보유, 분노3공명, 230713
                new Personality(3, RODION, "남부 리우 협회 4과 부장 로쟈", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(BURN),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 27),
                        "/sinners/rodion/125px-Liu_Assoc.webp"
                ), // 분노3공명, 분노6보유, 240307
                new Personality(3, RODION, "흑수-사 로쟈", List.of(흑수, 흑수_사),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(POISE, RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 5, 15),
                        "/sinners/rodion/125px-Heishou_Pack_-_Si_Branch_Rodion_Uptied.webp"
                ), //
                new Personality(3, RODION, "로보토미 E.G.O::눈물로 벼려낸 검 로쟈", List.of(EGO_장비, 로보토미_본사),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(SINKING, CHARGE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 7, 17),
                        "/sinners/rodion/125px-Lobotomy_E.webp"
                ),
                new Personality(1, SINCLAIR, "LCB 수감자 싱클레어", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(RUPTURE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/sinclair/125px-LCB_Sinner_Sinclair.webp"
                ),  //오만3공명, 오만3공명, 230227
                new Personality(3, SINCLAIR, "쥐어들 자 싱클레어", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BURN, BLEED),
                        "오만",
                        Set.of(
                                new Passive(WRATH, 2, MAIN, POSSESSION),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 5, 3),
                        "/sinners/sinclair/125px-The_One_Who_Shall_Grip_Sinclair_Uptied.webp"
                ), // 분노2보유, 분노6보유, 230503
                new Personality(3, SINCLAIR, "남부 섕크 협회 4과 부장 싱클레어", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(POISE),
                        "탐식",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 12, 21),
                        "/sinners/sinclair/125px-Cinq_Assoc.webp"
                ), // 오만5보유, 오만3공명, 231221
                new Personality(3, SINCLAIR, "새벽 사무소 해결사 싱클레어", List.of(해결사, 새벽_사무소),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        Set.of(BURN),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 5, 2),
                        "/sinners/sinclair/125px-Dawn_Office_Fixer_Sinclair_Uptied.webp"
                ), // 분노5보유, 분노3공명, 240502
                new Personality(3, SINCLAIR, "북부 제바찌 협회 3과 싱클레어", List.of(해결사, 제바찌_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 11, 28),
                        "/sinners/sinclair/125px-Devyat'_Assoc.webp"
                ), // 탐식4보유, 탐식6보유, 241128
                new Personality(2, SINCLAIR, "마리아치 보스 싱클레어", List.of(뒷골목, 조직, 마리아치),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(POISE, SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/sinclair/125px-Los_Mariachis_Jefe_Sinclair_Uptied.webp"
                ), // 우울3공명, 우울4보유, 230227
                new Personality(3, SINCLAIR, "검계 살수 싱클레어", List.of(조직, 검계),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(POISE, BLEED),
                        "분노",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/sinclair/125px-Blade_Lineage_Salsu_Sinclair_Uptied.webp"
                ), // 오만2공명, 오만3공명, 230227
                new Personality(2, SINCLAIR, "남부 츠바이 협회 6과 싱클레어", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(TREMOR),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 2, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/sinclair/125px-Southern_Zwei_Assoc.webp"
                ),// 우울2공명, 우울4보유, 230227
                new Personality(3, SINCLAIR, "중지 작은 아우 싱클레어", List.of(조직, 중지),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        Set.of(BLEED),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 4, 3),
                        "/sinners/sinclair/125px-The_Middle_Little_Brother_Sinclair_Uptied.webp"
                ), // 질투3보유, 질투5보유, 250403
                new Personality(2, SINCLAIR, "로보토미 E.G.O::홍적 싱클레어", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6, 29),
                        "/sinners/sinclair/125px-Lobotomy_E.webp"
                ), // 탐식3공명, 탐식4공명, 230629
                new Personality(2, SINCLAIR, "어금니 보트 센터 해결사 싱클레어", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(TREMOR),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7, 27),
                        "/sinners/sinclair/125px-Molar_Boatworks_Fixer_Sinclair_Uptied.webp"
                ), // 우울4보유, 우울4보유, 230727
                new Personality(2, SINCLAIR, "서부 츠바이 협회 3과 싱클레어", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 10),
                        "/sinners/sinclair/125px-Western_Zwei_Assoc.webp"
                ), // 나태5보유, 나태4보유, 241010
                new Personality(3, SINCLAIR, "동부 엄지 솔다토II 싱클레어", List.of(조직, 엄지, 솔다토II),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(TREMOR, BURN),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 6, 19),
                        "/sinners/sinclair/125px-The_Thumb_East_Soldato_II_Sinclair_Uptied.webp"
                ),
                new Personality(1, OUTIS, "LCB 수감자 오티스", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(RUPTURE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 4, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/outis/125px-LCB_Sinner_Outis.webp"
                ), // 나태4보유, 나태5보유, 230227
                new Personality(3, OUTIS, "어금니 사무소 해결사 오티스", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(TREMOR),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9, 14),
                        "/sinners/outis/125px-Molar_Office_Fixer_Outis_Uptied.webp"
                ), // 나태5보유, 나태3보유, 230914
                new Personality(3, OUTIS, "로보토미 E.G.O::마탄 오티스", List.of(로보토미_본사),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        Set.of(BURN),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 1, 11),
                        "/sinners/outis/125px-Lobotomy_E.webp"
                ), // 오만3보유, 오만3공명, 240111
                new Personality(3, OUTIS, "워더링하이츠 치프 버틀러 오티스", List.of(해결사, 워더링하이츠),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 28),
                        "/sinners/outis/125px-Wuthering_Heights_Chief_Butler_Outis_Uptied.webp"
                ), // 우울3공명, 우울4보유 240328
                new Personality(2, OUTIS, "약지 점묘파 스튜던트 오티스", List.of(조직, 약지),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 5, 16),
                        "/sinners/outis/125px-The_Ring_Pointillist_Student_Outis_Uptied.webp"
                ), // 색욕4보유, 색욕4보유, 240516
                new Personality(3, OUTIS, "W사 3등급 정리 요원 팀장 오티스", List.of(W사),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(CHARGE, RUPTURE),
                        "오만",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 7, 25),
                        "/sinners/outis/125px-W_Corp.webp"
                ), // 질투3보유, 질투4공명, 240725
                new Personality(3, OUTIS, "라만차랜드 이발사 오티스", List.of(제3권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        Set.of(BLEED),
                        "탐식",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 17),
                        "/sinners/outis/125px-The_Barber_of_La_Manchaland_Outis_Uptied.webp"
                ), // 색욕3공명 색욕 5보유, 241017
                new Personality(3, OUTIS, "흑수-묘 오티스", List.of(흑수, 흑수_묘),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3, 20),
                        "/sinners/outis/125px-Heishou_Pack_-_Mao_Branch_Outis_Uptied.webp"
                ), // 탐식3보유, 탐식3공명, 250320
                new Personality(2, OUTIS, "남부 섕크 협회 4과 오티스", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 12, 21),
                        "/sinners/outis/125px-Cinq_Assoc.webp"
                ), // 오만3보유, 오만3공명, 231221
                new Personality(2, OUTIS, "검계 살수 오티스", List.of(조직, 검계),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        Set.of(POISE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/outis/125px-Blade_Lineage_Salsu_Outis_Uptied.webp"
                ), // 오만2공명, 오만4보유, 230227
                new Personality(2, OUTIS, "G사 부장 오티스", List.of(G사),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        Set.of(SINKING),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/outis/125px-G_Corp.webp"
                ),// 나태2공명, 나태4보유, 230227
                new Personality(3, OUTIS, "남부 세븐 협회 6과 오티스", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, SLOTH, SLASH),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 4, 6),
                        "/sinners/outis/125px-Seven_Assoc.webp"
                ),// 탐식3공명, 탐식4보유, 230406
                new Personality(1, GREGOR, "LCB 수감자 그레고르", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        Set.of(RUPTURE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/gregor/125px-LCB_Sinner_Gregor.webp"
                ), // 우울3보유, 우울3보유, 230227
                new Personality(2, GREGOR, "남부 리우 협회 6과 그레고르", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        Set.of(BURN),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/gregor/125px-Liu_Assoc.webp"
                ), // 나태3보유, 나태5보유, 230227
                new Personality(3, GREGOR, "쌍갈고리 해적단 부선장 그레고르", List.of(조직, 쌍갈고리_해적단),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        Set.of(POISE, BLEED),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11, 16),
                        "/sinners/gregor/125px-Twinhook_Pirates_First_Mate_Gregor_Uptied.webp"
                ), // 오만2보유, 오만4보유, 231116
                new Personality(3, GREGOR, "에드가 가문 승계자 그레고르", List.of(에드가_가문),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        Set.of(SINKING),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4, 4),
                        "/sinners/gregor/125px-Edgar_Family_Heir_Gregor_Uptied.webp"
                ), // 우울3공명, 우울3보유, 240404
                new Personality(3, GREGOR, "라만차랜드 신부 그레고르", List.of(제3권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        Set.of(BLEED, RUPTURE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 10, 31),
                        "/sinners/gregor/125px-The_Priest_of_La_Manchaland_Gregor_Uptied.webp"
                ), // 색욕5보유, 색욕 3공명, 241031
                new Personality(3, GREGOR, "불주먹 사무소 생존자 그레고르", List.of(해결사),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        Set.of(BURN),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3, 6),
                        "/sinners/gregor/125px-Firefist_Office_Survivor_Gregor_Uptied.webp"
                ), // 분노3공명, 분노3공명, 250306
                new Personality(3, GREGOR, "G사 일등대리 그레고르", List.of(G사),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, SLOTH, SLASH),
                        new PersonalitySkill(3, LUST, PIERCE),
                        Set.of(RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27),
                        "/sinners/gregor/125px-G_Corp.webp"
                ), // 탐식4보유 ,탐식4보유, 230227
                new Personality(2, GREGOR, "흑운회 부조장 그레고르", List.of(조직, 흑운회),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 22),
                        "/sinners/gregor/125px-Kurokumo_Clan_Captain_Gregor_Uptied.webp"
                ), // 색욕4보유, 색욕4보유, 240222
                new Personality(2, GREGOR, "장미스패너 공방 해결사 그레고르", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(CHARGE, TREMOR, RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6, 8),
                        "/sinners/gregor/125px-Rosespanner_Workshop_Fixer_Gregor_Uptied.webp"
                ), // 탐식4보유, 탐식4보유, 230608
                new Personality(3, GREGOR, "남부 츠바이 협회 4과 그레고르", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        Set.of(NONE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8, 10),
                        "/sinners/gregor/125px-Zwei_Assoc.webp"
                ), // 나태5보유, 나태5보유, 230810,
                new Personality(2, GREGOR, "료.고.파 조수 그레고르", List.of(뒷골목, 조직, 료고파),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        Set.of(BLEED),
                        "색욕",
                        Set.of(
                                new Passive(SLOTH, 4, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 4, 23),
                        "/sinners/gregor/125px-R.webp"
                ),
                new Personality(3, GREGOR, "흑수-사 그레고르", List.of(흑수, 흑수_사),
                        new PersonalitySkill(1, PRIDE , SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, ENVY, PIERCE),
                        Set.of(POISE, RUPTURE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 5, 15),
                        "/sinners/gregor/125px-Heishou_Pack_-_Si_Branch_Gregor_Uptied.webp"
                )
        );

        List<Personality> noRegisteredPersonalities = personalities.stream()
                .filter(personality -> !isRegisterPersonalities.containsKey(personality.getPersonalityName()))
                .toList();

        noRegisteredPersonalities.forEach(Personality::sync);

        this.personalityRepository.saveAll(noRegisteredPersonalities);
    }

}
