# 배포 및 개발 명령어

## 개발 명령어

```bash
# 프로젝트 빌드
./gradlew build

# 테스트 실행
./gradlew test

# 단일 테스트 실행
./gradlew test --tests "TestClassName"

# 애플리케이션 로컬 실행
./gradlew bootRun

# 배포용 실행 JAR 빌드
./gradlew bootJar

# 빌드 산출물 정리
./gradlew clean
```

## 테스트

**프레임워크:** JUnit 5
- 기본 컨텍스트 로드 테스트: `MylimbusApplicationTests.java`

## CI/CD

**GitHub Actions 워크플로우:** `.github/workflows/ci-cd.yml`

1. Gradle로 빌드
2. SCP를 통해 원격 서버에 JAR 업로드
3. 기존 애플리케이션 우아한 종료
4. 새 버전 배포

**트리거:** `main` 브랜치 커밋 시 자동 배포

## 배포 환경

**운영 사이트:** https://limgo.duckdns.org/
