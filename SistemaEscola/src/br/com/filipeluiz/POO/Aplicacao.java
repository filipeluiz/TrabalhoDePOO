package br.com.filipeluiz.POO;

import java.util.Scanner;

/**
 *
 * @author filipe
 */
public class Aplicacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Escola escola;
        String nomeDaEscola;
        boolean sair = false; 
        
        System.out.println("Digite o nome da Escola");
        nomeDaEscola = input.nextLine();

        escola = new Escola(nomeDaEscola);
        
        while(!sair) { // Menu principal
            
            System.out.println("\n######### " + escola.getNome() + " #########");
            System.out.println("1 - Aluno");
            System.out.println("2 - Funcionario");
            System.out.println("0 - Sair");           
            int menuPrincipal = input.nextInt();
            
            switch(menuPrincipal) { 
                case 1: // Entrando Menu Aluno
                    boolean sairAluno = false;
                    
                    while(!sairAluno) {
                        System.out.println("\n######### Aluno #########");
                        System.out.println("1 - Cadastrar aluno.");
                        System.out.println("2 - Lista dos alunos.");
                        System.out.println("3 - Procura a matricula de aluno.");
                        System.out.println("4 - Remover a matricula de aluno.");
                        System.out.println("5 - Alterar a informação do aluno");
                        System.out.println("6 - Quantidade dos alunos cadastrados.");
                        System.out.println("0 - Volta menu principal");
                        int menuAluno = input.nextInt();

                        switch(menuAluno) {
                            case 1:
                                input.nextLine();
                                System.out.println("Nome completo: ");
                                String nome = input.nextLine();
                                
                                boolean sairSexo = false;
                                char sexo = 0;
                                while(!sairSexo) {
                                    System.out.println("Sexo: ");
                                    System.out.println("1 - Masculino");
                                    System.out.println("2 - Feminino");
                                    int op = input.nextInt();
                                    
                                    switch(op) {
                                        case 1:
                                            sexo = 'M'; input.nextLine();
                                            sairSexo = true;
                                            break;
                                        case 2:
                                            sexo = 'F'; input.nextLine();
                                            sairSexo = true;
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                } 
                                
                                System.out.println("Informe o data de nascimento(formato dd/mm/yyyy)");
                                String dataNascimento = input.nextLine();

                                System.out.println("Qual é serie(apenas número): "); 
                                int serie = input.nextInt();                                    

                                boolean sairTurno = false;
                                String turno = null;
                                while(!sairTurno) {
                                    System.out.println("Turno: ");
                                    System.out.println("1 - Manhã");
                                    System.out.println("2 - Tarde");
                                    int op = input.nextInt();
                                    
                                    switch(op) {
                                        case 1:
                                            turno = "Manhã"; input.nextLine();
                                            sairTurno = true;
                                            break;
                                        case 2:
                                            turno = "Tarde"; input.nextLine();
                                            sairTurno = true;
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                }                                 
                                System.out.println("Informe o Telefone: ");
                                String tel = input.nextLine();
                                System.out.println("Email: ");
                                String email = input.next(); input.nextLine();

                                Contato contato = new Contato(email, tel);
                                Turma turma = new Turma(serie, turno);
                                
                                int limiteAluno = 400;
                                String matricula = escola.gerarMatricula(limiteAluno);

                                Aluno aluno = new Aluno(nome,matricula,dataNascimento,sexo,contato,turma);
                                escola.cadastrarAluno(aluno);
                                break;
                            case 2:
                                escola.listarAluno();
                                break;
                            case 3:
                                System.out.println("Informe a matricula para procurar");
                                String matriculaProcure = input.next();
                                escola.procurarAluno(matriculaProcure);
                                break;
                            case 4:
                                System.out.println("Informe a matricula para remover");
                                String matriculaRemove = input.next();
                                escola.removerAluno(matriculaRemove);
                                break;
                            case 5:
                                System.out.println("Informe a matricula para alterar as informaçẽes.");
                                String matriculaAlteracao = input.next();
                                Aluno alunoAlteracao = null;
                                alunoAlteracao = escola.acharAluno(matriculaAlteracao);
                                
                                if(alunoAlteracao != null) {
                                    boolean sairAlteracao = false;
                                    while(!sairAlteracao) {
                                        System.out.println("\n##### " + alunoAlteracao.getNome() + " #####");
                                        System.out.println("1 - Alterar nome do aluno.");
                                        System.out.println("2 - Alterar o sexo do aluno.");
                                        System.out.println("3 - Alterar data de nascimento do aluno.");
                                        System.out.println("4 - Alterar o contato do aluno.");
                                        System.out.println("5 - Alterar Turma do aluno.");
                                        System.out.println("0 - Sair");
                                        int opAlteracao = input.nextInt();

                                        switch(opAlteracao) {
                                            case 1:
                                                System.out.println("Informe o nome para alterar"); input.nextLine();
                                                String nomeAltera = input.nextLine();
                                                alunoAlteracao.setNome(nomeAltera);
                                                System.out.println("O nome foi alterado com sucesso.");
                                                break;
                                            case 2:
                                                boolean sairSexoAlteracao = false;
                                                char sexoAlteracao = 0;
                                                while(!sairSexoAlteracao) {
                                                    System.out.println("Sexo: ");
                                                    System.out.println("1 - Masculino");
                                                    System.out.println("2 - Feminino");
                                                    int op = input.nextInt();

                                                    switch(op) {
                                                        case 1:
                                                            sexoAlteracao = 'M'; input.nextLine();
                                                            sairSexoAlteracao = true;
                                                            break;
                                                        case 2:
                                                            sexoAlteracao = 'F'; input.nextLine();
                                                            sairSexoAlteracao = true;
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida.");
                                                    }
                                                } 
                                                alunoAlteracao.setSexo(sexoAlteracao);
                                                System.out.println("O sexo foi alterado com sucesso.");
                                                break;  
                                            case 3:
                                                System.out.println("Informe o data de nascimento para alterar"); input.nextLine();
                                                String dataNascimentoAltera = input.nextLine();
                                                alunoAlteracao.setDataNascimento(dataNascimentoAltera);
                                                System.out.println("O data de nascimento foi alterado com sucesso.");
                                                break;
                                            case 4:
                                                boolean sairContatoAlteracao = false;
                                                String emailAlteracao, telefoneAlteracao;
                                                while(!sairContatoAlteracao) {
                                                    System.out.println("Contato: ");
                                                    System.out.println("1 - E-mail");
                                                    System.out.println("2 - Telefone");
                                                    int op = input.nextInt();

                                                    switch(op) {
                                                        case 1:
                                                            System.out.println("Digite o e-mail para alterar."); input.nextLine();
                                                            emailAlteracao = input.nextLine();
                                                            alunoAlteracao.getContato().setEmail(emailAlteracao);                                                            
                                                            System.out.println("Alteração com sucesso.");
                                                            sairContatoAlteracao = true;                                                            
                                                            break;
                                                        case 2:
                                                            System.out.println("Digite o telefone para alterar."); input.nextLine();
                                                            telefoneAlteracao = input.nextLine();
                                                            alunoAlteracao.getContato().setTelefone(telefoneAlteracao);
                                                            System.out.println("Alteração com sucesso.");
                                                            sairContatoAlteracao = true;                                                            
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida.");
                                                    }
                                                } 
                                                break;
                                            case 5:
                                                boolean sairTurmaAlteracao = false;
                                                int serieAlteracao = 0; 
                                                String turnoAlteracao;
                                                
                                                while(!sairTurmaAlteracao) {
                                                    System.out.println("Turma: ");
                                                    System.out.println("1 - Série");
                                                    System.out.println("2 - Turno");
                                                    int op = input.nextInt();

                                                    switch(op) {
                                                        case 1:
                                                            System.out.println("Digite o série para alterar."); 
                                                            serieAlteracao = input.nextInt();
                                                            alunoAlteracao.getTurma().setSerie(serieAlteracao);
                                                            System.out.println("Alteração com sucesso.");
                                                            sairTurmaAlteracao = true;                                                            
                                                            break;
                                                        case 2:
                                                            System.out.println("Digite o Turno para alterar."); input.nextLine();
                                                            turnoAlteracao = input.nextLine();
                                                            alunoAlteracao.getTurma().setTurno(turnoAlteracao);
                                                            System.out.println("Alteração com sucesso.");
                                                            sairTurmaAlteracao = true;                                                            
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida.");
                                                    }
                                                } 
                                                break;                                                
                                            case 0: 
                                                sairAlteracao = true;
                                                break;    
                                        }
                                    }
                                } 
                                break;
                            case 6:
                                escola.qtdAlunosCadastrados();
                                break;                                
                            case 0:
                                sairAluno = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        } 
                        
                    } // fim while
                    break; // fim Menu Aluno
                case 2: // Entrando Menu Professor
                    boolean sairProfessor = false;

                    while(!sairProfessor) {
                        System.out.println("\n######### Professor #########");
                        System.out.println("1 - Cadastrar professor.");
                        System.out.println("2 - Lista dos professor.");
                        System.out.println("3 - Procura a matricula do professor.");
                        System.out.println("4 - Remover a matricula do professor.");
                        System.out.println("5 - Alterar a informação do professor.");
                        System.out.println("6 - Benefícios e salários.");
                        System.out.println("7 - Quantidade dos professores cadastrados.");
                        System.out.println("0 - Volta menu principal.");
                        int menuProfessor = input.nextInt();

                        switch(menuProfessor) {
                            case 1:
                                input.nextLine();
                                System.out.println("Nome completo: ");
                                String nome = input.nextLine();

                                boolean sairSexo = false;
                                char sexo = 0;
                                while(!sairSexo) {
                                    System.out.println("Sexo: ");
                                    System.out.println("1 - Masculino");
                                    System.out.println("2 - Feminino");
                                    int op = input.nextInt();

                                    switch(op) {
                                        case 1:
                                            sexo = 'M'; input.nextLine();
                                            sairSexo = true;
                                            break;
                                        case 2:
                                            sexo = 'F'; input.nextLine();
                                            sairSexo = true;
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                } 

                                System.out.println("Informe o data de nascimento(formato dd/mm/yyyy)");
                                String dataNascimento = input.nextLine();                                  

                                boolean sairMateria = false;
                                String materia = null;
                                double salario = 0; 
                                while(!sairMateria) {
                                    System.out.println("Materia: ");
                                    System.out.println("1 - Português");
                                    System.out.println("2 - Matemática");
                                    System.out.println("3 - Inglês");
                                    System.out.println("4 - Ciência");
                                    System.out.println("5 - Fisica");
                                    System.out.println("6 - Quimica");
                                    int op = input.nextInt();

                                    switch(op) {
                                        case 1:
                                            materia = "Português"; input.nextLine();
                                            salario = 2500;
                                            sairMateria = true;
                                            break;
                                        case 2:
                                            materia = "Matemática"; input.nextLine();
                                            salario = 3200;
                                            sairMateria = true;
                                            break;
                                        case 3:
                                            materia = "Inglês"; input.nextLine();
                                            salario = 4000;
                                            sairMateria = true;
                                            break; 
                                        case 4:
                                            materia = "Ciência"; input.nextLine();
                                            salario = 3500;
                                            sairMateria = true;
                                            break;
                                        case 5:
                                            materia = "Fisica"; input.nextLine();
                                            salario = 3300;
                                            sairMateria = true;
                                            break;  
                                        case 6:
                                            materia = "Quimica"; input.nextLine();
                                            salario = 3800;
                                            sairMateria = true;
                                            break;                                                         
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                }    
                                
                                System.out.println("Informe a data de admissão: ");
                                String dataAdmissao = input.nextLine();                                
                                System.out.println("Informe o Telefone: ");
                                String tel = input.nextLine();
                                System.out.println("Email: ");
                                String email = input.next(); input.nextLine();

                                Contato contato = new Contato(email, tel);

                                int limiteFuncionario = 200;
                                String matricula = escola.gerarMatricula(limiteFuncionario);

                                Professor professor = new Professor(nome,matricula,dataNascimento,sexo,contato,dataAdmissao, salario, materia);
                                escola.cadastrarFuncionario(professor);                                
                                break;
                            case 2:
                                escola.listarFuncionario();
                                break;
                            case 3:
                                System.out.println("Informe a matricula para procurar");
                                String matriculaProcure = input.next();
                                escola.procurarFuncionario(matriculaProcure);
                                break;
                            case 4:
                                System.out.println("Informe a matricula para remover");
                                String matriculaRemove = input.next();
                                escola.removerFuncionario(matriculaRemove);
                                break;
                            case 5:
                                System.out.println("Informe a matricula para alterar as informações.");
                                String matriculaAlteracao = input.next();
                                Funcionario funcionarioAlteracao = null;
                                funcionarioAlteracao = escola.acharFuncionario(matriculaAlteracao);    

                                if(funcionarioAlteracao != null) {
                                    boolean sairAlteracao = false;
                                    while(!sairAlteracao) {
                                        System.out.println("\n##### " + funcionarioAlteracao.getNome() + " #####");
                                        System.out.println("1 - Alterar nome do professor.");
                                        System.out.println("2 - Alterar o sexo do professor.");
                                        System.out.println("3 - Alterar data de nascimento do professor.");
                                        System.out.println("4 - Alterar o contato do professor.");
                                        System.out.println("0 - Sair");
                                        int opAlteracao = input.nextInt();

                                        switch(opAlteracao) {
                                            case 1:
                                                System.out.println("Informe o nome para alterar"); input.nextLine();
                                                String nomeAltera = input.nextLine();
                                                funcionarioAlteracao.setNome(nomeAltera);
                                                System.out.println("O nome foi alterado com sucesso.");
                                                break;
                                            case 2:
                                                boolean sairSexoAlteracao = false;
                                                char sexoAlteracao = 0;
                                                while(!sairSexoAlteracao) {
                                                    System.out.println("Sexo: ");
                                                    System.out.println("1 - Masculino");
                                                    System.out.println("2 - Feminino");
                                                    int op = input.nextInt();

                                                    switch(op) {
                                                        case 1:
                                                            sexoAlteracao = 'M'; input.nextLine();
                                                            sairSexoAlteracao = true;
                                                            break;
                                                        case 2:
                                                            sexoAlteracao = 'F'; input.nextLine();
                                                            sairSexoAlteracao = true;
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida.");
                                                    }
                                                } 
                                                funcionarioAlteracao.setSexo(sexoAlteracao);
                                                System.out.println("O sexo foi alterado com sucesso.");
                                                break;  
                                            case 3:
                                                System.out.println("Informe o data de nascimento para alterar"); input.nextLine();
                                                String dataNascimentoAltera = input.nextLine();
                                                funcionarioAlteracao.setDataNascimento(dataNascimentoAltera);
                                                System.out.println("O data de nascimento foi alterado com sucesso.");
                                                break;
                                            case 4:
                                                boolean sairContatoAlteracao = false;
                                                String emailAlteracao, telefoneAlteracao;
                                                while(!sairContatoAlteracao) {
                                                    System.out.println("Contato: ");
                                                    System.out.println("1 - E-mail");
                                                    System.out.println("2 - Telefone");
                                                    int op = input.nextInt();

                                                    switch(op) {
                                                        case 1:
                                                            System.out.println("Digite o e-mail para alterar."); input.nextLine();
                                                            emailAlteracao = input.nextLine();
                                                            funcionarioAlteracao.getContato().setEmail(emailAlteracao);                                                            
                                                            System.out.println("Alteração com sucesso.");
                                                            sairContatoAlteracao = true;                                                            
                                                            break;
                                                        case 2:
                                                            System.out.println("Digite o telefone para alterar."); input.nextLine();
                                                            telefoneAlteracao = input.nextLine();
                                                            funcionarioAlteracao.getContato().setTelefone(telefoneAlteracao);
                                                            System.out.println("Alteração com sucesso.");
                                                            sairContatoAlteracao = true;                                                            
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida.");
                                                    }
                                                } 
                                                break;               
                                            case 0: 
                                                sairAlteracao = true;
                                                break;    
                                        }
                                    }
                                } 
                                break;
                            case 6:   
                                System.out.println("Informe a matricula.");
                                String matriculaSalario = input.next();
                                Funcionario FuncionarioAlteraSalario = null;
                                FuncionarioAlteraSalario = escola.acharFuncionario(matriculaSalario);

                                if(FuncionarioAlteraSalario != null) {
                                    boolean sairSalario = false;
                                    while(!sairSalario) {
                                        System.out.println("\n##### " + FuncionarioAlteraSalario.getNome() + " #####");
                                        System.out.println("1 - Alterar o salario.");
                                        System.out.println("2 - Beneficio.");
                                        System.out.println("0 - Sair");
                                        int opAlteracao = input.nextInt();

                                        switch(opAlteracao) {
                                            case 1:
                                                System.out.println("Informe o valor para alterar salario"); 
                                                double alteraSalario = input.nextDouble();
                                                FuncionarioAlteraSalario.setSalario(alteraSalario);
                                                System.out.println("O salario foi alterado com sucesso.");
                                                break;
                                            case 2:
                                                boolean sairBeneficio = false;
                                                while(!sairBeneficio) {
                                                    System.out.println("\n##### Beneficios #####");
                                                    System.out.println("1 - Horas extra");
                                                    System.out.println("2 - Refeição");
                                                    System.out.println("0 - Sair");
                                                    int opBeneficio = input.nextInt();
                                                    
                                                    switch(opBeneficio) {
                                                        case 1:
                                                            FuncionarioAlteraSalario.horasExtra();
                                                            System.out.println("Horas extra com sucesso.");
                                                            break;
                                                        case 2:
                                                            FuncionarioAlteraSalario.refeicao();
                                                            System.out.println("Refeição com sucesso.");
                                                            break;
                                                        case 0:
                                                            sairBeneficio = true;
                                                            break;
                                                        default: 
                                                            System.out.println("OPção inválida");
                                                    }
                                                }
                                                break;
                                            case 0:
                                                sairSalario = true;
                                                break;
                                        }
                                    }
                                } 
                                break;
                            case 7:
                                escola.qtdFuncionarioCadastrados();
                                break;                                
                            case 0:
                                sairProfessor = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        } 

                    } // fim while
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } // fim while
    }
    
}
