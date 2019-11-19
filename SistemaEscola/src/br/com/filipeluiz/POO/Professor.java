package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Professor extends Funcionario {
    private String materia;
    
    public Professor(String materia) {
        this.materia = materia;
    }

    public Professor(String nome, String matricula, String dataNascimento, char sexo, Contato contato, String dataAdmissao, double salario, String materia) {
        super(nome, matricula, dataNascimento, sexo, contato, dataAdmissao, salario);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "\nNome de aluno: " + super.getNome() +
               "\nNº de matricula: " + super.getMatricula() + 
               "\nSexo: " + super.getSexo() + 
               "\nData de nascimento: " + super.getDataNascimento() +
               "\nMateria: " + this.getMateria() +
               "\nData de admissão: " + super.getDataAdmissao() +
               "\nSalario: R$ " + super.getSalario() +
               super.getContato() + "\n"; 
    }    
}
