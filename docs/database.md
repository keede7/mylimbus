# 데이터베이스 설계

## 주요 엔티티

| 엔티티 | 설명 |
|---|---|
| `Personality` | 스킬, 패시브, 친화성을 가진 캐릭터 인격 |
| `PersonalitySkill` | 임베드 가능한 스킬 데이터 (죄악 유형, 공격 유형) |
| `Passive` | 조건이 있는 캐릭터 패시브 능력 |
| `EGO` | 사용 조건이 있는 특별 능력 |

## 중요한 패턴

- N+1 쿼리 방지를 위한 `@EntityGraph` 사용
- 명시적 그래프 로딩과 함께 `FetchType.LAZY` 사용
- `config/entity/`의 enum 타입용 커스텀 JPA 컨버터
- 모든 수치 계산에 `BigDecimal` 사용 (금융 정밀도 표준 준수)

## 환경 프로파일 (application.yml)

| 프로파일 | DB | 포트 | DDL 전략 |
|---|---|---|---|
| `local` | H2 | 8080 | create-drop |
| `dev` | H2 | 9090 | update |
| `prod` | MySQL | - | 수동 관리 |

> **prod 설정:** `application-prod.yml` (gitignore됨)
> **H2 콘솔:** local/dev 프로파일에서 `/h2-console` 접근 가능

## 데이터 관리

**캐릭터 데이터:** 12명의 메인 캐릭터
- 이상, 파우스트, 돈키호테, 료슈, 뫼르소, 홍루, 히스클리프, 이스마엘, 로쟈, 싱클레어, 오티스, 그레고르

**데이터 로딩 방식:**
- 인격과 EGO는 `@PostConstruct` 이니셜라이저를 통해 시드됨
- 모든 게임 데이터가 내장됨 (외부 API 의존성 없음)
- Hibernate를 통해 H2/MySQL에 데이터 지속성 유지

**관련 파일:**
- `PersonalityInitializer.java` - 인격 데이터 시드
- `EGOInitializer.java` - EGO 데이터 시드

## 데이터베이스 변경 시

- `dev` 프로파일에서 DDL 자동 업데이트 사용
- 운영환경은 수동 스키마 관리
- 오프라인 개발을 위한 내장 H2 활용
