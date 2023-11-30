    package ReyKash.ProjetoFinance.Service;

    import ReyKash.ProjetoFinance.Model.M_Cliente;
    import ReyKash.ProjetoFinance.Model.M_Consultor;
    import ReyKash.ProjetoFinance.Model.M_Resposta;
    import ReyKash.ProjetoFinance.Repository.R_Cliente;
    import ReyKash.ProjetoFinance.Repository.R_Consultor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.DataIntegrityViolationException;
    import org.springframework.stereotype.Service;

    import java.time.LocalDate;
    import java.time.format.DateTimeParseException;
    import java.time.temporal.ChronoUnit;
    import java.util.List;

    @Service
    public class S_Consultor {
        @Autowired
        private static R_Consultor r_consultor;


        public S_Consultor(R_Consultor r_consultor) {
            this.r_consultor = r_consultor;
        }

        public static List<M_Consultor> listarConsultores() {
            return r_consultor.listConsultores();
        }

        //public List<M_Cliente> obterClientesPorConsultor(Long id_consultor) {
            //return r_consultor.buscarClientesPorConsultor(id_consultor);
        //}


        public static M_Consultor verificaLogin(String email, String senha){

            if(S_Generico.textoEstaVazio(email)){
                return null;
            }else if(S_Generico.textoEstaVazio(senha)){
                return null;
            }
            return r_consultor.buscarEmailSenha(email, senha);
        }




        public static M_Resposta salvarCadastro(String nome, String email, String cpf,
                                                  String data_nasc, String senha, String confSenha, String tipoConsultor){
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

            if(S_Generico.textoEstaVazio(tipoConsultor)){
                cadastroValido = false;
                mensagem += "O tipo consultor precisa ser preenchido!";
            }

            if(cadastroValido){
                M_Consultor m_consultor = new M_Consultor();
                m_consultor.setNome(nome);
                m_consultor.setEmail(email);
                m_consultor.setCpf(Long.parseLong(S_CPF.limparNumero(cpf)));
                m_consultor.setData_nasc(LocalDate.parse(data_nasc));
                m_consultor.setSenha(senha);
                m_consultor.setTipoConsultor(tipoConsultor);

                try {
                    r_consultor.save(m_consultor);
                    mensagem += "Cadastro realizado com sucesso!";
                }catch (DataIntegrityViolationException e){
                    if(e.getMessage().contains("cpf")){
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