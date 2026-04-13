package io.keede.mylimbus.domains.personality.service;

import io.keede.mylimbus.domains.personality.entity.Passive;
import io.keede.mylimbus.domains.personality.entity.Personality;
import io.keede.mylimbus.domains.personality.entity.PersonalityRepository;
import io.keede.mylimbus.domains.personality.entity.PersonalitySkill;
import io.keede.mylimbus.domains.personality.enums.*;
import io.keede.mylimbus.web.dto.request.RequestPersonalityByBaseName;
import io.keede.mylimbus.web.dto.request.RequestPersonalityFilterDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PersonalityQueryService 유닛 테스트")
class PersonalityQueryServiceTest {

    @Mock
    private PersonalityRepository personalityRepository;

    @InjectMocks
    private PersonalityQueryService personalityQueryService;

    // -------------------------------------------------------------------------
    // getPersonalityByBaseName
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("getPersonalityByBaseName 메서드")
    class GetPersonalityByBaseName {

        @Test
        @DisplayName("baseName이 일치하는 인격 목록을 반환한다")
        void getPersonalityByBaseName_matchingName_returnsFilteredList() {
            // given
            Personality matched = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of(Affinity.BLEED));
            Personality notMatched = createPersonality(2, "파우스트", "LCB 파우스트", Sin.LUST, AttackType.PIERCE, Set.of(Affinity.BURN));
            given(personalityRepository.findPersonalities()).willReturn(List.of(matched, notMatched));

            RequestPersonalityByBaseName dto = new RequestPersonalityByBaseName("이상");

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityByBaseName(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("이상");
            verify(personalityRepository, times(1)).findPersonalities();
        }

        @Test
        @DisplayName("일치하는 인격이 없으면 빈 목록을 반환한다")
        void getPersonalityByBaseName_noMatchingName_returnsEmptyList() {
            // given
            Personality personality = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of(Affinity.BLEED));
            given(personalityRepository.findPersonalities()).willReturn(List.of(personality));

            RequestPersonalityByBaseName dto = new RequestPersonalityByBaseName("그레고르");

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityByBaseName(dto);

            // then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("레포지토리가 빈 목록을 반환하면 빈 목록을 반환한다")
        void getPersonalityByBaseName_emptyRepository_returnsEmptyList() {
            // given
            given(personalityRepository.findPersonalities()).willReturn(Collections.emptyList());
            RequestPersonalityByBaseName dto = new RequestPersonalityByBaseName("이상");

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityByBaseName(dto);

            // then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("동일한 baseName의 인격이 여러 개면 모두 반환한다")
        void getPersonalityByBaseName_multipleMatch_returnsAll() {
            // given
            Personality p1 = createPersonality(3, "히스클리프", "W 히스클리프", Sin.GLOOM, AttackType.SLASH, Set.of());
            Personality p2 = createPersonality(2, "히스클리프", "LCB 히스클리프", Sin.PRIDE, AttackType.BLUNT, Set.of());
            given(personalityRepository.findPersonalities()).willReturn(List.of(p1, p2));

            RequestPersonalityByBaseName dto = new RequestPersonalityByBaseName("히스클리프");

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityByBaseName(dto);

            // then
            assertThat(result).hasSize(2);
            assertThat(result).allMatch(r -> r.baseName().equals("히스클리프"));
        }
    }

    // -------------------------------------------------------------------------
    // getPersonalityById
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("getPersonalityById 메서드")
    class GetPersonalityById {

        @Test
        @DisplayName("유효한 ID로 인격 정보를 반환한다")
        void getPersonalityById_validId_returnsPersonalityDto() {
            // given
            Personality personality = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of(Affinity.BLEED));
            given(personalityRepository.findPersonalityById(1L)).willReturn(Optional.of(personality));

            // when
            GetPersonalityResponseDto result = personalityQueryService.getPersonalityById(1L);

            // then
            assertThat(result).isNotNull();
            assertThat(result.baseName()).isEqualTo("이상");
            assertThat(result.personalityName()).isEqualTo("LCB 이상");
            verify(personalityRepository, times(1)).findPersonalityById(1L);
        }

        @Test
        @DisplayName("존재하지 않는 ID로 조회 시 RuntimeException을 던진다")
        void getPersonalityById_invalidId_throwsRuntimeException() {
            // given
            given(personalityRepository.findPersonalityById(999L)).willReturn(Optional.empty());

            // when & then
            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> personalityQueryService.getPersonalityById(999L)
            );
            assertThat(exception.getMessage()).isEqualTo("없는 캐릭터입니다.");
        }

