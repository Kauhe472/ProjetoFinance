$("#login").click(login);

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

function login() {
    let email = $("#email").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data: {
            email: email,
            senha: senha
        },
        success: function (data) {
            if (data === "consultor") {
                window.location.href = "/ferramentas";
            } else if (data === "cliente") {
                window.location.href = "/home";
            } else {
                $('.alert-container').html('<div class="alert alert-danger" role="alert">Errooouuu!</div>');
                alert("Errooouuu!");
            }
        },
        error: function () {
            alert("Falha ao tentar realizar o login!");
        }
    });
}
