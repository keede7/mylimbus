// Function to open character selection modal
function openCharacterModal(characterElement) {
    const personalityId = characterElement.getAttribute('data-id');
    const personalityKRName = characterElement.getAttribute('data-kr-name');
    const modal = document.getElementById('characterModal');

    // Show modal
    modal.style.display = 'block';

    // Fetch alternative characters via REST API
    fetchAlternativeCharacters(personalityId, personalityKRName);
}

// Function to close character selection modal
// function closeCharacterModal() {
//
//     document.querySelectorAll('input[type="checkbox"]')
//         .forEach(checkbox => {
//             checkbox.checked = false;
//         });
//
//     const modal = document.getElementById('characterModal');
//     modal.style.display = 'none';
// }

// personalityId 미사용
function fetchAlternativeCharacters(personalityId, baseNameKor) {
    // Clear previous content
    const modalGrid = document.getElementById('modalCharacterGrid');
    modalGrid.innerHTML = '';
    modalGrid.setAttribute("data-kr-name", baseNameKor)

    // Create form data for ModelAttribute
    const formData = new FormData();
    formData.append('baseName', baseNameKor);

    // Updated API endpoint with ModelAttribute approach
    fetch(`/api/personality/base?baseName=${baseNameKor}`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            // Populate modal with character alternatives
            data.forEach(character => {
                const li = document.createElement('li');
                li.className = 'character-card';
                li.setAttribute('data-id', character.id);
                li.onclick = function () {
                    console.log(character)
                    selectCharacter(character);
                };

                // Convert rarity number to r1, r2, r3 format
                const rarityClass = `character-frame r${character.rarity}`;

                // Updated inner HTML with converted rarity class
                li.innerHTML = `
                    <div class="character-frame ${rarityClass}">
                        <img src="${character.imgUrl}" alt="${character.baseName}">
<!--                        <div class="character-rarity">${character.rarity}</div>-->
                        <div class="character-type">${character.personalityName}</div>
                        <div class="character-name">${character.baseName}</div>
                    </div>
                `;

                modalGrid.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error fetching character alternatives:', error);
            modalGrid.innerHTML = '';
        });

    const filterCheckBoxes = document.querySelectorAll('.filter-checkbox');

    filterCheckBoxes.forEach(
        checkbox => checkbox.addEventListener('change', filterCharacters)
    )

}

function selectCharacter(character) {
    // Find the original character element that was clicked
    const originalCharacterSlot = document.querySelector('.character-card[data-selected="true"]');

    const idTagName = 'data-id';

    if (originalCharacterSlot) {

        // 이전에 선택된 캐릭터의 스킬 카운트 감소 (이전 캐릭터 정보 필요)
        // 이 부분은 이전 캐릭터 정보를 어떻게 관리하는지에 따라 달라질 수 있음
        const previousCharacterId = originalCharacterSlot.getAttribute(idTagName);
        if (previousCharacterId) {
            decreaseSkillCounts(previousCharacterId);
        }

        // 새로 선택된 캐릭터의 스킬 카운트 증가
        increaseSkillCounts(character);

        // 현재 선택된 캐릭터 ID를 저장해 나중에 감소시킬 때 사용
        originalCharacterSlot.setAttribute(idTagName, character.id);

        // Update the original character slot with the new character data
        originalCharacterSlot.querySelector('img').src = character.imgUrl;

        const frameTag = originalCharacterSlot.querySelector('.character-frame')
        // Remove existing rarity class (r1, r2, r3, etc.)
        frameTag.className = frameTag.className.replace(/\br\d\b/g, '');
        // Add new rarity class
        frameTag.className = `character-frame r${character.rarity}`;

        // originalCharacterSlot.querySelector('.character-rarity').textContent = character.rarity;
        originalCharacterSlot.querySelector('.character-type').textContent = character.personalityName;
        originalCharacterSlot.querySelector('.character-name').textContent = character.baseName;
        originalCharacterSlot.setAttribute(idTagName, character.id);

        // Remove the selected attribute
        originalCharacterSlot.removeAttribute('data-selected');

        // Close the modal
        closeCharacterModal();
    }
}

// 스킬 카운트 업데이트 함수 (증가/감소)
function updateSkillCount(skillType, change) {
    if (!skillType) return;

    // 스킬 타입에 맞는 리소스 아이템 찾기
    const resourceItem = findResourceItemBySkillType(skillType);
    if (!resourceItem) return;

    // 현재 카운트 값 가져오기
    const countSpan = resourceItem.querySelector('.resource-count span:first-child');
    if (!countSpan) return;

    // 현재 값을 가져와서 증감시키기
    let currentCount = parseInt(countSpan.textContent, 10);
    currentCount += change;

    // 최소값은 0, 최대값은 22로 제한 => 최대값은 전체 E.G.O 사용에 필요한 각 자원 총 합이다.
    const maxCount = parseInt(resourceItem.querySelector('.resource-count span:last-child').textContent, 10) || 22;
    currentCount = Math.max(0, Math.min(currentCount, maxCount));

    // 업데이트된 값 적용
    countSpan.textContent = currentCount;
}

// 스킬 카운트 증가 함수
function increaseSkillCounts(character) {
    if (!character) return;

    // 스킬 타입에 따라 해당 리소스 카운트 증가
    updateSkillCount(character.firstSkill?.sinType, 3);
    updateSkillCount(character.secondSkill?.sinType, 2);
    updateSkillCount(character.thirdSkill?.sinType, 1);
}

// 스킬 카운트 감소 함수
function decreaseSkillCounts(personalityId) {
    // 서버에서 해당 캐릭터의 스킬 정보를 가져온 후 카운트 감소
    fetch(`/api/personality/${personalityId}`)
        .then(response => response.json())
        .then(personality => {
            updateSkillCount(personality.firstSkill?.sinType, -3);
            updateSkillCount(personality.secondSkill?.sinType, -2);
            updateSkillCount(personality.thirdSkill?.sinType, -1);
        })
        .catch(error => {
            console.error('Error fetching previous personality skills:', error);
        });
}

// 스킬 타입에 해당하는 리소스 아이템 찾기
function findResourceItemBySkillType(skillType) {
    const skillToImageMap = {
        'WRATH': 'Wrath.webp',
        'LUST': 'Lust.webp',
        'SLOTH': 'Sloth.webp',
        'GLUTTONY': 'Gluttony.webp',
        'GLOOM': 'Gloom.webp',
        'PRIDE': 'Pride.webp',
        'ENVY': 'Envy.webp'
    };

    const imageName = skillToImageMap[skillType];
    if (!imageName) return null;

    // 이미지 경로에 해당 이름이 포함된 리소스 아이템 찾기
    return Array.from(document.querySelectorAll('.resource-item'))
        .find(item => {
            const imgSrc = item.querySelector('img').getAttribute('src');
            return imgSrc && imgSrc.includes(imageName);
        });
}

// When a character is clicked, mark it as selected before opening modal
document.querySelectorAll('.character-card').forEach(card => {
    card.addEventListener('click', function () {
        // Remove previous selection
        document.querySelectorAll('.character-card[data-selected="true"]').forEach(selected => {
            selected.removeAttribute('data-selected');
        });

        // Mark this card as selected
        this.setAttribute('data-selected', 'true');
    });
});

function filterCharacters() {
    console.log("filterCharacters ....")
    // Get all selected keywords
    const modalGrid = document.getElementById('modalCharacterGrid');
    const personalityKRName = modalGrid.getAttribute('data-kr-name'); // characterKRName 이 적합.

    const selectedKeywords = Array.from(
        document.querySelectorAll('input[name="affinity"]:checked')
    ).map(checkbox => checkbox.value);

    // Get all selected attack types
    const selectedSkillTypes = Array.from(
        document.querySelectorAll('input[name="skillType"]:checked')
    ).map(checkbox => checkbox.value);

    // Get all selected skill sin attributes - Added new code here
    const selectedSkillSins = Array.from(
        document.querySelectorAll('input[name="skillSin"]:checked')
    ).map(checkbox => checkbox.value);

    // Build query parameters
    const queryParams = new URLSearchParams();

    queryParams.append("personalityKRName", personalityKRName);

    if (selectedKeywords.length > 0) {
        queryParams.append('personalityAffinities', selectedKeywords.join(','));
    }

    if (selectedSkillTypes.length > 0) {
        queryParams.append('personalitySkillTypes', selectedSkillTypes.join(','));
    }

    // Add the skillSin parameters - Added new code here
    if (selectedSkillSins.length > 0) {
        queryParams.append('personalitySkillSins', selectedSkillSins.join(','));
    }

    // Only proceed if we have filters selected
    if (selectedKeywords.length > 0 || selectedSkillTypes.length > 0 || selectedSkillSins.length > 0) {
        // Clear existing grid
        const modalGrid = document.getElementById('modalCharacterGrid');
        // modalGrid.innerHTML = '<p>데이터를 불러오는 중...</p>';

        // Call the new API with filters
        fetch(`/api/personality/filter?${queryParams.toString()}`, {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                // Populate modal with filtered characters
                populateCharacterGrid(data, modalGrid);
            })
            .catch(error => {
                console.error('Error fetching filtered characters:', error);
                modalGrid.innerHTML = '';
            });
    } else {
        // If no filters selected, use the original API
        console.log("If no filters selected, use the original API");
        fetchAlternativeCharacters("", personalityKRName);
    }
}

// Helper function to populate the character grid
function populateCharacterGrid(characters, gridElement) {
    // Clear the grid
    gridElement.innerHTML = '';

    if (characters.length === 0) {
        // gridElement.innerHTML = '<p>조건에 맞는 인격이 없습니다.</p>';
        return;
    }

    // Add each character to the grid
    characters.forEach(character => {
        const li = document.createElement('li');
        li.className = 'character-card';
        li.setAttribute('data-id', character.id);
        li.onclick = function () {
            selectCharacter(character);
        };

        // Convert rarity number to r1, r2, r3 format
        const rarityClass = `character-frame r${character.rarity}`;

        li.innerHTML = `
            <div class="character-frame ${rarityClass}">
                <img src="${character.imgUrl}" alt="${character.baseName}">
                <div class="character-type">${character.personalityName}</div>
                <div class="character-name">${character.baseName}</div>
            </div>
        `;

        gridElement.appendChild(li);
    });

    console.log(gridElement)
}

// function populateCharacterGrid(characters, gridElement) {
//     // 기존 요소들에게 사라지는 애니메이션 적용
//     const existingItems = gridElement.querySelectorAll('.character-card');
//     existingItems.forEach(item => {
//         item.classList.add('fade-out');
//     });
//
//     // 애니메이션 완료 후 새로운 요소 추가
//     setTimeout(() => {
//         // 그리드 비우기
//         gridElement.innerHTML = '';
//
//         if (characters.length === 0) {
//             return;
//         }
//
//         // 각 캐릭터를 그리드에 추가
//         characters.forEach(character => {
//             const li = document.createElement('li');
//             li.className = 'character-card fade-in'; // fade-in 클래스 추가
//             li.setAttribute('data-id', character.id);
//             li.onclick = function () {
//                 selectCharacter(character);
//             };
//
//             // 레어리티 클래스 변환
//             const rarityClass = `character-frame r${character.rarity}`;
//
//             li.innerHTML = `
//                 <div class="character-frame ${rarityClass}">
//                     <img src="${character.imgUrl}" alt="${character.baseName}">
//                     <div class="character-type">${character.personalityName}</div>
//                     <div class="character-name">${character.baseName}</div>
//                 </div>
//             `;
//
//             gridElement.appendChild(li);
//         });
//     }, 200); // 페이드 아웃 시간에 맞춰 조정
// }