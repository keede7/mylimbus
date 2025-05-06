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
// window.onclick = function(event) {
//     const modal = document.getElementById('egoModal');
//     if (event.target === modal) {
//         modal.style.display = 'none';
//     }
// }

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

    // Main Grid에서 선택된 EGO 정보 수집
    const selectedEGOs = [];
    if (egoMainCard) {
        const letterRows = egoMainCard.querySelectorAll('.letter-row[data-selected="true"]');

        letterRows.forEach(row => {
            const egoId = row.getAttribute('data-ego-id');
            const tier = row.getAttribute('data-tier');
            const egoName = row.querySelector('.ego-name').textContent;
            if (egoId) {
                selectedEGOs.push({ id: egoId, tier: tier, name: egoName });
            }
        });
    }

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

            // 색상부여
            egoListRow.style.background = window.getComputedStyle(letterRow).background;
            egoListRow.style.boxShadow = window.getComputedStyle(letterRow).boxShadow;
            egoListRow.style.fontFamily = window.getComputedStyle(letterRow).fontFamily;

            // 선택된 상태 복원
            if (letterRow.getAttribute('data-selected') === 'true') {
                egoListRow.setAttribute('data-card-selected', 'true');
            }

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
                    const egoCard = createEGOCard(ego, characterType);

                    // 이전에 선택된 EGO인지 확인하고 상태 복원
                    const selectedEGO = selectedEGOs.find(selected => {
                        return parseInt(selected.id) === parseInt(ego.id)
                    });

                    if (selectedEGO) {
                        egoCard.setAttribute('data-selected', 'true');
                        const egoCircle = egoCard.querySelector('.ego-circle');
                        egoCircle.style.border = '3px solid #c0945c';
                    }

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

