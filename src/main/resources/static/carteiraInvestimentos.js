function addInvestimento(){
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
}

$(document).ready(function () {
    // Fazer uma requisição AJAX para obter a lista de consultores do endpoint
    $.ajax({
        type: "GET",
        url: "/carteiraInvestimento",
        success: function (data) {
            $("#tiposInvestimentoDataList").html(data);
        },
        error: function () {
            alert("Falha ao obter a lista tipo investimento");
        }
    });
});