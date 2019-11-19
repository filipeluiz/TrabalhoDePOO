package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public abstract class Pessoa {
    protected String nome;
    protected String matricula;
    protected String dataNascimento;
    protected char sexo;
    protected Contato contato;
    
    Pessoa() {}
    
    Pessoa(String nome, String matricula, String dataNascimento, char sexo, Contato contato) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.contato = contato;
    }
     
    public void setNome(String n) {
        this.nome = n;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setMatricula(String m) {
        this.matricula = m;
    }
    
    public String getMatricula() {
        return this.matricula;
    }    

    public void setDataNascimento(String d) {
        this.dataNascimento = d;
    }
    
    public String getDataNascimento() {
        return this.dataNascimento;
    }    
    
    public void setSexo(char s) {
        this.sexo = s;
    }
    
    public char getSexo() {
        return this.sexo;
    }    

    public void setContato(Contato c) {
        this.contato = c;
    }
    
    public Contato getContato() {
        return this.contato;
    }    
}
