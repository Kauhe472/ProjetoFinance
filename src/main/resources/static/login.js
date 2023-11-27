$("#login").click(loginCliente);

$("#email").keyup(function(event){
    if (event.key === "Enter") {
        $("#senha").focus();
    }
});

$("#senha").keyup(function(event){
    if (event.key === "Enter") {
        loginCliente();
    }
});

function loginCliente(){
    let email = $("#email").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data:{
            email: email,
            senha: senha
        },
        success: function(data){
            if(data){
                window.location.href="/ferramentas";
            }else{
                $('.alert-container').html('<div class="alert alert-danger" role="alert">Errooouuu!</div>');
                alert("Errooouuu!");
            }
        },
        error: function(){
            alert("Falha ao tentar realizar o login!");
        }
    });
}