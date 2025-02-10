import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import CRUD.Add;
import CRUD.Delete;
import CRUD.Edit;


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

          
            switch (opcao) {
                case 1:
                 
                    System.out.println("\nCriando uma nova lista de tarefas...");

                    String nomeTarefa = "Nova Tarefa";
                    Add addTask = new Add(nomeTarefa);
                    addTask.addTask();
                    
                    break;
                case 2:
                    System.out.println("\nCriando tarefas para a sua lista...");

                    break;
                case 3:
                    System.out.println("\nEditando uma lista existente...");
                    Edit edit = new Edit("TEste");
                    edit.Edit();
                    break;
                case 4:
                    System.out.println("\nEditando uma tarefa em uma lista...");
                  //aqui a tarefa TAREFA
                    break;
                case 5:
                    System.out.println("\nVisualizando suas listas...");
                    //VISUALIZA TODOS
                    break;
                case 6:
                    System.out.println("\nVisualizando tarefa por ID...");
                  // POR ID
                    break;
                case 7:
                    System.out.println("\nVisualizando lista por ID...");
                 //POR ID
                    break;
                case 8:
                    System.out.println("\nVisualizando tarefa por descrição...");
                    //DESCRIPTION
                    break;
                case 9:
                    System.out.println("\nVisualizando lista por descrição...");
                    //DESCRIPTION
                    break;
                case 10:
                    System.out.println("\nExcluindo uma lista...");
                    //EXCLUI
                    Delete del = new Delete(4013);
                    del.Delete();
                    break;
                case 11:
                    System.out.println("\nExcluindo uma tarefa...");
                   //EXCLUI
                    break;
                case 0:
                    System.out.println("\nSaindo do To-Do List App. Até logo!");
                    sc.close();  
                    return; 
                default:
                    System.out.println("\nOpção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    

    
    
    
    }

}