function createEGOCard(ego, characterType) {
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

        // 같은 티어를 가진 모든 EGO 카드 찾기
        const allEgoCards = document.querySelectorAll('.ego-card');

        // 같은 티어의 다른 선택된 카드들 해제
        allEgoCards.forEach(card => {
            if (card.getAttribute('data-tier') === cardTier && card !== this) {
                if (card.getAttribute('data-selected') === 'true') {
                    // 선택 해제될 카드의 자원 정보 가져오기
                    const useConditionsStr = card.getAttribute('data-use-conditions');
                    if (useConditionsStr) {
                        try {
                            const useConditions = JSON.parse(useConditionsStr);
                            // 선택 해제될 카드의 자원 복원 (빼기)
                            updateResourceCount(useConditions, false);
                        } catch (e) {
                            console.error('Error parsing use conditions:', e);
                        }
                    }

                    // 카드 선택 해제
                    card.setAttribute('data-selected', 'false');
                    const egoCircle = card.querySelector('.ego-circle');
                    egoCircle.style.border = ''; // border 초기화
                }
            }
        });

        // 해당 티어와 일치하는 ego-list-row 찾기
        const allListRows = document.querySelectorAll('.ego-list-row');
        let matchingListRow = null;

        allListRows.forEach(row => {
            const rowTier = row.querySelector('.ego-tier-icon').textContent.trim();
            if (rowTier === cardTier) {
                matchingListRow = row;
            }
        });

        // 일치하는 row가 없으면 중단
        if (!matchingListRow) {
            console.error(`티어 ${cardTier}에 맞는 ego-list-row를 찾을 수 없습니다.`);
            return;
        }

        // 원래 티어 이름 저장 (초기화)
        if (!matchingListRow.hasAttribute('data-tier-name')) {
            matchingListRow.setAttribute('data-tier-name', getTier(cardTier));
        }

        // 2. data-type이 일치하는 ego-main-grid 찾기
        const matchingMainGrid = document.querySelector(`.ego-main-card[data-type="${characterType}"]`);

        // letter-row 값을 저장할 맵 초기화 (필요한 경우)
        if (matchingMainGrid && !window.letterRowOriginalNames) {
            window.letterRowOriginalNames = {};
        }

        // 현재 카드의 자원 정보 가져오기
        const useConditionsStr = this.getAttribute('data-use-conditions');
        let useConditions = [];
        if (useConditionsStr) {
            try {
                useConditions = JSON.parse(useConditionsStr);
            } catch (e) {
                console.error('Error parsing use conditions:', e);
            }
        }
        console.log("useConditions");
        console.log(useConditions);

        if (!isSelected) {
            // 현재 카드 선택 상태로 변경
            this.setAttribute('data-selected', 'true');

            // 선택한 카드의 자원 적용 (더하기)
            updateResourceCount(useConditions, true);

            // ego-circle 스타일 변경
            const egoCircle = this.querySelector('.ego-circle');
            egoCircle.style.border = `3px solid #c0945c`;

            // 3. ego-nameplate에서 이름 가져와서 일치하는 ego-list-row에 적용
            const egoName = this.querySelector('.ego-nameplate .ego-name').textContent;
            matchingListRow.querySelector('.ego-name').textContent = egoName;

            // 4. ego-nameplate의 스타일을 ego-list-row에 적용
            const egoNameplate = this.querySelector('.ego-nameplate');

            matchingListRow.style.background = window.getComputedStyle(egoNameplate).background;
            matchingListRow.style.boxShadow = window.getComputedStyle(egoNameplate).boxShadow;
            matchingListRow.style.fontFamily = window.getComputedStyle(egoNameplate).fontFamily;

            // 선택된 상태를 ego-list-row에도 표시
            matchingListRow.setAttribute('data-card-selected', 'true');
            matchingListRow.setAttribute('data-tier-name', getTier(cardTier));

            // 5. ego-main-grid의 letter-row 업데이트 (해당하는 티어만)
            if (matchingMainGrid) {
                const letterRow = matchingMainGrid.querySelector(`.letter-row[data-tier="${cardTier}"]`);
                if (letterRow) {
                    // 원래 값 저장 (아직 저장되지 않은 경우)
                    if (!window.letterRowOriginalNames[cardTier]) {
                        window.letterRowOriginalNames[cardTier] = letterRow.querySelector('.ego-name').textContent;
                    }

                    // 선택한 카드의 이름으로 업데이트
                    letterRow.querySelector('.ego-name').textContent = egoName;

                    // 스타일 변경 (선택사항)
                    letterRow.style.background = window.getComputedStyle(egoNameplate).background;
                    letterRow.style.boxShadow = window.getComputedStyle(egoNameplate).boxShadow;
                    letterRow.style.fontFamily = window.getComputedStyle(egoNameplate).fontFamily;

                    // 선택 상태 표시
                    letterRow.setAttribute('data-selected', 'true');
                    letterRow.setAttribute('data-ego-id', ego.id)
                }
            }

        } else {

            // 5. 이미 선택된 카드를 다시 클릭하면 선택 해제
            this.setAttribute('data-selected', 'false');

            // 선택 해제된 카드의 자원 복원 (빼기)
            updateResourceCount(useConditions, false);

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

            // ego-main-grid의 letter-row 초기화
            if (matchingMainGrid) {
                const letterRow = matchingMainGrid.querySelector(`.letter-row[data-tier="${cardTier}"]`);
                if (letterRow) {
                    // 원래 값으로 복원
                    const originalLetterName = window.letterRowOriginalNames[cardTier] || getTier(cardTier);
                    letterRow.querySelector('.ego-name').textContent = originalLetterName;

                    // 스타일 초기화
                    letterRow.style.background = '';
                    letterRow.style.boxShadow = '';
                    letterRow.style.fontFamily = '';

                    // 선택 상태 해제
                    letterRow.setAttribute('data-selected', 'false');
                }
            }
        }
    });

    return egoCard;
}


// 자원 카운트 업데이트 함수
function updateResourceCount(useConditions, isAdd) {
    if (!useConditions || !Array.isArray(useConditions)) return;

    // Sin 타입에 따른 인덱스 매핑
    const sinTypeToIndex = {
        'WRATH': 0,    // 빨강
        'LUST': 1,     // 주황
        'SLOTH': 2,    // 노랑
        'GLUTTONY': 3, // 초록
        'GLOOM': 4,    // 파랑
        'PRIDE': 5,    // 남색
        'ENVY': 6      // 보라
    };

    // 자원 항목 요소들 가져오기
    const resourceItems = document.querySelectorAll('.resource-item');

    // 각 자원 조건에 대해
    useConditions.forEach(condition => {
        const sinType = condition.sinType;
        const quantity = condition.consumedQuantity || 0;

        // 매핑된 인덱스 가져오기
        const index = sinTypeToIndex[sinType];

        // 해당 인덱스의 자원 항목이 존재하는지 확인
        if (index !== undefined && index >= 0 && index < resourceItems.length) {
            const resourceItem = resourceItems[index];
            const resourceCountSpans = resourceItem.querySelectorAll('.resource-count span');

            // 두 번째 span (필요한 전체 개수)에 접근
            if (resourceCountSpans.length >= 2) {
                const totalCountSpan = resourceCountSpans[1];
                const currentTotal = parseInt(totalCountSpan.textContent) || 0;

                // 더하기 또는 빼기 연산
                const newTotal = isAdd ? currentTotal + quantity : currentTotal - quantity;

                // 값 업데이트 (음수 방지)
                totalCountSpan.textContent = Math.max(0, newTotal);
            }
        }
    });
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