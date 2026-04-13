# API 스펙

## 메인 API 컨트롤러

**파일:** `web/api/ApiController.java`

## 엔드포인트 목록

### 인격 (Personality)

| 메서드 | 경로 | 설명 |
|---|---|---|
| `GET` | `/api/personality/base?baseName={characterName}` | 캐릭터별 인격 조회 |
| `GET` | `/api/personality/{id}` | 인격 상세 정보 |
| `GET` | `/api/personality/filter` | 고급 인격 필터링 |

#### `/api/personality/filter` 파라미터

- `affinity` - 친화성 필터 (Affinity enum)
- `sin` - 죄악 속성 필터 (Sin enum)
- `attackType` - 공격 유형 필터 (AttackType enum)
- `attackTypeQuantity` - 공격 유형 최소 개수
- `personalityKRName` - 인격 한국어 이름 필터

**관련 DTO:** `RequestPersonalityFilterDto`
**관련 서비스:** `PersonalityQueryService.getPersonalityFilter()`

### EGO

| 메서드 | 경로 | 설명 |
|---|---|---|
| `GET` | `/api/ego/{characterKRName}` | 캐릭터의 EGO 능력 조회 |

**관련 서비스:** `EgoQueryService`
