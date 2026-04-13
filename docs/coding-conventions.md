# 코딩 컨벤션

## 코드 스타일 가이드

| 항목 | 규칙 |
|---|---|
| **언어** | 주석/문서는 한국어, 코드는 영어 |
| **네이밍** | CamelCase, 명확한 의도 표현 |
| **트랜잭션** | 조회 메서드에 `@Transactional(readOnly = true)` 사용 |
| **DTO** | 불변 데이터 전송 객체에 Records 사용 |
| **열거형** | 게임 속성(Sin, Affinity 등)에 타입 세이프 열거형 사용 |

## 일반적인 개발 작업

### 새로운 인격 추가

1. `PersonalityInitializer.java`에서 데이터 업데이트
2. 애플리케이션 재시작 시 데이터 자동 지속화
3. API 엔드포인트를 통해 프론트엔드에 변경사항 반영

### 필터 기능 추가

1. 새 매개변수로 `RequestPersonalityFilterDto` 확장
2. `Personality` 엔티티 또는 서비스 계층에 필터 로직 추가
3. `PersonalityQueryService.getPersonalityFilter()` 업데이트
4. 새 필터 컨트롤을 포함하도록 프론트엔드 JavaScript 수정
