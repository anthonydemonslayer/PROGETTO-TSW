document.addEventListener('DOMContentLoaded', function() {
    const inputs = document.querySelectorAll('input, select, textarea');

    inputs.forEach(input => {
        input.addEventListener('input', validateInput);
        input.addEventListener('blur', validateInput);
    });

    function validateInput(event) {
        const input = event.target;
        let isValid = true;

        if (input.value.trim() === '' && input.required) {
            isValid = false;
        } else {
            switch(input.type) {
                case 'email':
                    isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(input.value) || input.value === '';
                    break;
                case 'number':
                    isValid = !isNaN(input.value) || input.value === '';
                    break;
                case 'tel':
                    isValid = /^\+?[\d\s-]{10,}$/.test(input.value) || input.value === '';
                    break;
                case 'date':
                    isValid = !isNaN(Date.parse(input.value)) || input.value === '';
                    break;
                case 'url':
                    isValid = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/.test(input.value) || input.value === '';
                    break;
                default:
                    isValid = true; // Assume valid for other types
            }
        }

        if (isValid) {
            input.style.border = '3px solid var(--nero)';  // Ripristina il bordo normale
        } else {
            input.style.border = '3px solid var(--rosso)';   // Imposta il bordo rosso
        }
    }
});
