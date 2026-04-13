# 아키텍처

## 기술 스택

| 영역 | 기술 |
|---|---|
| **백엔드** | Spring Boot 3.4.4 (Java 17+) |
| **프론트엔드** | Vanilla JavaScript + Thymeleaf 템플릿 |
| **데이터베이스** | H2 (개발/오프라인), MySQL (운영) |
| **빌드 도구** | Gradle |
| **테스트** | JUnit 5 |

## 도메인 주도 설계 구조

```
src/main/java/io/keede/mylimbus/
├── config/              # 설정 및 JPA 컨버터
├── domains/             # 도메인 계층
│   ├── personality/     # 캐릭터 인격 도메인
│   ├── ego/            # EGO 능력 도메인
│   └── statistic/      # 분석/방문자 추적
└── web/                # 웹 계층 (컨트롤러, DTO)
```

## 주요 컴포넌트

### 도메인 서비스

| 서비스 | 역할 |
|---|---|
| `PersonalityQueryService` | N+1 방지를 포함한 고급 인격 필터링 |
| `EgoQueryService` | EGO 능력 조회 |
| `PersonalityInitializer` | 애플리케이션 시작 시 인격 데이터 시드 |
| `EGOInitializer` | 애플리케이션 시작 시 EGO 데이터 시드 |

### API 컨트롤러

**파일:** `web/api/ApiController.java`

> 상세 엔드포인트 스펙은 [api-spec.md](api-spec.md) 참조
