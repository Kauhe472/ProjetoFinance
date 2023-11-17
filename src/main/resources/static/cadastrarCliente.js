function cadastrarCliente(){
	let nome = $("#nome").val();
	let email = $("#email").val();
	let cpf = $("#cpf").val();
	let idade = $("#idade").value;
	let senha = $("#senha").value;

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			email:email,
			cpf:cpf,
			idade:idade,
			senha:senha
		},
		success:function(data){
			alertaSucesso(data);
		},
		error: function(){
			alert("Não ok");
		}
	});
}