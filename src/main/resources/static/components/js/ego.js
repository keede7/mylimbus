function openEGOModal() {
    document.getElementById('egoModal').style.display = 'block';
}

function closeEGOModal() {
    document.getElementById('egoModal').style.display = 'none';
}

// Close modal when clicking outside
// 2개가 적용되어있어서 마지막에 적용한 이 function만 기능을 수행하고있다.
window.onclick = function(event) {
    var modal = document.getElementById('egoModal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}