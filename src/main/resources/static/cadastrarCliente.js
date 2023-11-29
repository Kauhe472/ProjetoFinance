 document.addEventListener("keydown", function(event) {
      if (event.key === "Enter" && document.activeElement.id === "btn") {
        event.preventDefault();
        cadastrarCliente();
      }
    });

 document.addEventListener("keydown", function(event) {
      if (event.key === "Enter" && document.activeElement.id === "btn") {
        event.preventDefault();
        cadastrarCliente();
      }
    });

$(document).ready(function () {
    // Fazer uma requisição AJAX para obter a lista de consultores do endpoint /consultores
    $.ajax({
        type: "GET",
        url: "/consultores",
        success: function (data) {
            // Preencher o datalist com os consultores obtidos
            $("#consultoresDataList").html(data);
        },
        error: function () {
            alert("Falha ao obter a lista de consultores");
        }
    });
});


//function cadastrarCliente(){
//    let cadastroValido = true
//
//	let nome = $("#nome").val();
//	let email = $("#email").val();
//	let cpf = $("#cpf").val();
//	let data_nasc = $("#data_nasc").val();
//	let senha = $("#senha").val();
//	let confSenha = $("#confSenha").val();
//	let id_consultor = $("#ConsultoresList option[value='" + $("#consultor").val() + "']").data("value");
//
//    if(campoVazio(nome)){
//    		podeEnviar = false;
//    		$(".nome").addClass("error-field");
//    		showToast({sucesso:false,mensagem:"O nome precisa ser preenchido!"});
//    	}
//    	if(campoVazio(email)){
//            		podeEnviar = false;
//            		$(".email").addClass("error-field");
//            		showToast({sucesso:false,mensagem:"É necessário informar um email!"});
//            	}
//    	if(!validarCPF(cpf)){
//            podeEnviar = false;
//            $(".cpf").addClass("error-field");
//            showToast({sucesso:false,mensagem:"O CPF informado é inválido!"});
//        }
//        if(campoVazio(data_nasc)){
//                    podeEnviar = false;
//                    $(".data_nasc").addClass("error-field");
//                    showToast({sucesso:false,mensagem:"A idade é invalida!"});
//                }
//    	if(campoVazio(senha)){
//    		podeEnviar = false;
//    		$(".senha").addClass("error-field");
//    		showToast({sucesso:false,mensagem:"É necessário informar uma senha!"});
//    	}else if(senha != confSenha){
//    		podeEnviar = false;
//    		$(".senha").addClass("error-field");
//    		showToast({sucesso:false,mensagem:"A Senha e a confirmação de senha não conferem!"});
//    	}
//
//
//	if(cadastroValido){
//            $.ajax({
//                type: "POST",
//                url: "/cadastro",
//                data: {
//                    nome: nome,
//                    email: email,
//                    cpf: cpf,
//                    data_nasc: data_nasc,
//                    senha: senha,
//                    confSenha: confSenha,
//                    id_consultor: id_consultor
//                },
//                success: function(data){
//                    window.location.href="/homeLogado";
//                },
//                error: function(){
//                    showToast({sucesso: false, mensagem: "Erro ao enviar o cadastro!"});
//                }
//            })
//        }
//}


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

function cadastrarCliente(){
    let cadastroValido = true

	let nome = $("#nome").val();
	let email = $("#email").val();
	let cpf = $("#cpf").val();
	let data_nasc = $("#data_nasc").val();
	let senha = $("#senha").val();
	let confSenha = $("#confSenha").val();
	let id_consultor = $("#ConsultoresList option[value='" + $("#consultor").val() + "']").data("value");

    if(campoVazio(nome)){
    		podeEnviar = false;
    		$(".nome").addClass("error-field");
    		showToast({sucesso:false,mensagem:"O nome precisa ser preenchido!"});
    	}
    	if(campoVazio(email)){
            		podeEnviar = false;
            		$(".email").addClass("error-field");
            		showToast({sucesso:false,mensagem:"É necessário informar um email!"});
            	}
    	if(!validarCPF(cpf)){
            podeEnviar = false;
            $(".cpf").addClass("error-field");
            showToast({sucesso:false,mensagem:"O CPF informado é inválido!"});
        }
        if(campoVazio(data_nasc)){
                    podeEnviar = false;
                    $(".data_nasc").addClass("error-field");
                    showToast({sucesso:false,mensagem:"A idade é invalida!"});
                }
    	if(campoVazio(senha)){
    		podeEnviar = false;
    		$(".senha").addClass("error-field");
    		showToast({sucesso:false,mensagem:"É necessário informar uma senha!"});
    	}else if(senha != confSenha){
    		podeEnviar = false;
    		$(".senha").addClass("error-field");
    		showToast({sucesso:false,mensagem:"A Senha e a confirmação de senha não conferem!"});
    	}


	if(cadastroValido){
            $.ajax({
                type: "POST",
                url: "/cadastro",
                data: {
                    nome: nome,
                    email: email,
                    cpf: cpf,
                    data_nasc: data_nasc,
                    senha: senha,
                    confSenha: confSenha,
                    id_consultor: id_consultor
                },
                success: function(data){
                    window.location.href="/login";
                },
                error: function(){
                    showToast({sucesso: false, mensagem: "Erro ao enviar o cadastro!"});
                }
            })
        }
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