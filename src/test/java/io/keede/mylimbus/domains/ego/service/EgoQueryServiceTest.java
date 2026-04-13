package io.keede.mylimbus.domains.ego.service;

import io.keede.mylimbus.domains.ego.entity.EGO;
import io.keede.mylimbus.domains.ego.entity.EGORepository;
import io.keede.mylimbus.domains.ego.entity.EGOUseCondition;
import io.keede.mylimbus.domains.ego.entity.RiskLevel;
import io.keede.mylimbus.domains.personality.enums.AttackType;
import io.keede.mylimbus.domains.personality.enums.Sin;
import io.keede.mylimbus.web.dto.response.GetEGOResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("EgoQueryService 유닛 테스트")
class EgoQueryServiceTest {

    @Mock
    private EGORepository egoRepository;

    @InjectMocks
    private EgoQueryService egoQueryService;

    // -------------------------------------------------------------------------
    // getEGOsByCharacterKRName
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("getEGOsByCharacterKRName 메서드")
    class GetEGOsByCharacterKRName {

        @Test
        @DisplayName("캐릭터 이름으로 EGO 목록을 반환한다")
        void getEGOsByCharacterKRName_validName_returnsEGODtoList() {
            // given
            EGO ego = createEGO("이상", "이상의 EGO - 형벌", RiskLevel.TETH, Sin.WRATH, AttackType.SLASH);
            given(egoRepository.findEGOsByCharacterKRName("이상")).willReturn(List.of(ego));

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("이상");

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).egoName()).isEqualTo("이상의 EGO - 형벌");
            assertThat(result.get(0).sinType()).isEqualTo(Sin.WRATH);
            assertThat(result.get(0).riskLevel()).isEqualTo(RiskLevel.TETH);
            assertThat(result.get(0).attackType()).isEqualTo(AttackType.SLASH);
            verify(egoRepository, times(1)).findEGOsByCharacterKRName("이상");
        }

        @Test
        @DisplayName("캐릭터가 여러 EGO를 가진 경우 모두 반환한다")
        void getEGOsByCharacterKRName_multipleEGOs_returnsAll() {
            // given
            EGO ego1 = createEGO("파우스트", "파우스트의 EGO - 다브", RiskLevel.HE, Sin.LUST, AttackType.PIERCE);
            EGO ego2 = createEGO("파우스트", "파우스트의 EGO - 코로나", RiskLevel.WAW, Sin.PRIDE, AttackType.SLASH);
            given(egoRepository.findEGOsByCharacterKRName("파우스트")).willReturn(List.of(ego1, ego2));

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("파우스트");

            // then
            assertThat(result).hasSize(2);
            assertThat(result).extracting(GetEGOResponseDto::egoName)
                    .containsExactlyInAnyOrder("파우스트의 EGO - 다브", "파우스트의 EGO - 코로나");
        }

        @Test
        @DisplayName("EGO가 없는 캐릭터 이름으로 조회하면 빈 목록을 반환한다")
        void getEGOsByCharacterKRName_noEGOsFound_returnsEmptyList() {
            // given
            given(egoRepository.findEGOsByCharacterKRName("그레고르")).willReturn(Collections.emptyList());

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("그레고르");

            // then
            assertThat(result).isEmpty();
            verify(egoRepository, times(1)).findEGOsByCharacterKRName("그레고르");
        }

        @Test
        @DisplayName("빈 문자열로 조회해도 레포지토리 결과를 그대로 반환한다")
        void getEGOsByCharacterKRName_emptyString_returnsRepositoryResult() {
            // given
            given(egoRepository.findEGOsByCharacterKRName("")).willReturn(Collections.emptyList());

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("");

            // then
            assertThat(result).isEmpty();
            verify(egoRepository, times(1)).findEGOsByCharacterKRName("");
        }

        @Test
        @DisplayName("EGO에 사용 조건(useConditions)이 포함되어 DTO로 매핑된다")
        void getEGOsByCharacterKRName_egoWithUseConditions_mapsConditionsToDto() {
            // given
            EGOUseCondition condition1 = new EGOUseCondition(Sin.WRATH, 4);
            EGOUseCondition condition2 = new EGOUseCondition(Sin.LUST, 2);
            EGO ego = createEGOWithConditions("이상", "이상의 EGO - 형벌", RiskLevel.TETH, Sin.WRATH, AttackType.SLASH,
                    List.of(condition1, condition2));
            given(egoRepository.findEGOsByCharacterKRName("이상")).willReturn(List.of(ego));

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("이상");

            // then
            assertThat(result).hasSize(1);
            assertThat(result.get(0).useConditions()).hasSize(2);
        }

        @Test
        @DisplayName("레포지토리가 RuntimeException을 던지면 그대로 전파된다")
        void getEGOsByCharacterKRName_repositoryThrows_exceptionPropagated() {
            // given
            given(egoRepository.findEGOsByCharacterKRName(any())).willThrow(new RuntimeException("DB 오류"));

            // when & then
            assertThrows(RuntimeException.class, () -> egoQueryService.getEGOsByCharacterKRName("이상"));
        }

        @Test
        @DisplayName("다양한 RiskLevel을 가진 EGO가 정확히 DTO에 매핑된다")
        void getEGOsByCharacterKRName_variousRiskLevels_mappedCorrectly() {
            // given
            EGO zayinEgo = createEGO("료슈", "ZAYIN EGO", RiskLevel.ZAYIN, Sin.SLOTH, AttackType.PIERCE);
            EGO alephEgo = createEGO("료슈", "ALEPH EGO", RiskLevel.ALEPH, Sin.SLOTH, AttackType.SLASH);
            given(egoRepository.findEGOsByCharacterKRName("료슈")).willReturn(List.of(zayinEgo, alephEgo));

            // when
            List<GetEGOResponseDto> result = egoQueryService.getEGOsByCharacterKRName("료슈");

            // then
            assertThat(result).hasSize(2);
            assertThat(result).extracting(GetEGOResponseDto::riskLevel)
                    .containsExactlyInAnyOrder(RiskLevel.ZAYIN, RiskLevel.ALEPH);
        }
    }

    // -------------------------------------------------------------------------
    // 테스트용 헬퍼 메서드
    // -------------------------------------------------------------------------

    private EGO createEGO(String characterName, String egoName, RiskLevel riskLevel, Sin sin, AttackType attackType) {
        return new EGO(characterName, egoName, "https://example.com/ego.png", riskLevel, sin, attackType, Collections.emptyList());
    }

    private EGO createEGOWithConditions(
            String characterName,
            String egoName,
            RiskLevel riskLevel,
            Sin sin,
            AttackType attackType,
            List<EGOUseCondition> conditions
    ) {
        return new EGO(characterName, egoName, "https://example.com/ego.png", riskLevel, sin, attackType, conditions);
    }
}
