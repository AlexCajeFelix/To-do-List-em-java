import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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
                  
                    break;
                case 2:
                    System.out.println("\nCriando tarefas para a sua lista...");
                  
                    break;
                case 3:
                    System.out.println("\nEditando uma lista existente...");
              
                    break;
                case 4:
                    System.out.println("\nEditando uma tarefa em uma lista...");
                  
                    break;
                case 5:
                    System.out.println("\nVisualizando suas listas...");
               
                    break;
                case 6:
                    System.out.println("\nVisualizando tarefa por ID...");
                  
                    break;
                case 7:
                    System.out.println("\nVisualizando lista por ID...");
                 
                    break;
                case 8:
                    System.out.println("\nVisualizando tarefa por descrição...");
                
                    break;
                case 9:
                    System.out.println("\nVisualizando lista por descrição...");
                  
                    break;
                case 10:
                    System.out.println("\nExcluindo uma lista...");
                  
                    break;
                case 11:
                    System.out.println("\nExcluindo uma tarefa...");
                   
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
