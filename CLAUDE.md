# CLAUDE.md

이 파일은 이 저장소에서 작업할 때 Claude Code (claude.ai/code)에게 가이드를 제공합니다.

## 프로젝트 개요

MyLimbus는 Project Moon의 게임 "림버스 컴퍼니"의 캐릭터 정보 및 팀 구성 시뮬레이터 역할을 하는 Spring Boot 웹 애플리케이션입니다. 캐릭터 인격, 스킬, EGO 능력을 표시하고 사용자가 팀 조합을 시뮬레이션할 수 있게 합니다.

**배포 사이트:** https://limgo.duckdns.org/

## 기술 스택

- **백엔드:** Spring Boot 3.4.4 (Java 17+)
- **프론트엔드:** Vanilla JavaScript + Thymeleaf 템플릿
- **데이터베이스:** H2 (개발/오프라인), MySQL (운영)
- **빌드 도구:** Gradle
- **테스트:** JUnit 5

## 개발 명령어

```bash
# 프로젝트 빌드
./gradlew build

# 테스트 실행
./gradlew test

# 애플리케이션 로컬 실행
./gradlew bootRun

# 배포용 실행 JAR 빌드
./gradlew bootJar

# 빌드 산출물 정리
./gradlew clean
```

## 아키텍처

### 도메인 주도 설계 구조
```
src/main/java/io/keede/mylimbus/
├── config/              # 설정 및 JPA 컨버터
├── domains/             # 도메인 계층
│   ├── personality/     # 캐릭터 인격 도메인
│   ├── ego/            # EGO 능력 도메인
│   └── statistic/      # 분석/방문자 추적
└── web/                # 웹 계층 (컨트롤러, DTO)
```

### 주요 컴포넌트

**메인 API 컨트롤러:** `web/api/ApiController.java`
- `GET /api/personality/base?baseName={characterName}` - 캐릭터별 인격 조회
- `GET /api/personality/{id}` - 인격 상세 정보
- `GET /api/personality/filter` - 고급 인격 필터링
- `GET /api/ego/{characterKRName}` - EGO 능력 조회

**도메인 서비스:**
- `PersonalityQueryService` - N+1 방지를 포함한 고급 인격 필터링
- `EgoQueryService` - EGO 능력 조회
- `PersonalityInitializer` & `EGOInitializer` - 애플리케이션 시작 시 데이터 시드

### 데이터베이스 설계

**주요 엔티티:**
- `Personality` - 스킬, 패시브, 친화성을 가진 캐릭터 인격
- `PersonalitySkill` - 임베드 가능한 스킬 데이터 (죄악 유형, 공격 유형)
- `Passive` - 조건이 있는 캐릭터 패시브 능력
- `EGO` - 사용 조건이 있는 특별 능력

**중요한 패턴:**
- N+1 쿼리 방지를 위한 `@EntityGraph` 사용
- 명시적 그래프 로딩과 함께 `FetchType.LAZY` 사용
- `config/entity/`의 enum 타입용 커스텀 JPA 컨버터
- 모든 수치 계산에 BigDecimal 사용 (금융 정밀도 표준 준수)

## 환경 설정

**프로파일 (application.yml):**
- `local` - H2 데이터베이스, 포트 8080, DDL create-drop
- `dev` - H2 데이터베이스, 포트 9090, DDL update
- `prod` - MySQL 데이터베이스 (application-prod.yml, gitignore됨)

**H2 콘솔:** local/dev 프로파일에서 `/h2-console`에서 사용 가능

## 프론트엔드 아키텍처

**주요 템플릿:**
- `main.html` - 기본 애플리케이션 인터페이스
- `mainTest.html` - 테스트/샌드박스 버전

**JavaScript 모듈:**
- `main.js` - 캐릭터 선택 및 필터링 로직
- `modal.js` - 모달 다이얼로그 관리
- `ego.js` - EGO 표시 기능
- `mobile.js` - 모바일 기기 지원

**주요 프론트엔드 기능:**
- 12-캐릭터 그리드 선택 인터페이스
- 캐릭터 슬롯별 모달 기반 인격 선택
- 친화성, 스킬 유형, 죄악 속성별 실시간 필터링
- 팀 구성 통계 및 시뮬레이션

## 데이터 관리

**캐릭터 데이터:** 12명의 메인 캐릭터 (이상, 파우스트, 돈키호테, 료슈, 뫼르소, 홍루, 히스클리프, 이스마엘, 로쟈, 싱클레어, 오티스, 그레고르)

**데이터 로딩:**
- 인격과 EGO는 `@PostConstruct` 이니셜라이저를 통해 시드됨
- 모든 게임 데이터가 내장됨 (외부 API 의존성 없음)
- Hibernate를 통해 H2/MySQL에 데이터 지속성 유지

## 테스트

**현재 프레임워크:** JUnit 5 (최소 커버리지)
- 기본 컨텍스트 로드 테스트: `MylimbusApplicationTests.java`
- 단일 테스트 실행: `./gradlew test --tests "TestClassName"`

## 배포

**CI/CD:** GitHub Actions 워크플로우 (`.github/workflows/ci-cd.yml`)
1. Gradle로 빌드
2. SCP를 통해 원격 서버에 JAR 업로드
3. 기존 애플리케이션 우아한 종료
4. 새 버전 배포

**운영:** main 브랜치 커밋 시 자동 배포 트리거

## 일반적인 개발 작업

**새로운 인격 추가:**
1. `PersonalityInitializer.java`에서 데이터 업데이트
2. 애플리케이션 재시작 시 데이터 자동 지속화
3. API 엔드포인트를 통해 프론트엔드에 변경사항 반영

**필터 기능 추가:**
1. 새 매개변수로 `RequestPersonalityFilterDto` 확장
2. `Personality` 엔티티 또는 서비스 계층에 필터 로직 추가
3. `PersonalityQueryService.getPersonalityFilter()` 업데이트
4. 새 필터 컨트롤을 포함하도록 프론트엔드 JavaScript 수정

**데이터베이스 변경:**
- dev 프로파일에서 DDL 자동 업데이트 사용
- 운영환경은 수동 스키마 관리
- 오프라인 개발을 위한 내장 H2

## 코드 스타일 가이드

- **언어:** 한국어 주석/문서, 영어 코드
- **네이밍:** CamelCase, 명확한 의도 표현
- **트랜잭션:** 조회 메소드에 `@Transactional(readOnly = true)` 사용
- **DTO:** 불변 데이터 전송 객체에 Records 사용
- **열거형:** 게임 속성(Sin, Affinity 등)에 타입 세이프 열거형 사용