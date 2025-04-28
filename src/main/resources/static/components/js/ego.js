// 타입에 따라 EGO 모달 열기
function openEGOModal(characterType) {
    const modal = document.getElementById('egoModal');
    modal.style.display = 'block';

    // 타입 속성을 이용하여 REST API 호출하기
    fetchEGOData(characterType);
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
function fetchEGOData(characterType) {
    // EGO 그리드와 리스트 요소 초기화
    const egoGrid = document.getElementById('egoGrid');
    const egoListItems = document.getElementById('egoListItems');
    const identityImage = document.getElementById('identityImage');

    // 초기화
    egoGrid.innerHTML = '';
    egoListItems.innerHTML = '';

    // 로딩 표시
    egoGrid.innerHTML = '<div class="loading">데이터 로딩 중...</div>';

    // 일치하는 special-card 찾기 (data-type 속성 기준)
    // if (specialCard) {
        // 인격 이미지는 일치하는 character-card에서 가져옴
        const matchingCharacterCard = document.querySelector(`.character-card[data-type="${characterType}"]`);
        // if (matchingCharacterCard) {
            const characterImg = matchingCharacterCard.querySelector('img');
            if (characterImg) {
                identityImage.src = characterImg.src;
                identityImage.alt = matchingCharacterCard.getAttribute('data-kr-name') || '캐릭터 인격';
            }
        // }

        const specialCard = document.querySelector(`.special-card[data-type="${characterType}"]`);
        // Korean letters를 special-card에서 찾아 EGO 목록으로 사용
        const letterRows = specialCard.querySelectorAll('.korean-letters .letter-row');
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

                egoListRow.innerHTML = `
            <span class="ego-tier-icon">${tier}</span>
            <span class="ego-name">${name}</span>
        `;

                egoListItems.appendChild(egoListRow);
            });
        }
    // }

    // API 호출
    fetch(`/api/ego/${characterType}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('EGO 데이터를 불러오는 데 실패했습니다.');
            }
            return response.json();
        })
        .then(data => {
            // 로딩 메시지 제거
            egoGrid.innerHTML = '';

            // EGO 카드 동적 생성
            if (data.egos && Array.isArray(data.egos)) {
                data.egos.forEach(ego => {
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

// EGO 카드 요소 생성 함수
function createEGOCard(ego) {
    const egoCard = document.createElement('div');
    egoCard.className = 'ego-card';

    egoCard.innerHTML = `
        <div class="ego-frame">
            <div class="ego-effect"></div>
            <div class="ego-circle">
                <img class="ego-image" src="${ego.imageUrl}" alt="${ego.name}">
            </div>
            <div class="ego-nameplate">
                <div class="ego-nameplate-tier">${ego.tier}</div>
                <div class="ego-name">${ego.name}</div>
            </div>
        </div>
    `;

    // 클릭 이벤트 (필요한 경우)
    egoCard.addEventListener('click', () => {
        selectEGO(ego);
    });

    return egoCard;
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