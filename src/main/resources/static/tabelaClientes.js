$('a').click(function(event){
    if(!$(this).hasClass('dropdown-toggle')){
        event.preventDefault();
        if(!$(this).hasClass('btn')){
            $('a').removeClass('active disabled');
            $(this).addClass('active disabled');
        }
        controleRotasGet($(this).attr("href"));
    }
});

$('.navbar-brand').off('click');

function gerarSwal(urlSucesso){
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success me-2',
        cancelButton: 'btn btn-danger ms-2'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Sair?',
      text: "Você realmente deseja sair da aplicação?",
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
      cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
      reverseButtons: false
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href=urlSucesso;
        }
    });
}

function alertaSucesso(mensagem){
    Swal.fire({
        position: 'top-end',
        toast: true,
        icon: 'success',
        title: mensagem,
        showConfirmButton: false,
        timer: 2000
    });
}

function addCliente(){
    let nome = $("#nome").val();
    let email = $("#email").val();
    let perfilInvestidor = $("#perfilInvestidor option:selected").val();


       $.ajax({
              type: "POST",
              url: "/tabelaClientes",
              data:{
                 nome: nome,
                 email: email,
                 perfilInvestidor: perfilInvestidor
              },
              success: function(data){
                  if(data){
                      alert("Acertouuuu!");
                  }else{
                      alert("Errooouuu!");
                  }
              },
              error: function(){
                  alert("Falhou!");
              }
          });

    $("#listaClientes").prepend('<tr>'+
                                    '<td>'+nome+'</td>'+
                                    '<td>'+email+'</td>'+
                                    '<td>'+perfilInvestidor+'</td>'+
                                '</tr>');
}