        @Test
        @DisplayName("ID가 1인 경우 정상적으로 조회된다 (최솟값 경계)")
        void getPersonalityById_idOne_returnsPersonalityDto() {
            // given
            Personality personality = createPersonality(2, "파우스트", "LCB 파우스트", Sin.LUST, AttackType.PIERCE, Set.of());
            given(personalityRepository.findPersonalityById(1L)).willReturn(Optional.of(personality));

            // when
            GetPersonalityResponseDto result = personalityQueryService.getPersonalityById(1L);

            // then
            assertThat(result.baseName()).isEqualTo("파우스트");
        }

        @Test
        @DisplayName("레포지토리가 RuntimeException을 던지면 그대로 전파된다")
        void getPersonalityById_repositoryThrows_exceptionPropagated() {
            // given
            given(personalityRepository.findPersonalityById(any())).willThrow(new RuntimeException("DB 오류"));

            // when & then
            assertThrows(RuntimeException.class, () -> personalityQueryService.getPersonalityById(1L));
        }
    }

    // -------------------------------------------------------------------------
    // getPersonalityFilter
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("getPersonalityFilter 메서드")
    class GetPersonalityFilter {

        @Test
        @DisplayName("모든 필터가 null/비어있으면 조회된 인격을 모두 반환한다")
        void getPersonalityFilter_allFiltersEmpty_returnsAll() {
            // given
            Personality p1 = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of());
            Personality p2 = createPersonality(2, "파우스트", "LCB 파우스트", Sin.LUST, AttackType.PIERCE, Set.of());
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(p1, p2));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(null, null, null, null, 1);

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(2);
        }

        @Test
        @DisplayName("친화성 필터가 일치하는 인격만 반환한다")
        void getPersonalityFilter_withAffinityFilter_returnsMatchingPersonalities() {
            // given
            Personality bleedPersonality = createPersonality(3, "이상", "W 이상", Sin.WRATH, AttackType.SLASH, Set.of(Affinity.BLEED));
            Personality burnPersonality = createPersonality(3, "파우스트", "W 파우스트", Sin.LUST, AttackType.PIERCE, Set.of(Affinity.BURN));
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(bleedPersonality, burnPersonality));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(
                    null,
                    new Affinity[]{Affinity.BLEED},
                    null,
                    null,
                    1
            );

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("이상");
        }

        @Test
        @DisplayName("스킬 죄악 속성 필터가 일치하는 인격만 반환한다")
        void getPersonalityFilter_withSinFilter_returnsMatchingPersonalities() {
            // given
            Personality wrathPersonality = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of());
            Personality lustPersonality = createPersonality(3, "파우스트", "LCB 파우스트", Sin.LUST, AttackType.PIERCE, Set.of());
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(wrathPersonality, lustPersonality));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(
                    null,
                    null,
                    null,
                    new Sin[]{Sin.WRATH},
                    1
            );

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("이상");
        }

        @Test
        @DisplayName("스킬 공격 유형 필터(SLASH 1개 이상)가 일치하는 인격만 반환한다")
        void getPersonalityFilter_withAttackTypeFilter_returnsMatchingPersonalities() {
            // given
            Personality slashPersonality = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of());
            Personality piercePersonality = createPersonality(3, "파우스트", "LCB 파우스트", Sin.LUST, AttackType.PIERCE, Set.of());
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(slashPersonality, piercePersonality));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(
                    null,
                    null,
                    new AttackType[]{AttackType.SLASH},
                    null,
                    1
            );

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("이상");
        }

        @Test
        @DisplayName("스킬 공격 유형을 2개 이상 요구할 때 조건을 만족하는 인격만 반환한다")
        void getPersonalityFilter_attackTypeQuantityTwo_returnsOnlyMatchingPersonalities() {
            // given
            // slashPersonality: SLASH/SLASH/PIERCE -> SLASH 2개 보유
            Personality doubleSlash = createPersonalityWithSkills(
                    3, "히스클리프", "W 히스클리프",
                    new PersonalitySkill(1, Sin.GLOOM, AttackType.SLASH),
                    new PersonalitySkill(2, Sin.GLOOM, AttackType.SLASH),
                    new PersonalitySkill(3, Sin.GLOOM, AttackType.PIERCE),
                    Set.of()
            );
            // singleSlash: SLASH/PIERCE/BLUNT -> SLASH 1개만 보유
            Personality singleSlash = createPersonalityWithSkills(
                    3, "이상", "LCB 이상",
                    new PersonalitySkill(1, Sin.WRATH, AttackType.SLASH),
                    new PersonalitySkill(2, Sin.WRATH, AttackType.PIERCE),
                    new PersonalitySkill(3, Sin.WRATH, AttackType.BLUNT),
                    Set.of()
            );
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(doubleSlash, singleSlash));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(
                    null, null, new AttackType[]{AttackType.SLASH}, null, 2
            );

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("히스클리프");
        }

        @Test
        @DisplayName("personalityKRName 필터로 특정 캐릭터만 조회한다")
        void getPersonalityFilter_withKRNameFilter_queriesRepositoryWithName() {
            // given
            Personality personality = createPersonality(3, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of());
            given(personalityRepository.findPersonalityByKRName("이상")).willReturn(List.of(personality));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto("이상", null, null, null, 1);

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            verify(personalityRepository, times(1)).findPersonalityByKRName("이상");
        }

        @Test
        @DisplayName("레포지토리가 빈 목록을 반환하면 빈 목록을 반환한다")
        void getPersonalityFilter_emptyRepository_returnsEmptyList() {
            // given
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(Collections.emptyList());
            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(null, null, null, null, 1);

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("결과가 rarity 내림차순, personalityName 오름차순으로 정렬된다")
        void getPersonalityFilter_multipleResults_sortedByRarityDescThenNameAsc() {
            // given
            Personality rarity2 = createPersonality(2, "이상", "LCB 이상", Sin.WRATH, AttackType.SLASH, Set.of());
            Personality rarity3a = createPersonality(3, "파우스트", "W 파우스트", Sin.LUST, AttackType.PIERCE, Set.of());
            Personality rarity3b = createPersonality(3, "이상", "R 이상", Sin.GLOOM, AttackType.BLUNT, Set.of());
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(rarity2, rarity3a, rarity3b));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(null, null, null, null, 1);

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(3);
            assertThat(result.get(0).rarity()).isEqualTo(3);
            assertThat(result.get(1).rarity()).isEqualTo(3);
            // rarity 3 중에서 personalityName 오름차순: "R 이상" < "W 파우스트"
            assertThat(result.get(0).personalityName()).isEqualTo("R 이상");
            assertThat(result.get(1).personalityName()).isEqualTo("W 파우스트");
            assertThat(result.get(2).rarity()).isEqualTo(2);
        }

        @Test
        @DisplayName("친화성과 스킬 죄악 속성 필터를 동시에 적용하면 두 조건을 모두 만족하는 인격만 반환한다")
        void getPersonalityFilter_combinedAffinityAndSinFilter_returnsOnlyFullyMatched() {
            // given
            Personality matched = createPersonality(3, "이상", "W 이상", Sin.WRATH, AttackType.SLASH, Set.of(Affinity.BLEED));
            Personality onlySin = createPersonality(3, "파우스트", "W 파우스트", Sin.WRATH, AttackType.PIERCE, Set.of(Affinity.BURN));
            Personality onlyAffinity = createPersonality(3, "돈키호테", "LCB 돈키호테", Sin.LUST, AttackType.BLUNT, Set.of(Affinity.BLEED));
            given(personalityRepository.findPersonalityByKRName(null)).willReturn(List.of(matched, onlySin, onlyAffinity));

            RequestPersonalityFilterDto dto = new RequestPersonalityFilterDto(
                    null,
                    new Affinity[]{Affinity.BLEED},
                    null,
                    new Sin[]{Sin.WRATH},
                    1
            );

            // when
            List<GetPersonalityResponseDto> result = personalityQueryService.getPersonalityFilter(dto);

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).baseName()).isEqualTo("이상");
        }
    }

    // -------------------------------------------------------------------------
    // 테스트용 헬퍼 메서드
    // -------------------------------------------------------------------------

    /**
     * 3개의 스킬이 모두 동일한 Sin/AttackType인 단순 Personality 생성
     */
    private Personality createPersonality(
            int rarity,
            String baseName,
            String personalityName,
            Sin sin,
            AttackType attackType,
            Set<Affinity> affinities
    ) {
        PersonalitySkill skill = new PersonalitySkill(1, sin, attackType);
        return new Personality(
                rarity,
                baseName,
                personalityName,
                List.of(PersonalityGroup.LCB),
                skill,
                skill,
                skill,
                affinities,
                "방어",
                Set.of(),
                LocalDate.of(2025, 1, 1),
                "https://example.com/img.png"
        );
    }

    /**
     * 스킬별로 다른 Sin/AttackType을 지정할 수 있는 Personality 생성
     */
    private Personality createPersonalityWithSkills(
            int rarity,
            String baseName,
            String personalityName,
            PersonalitySkill firstSkill,
            PersonalitySkill secondSkill,
            PersonalitySkill thirdSkill,
            Set<Affinity> affinities
    ) {
        return new Personality(
                rarity,
                baseName,
                personalityName,
                List.of(PersonalityGroup.LCB),
                firstSkill,
                secondSkill,
                thirdSkill,
                affinities,
                "방어",
                Set.of(),
                LocalDate.of(2025, 1, 1),
                "https://example.com/img.png"
        );
    }
}
