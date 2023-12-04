


function salvarInvestimento(){
    let investimentoValido = true

	let tipo = $("#tipo").val();
	let tag = $("#tag").val();
	let valor = $("#valor").val();

	if(investimentoValido){
            $.ajax({
                    type: "POST",
                    url: "/carteiraInvestimentos",
                    data: {
                        tipo: tipo,
                        tag: tag,
                        valor: valor,
                    },
                    success: function (data) {
                        window.location.href = "/carteiraInvestimentos";
                        localStorage.setItem("mensagemCadastro", "Investimento Adicionado");

                    },
                    error: function () {
                        showToast({ sucesso: false, mensagem: "Erro ao enviar o cadastro!" });
                    }
                });
            }
    }

