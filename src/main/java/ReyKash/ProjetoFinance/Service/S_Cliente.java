    package ReyKash.ProjetoFinance.Service;

    import ReyKash.ProjetoFinance.Model.M_Cliente;
    import ReyKash.ProjetoFinance.Model.M_Resposta;
    import ReyKash.ProjetoFinance.Repository.R_Cliente;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.DataIntegrityViolationException;
    import org.springframework.stereotype.Service;

    import java.time.LocalDate;
    import java.time.format.DateTimeParseException;
    import java.time.temporal.ChronoUnit;
    import java.util.ArrayList;
    import java.util.List;


    @Service
    public class S_Cliente {

        @Autowired
        private static R_Cliente r_cliente;

        public S_Cliente(R_Cliente r_cliente) {
            this.r_cliente = r_cliente;
        }


        /*@Autowired
        private S_CarteiraVirtual s_carteiraVirtual; // Injeção do serviço da carteira virtual

        public M_Cliente obterClienteComCarteira(Long id_cliente) {
            M_Cliente cliente = r_cliente.obterClienteComCarteira(id_cliente);
            if (cliente != null) {
                List<M_CarteiraVirtual> carteiraVirtual = s_carteiraVirtual.obterDetalhesCarteiraPorCliente(id_cliente);
                cliente.setCarteiraVirtual(carteiraVirtual);
            }
            return cliente;
        }*/

        public static List<M_Cliente> listarClientesDoConsultor(Long id_cliente) {
            return r_cliente.buscaClientesPorConsultor(id_cliente);
        }

        public static ArrayList<M_Cliente> listarClientes() {
            return r_cliente.listClientes();
        }

        public static M_Cliente verificaLogin(String email, String senha){

            if(S_Generico.textoEstaVazio(email)){
                return null;
            }else if(S_Generico.textoEstaVazio(senha)){
                return null;
            }
            return r_cliente.buscarEmailSenha(email, senha);
        }

        public static M_Resposta salvarCadastro(String nome, String email, String cpf,
                                                  String data_nasc, String senha, String confSenha){
            boolean cadastroValido = true;
            String mensagem = "";

            if(S_Generico.textoEstaVazio(nome)){
                cadastroValido = false;
                mensagem += "O nome precisa ser preenchido!";
            }
            if(!S_Generico.validarEmail(email)){
                cadastroValido = false;
                mensagem += "e-Mail é inválido!";
            }
            if(!S_CPF.validarCPF(cpf)){
                cadastroValido = false;
                mensagem += "O CPF informado é inválido!";
            }

            if(S_Generico.textoEstaVazio(data_nasc)){
                cadastroValido = false;
                mensagem += "A data de nascimento não pode estar vazia!";
            } else {
                // Validar a idade com base na data de nascimento
                try {
                    LocalDate dataNascimentoDate = LocalDate.parse(data_nasc);
                    LocalDate dataAtual = LocalDate.now();
                    long idade = ChronoUnit.YEARS.between(dataNascimentoDate, dataAtual);

                    if (idade <= 0 || idade > 150) {
                        cadastroValido = false;
                        mensagem += "A idade deve estar entre 1 e 150 anos!";
                    }
                } catch (DateTimeParseException e) {
                    cadastroValido = false;
                    mensagem += "A data de nascimento é inválida!";
                }
            }

            if(senha == null || senha.equals("")){
                cadastroValido = false;
                mensagem += "É necessário informar uma senha!";
            }else if(!senha.equals(confSenha)){
                mensagem += "A senha e a confirmação de senha precisam ser iguais!";
            }

            if(cadastroValido){
                M_Cliente m_cliente = new M_Cliente();
                m_cliente.setNome(nome);
                m_cliente.setEmail(email);
                m_cliente.setCpf(Long.parseLong(S_CPF.limparNumero(cpf)));
                m_cliente.setData_nasc(LocalDate.parse(data_nasc));
                m_cliente.setSenha(senha);

                try {
                    r_cliente.save(m_cliente);
                    mensagem += "Cadastro realizado com sucesso!";
                }catch (DataIntegrityViolationException e){
                    if(e.getMessage().contains("u_cpf")){
                        mensagem += "O CPF informado já foi cadastrado!";
                    }else{
                        mensagem += "Erro ao cadastrar";
                    }
                    cadastroValido = false;
                }
            }
            return new M_Resposta(cadastroValido, mensagem);
        }
    }