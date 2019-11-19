package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Aluno extends Pessoa {
    private Turma turma;
    
    public Aluno() {
    }
    
    public Aluno(String nome, String matricula, String dataNascimento, char sexo, Contato contato, Turma turma) {
        super(nome, matricula, dataNascimento, sexo, contato);
        this.turma = turma;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    @Override
    public String toString() {
        return "\nNome de aluno: " + super.getNome() +
               "\nNº de matricula: " + super.getMatricula() + 
               "\nSexo: " + super.getSexo() + 
               "\nData de nascimento: " + super.getDataNascimento() +
               "\nTurma: " + this.getTurma() + 
               super.getContato() + "\n"; 
    }
}
