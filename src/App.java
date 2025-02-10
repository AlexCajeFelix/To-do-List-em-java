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
            sc.nextLine();  // Consome o buffer de quebra de linha após a entrada do número
            
            switch (opcao) {
                case 1:
                    System.out.println("\nCriando uma nova lista de tarefas...");
                    System.out.print("Digite o nome da lista: ");
                    String name = sc.nextLine();
                    System.out.print("Digite a descrição da lista: ");
                    String description = sc.nextLine();
                    System.out.println("Lista criada com sucesso!");
                    Add add = new Add();
                    add.addTask(name,description);
                    break;
                case 2:
                    System.out.println("\nCriando tarefas para a sua lista...");
                    System.out.print("Digite o nome da tarefa: ");
                    String taskName = sc.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String taskDescription = sc.nextLine();
                    System.out.print("Digite a data de início (yyyy-mm-dd): ");
                    String taskDate = sc.nextLine();
                    System.out.println("Tarefa criada com sucesso!");
                    // Chamar o método para adicionar a tarefa no banco.
                    break;
                case 3:
                    System.out.println("\nEditando uma lista existente...");
                    System.out.print("Digite o ID da lista que deseja editar: ");
                    int listIdToEdit = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    System.out.print("Digite o novo nome da lista: ");
                    String newName = sc.nextLine();
                    System.out.print("Digite a nova descrição da lista: ");
                    String newDescription = sc.nextLine();
                    System.out.println("Lista editada com sucesso!");
                    // Chamar o método Edit para editar a lista no banco.
                    break;
                case 4:
                    System.out.println("\nEditando uma tarefa em uma lista...");
                    System.out.print("Digite o ID da tarefa que deseja editar: ");
                    int taskIdToEdit = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    System.out.print("Digite o novo nome da tarefa: ");
                    String newTaskName = sc.nextLine();
                    System.out.print("Digite a nova descrição da tarefa: ");
                    String newTaskDescription = sc.nextLine();
                    System.out.print("Digite a nova data de início (yyyy-mm-dd): ");
                    String newTaskDate = sc.nextLine();
                    System.out.println("Tarefa editada com sucesso!");
                    // Chamar o método Edit para editar a tarefa no banco.
                    break;
                case 5:
                    System.out.println("\nVisualizando suas listas...");
                    // Aqui você pode chamar o método que lista todas as listas no banco.
                    break;
                case 6:
                    System.out.println("\nVisualizando tarefa por ID...");
                    System.out.print("Digite o ID da tarefa: ");
                    int taskIdToView = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    System.out.println("Tarefa exibida com sucesso!");
                    // Chamar o método para exibir a tarefa pelo ID.
                    break;
                case 7:
                    System.out.println("\nVisualizando lista por ID...");
                    System.out.print("Digite o ID da lista: ");
                    int listIdToView = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    System.out.println("Lista exibida com sucesso!");
                    // Chamar o método para exibir a lista pelo ID.
                    break;
                case 8:
                    System.out.println("\nVisualizando tarefa por descrição...");
                    System.out.print("Digite a descrição da tarefa: ");
                    String taskDescriptionToSearch = sc.nextLine();
                    System.out.println("Tarefa exibida com sucesso!");
                    // Chamar o método para buscar tarefa pela descrição.
                    break;
                case 9:
                    System.out.println("\nVisualizando lista por descrição...");
                    System.out.print("Digite a descrição da lista: ");
                    String listDescriptionToSearch = sc.nextLine();
                    System.out.println("Lista exibida com sucesso!");
                    // Chamar o método para buscar lista pela descrição.
                    break;
                case 10:
                    System.out.println("\nExcluindo uma lista...");
                    System.out.print("Digite o ID da lista que deseja excluir: ");
                    int listIdToDelete = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    Delete del = new Delete(listIdToDelete);
                    del.Delete();
                    System.out.println("Lista excluída com sucesso!");
                    break;
                case 11:
                    System.out.println("\nExcluindo uma tarefa...");
                    System.out.print("Digite o ID da tarefa que deseja excluir: ");
                    int taskIdToDelete = sc.nextInt();
                    sc.nextLine(); // Consome o buffer
                    // Chamar o método para excluir a tarefa pelo ID.
                    System.out.println("Tarefa excluída com sucesso!");
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
