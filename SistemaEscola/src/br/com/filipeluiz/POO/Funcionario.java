package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Funcionario extends Pessoa implements Beneficio {
    private String dataAdmissao;
    private double salario;
    
    public Funcionario() {  
    }
    
    public Funcionario(String nome, String matricula, String dataNascimento, char sexo, Contato contato, String dataAdmissao, double salario) {
        super(nome, matricula, dataNascimento, sexo, contato);
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return this.dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void horasExtra() {
        this.salario = this.salario + (this.salario * 0.05);
    }
    
    public void refeicao() {
        this.salario = this.salario + 500;
    }   
}
