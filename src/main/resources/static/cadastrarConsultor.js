 document.addEventListener("keydown", function(event) {
      if (event.key === "Enter" && document.activeElement.id === "btn") {
        event.preventDefault();
        cadastrarConsultor();
      }
    });


function cadastrarConsultor() {
  let cadastroValido = true;

  let nome = $("#nome").val();
  let email = $("#email").val();
  let cpf = $("#cpf").val();
  let data_nasc = $("#data_nasc").val();
  let senha = $("#senha").val();
  let confSenha = $("#confSenha").val();
  let tipo_consultor = $("#tipo_consultor").val();

  if (campoVazio(nome)) {
    cadastroValido = false;
    $(".nome").addClass("error-field");
    showToast({ sucesso: false, mensagem: "O nome precisa ser preenchido!" });
  }
  if (campoVazio(email)) {
    cadastroValido = false;
    $(".email").addClass("error-field");
    showToast({ sucesso: false, mensagem: "É necessário informar um email!" });
  }
  if (!validarCPF(cpf)) {
    cadastroValido = false;
    $(".cpf").addClass("error-field");
    showToast({ sucesso: false, mensagem: "O CPF informado é inválido!" });
  }
  if (campoVazio(data_nasc)) {
    cadastroValido = false;
    $(".data_nasc").addClass("error-field");
    showToast({ sucesso: false, mensagem: "A idade é inválida!" });
  }
  if (campoVazio(senha)) {
    cadastroValido = false;
    $(".senha").addClass("error-field");
    showToast({ sucesso: false, mensagem: "É necessário informar uma senha!" });
  } else if (senha != confSenha) {
    cadastroValido = false;
    $(".senha").addClass("error-field");
    showToast({ sucesso: false, mensagem: "A Senha e a confirmação de senha não conferem!" });
  }

  if (cadastroValido) {
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
        tipo_consultor: tipo_consultor,
      },
      success: function (data) {
        window.location.href = "/login";
        localStorage.setItem("mensagemCadastro", "Cadastro realizado com sucesso");
      },
      error: function () {
        showToast({ sucesso: false, mensagem: "Erro ao enviar o cadastro!" });
      },
    });
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