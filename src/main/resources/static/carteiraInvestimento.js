
function salvarInvestimento(){
    let investimentoValido = true

	let tipo = $("#tipo").val();
	let tag = $("#tag").val();
	let valor = $("#valor").val();

	if(investimentoValido){
            $.ajax({
                    type: "POST",
                    url: "/carteiraInvestimento",
                    data: {
                        tipo: tipo,
                        tag: tag,
                        valor: valor,
                    },
                    success: function (data) {
                        window.location.href = "/carteiraInvestimento";
                        localStorage.setItem("mensagemCadastro", "Investimento Adicionado");

                    },
                    error: function () {
                        showToast({ sucesso: false, mensagem: "Erro ao enviar o cadastro!" });
                    }
                });
            }
    }

