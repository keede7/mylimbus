// 타입에 따라 EGO 모달 열기
function openEGOModal(characterElement) {
    const modal = document.getElementById('egoModal');
    modal.style.display = 'block';

    // 타입 속성을 이용하여 REST API 호출하기
    fetchEGOData(characterElement);
}

function closeEGOModal() {
    document.getElementById('egoModal').style.display = 'none';
}

// 외부 클릭 시 모달 닫기
window.onclick = function(event) {
    const modal = document.getElementById('egoModal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}

// 캐릭터 타입에 따라 EGO 데이터 가져오기
function fetchEGOData(characterElement) {
    // EGO 그리드와 리스트 요소 초기화
    const egoGrid = document.getElementById('egoGrid');
    const egoListItems = document.getElementById('egoListItems');
    const identityImage = document.getElementById('identityImage');

    const characterKRName = characterElement.getAttribute('data-kr-name');
    const characterType = characterElement.getAttribute('data-type');

    // 초기화
    egoGrid.innerHTML = '';
    egoListItems.innerHTML = '';

    // 로딩 표시
    egoGrid.innerHTML = '<div class="loading">데이터 로딩 중...</div>';

    const matchingCharacterCard = document.querySelector(`.character-card[data-type="${characterType}"]`);
    const characterImg = matchingCharacterCard.querySelector('img');
    const personalityType = matchingCharacterCard.querySelector('.character-type').textContent;
    const personalityName = matchingCharacterCard.querySelector('.character-name').textContent;

    if (characterImg) {
        identityImage.src = characterImg.src;
        identityImage.alt = matchingCharacterCard.getAttribute('data-kr-name') || '캐릭터 인격';

        document.getElementById('identityType').textContent = personalityType;
        document.getElementById('identityName').textContent = personalityName;

        const identityType = document.getElementById('identityType');

        // 등급에 따른 색상 설정
        if (matchingCharacterCard.querySelector('.character-frame').classList.contains('r3')) {
            // 고급 (r3) - 골드 색상
            identityType.style.backgroundColor = 'rgba(255, 153, 0, 0.7)';
            identityImage.style.border = '2px solid #ff9900'; // 테두리 굵기 증가 및 색상 변경
            // 배경 그라데이션 추가 (선택 사항)
            identityImage.style.background = 'linear-gradient(to bottom, rgba(51, 34, 0, 0.2), rgba(34, 17, 0, 0.2))';
        } else if (matchingCharacterCard.querySelector('.character-frame').classList.contains('r2')) {
            // 중급 (r2) - 레드 색상
            identityType.style.backgroundColor = 'rgba(255, 51, 0, 0.7)';
            identityImage.style.border = '2px solid #ff3300'; // 테두리 굵기 증가 및 색상 변경
            // 배경 그라데이션 추가 (선택 사항)
            identityImage.style.background = 'linear-gradient(to bottom, rgba(51, 17, 0, 0.2), rgba(34, 10, 0, 0.2))';
        } else {
            // 기본 (r1) - 퍼플 색상
            identityType.style.backgroundColor = 'rgba(153, 102, 204, 0.7)';
            identityImage.style.border = '2px solid #9966cc'; // 테두리 굵기 증가 및 색상 변경
            // 배경 그라데이션 추가 (선택 사항)
            identityImage.style.background = 'linear-gradient(to bottom, rgba(34, 17, 51, 0.2), rgba(17, 10, 34, 0.2))';
        }
    } // ---- EGO Modal 인격 사진 설정

    // 일치하는 ego-main-card 찾기 (data-type 속성 기준)
    const egoMainCard = document.querySelector(`.ego-main-card[data-type="${characterType}"]`);

    // Korean letters를 special-card에서 찾아 EGO 목록으로 사용
    const letterRows = egoMainCard.querySelectorAll('.korean-letters .letter-row');
    if (letterRows && letterRows.length > 0) {
        egoListItems.innerHTML = ''; // 기존 내용 제거

        // 각 letter-row에 대해 ego-list-row 생성
        letterRows.forEach(letterRow => {
            const egoListRow = document.createElement('div');
            egoListRow.className = 'ego-list-row';

            // ego-nameplate-tier와 ego-name 요소 가져오기
            const tierElement = letterRow.querySelector('.ego-nameplate-tier');
            const nameElement = letterRow.querySelector('.ego-name');

            // 요소가 존재하면 그 값을 사용, 없으면 전체 텍스트 사용
            const tier = tierElement ? tierElement.textContent.trim() : letterRow.textContent.trim().charAt(0);
            const name = nameElement ? nameElement.textContent.trim() : letterRow.textContent.trim();

            // 설정 추가
            letterRow.setAttribute("data-tier", tier);

            egoListRow.innerHTML = `
                <span class="ego-tier-icon">${tier}</span>
                <span class="ego-name">${name}</span>
            `;

            egoListItems.appendChild(egoListRow);
        });
    } // EGO List 설정

    // API 호출
    fetch(`/api/ego/${characterKRName}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('EGO 데이터를 불러오는 데 실패했습니다.');
            }
            return response.json();
        })
        .then(egos => {
            // 로딩 메시지 제거
            egoGrid.innerHTML = '';

            // EGO 카드 동적 생성
            if (egos && Array.isArray(egos)) {
                egos.forEach(ego => {
                    // EGO 카드 생성
                    const egoCard = createEGOCard(ego);
                    egoGrid.appendChild(egoCard);
                });
            } else {
                egoGrid.innerHTML = '<div class="no-data">사용 가능한 EGO가 없습니다.</div>';
            }
        })
        .catch(error => {
            console.error('Error fetching EGO data:', error);
            egoGrid.innerHTML = `<div class="error">오류 발생: ${error.message}</div>`;
        });
}

function createEGOCard(ego) {
    const egoCard = document.createElement('div');
    egoCard.className = 'ego-card';

    // 티어 약자 설정 (예: ZAYIN -> Z, WAW -> W)
    let tierShort = '';
    switch(ego.riskLevel) {
        case 'ZAYIN': tierShort = 'Z'; break;
        case 'TETH': tierShort = 'T'; break;
        case 'HE': tierShort = 'H'; break;
        case 'WAW': tierShort = 'W'; break;
        case 'ALEPH': tierShort = 'A'; break;
        default: tierShort = ego.riskLevel.charAt(0);
    }

    // 데이터 속성에 필요한 정보 저장
    egoCard.setAttribute('data-id', ego.id);
    egoCard.setAttribute('data-ego-name', ego.egoName);
    egoCard.setAttribute('data-sin', ego.sinType);
    egoCard.setAttribute('data-risk-level', ego.riskLevel);
    egoCard.setAttribute('data-attack-type', ego.attackType);
    // 추가
    egoCard.setAttribute('data-tier', tierShort);

    // useConditions 데이터를 JSON 문자열로 변환하여 저장
    egoCard.setAttribute('data-use-conditions', JSON.stringify(ego.useConditions));

    // sin 값에 따른 네임플레이트 색상 설정
    let gradientStart = '#c0945c'; // 기본 시작 색상
    let gradientEnd = '#8a6941';   // 기본 끝 색상
    let borderColor = '#d4a76a';   // 기본 테두리 색상
    let shadowColor = 'rgba(192, 148, 92, 0.5)'; // 기본 그림자 색상

    switch(ego.sinType) {
        case 'WRATH':
            gradientStart = '#ff0000'; // 빨강 시작
            gradientEnd = '#990000';   // 빨강 끝
            borderColor = '#ff4444';   // 빨강 테두리
            shadowColor = 'rgba(255, 0, 0, 0.5)';
            break;
        case 'LUST':
            gradientStart = '#ff8800'; // 주황 시작
            gradientEnd = '#cc5500';   // 주황 끝
            borderColor = '#ffaa44';   // 주황 테두리
            shadowColor = 'rgba(255, 136, 0, 0.5)';
            break;
        case 'SLOTH':
            gradientStart = '#ffff00'; // 노랑 시작
            gradientEnd = '#cccc00';   // 노랑 끝
            borderColor = '#ffff44';   // 노랑 테두리
            shadowColor = 'rgba(255, 255, 0, 0.5)';
            break;
        case 'GLUTTONY':
            gradientStart = '#00ff00'; // 초록 시작
            gradientEnd = '#009900';   // 초록 끝
            borderColor = '#44ff44';   // 초록 테두리
            shadowColor = 'rgba(0, 255, 0, 0.5)';
            break;
        case 'GLOOM':
            gradientStart = '#00ccff'; // 하늘 시작
            gradientEnd = '#0099cc';   // 하늘 끝
            borderColor = '#44ddff';   // 하늘 테두리
            shadowColor = 'rgba(0, 204, 255, 0.5)';
            break;
        case 'PRIDE':
            gradientStart = '#0000ff'; // 파랑 시작
            gradientEnd = '#000099';   // 파랑 끝
            borderColor = '#4444ff';   // 파랑 테두리
            shadowColor = 'rgba(0, 0, 255, 0.5)';
            break;
        case 'ENVY':
            gradientStart = '#8800ff'; // 보라 시작
            gradientEnd = '#550099';   // 보라 끝
            borderColor = '#aa44ff';   // 보라 테두리
            shadowColor = 'rgba(136, 0, 255, 0.5)';
            break;
    }

    egoCard.innerHTML = `
        <div class="ego-frame">
            <div class="ego-effect"></div>
            <div class="ego-circle">
                <img class="ego-image" src="${ego.imgUrl}" alt="${ego.egoName}">
            </div>
            <div class="ego-nameplate" 
                style="
                    background: linear-gradient(to bottom, ${gradientStart}, ${gradientEnd}); 
                    border: 2px solid ${borderColor}; 
                    box-shadow: 0 0 10px ${shadowColor};
                    ">
                <div class="ego-nameplate-tier">${tierShort}</div>
                <div class="ego-name">${ego.egoName}</div>
            </div>
        </div>
    `;

    // 클릭 이벤트 추가
    egoCard.addEventListener('click', function() {

        // 1. 선택된 카드인지 확인
        const isSelected = this.getAttribute('data-selected') === 'true';

        // 현재 카드의 ego-nameplate-tier 값 가져오기
        const cardTier = this.getAttribute('data-tier');

        // // 해당 티어와 일치하는 ego-list-row 찾기
        // const allListRows = document.querySelectorAll('.ego-list-row');
        // let matchingListRow = null;
        //
        // allListRows.forEach(row => {
        //     const rowTier = row.querySelector('.ego-tier-icon').textContent.trim();
        //     if (rowTier === cardTier) {
        //         matchingListRow = row;
        //     }
        // });
        //
        // // 일치하는 row가 없으면 중단
        // if (!matchingListRow) {
        //     console.error(`티어 ${cardTier}에 맞는 ego-list-row를 찾을 수 없습니다.`);
        //     return;
        // }

        // 해당 티어와 일치하는 ego-list-row 찾기 - 캐싱 활용
        let matchingListRow = null;
        // DOM 캐싱을 위한 맵 객체가 없으면 초기화
        if (!window.tierRowMap) {
            window.tierRowMap = {};
            document.querySelectorAll('.ego-list-row').forEach(row => {
                const rowTier = row.querySelector('.ego-tier-icon').textContent.trim();
                window.tierRowMap[rowTier] = row;
            });
        }

        // 캐시에서 행 가져오기
        matchingListRow = window.tierRowMap[cardTier];

        // 일치하는 row가 없으면 중단
        if (!matchingListRow) {
            console.error(`티어 ${cardTier}에 맞는 ego-list-row를 찾을 수 없습니다.`);
            return;
        }

        // 원래 티어 이름 저장 (초기화)
        if (!matchingListRow.hasAttribute('data-tier-name')) {
            matchingListRow.setAttribute('data-tier-name', getTier(cardTier));
        }

        if (!isSelected) {
            // 현재 카드 선택 상태로 변경
            this.setAttribute('data-selected', 'true');

            // ego-circle 스타일 변경
            const egoCircle = this.querySelector('.ego-circle');
            egoCircle.style.border = `3px solid #c0945c`;

            // 3. ego-nameplate에서 이름 가져와서 일치하는 ego-list-row에 적용
            matchingListRow.querySelector('.ego-name').textContent = this.querySelector('.ego-nameplate .ego-name').textContent;

            // 4. ego-nameplate의 스타일을 ego-list-row에 적용
            const egoNameplate = this.querySelector('.ego-nameplate');

            matchingListRow.style.background = window.getComputedStyle(egoNameplate).background;
            matchingListRow.style.boxShadow = window.getComputedStyle(egoNameplate).boxShadow;
            matchingListRow.style.fontFamily = window.getComputedStyle(egoNameplate).fontFamily;

            // 선택된 상태를 ego-list-row에도 표시
            matchingListRow.setAttribute('data-card-selected', 'true');
            matchingListRow.setAttribute('data-tier-name', getTier(cardTier));

        } else {

            // 5. 이미 선택된 카드를 다시 클릭하면 선택 해제
            this.setAttribute('data-selected', 'false');

            // ego-circle 스타일 초기화
            const egoCircle = this.querySelector('.ego-circle');
            egoCircle.style.border = ''; // 원래 스타일로 복원

            // ego-list-row 원상 복구
            matchingListRow.querySelector('.ego-name').textContent = matchingListRow.getAttribute('data-tier-name') || '선택되지 않음';

            // ego-list-row의 스타일 초기화
            matchingListRow.style.background = '';
            matchingListRow.style.boxShadow = '';
            matchingListRow.style.fontFamily = '';

            // 선택 상태 해제
            matchingListRow.setAttribute('data-card-selected', 'false');
        }
    });

    return egoCard;
}

function getTier(tier) {
    switch(tier) {
        case 'Z': return  'ZAYIN';
        case 'T': return 'TETH';
        case 'H': return 'HE';
        case 'W': return  'WAW';
        case 'A': return 'ALEPH';
    }
}

// EGO 리스트 항목 생성 함수
function createEGOListRow(ego) {
    const egoListRow = document.createElement('div');
    egoListRow.className = 'ego-list-row';

    egoListRow.innerHTML = `
        <span class="ego-tier-icon">${ego.tier}</span>
        <span class="ego-name">${ego.name}</span>
    `;

    return egoListRow;
}

// EGO 선택 함수 (필요한 경우 구현)
function selectEGO(ego) {
    console.log('Selected EGO:', ego);
    // 여기에 EGO 선택 시 필요한 로직 구현
}