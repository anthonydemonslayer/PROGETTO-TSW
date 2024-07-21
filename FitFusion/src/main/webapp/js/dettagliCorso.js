const checkboxes = document.querySelectorAll('.check');
const submitButton = document.getElementById('aggiungiAlCarrello');

function updateButtonState() {
    const isAnyChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);
    submitButton.disabled = !isAnyChecked;
}

checkboxes.forEach(checkbox => {
    checkbox.addEventListener('change', updateButtonState);
});

// Chiamata iniziale per impostare lo stato corretto del bottone al caricamento della pagina
updateButtonState();