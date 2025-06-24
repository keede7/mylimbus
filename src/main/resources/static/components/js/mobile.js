// 모바일 디바이스 감지 및 가로모드 안내 스크립트
(function() {
    // 모바일 디바이스 감지 함수
    function isMobileDevice() {
        return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ||
            (window.innerWidth <= 768 && 'ontouchstart' in window);
    }

    // 세로모드 감지 함수
    function isPortraitMode() {
        return window.innerHeight > window.innerWidth;
    }

    // 가로모드 안내 alert 표시
    function showLandscapeAlert() {
        alert("📱 모바일은 더 나은 게임 경험을 위해\n화면을 가로모드로 돌려주세요!");
    }

    // 페이지 로드 시 모바일 세로모드 체크
    function checkMobileOrientation() {
        if (isMobileDevice() && isPortraitMode()) {
            showLandscapeAlert();
        }
    }

    // 화면 회전 시 체크 (선택사항)
    function handleOrientationChange() {
        if (isMobileDevice() && isPortraitMode()) {
            setTimeout(() => {
                showLandscapeAlert();
            }, 500); // 회전 애니메이션 완료 후 실행
        }
    }

    // 페이지 로드 완료 후 실행
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', checkMobileOrientation);
    } else {
        checkMobileOrientation();
    }

    // 화면 회전 이벤트 리스너 (선택사항 - 주석 해제 시 활성화)
    // window.addEventListener('orientationchange', handleOrientationChange);
    // window.addEventListener('resize', handleOrientationChange);
})();