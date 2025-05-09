// Function to close character selection modal
function closeCharacterModal() {

    document.querySelectorAll('input[type="checkbox"]')
        .forEach(checkbox => {
            checkbox.checked = false;
        });

    const modal = document.getElementById('characterModal');
    modal.style.display = 'none';
}

// Close modal when clicking outside of it
window.onclick = function (event) {
    const modal = document.getElementById('characterModal');
    if (event.target === modal) {
        closeCharacterModal();
    }

    const egoModal = document.getElementById('egoModal');
    if (event.target === egoModal) {
        egoModal.style.display = 'none';
    }

};