 function validarFormulario() {
        var email = document.getElementById("email").value;
        var senha = document.getElementById("senha").value;

        if (nome === "" || email === "" || senha === "") {
            alert("Por favor, preencha todos os campos antes de logar.");
            return false;
        }
        return true;
    }

    document.addEventListener("DOMContentLoaded", function() {
            var formulario = document.getElementById("seuFormulario");
            var botaoSubmit = document.getElementById("btnSubmit");

            formulario.addEventListener("keydown", function(event) {
                if (event.key === "Enter") {
                    event.preventDefault(); // Evita que o formulário seja enviado normalmente
                    validarFormulario(); // Chama a função de validação
                }
            });

            botaoSubmit.addEventListener("click", function() {
                validarFormulario();
            });
        });