import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Pipe.SourceChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import CRUD.Add;
import CRUD.Delete;
import CRUD.Edit;
import CRUD.Recuperar;
import Coneccao.Coneccao;
import Exeptions.ExeptionsMain;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        Scanner sc = new Scanner(System.in);
        int opcao;
       
        
        // Saudação de boas-vindas
        System.out.println("===========================================");
        System.out.println("        Olá, seja muito bem-vindo ao      ");
        System.out.println("            To-Do List App!               ");
        System.out.println("===========================================");

        while (true) {
           
            System.out.println("\nEscolha uma opção:");
            System.out.println("(1) Criar uma nova lista de tarefas");
            System.out.println("(2) Criar tarefas para a sua lista");
            System.out.println("(3) Editar uma lista existente");
            System.out.println("(4) Editar uma tarefa em uma lista");
            System.out.println("(5) Visualizar suas listas");
            System.out.println("(6) Visualizar tarefa por ID");
            System.out.println("(7) Visualizar lista por ID");
            System.out.println("(8) Visualizar tarefa por descrição");
            System.out.println("(9) Visualizar lista por descrição");
            System.out.println("(10) Excluir uma lista");
            System.out.println("(11) Excluir uma tarefa");
            System.out.println("(0) Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();  
            
            switch (opcao) {
                case 1:
                  try {
                    Add add = new Add();
                    System.out.println("\nCriando uma nova lista de tarefas...");
                    System.out.print("Digite o nome da lista: ");
                    String name = sc.nextLine();
                    System.out.print("Digite a descrição da lista: ");
                    String description = sc.nextLine();
                    System.out.println("Lista criada com sucesso!");
                    add.addLista(name,description);
                    
                  } catch (InputMismatchException | IOException e) {
                    throw new ExeptionsMain("Erro InputMismatchException: ID INVALIDO");
                  }
                    break;
                case 2:
                    try {
                        Add add = new Add();
                        System.out.println("\nCriando tarefas para a sua lista...");
                        System.out.print("Digite o nome da tarefa: ");
                        String taskName = sc.nextLine();
                        System.out.print("Digite a descrição da tarefa: ");
                        String taskDescription = sc.nextLine();
                        System.out.print("o id): ");
                        int listId = sc.nextInt();
                        add.addTarefa(taskName,taskDescription,listId);
                    } 
                    catch(InputMismatchException | IOException e) {
                        throw new ExeptionsMain("Erro InputMismatchException: ID INVALIDO");
                      }

                    break;
                case 3:
                     

                    break;
                case 4:
                   
                    
                    break;
                case 5:
                    System.out.println("\nVisualizando suas listas...");
                    Recuperar recuperar = new Recuperar();
                    recuperar.Recuperar();
                    
                    
                    break;
                case 6:
                System.out.println("\nVisualizando suas listas...");
                System.out.println("Digite o id da lista que deseja visualizar");
                int listId2 = sc.nextInt();
                Recuperar recuperar2 = new Recuperar();
                recuperar2.RecuperarPorId(listId2);
                    break;
                case 7:
                    System.out.println("\nVisualizando suas listas...");
                    System.out.println("Digite o id da tarefa que deseja visualizar");
                    int listTarefa = sc.nextInt();

                    Recuperar recuperarTeste = new Recuperar();
                    recuperarTeste.RecuperarPorIdTarefa(listTarefa);
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    
                    break;
                case 10:
                      System.out.println("Digite o ID da lista que voce deseja excluir");
                      int listId = sc.nextInt();
                      Delete dell = new Delete();
                      dell.DeleteList(listId);
                    break;
                case 11:
                      System.out.println("Digite o ID da tarefa que voce deseja excluir");
                      int idTarefa = sc.nextInt();
                      Delete dellTarefa = new Delete();
                      dellTarefa.DeleteTarefa(idTarefa);
                    break;
                case 0:
                    System.out.println("\nSaindo do To-Do List App. Até logo!");
                    Add add = new Add();
                     Connection conn = null;
                    PreparedStatement pst = null;
                     ResultSet rs = null;
                    add.fecharRecursos(rs,pst,conn);
                    sc.close();  
                    return; 
                default:
                    System.out.println("\nOpção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
