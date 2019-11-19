package br.com.filipeluiz.POO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author filipe
 */
public class Escola {

    private String nome;
    private Contato contato;
    private List<Aluno> alunos;
    private List<Funcionario> funcionarios;
    
    public Escola() {
        this.nome = "";
        this.contato = new Contato();
        this.alunos = new ArrayList<Aluno>();
        this.funcionarios = new ArrayList<Funcionario>();
    }
    
    public Escola(String nome, Contato contato, List<Aluno> alunos, List<Funcionario> funcionarios) {
        this.nome = nome;
        this.contato = contato;
        this.alunos = alunos;
        this.funcionarios = funcionarios;
    }
    
    public Escola(String nome) {
        this.nome = nome;
        this.contato = new Contato();
        this.alunos = new ArrayList<Aluno>();
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public String getNome() {
        return this.nome;
    }

    public Contato getContato() {
        return this.contato;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    // fiz dois métodos para aluno e funcionario, duplamente códigos(parecido) não é boa prática.   
    // Dá para fazer um método génerico para usar Aluno e funcionário com List<Object>? 
    // ou POO pode nos ajudar sem duplicação do codigos? Como se faz?
    
    // Abaixo os métodos são duplicados(Aluno e Funcionario).

    private static void ordenaPorNomeAluno(List<Aluno> alunos) {
        Collections.sort(alunos, new Comparator<Aluno>() {
            public int compare(Aluno o1, Aluno o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
     });
    }   
    
    private static void ordenaPorNomeFuncionario(List<Funcionario> funcionarios) {
        Collections.sort(funcionarios, new Comparator<Funcionario>() {
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
     });
    }    
    
    public String gerarMatricula(int limite) {
        Random gerador = new Random();
        int aleatorio = gerador.nextInt(limite);
        String matricula;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        if(aleatorio < 10) { // 0 até 9 (1 digitos)
            matricula = year + "101" + "00" + aleatorio;           
        } 
        else if(aleatorio > 9 && aleatorio < 100) { // 10 até 99 (2 digitos)
            matricula = year + "101" + "0" + aleatorio;
        }
        else { // mais de 100 (3 digitos)
            matricula = year + "101" + aleatorio;           
        }
        return matricula;
    }
    
    public void cadastrarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        System.out.println("Cadastrado com sucesso. Matricula é " + aluno.getMatricula());
        ordenaPorNomeAluno(this.alunos);
    }
    
    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        System.out.println("Cadastrado com sucesso. Matricula é " + funcionario.getMatricula());
        ordenaPorNomeFuncionario(this.funcionarios);
    }    
      
    public void listarAluno() {      
        if(this.alunos.isEmpty()) {
            System.out.println("Não há alunos na lista.");
        }
        else {
            for(int i = 0; i < this.alunos.size(); i++) {
                System.out.println(this.alunos.get(i));
            }
        }
    }
    
    public void listarFuncionario() {      
        if(this.funcionarios.isEmpty()) {
            System.out.println("Não há funcionario na lista.");
        }
        else {
            for(int i = 0; i < this.funcionarios.size(); i++) {
                System.out.println(this.funcionarios.get(i));
            }
        }
    }    
    
    private int buscarAluno(String matricula) {
        for(int i = 0; i < this.alunos.size(); i++) {
            if(this.alunos.get(i).getMatricula().equals(matricula)){
                return i;
            }
        }          
        return -1;
    }      
        
    public Aluno acharAluno(String matricula) throws NaoExisteListaException {
        int achou = this.buscarAluno(matricula);
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada.");
        }
        else {
            return this.alunos.get(achou);
        }
    }
    
    private int buscarFuncionario(String matricula) {
        for(int i = 0; i < this.funcionarios.size(); i++) {
            if(this.funcionarios.get(i).getMatricula().equals(matricula)){
                return i;
            }
        }          
        return -1;
    }     
    
    public Funcionario acharFuncionario(String matricula) throws NaoExisteListaException {
        int achou = this.buscarFuncionario(matricula);
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada.");
        }
        else {
            return this.funcionarios.get(achou);
        }
    }    
    
    public void removerAluno(String matricula) throws NaoExisteListaException {
        int achou = this.buscarAluno(matricula);       
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada para remover.");
        }
        else {
            alunos.remove(achou);
            System.out.println("Removeu com sucesso!!!");
        }       
    }    
    
    public void removerFuncionario(String matricula) throws NaoExisteListaException {
        int achou = this.buscarFuncionario(matricula);       
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada para remover.");
        }
        else {
            funcionarios.remove(achou);
            System.out.println("Removeu com sucesso!!!");
        }       
    }
    
    public void procurarAluno(String matricula) throws NaoExisteListaException {
        Aluno aluno = this.acharAluno(matricula);
        
        if(aluno == null) {
            System.out.println("A matricula não foi encontrada.");
        }
        else {
            System.out.println(aluno);
        }
    }
    
    public void procurarFuncionario(String matricula) throws NaoExisteListaException {
        Funcionario funcionario = this.acharFuncionario(matricula);
        
        if(funcionario == null) {
            System.out.println("A matricula não foi encontrada.");
        }
        else {
            System.out.println(funcionario);
        }
    }    
    
    public void qtdAlunosCadastrados() {
        System.out.println("Quantidade dos alunos cadastrados: " + alunos.size());
    }
    
    public void qtdFuncionarioCadastrados() {
        System.out.println("Quantidade dos funcionarios cadastrados: " + funcionarios.size());
    }    
}
