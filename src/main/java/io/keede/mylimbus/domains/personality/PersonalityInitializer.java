package io.keede.mylimbus.domains.personality;

import io.keede.mylimbus.domains.personality.entity.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static io.keede.mylimbus.domains.personality.entity.AttackType.*;
import static io.keede.mylimbus.domains.personality.entity.PassiveCondition.*;
import static io.keede.mylimbus.domains.personality.entity.PassiveType.*;
import static io.keede.mylimbus.domains.personality.entity.PersonalityKeyword.*;
import static io.keede.mylimbus.domains.personality.entity.Sin.*;

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
        List<Personality> personalities = List.of(
                new Personality(1, "LCB 수감자 이상", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 우울4 공명, 우울4 보유, 230227
                new Personality(3, "검계 살수 이상", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, RESONANCE),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 오만4 보유, 오만4 보유, 230227
                new Personality(3, "W사 3등급 정리 요원 이상", List.of(W사),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11,9)
                ), // 탐식4보유, 탐식4보유 , 231109
                new Personality(2, "LCE E.G.O::초롱 이상", List.of(LCE, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1,23)
                ), // 탐식3보유 , 탐식5보유, 250123
                new Personality(2, "남부 세븐 협회 6과 이상", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                       "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식4공명, 탐식3공명 230227
                new Personality(2, "어금니 사무소 해결사 이상", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9,14)
                ), //나태3보유 , 나태3보유 , 230914
                new Personality(2, "피쿼드호 일등 항해사 이상", List.of(피쿼드호),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 12,7)
                ), //오만4보유, 오만4보유 , 231207
                new Personality(2, "남부 디에치 협회 4과 이상", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), //나태3보유, 나태4보유, 240125
                new Personality(3, "개화 E.G.O::동백 이상", List.of(기술해방연합),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 4, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6, 15)
                ),// 나태4보유, 나태3공명, 230615
                new Personality(3, "약지 점묘파 스튜던트 이상", List.of(조직, 약지),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, MAIN, POSSESSION)
                        ),
                        LocalDate.of(2024, 5,16)
                ),// 색욕4보유, 색욕4보유 , 240516
                new Personality(3, "로보토미 E.G.O::엄숙한 애도 이상", List.of(로보토미_본사),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 우울3공명, 우울6보유, 240905
                new Personality(1, "LCB 수감자 파우스트", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 오만2공명, 오만3보유, 230227
                new Personality(3, "쥐는 자 파우스트", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, RESONANCE),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 3,23)
                ), // 색욕4공명, 색욕3공명, 230323
                new Personality(3, "남부 세븐 협회 4과 파우스트", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9,7)
                ), // 탐식3공명, 탐식4보유, 230907
                new Personality(3, "로보토미 E.G.O::후회 파우스트", List.of(로보토미_본사),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 6, MAIN, POSSESSION),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 10,26)
                ), // 분노6보유, 분노5보유, 231026
                new Personality(3, "검계 살수 파우스트", List.of(조직, 검계),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2,22)
                ), // 오만4보유, 오만4보유, 240222
                new Personality(2, "워더링하이츠 버틀러 파우스트", List.of(해결사, 워더링하이츠),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4,4)
                ), //우울4보유 , 우울4보유, 240404
                new Personality(3, "멀티크랙 사무소 대표 파우스트", List.of(해결사, 멀티크랙_사무소),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 질투3보유, 질투5보유, 240808
                new Personality(3, "LCE E.G.O::홍염살 파우스트", List.of(LCE, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 1,23)
                ), // 분노3보유, 분노3공명, 250123
                new Personality(2, "살아남은 로보토미 직원 파우스트", List.of(로보토미_지부),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "질투",
                        Set.of(
                                new Passive(LUST, 2, MAIN, RESONANCE),
                                new Passive(LUST, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕2공명, 색욕2공명, 230227
                new Personality(2, "남부 츠바이 협회 4과 파우스트", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 8,10)
                ), // 우울4보유, 우울2공명, 230810
                new Personality(2, "W사 2등급 정리 요원 파우스트", List.of(W사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 질투4보유, 질투3보유, 230227
                new Personality(1, "LCB 수감자 돈키호테", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕3공명, 색욕5보유, 230227
                new Personality(3, "W사 3등급 정리 요원 돈키호테", List.of(W사),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 우울3공명, 우울3공명, 230227
                new Personality(3, "중지 작은 아우 돈키호테", List.of(조직, 중지),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, PRIDE, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 질투4보유, 질투3보유, 231123
                new Personality(2, "검계 살수 돈키호테", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 오만2공명, 오만3보유 240222
                new Personality(3, "T사 3등급 징수직 직원 돈키호테", List.of(T사),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 6,27)
                ), // 나태5보유, 나태3보유 240627
                new Personality(3, "라만차랜드 실장 돈키호테", List.of(제2권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 12,12)
                ), // 색욕4보유, 색욕3공명, 241212
                new Personality(3, "동부 섕크 협회 3과 돈키호테", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 2, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3,6)
                ), // 분노오만2보유, 분노3공명, 250306
                new Personality(2, "N사 중간 망치 돈키호테", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 5,3)
                ), // 색욕3보유, 색욕4보유, 230503
                new Personality(2, "로보토미 E.G.O::초롱 돈키호테", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 탐식4보유, 탐식5보유, 240111
                new Personality(2, "남부 시 협회 5과 부장 돈키호테", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노3공명, 분노5보유, 230227
                new Personality(1, "LCB 수감자 료슈", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식3공명, 탐식3공명, 230227
                new Personality(3, "W사 3등급 정리 요원 료슈", List.of(W사),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8,24)
                ), // 오만5보유, 오만5보유, 230824
                new Personality(2, "남부 리우 협회 4화 료슈", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, SLASH),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, POSSESSION),
                                new Passive(WRATH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3,27)
                ), // 분노4보유, 분노4보유, 240327
                new Personality(3, "에드가 가문 치프 버틀러 료슈", List.of(해결사, 에드가_가문),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4,18)
                ), // 오만3보유, 오만4보유, 240418
                new Personality(3, "로보토미 E.G.O::적안•참회 료슈", List.of(로보토미_본사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 9,5)
                ), // 분노3우울3보유, 질투3공명, 240905
                new Personality(3, "흑수•묘 료슈", List.of(흑수, 흑수_묘),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 3,20)
                ), // 탐식3보유, 탐식5보유, 250320
                new Personality(2, "남부 세븐 협회 6과 료슈", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식5보유, 탐식4보유, 230227
                new Personality(2, "LCCB 대리 료슈", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11,16)
                ), // 탐식2보유, 오만4보유, 231116
                new Personality(3, "흑운회 와카슈 료슈", List.of(조직, 흑운회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕3공명, 색욕4보유, 230227
                new Personality(3, "료.고.파 주방장 료슈", List.of(뒷골목, 조직, 료고파),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, LUST, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 4,20)
                ), // 색욕5보유, 색욕5보유, 230420
                new Personality(2, "20구 유로지비 료슈", List.of(조직, 유로지비),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 6,13)
                ), // 나태3공명, 나태4보유, 240613
                new Personality(1, "LCB 수감자 뫼르소", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 나태2보유, 나태3보유, 230227
                new Personality(2, "남부 리우 협회 6과 뫼르소", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕4보유, 색욕4보유, 230227
                new Personality(2, "중지 작은 아우 뫼르소", List.of(조직, 중지),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11,23)
                ), // 질투3보유, 질투3보유, 231123
                new Personality(3, "검계 우두머리 뫼르소", List.of(조직, 검계),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "질투",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 22)
                ), // 오만3공명, 오만5보유, 240222
                new Personality(3, "남부 디에치 협회 4과 부장 뫼르소", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 2, MAIN, RESONANCE),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 7,11)
                ), // 우울2공명, 우울5보유, 240711
                new Personality(3, "서부 섕크 협회 3과 뫼르소", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 10,10)
                ), // 오만2탐식2보유, 오만3공명, 241010
                new Personality(3, "R사 제4무리 코뿔소팀 뫼르소", List.of(R사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7,13)
                ), // 질투5보유, 질투5보유, 230713
                new Personality(3, "N사 큰 망치 뫼르소", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 3,9)
                ), // 분노4공명, 분노3공명, 230309
                new Personality(3, "W사 2등급 정리 요원 뫼르소", List.of(W사),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ),// 질투3보유, 질투4보유, 230227
                new Personality(2, "장미스패너 공방 해결사 뫼르소", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(GLOOM, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6,01)
                ), // 우울5보유, 우울3공명, 230601
                new Personality(2, "데드레빗츠 보스 뫼르소", List.of(조직, 데드레빗츠),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 3,28)
                ), // 탐식3공명, 탐식3공명, 240328
                new Personality(1, "LCB 수감자 홍루", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, SLOTH, SLASH),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, RESONANCE),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 나태2공명, 나태5보유, 230227
                new Personality(3, "K사 3등급 적출직 직원 홍루", List.of(K사),
                        new PersonalitySkill(1, PRIDE, SLASH),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 5, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6,29)
                ), // 탐식5보유, 탐식4공명, 230629
                new Personality(2, "갈고리 사무소 해결사 홍루", List.of(해결사, 갈고리_사무소),
                        new PersonalitySkill(1, WRATH, PIERCE),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 10,26)
                ), // 색욕 5보유, 색욕5보유, 231026
                new Personality(3, "남부 디에치 협회 4과 홍루", List.of(해결사, 디에치_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10,25)
                ), // 우울3공명, 우울4보유,240125
                new Personality(3, "20구 유로지비 홍루", List.of(조직, 유로지비),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 6, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 6,13)
                ), // 나태6보유, 나태3공명, 240613
                new Personality(3, "마침표 사무소 대표 홍루", List.of(해결사, 마침표_사무소),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1,9)
                ),// 오만5보유, 오만5보유, 250109
                new Personality(2, "W사 2등급 정리 요원 홍루", List.of(W사),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8,24)
                ), // 오만3보유, 오만3보유, 230824
                new Personality(2, "남부 리우 협회 5과 홍루", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 4, MAIN, POSSESSION),
                                new Passive(WRATH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노4보유, 분노4보유, 230406
                new Personality(2, "송곳니 사냥 사무소 홍루", List.of(해결사, 송곳니_사냥_사무소),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10,17)
                ), // 탐식4보유, 탐식4보유, 241017
                new Personality(2, "흑운회 와카슈 홍루", List.of(조직, 흑운회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, SLOTH, SLASH),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕3공명, 색욕4보유, 230227
                new Personality(3, "콩콩이파 두목 홍루", List.of(뒷골목, 조직, 콩콩이파),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 2, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ),// 탐식2공명, 탐식5보유, 230227
                new Personality(1, "LCB 수감자 히스클리프", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 4, MAIN, RESONANCE),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 질투4공명, 질투5보유, 230227
                new Personality(3, "R사 제4무리 토끼팀 히스클리프", List.of(R사),
                        new PersonalitySkill(1, WRATH, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, ENVY, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노3공명, 분노5보유, 230227
                new Personality(2, "남부 세븐 협회 4과 히스클리프", List.of(해결사, 세븐_협회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "분노",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식4보유, 탐식4보유, 230907
                new Personality(3, "피쿼드호 작살잡이 히스클리프", List.of(피쿼드호),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, ENVY, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 12,7)
                ), // 질투5보유, 질투5보유, 231207
                new Personality(2, "멀티크랙 사무소 해결사 히스클리프", List.of(해결사, 멀티크랙_사무소),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 7, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 8,8)
                ), // 질투3보유, 질투7보유, 240808
                new Personality(3, "와일드헌트 히스클리프", List.of(워더링하이츠, 와일드헌트),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "색욕",
                        Set.of(
                                new Passive(ENVY, 5, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 8,22)
                ), //질투5보유, 우울3공명, 240822
                new Personality(3, "마침표 사무소 해결사 히스클리프", List.of(해결사, 마침표_사무소),
                        new PersonalitySkill(1, GLOOM, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 1,9)
                ),// 오만2공명, 오만5보유, 250109
                new Personality(3, "흑운회 와카슈 히스클리프", List.of(조직, 흑운회),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2,6)
                ), // 색욕3공명, 색욕5보유, 240206
                new Personality(2, "남부 시 협회 5과 히스클리프", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노3공명, 분노3공명, 230227
                new Personality(2, "N사 작은 망치 히스클리프", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 3,23)
                ),// 질투2보유, 색욕4보유, 230323
                new Personality(3, "로보토미 E.G.O::여우비 히스클리프", List.of(로보토미_본사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6,8)
                ), // 질투3보유, 질투3보유, 230608
                new Personality(1, "LCB 수감자 이스마엘", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노3보유, 분노6보유, 230227
                new Personality(3, "남부 리우 협회 4과 이스마엘", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7,6)
                ), //분노3공명, 분노6보유, 230706
                new Personality(3, "피쿼드호 선장 이스마엘", List.of(피쿼드호),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 2,8)
                ), // 오만3공명, 오만3공명, 240208
                new Personality(3, "서부 츠바이 협회 3과 이스마엘", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10,3)
                ), // 오만5보유, 오만3보유, 241003
                new Personality(3, "흑운회 부조장 이스마엘", List.of(조직, 흑운회),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 2,6)
                ), // 색욕3공명, 색욕3공명, 250206
                new Personality(3, "R사 제4무리 순록팀 이스마엘", List.of(R사),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 우울3공명, 우울5보유, 230227
                new Personality(2, "에드가 가문 버틀러 이스마엘", List.of(해결사, 에드가_가문),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 5, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4,18)
                ),// 우울5보유, 우울5보유, 240418
                new Personality(2, "LCCB 대리 이스마엘", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, PRIDE, BLUNT),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식3공명, 탐식2공명, 230227
                new Personality(2, "남부 시 협회 5과 이스마엘", List.of(해결사, 시_협회),
                        new PersonalitySkill(1, ENVY, PIERCE),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(ENVY, 2, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 질투2보유, 질투2공명, 230227
                new Personality(2, "로보토미 E.G.O::출렁임 이스마엘", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, GLUTTONY, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6,15)
                ), // 우울3보유, 우울4보유, 230615
                new Personality(3, "어금니 보트 센터 해결사 이스마엘", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, SLOTH, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7,27)
                ), // 오만3보유, 오만4보유, 230727
                new Personality(1, "LCB 수감자 로쟈", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노5보유, 분노5보유, 230227
                new Personality(2, "T사 2등급 징수직 직원 로쟈", List.of(T사),
                        new PersonalitySkill(1, ENVY, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 6,27)
                ),//나태5보유, 나태3공명, 240627
                new Personality(3, "북부 제바찌 협회 3과 로쟈", List.of(해결사, 제바찌_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, GLUTTONY, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 9,19)
                ), // 탐식4보유, 탐식6보유, 240919
                new Personality(3, "라만차랜드 공주 로쟈", List.of(제2권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 2, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, POSSESSION),
                                new Passive(ENVY, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024,  11,14)
                ), // 색욕3질투2보유, 색욕3질투3보유, 241114
                new Personality(2, "LCCB 대리 로쟈", List.of(LCCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, RESONANCE),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 질투3공명, 질투5보유, 230227
                new Personality(2, "N사 중간 망치 로쟈", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 3,9)
                ), // 분노5보유, 분노3보유, 230309
                new Personality(3, "흑운회 와카슈 로쟈", List.of(조직, 흑운회),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "오만",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 색욕4보유, 우울5보유, 230227
                new Personality(3, "장미스패너 공방 대표 로쟈", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(PRIDE, 4, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6, 1)
                ), // 오만4보유, 오만4보유, 230601
                new Personality(2, "남부 츠바이 협회 5과 로쟈", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, SLOTH, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 분노3보유, 분노3공명, 230713
                new Personality(3, "남부 리우 협회 4과 부장 로쟈", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "분노",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 27)
                ), // 분노3공명, 분노6보유, 240307
                new Personality(1, "LCB 수감자 싱클레어", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, ENVY, SLASH),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ),  //오만3공명, 오만3공명, 230227
                new Personality(3, "쥐어들 자 싱클레어", List.of(N사, N사_광신도),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "오만",
                        Set.of(
                                new Passive(WRATH, 2, MAIN, POSSESSION),
                                new Passive(WRATH, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 5,3)
                ), // 분노2보유, 분노6보유, 230503
                new Personality(3, "남부 섕크 협회 4과 부장 싱클레어", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "탐식",
                        Set.of(
                                new Passive(PRIDE, 5, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 12, 21)
                ), // 오만5보유, 오만3공명, 231221
                new Personality(3, "새벽 사무소 해결사 싱클레어", List.of(해결사, 새벽_사무소),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, ENVY, SLASH),
                        new PersonalitySkill(3, WRATH, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 5, MAIN, POSSESSION),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 5, 2)
                ), // 분노5보유, 분노3공명, 240502
                new Personality(3, "북부 제바찌 협회 3과 싱클레어", List.of(해결사, 제바찌_협회),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 6, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 11, 28)
                ), // 탐식4보유, 탐식6보유, 241128
                new Personality(2, "마리아치 보스 싱클레어", List.of(뒷골목, 조직, 마리아치),
                        new PersonalitySkill(1, SLOTH, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 우울3공명, 우울4보유, 230227
                new Personality(3, "검계 살수 싱클레어", List.of(조직, 검계),
                        new PersonalitySkill(1, GLUTTONY, PIERCE),
                        new PersonalitySkill(2, WRATH, SLASH),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "분노",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 오만2공명, 오만3공명, 230227
                new Personality(2, "남부 츠바이 협회 6과 싱클레어", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 2, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ),// 우울2공명, 우울4보유, 230227
                new Personality(3, "중지 작은 아우 싱클레어", List.of(조직, 중지),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, ENVY, BLUNT),
                        "질투",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 4, 3)
                ), // 질투3보유, 질투5보유, 250403
                new Personality(2, "로보토미 E.G.O::홍적 싱클레어", List.of(로보토미_본사),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, RESONANCE),
                                new Passive(GLUTTONY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 6,29)
                ), // 탐식3공명, 탐식4공명, 230629
                new Personality(2, "어금니 보트 센터 해결사 싱클레어", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, GLOOM, BLUNT),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 4, MAIN, POSSESSION),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 7, 27)
                ), // 우울4보유, 우울4보유, 230727
                new Personality(2, "서부 츠바이 협회 3과 싱클레어", List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, LUST, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 10)
                ), // 나태5보유, 나태4보유, 241010
                new Personality(1, "LCB 수감자 오티스", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, PRIDE, SLASH),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 4, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 나태4보유, 나태5보유, 230227
                new Personality(3, "어금니 사무소 해결사 오티스", List.of(해결사, 어금니_사무소),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 9,14)
                ), // 나태5보유, 나태3보유, 230914
                new Personality(3, "로보토미 E.G.O::마탄 오티스", List.of(로보토미_본사),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, PRIDE, PIERCE),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 5, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 1, 11)
                ), // 오만3보유, 오만3공명, 240111
                new Personality(3, "워더링하이츠 치프 버틀러 오티스", List.of(해결사, 워더링하이츠),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, GLOOM, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 3, 28)
                ), // 우울3공명, 우울4보유 240328
                new Personality(2, "약지 점묘파 스튜던트 오티스", List.of(조직, 약지),
                        new PersonalitySkill(1, LUST, PIERCE),
                        new PersonalitySkill(2, WRATH, PIERCE),
                        new PersonalitySkill(3, GLUTTONY, PIERCE),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 4, MAIN, POSSESSION),
                                new Passive(LUST, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2025, 5, 16)
                ), // 색욕4보유, 색욕4보유, 240516
                new Personality(3, "W사 3등급 정리 요원 팀장 오티스", List.of(W사),
                        new PersonalitySkill(1, PRIDE, BLUNT),
                        new PersonalitySkill(2, ENVY, BLUNT),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "오만",
                        Set.of(
                                new Passive(ENVY, 3, MAIN, POSSESSION),
                                new Passive(ENVY, 4, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 7, 25)
                ), // 질투3보유, 질투4공명, 240725
                new Personality(3, "라만차랜드 이발사 오티스", List.of(제3권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, LUST, SLASH),
                        new PersonalitySkill(3, WRATH, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(LUST, 3, MAIN, RESONANCE),
                                new Passive(LUST, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 10, 17)
                ), // 색욕3공명 색욕 5보유, 241017
                new Personality(3, "흑수•묘 오티스", List.of(흑수, 흑수_묘),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 3, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3, 20)
                ), // 탐식3보유, 탐식3공명, 250320
                new Personality(2, "남부 섕크 협회 4과 오티스", List.of(해결사, 섕크_협회),
                        new PersonalitySkill(1, PRIDE, PIERCE),
                        new PersonalitySkill(2, GLOOM, PIERCE),
                        new PersonalitySkill(3, LUST, PIERCE),
                       "오만",
                        Set.of(
                                new Passive(PRIDE, 3, MAIN, POSSESSION),
                                new Passive(PRIDE, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2023, 12, 21)
                ), // 오만3보유, 오만3공명, 231221
                new Personality(2, "검계 살수 오티스", List.of(조직, 검계),
                        new PersonalitySkill(1, WRATH, SLASH),
                        new PersonalitySkill(2, LUST, PIERCE),
                        new PersonalitySkill(3, PRIDE, SLASH),
                        "오만",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, RESONANCE),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2, 27)
                ), // 오만2공명, 오만4보유, 230227
                new Personality(2, "G사 부장 오티스", List.of(G사),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, GLUTTONY, BLUNT),
                        new PersonalitySkill(3, GLOOM, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 2, MAIN, RESONANCE),
                                new Passive(SLOTH, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ),// 나태2공명, 나태4보유, 230227
                new Personality(1, "LCB 수감자 그레고르", List.of(LCB, 림버스_컴퍼니),
                        new PersonalitySkill(1, GLOOM, SLASH),
                        new PersonalitySkill(2, GLUTTONY, PIERCE),
                        new PersonalitySkill(3, SLOTH, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, POSSESSION),
                                new Passive(GLOOM, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 우울3보유, 우울3보유, 230227
                new Personality(2, "남부 리우 협회 6과 그레고르", List.of(해결사, 리우_협회),
                        new PersonalitySkill(1, WRATH, BLUNT),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, SLOTH, BLUNT),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 3, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 나태3보유, 나태5보유, 230227
                new Personality(3, "쌍갈고리 해적단 부선장 그레고르", List.of(조직, 쌍갈고리_해적단),
                        new PersonalitySkill(1, SLOTH, PIERCE),
                        new PersonalitySkill(2, PRIDE, PIERCE),
                        new PersonalitySkill(3, GLOOM, PIERCE),
                        "우울",
                        Set.of(
                                new Passive(PRIDE, 2, MAIN, POSSESSION),
                                new Passive(PRIDE, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 11, 16)
                ), // 오만2보유, 오만4보유, 231116
                new Personality(3, "에드가 가문 승계자 그레고르", List.of(에드가_가문),
                        new PersonalitySkill(1, ENVY, SLASH),
                        new PersonalitySkill(2, GLOOM, SLASH),
                        new PersonalitySkill(3, LUST, SLASH),
                        "우울",
                        Set.of(
                                new Passive(GLOOM, 3, MAIN, RESONANCE),
                                new Passive(GLOOM, 3, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 4, 4)
                ), // 우울3공명, 우울3보유, 240404
                new Personality(3, "라만차랜드 신부 그레고르", List.of(제3권속, 혈귀, 라만차랜드),
                        new PersonalitySkill(1, GLUTTONY, BLUNT),
                        new PersonalitySkill(2, PRIDE, BLUNT),
                        new PersonalitySkill(3, LUST, BLUNT),
                        "색욕",
                        Set.of(
                                new Passive(LUST, 5, MAIN, POSSESSION),
                                new Passive(LUST, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2024, 10, 31)
                ), // 색욕5보유, 색욕 3공명, 241031
                new Personality(3, "불주먹 사무소 생존자 그레고르", List.of(해결사),
                        new PersonalitySkill(1, LUST, BLUNT),
                        new PersonalitySkill(2, WRATH, BLUNT),
                        new PersonalitySkill(3, WRATH, BLUNT),
                        "우울",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 3, SUPPORT, RESONANCE)
                        ),
                        LocalDate.of(2025, 3, 6)
                ), // 분노3공명, 분노3공명, 250306
                new Personality(3, "G사 일등대리 그레고르", List.of(G사),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, SLOTH, SLASH),
                        new PersonalitySkill(3, LUST, PIERCE),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 2,27)
                ), // 탐식4보유 ,탐식4보유, 230227
                new Personality(2, "흑운회 부조장 그레고르", List.of(조직, 흑운회),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, LUST, BLUNT),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "색욕",
                        Set.of(
                                new Passive(WRATH, 3, MAIN, RESONANCE),
                                new Passive(WRATH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2024, 2, 22)
                ), // 색욕4보유, 색욕4보유, 240222
                new Personality(2, "장미스패너 공방 해결사 그레고르", List.of(해결사, 장미스패너_공방),
                        new PersonalitySkill(1, GLUTTONY, SLASH),
                        new PersonalitySkill(2, ENVY, PIERCE),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "탐식",
                        Set.of(
                                new Passive(GLUTTONY, 4, MAIN, POSSESSION),
                                new Passive(GLUTTONY, 4, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 6,  8)
                ), // 탐식4보유, 탐식4보유, 230608
                new Personality(3, "남부 츠바이 협회 4과 그레고르",List.of(해결사, 츠바이_협회),
                        new PersonalitySkill(1, SLOTH, SLASH),
                        new PersonalitySkill(2, GLUTTONY, SLASH),
                        new PersonalitySkill(3, GLOOM, SLASH),
                        "나태",
                        Set.of(
                                new Passive(SLOTH, 5, MAIN, POSSESSION),
                                new Passive(SLOTH, 5, SUPPORT, POSSESSION)
                        ),
                        LocalDate.of(2023, 8,  10)
                ) // 나태5보유, 나태5보유, 230810
        );

        this.personalityRepository.saveAll(personalities);
    }

}
