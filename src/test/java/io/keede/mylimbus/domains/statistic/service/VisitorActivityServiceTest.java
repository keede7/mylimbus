package io.keede.mylimbus.domains.statistic.service;

import io.keede.mylimbus.domains.statistic.entity.VisitorActivity;
import io.keede.mylimbus.domains.statistic.entity.VisitorActivityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("VisitorActivityService 유닛 테스트")
class VisitorActivityServiceTest {

    @Mock
    private VisitorActivityRepository visitorActivityRepository;

    @InjectMocks
    private VisitorActivityService visitorActivityService;

    // -------------------------------------------------------------------------
    // register
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("register 메서드")
    class Register {

        @Test
        @DisplayName("유효한 VisitorActivity 엔티티를 저장한다")
        void register_validEntity_savesSuccessfully() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-001",
                    "127.0.0.1",
                    "Mozilla/5.0",
                    "https://referrer.com",
                    "/main"
            );
            given(visitorActivityRepository.save(entity)).willReturn(entity);

            // when
            visitorActivityService.register(entity);

            // then
            verify(visitorActivityRepository, times(1)).save(entity);
        }

        @Test
        @DisplayName("save 호출 시 전달된 엔티티의 필드가 정확히 일치한다")
        void register_validEntity_passesCorrectEntityToRepository() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-002",
                    "192.168.0.1",
                    "Chrome/120",
                    "https://google.com",
                    "/api/personality/base"
            );
            ArgumentCaptor<VisitorActivity> captor = ArgumentCaptor.forClass(VisitorActivity.class);
            given(visitorActivityRepository.save(captor.capture())).willReturn(entity);

            // when
            visitorActivityService.register(entity);

            // then
            VisitorActivity captured = captor.getValue();
            assertThat(captured.getVisitorId()).isEqualTo("visitor-uuid-002");
            assertThat(captured.getIpAddress()).isEqualTo("192.168.0.1");
            assertThat(captured.getUserAgent()).isEqualTo("Chrome/120");
            assertThat(captured.getReferrer()).isEqualTo("https://google.com");
            assertThat(captured.getPageUrl()).isEqualTo("/api/personality/base");
        }

        @Test
        @DisplayName("레포지토리가 RuntimeException을 던지면 그대로 전파된다")
        void register_repositoryThrows_exceptionPropagated() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-003",
                    "10.0.0.1",
                    "Safari/17",
                    null,
                    "/main"
            );
            willThrow(new RuntimeException("DB 저장 오류")).given(visitorActivityRepository).save(entity);

            // when & then
            assertThrows(RuntimeException.class, () -> visitorActivityService.register(entity));
        }

        @Test
        @DisplayName("referrer가 null인 방문자 활동도 정상적으로 저장한다")
        void register_nullReferrer_savesSuccessfully() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-004",
                    "10.0.0.2",
                    "Mozilla/5.0",
                    null,
                    "/main"
            );
            given(visitorActivityRepository.save(entity)).willReturn(entity);

            // when
            visitorActivityService.register(entity);

            // then
            verify(visitorActivityRepository, times(1)).save(entity);
        }

        @Test
        @DisplayName("ipAddress가 null인 방문자 활동도 정상적으로 저장한다 (프록시 환경)")
        void register_nullIpAddress_savesSuccessfully() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-005",
                    null,
                    "Mozilla/5.0",
                    "https://referrer.com",
                    "/main"
            );
            given(visitorActivityRepository.save(entity)).willReturn(entity);

            // when
            visitorActivityService.register(entity);

            // then
            verify(visitorActivityRepository, times(1)).save(entity);
        }

        @Test
        @DisplayName("save가 정확히 1번만 호출된다 (중복 저장 방지 확인)")
        void register_calledOnce_saveInvokedExactlyOnce() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-006",
                    "127.0.0.1",
                    "Mozilla/5.0",
                    null,
                    "/"
            );
            given(visitorActivityRepository.save(any())).willReturn(entity);

            // when
            visitorActivityService.register(entity);

            // then
            verify(visitorActivityRepository, times(1)).save(any());
            verifyNoMoreInteractions(visitorActivityRepository);
        }

        @Test
        @DisplayName("타임스탬프가 엔티티 생성 시 자동으로 설정된다")
        void register_entityCreated_timestampIsNotNull() {
            // given
            VisitorActivity entity = createVisitorActivity(
                    "visitor-uuid-007",
                    "127.0.0.1",
                    "Mozilla/5.0",
                    null,
                    "/"
            );

            // when & then
            assertThat(entity.getTimestamp()).isNotNull();
        }
    }

    // -------------------------------------------------------------------------
    // 테스트용 헬퍼 메서드
    // -------------------------------------------------------------------------

    private VisitorActivity createVisitorActivity(
            String visitorId,
            String ipAddress,
            String userAgent,
            String referrer,
            String pageUrl
    ) {
        return new VisitorActivity(visitorId, ipAddress, userAgent, referrer, pageUrl);
    }
}
