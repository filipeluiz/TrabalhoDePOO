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
public class Cadastramento {
    private List<Aluno> alunos;
    private List<Funcionario> funcionarios;
    
    public Cadastramento() {
        this.alunos = new ArrayList<Aluno>();
        this.funcionarios = new ArrayList<Funcionario>();        
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
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
    
    private int buscarAluno(String matricula) {
        for(int i = 0; i < this.alunos.size(); i++) {
            if(this.alunos.get(i).getMatricula().equals(matricula)){
                return i;
            }
        }          
        return -1;
    }  
    
    private int buscarFuncionario(String matricula) {
        for(int i = 0; i < this.funcionarios.size(); i++) {
            if(this.funcionarios.get(i).getMatricula().equals(matricula)){
                return i;
            }
        }          
        return -1;
    }     
    
    public String matricula(int limite) {
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
    
    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
        System.out.println("Cadastrado com sucesso. Matricula é " + aluno.getMatricula());
        ordenaPorNomeAluno(this.alunos);
    }
    
    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        System.out.println("Cadastrado com sucesso. Matricula é " + funcionario.getMatricula());
        ordenaPorNomeFuncionario(this.funcionarios);
    }    
      
    public void grupoAluno() {      
        if(this.alunos.isEmpty()) {
            System.out.println("Não há alunos na lista.");
        }
        else {
            for(int i = 0; i < this.alunos.size(); i++) {
                System.out.println(this.alunos.get(i));
            }
        }
    }
    
    public void grupoFuncionario() {      
        if(this.funcionarios.isEmpty()) {
            System.out.println("Não há funcionario na lista.");
        }
        else {
            for(int i = 0; i < this.funcionarios.size(); i++) {
                System.out.println(this.funcionarios.get(i));
            }
        }
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
           
    public Funcionario acharFuncionario(String matricula) throws NaoExisteListaException {
        int achou = this.buscarFuncionario(matricula);
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada.");
        }
        else {
            return this.funcionarios.get(achou);
        }
    }    
    
    public void apagaAluno(String matricula) throws NaoExisteListaException {
        int achou = this.buscarAluno(matricula);       
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada para remover.");
        }
        else {
            alunos.remove(achou);
            System.out.println("Removeu com sucesso!!!");
        }       
    }    
    
    public void apagaFuncionario(String matricula) throws NaoExisteListaException {
        int achou = this.buscarFuncionario(matricula);       
        
        if(achou == -1) {
            throw new NaoExisteListaException("A matricula não foi encontrada para remover.");
        }
        else {
            funcionarios.remove(achou);
            System.out.println("Removeu com sucesso!!!");
        }       
    }
    
    public Aluno localizaAluno(String matricula) throws NaoExisteListaException {
        Aluno aluno = this.acharAluno(matricula);
        
        if(aluno == null) {
            System.out.println("A matricula não foi encontrada.");
        }
        else {
            return aluno;
        }
        return null;
    }
    
    public Funcionario localizaFuncionario(String matricula) throws NaoExisteListaException {
        Funcionario funcionario = this.acharFuncionario(matricula);
        
        if(funcionario == null) {
            System.out.println("A matricula não foi encontrada.");
        }
        else {
            return funcionario;
        }
        return null;
    } 
    
    public boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
    
    public void qtdAlunos() {
        System.out.println("Quantidade dos alunos cadastrados: " + alunos.size());
    }
    
    public void qtdFuncionarios() {
        System.out.println("Quantidade dos funcionarios cadastrados: " + funcionarios.size());
    }     
    
}
