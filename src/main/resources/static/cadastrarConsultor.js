function cadastrarConsultor(){
    let podeEnviar = true

	let nome = $("#nome").val();
	let email = $("#email").val();
	let cpf = $("#cpf").val();
	let idade = $("#idade").val();
	let senha = $("#senha").val();
    let confSenha = $("#confSenha").val();

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			email:email,
			cpf:cpf,
			idade:idade,
			senha:senha,
			confSenha:confSenha,
		},
		success: function(data){
			alertaSucesso(data);
            },
        error: function(){
			alert("Não ok");
        }
	});
}

 function validarCPF() {
            var cpf = document.getElementById("cpf").value.replace(/[^\d]+/g,'');

            if (cpf.length !== 11) {
                document.getElementById("resultado").innerHTML = "CPF deve conter 11 dígitos";
                return;
            }

            // Verificação da validade do CPF
            var soma = 0;
            for (var i = 0; i < 9; i++) {
                soma += parseInt(cpf.charAt(i)) * (10 - i);
            }
            var resto = (soma * 10) % 11;

            if ((resto === 10) || (resto === 11)) {
                resto = 0;
            }

            if (resto !== parseInt(cpf.charAt(9))) {
                document.getElementById("resultado").innerHTML = "CPF inválido";
                return;
            }

            soma = 0;
            for (var i = 0; i < 10; i++) {
                soma += parseInt(cpf.charAt(i)) * (11 - i);
            }
            resto = (soma * 10) % 11;

            if ((resto === 10) || (resto === 11)) {
                resto = 0;
            }

            if (resto !== parseInt(cpf.charAt(10))) {
                document.getElementById("resultado").innerHTML = "CPF inválido";
                return;
            }

            document.getElementById("resultado").innerHTML = "CPF válido";
        }