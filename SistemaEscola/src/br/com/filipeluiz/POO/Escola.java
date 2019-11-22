package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Escola {

    private String nome;
    private Cadastramento cadastro;

    public Escola() {
        this.nome = "";
        this.cadastro = new Cadastramento();
    }
    
    public Escola(String nome) {
        this.nome = nome;
        this.cadastro = new Cadastramento();        
    }

    // get's e set's
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cadastramento getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(Cadastramento cadastro) {
        this.cadastro = cadastro;
    }
    // fim get's e set's
    
    // Métodos
    public String gerarMatricula(int limite) {
        return this.cadastro.matricula(limite);
    }
    
    public void cadastrarAluno(Aluno aluno) {
        this.cadastro.addAluno(aluno);
    }
    
    public void cadastrarFuncionario(Funcionario funcionario) {
        this.cadastro.addFuncionario(funcionario);
    }
    
    public void listarAluno() {
        this.cadastro.grupoAluno();
    }
    
    public void listarFuncionario() {
        this.cadastro.grupoFuncionario();
    }
    
    public void procurarAluno(String matricula) {
        try {
            System.out.println(this.cadastro.localizaAluno(matricula));
        } catch(NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void procurarFuncionario(String matricula) {
        try {
            System.out.println(this.cadastro.localizaFuncionario(matricula));
        } catch (NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void removerAluno(String matricula) {
        try {
            this.cadastro.apagaAluno(matricula);
        } catch (NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void removerFuncionario(String matricula) {
        try {
            this.cadastro.apagaFuncionario(matricula);
        } catch(NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Aluno acharAluno(String matricula) {
        try {
            return this.cadastro.localizaAluno(matricula);
        } catch (NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Funcionario acharFuncionario(String matricula) {
        try {
            return this.cadastro.localizaFuncionario(matricula);
        } catch (NaoExisteListaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }    
  
    public void qtdAlunosCadastrados() {
        this.cadastro.qtdAlunos();
    }
    
    public void qtdFuncionarioCadastrados() {
        this.cadastro.qtdFuncionarios();
    }
}
