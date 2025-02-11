import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
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
            System.out.println("(6) Visualizar lista por ID");
            System.out.println("(7) Visualizar tarefa por ID");
            System.out.println("(8) Excluir uma lista");
            System.out.println("(9) Excluir uma tarefa");
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
                        add.addLista(name, description);
                        System.out.println("Lista criada com sucesso!");
                    } catch (InputMismatchException | IOException e) {
                        System.err.println("Erro ao criar lista: " + e.getMessage());
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
                        System.out.print("Digite o ID da lista: ");
                        int listId = sc.nextInt();
                        add.addTarefa(taskName, taskDescription, listId);
                    } catch (InputMismatchException | IOException e) {
                        System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Digite o ID da lista para editar: ");
                        int listEdit = sc.nextInt();
                        sc.nextLine();  // Limpa o buffer
                        System.out.print("Digite o novo nome da lista: ");
                        String nomeEdit = sc.nextLine();
                        Edit edit = new Edit();
                        edit.EditList(listEdit, nomeEdit);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao editar lista: ID inválido.");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Digite o ID da tarefa para editar: ");
                        int tarefaidEdit = sc.nextInt();
                        sc.nextLine();  // Limpa o buffer
                        System.out.print("Digite o novo nome da tarefa: ");
                        String TarefanomeEdit = sc.nextLine();
                        Edit editTarefa = new Edit();
                        editTarefa.EditTarefa(tarefaidEdit, TarefanomeEdit);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao editar tarefa: ID inválido.");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("\nVisualizando suas listas...");
                        Recuperar recuperar = new Recuperar();
                        recuperar.Recuperar();
                    } catch (Exception e) {
                        System.err.println("Erro ao recuperar listas: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("\nVisualizando lista por ID...");
                        System.out.print("Digite o ID da lista que deseja visualizar: ");
                        int listId2 = sc.nextInt();
                        Recuperar recuperar2 = new Recuperar();
                        recuperar2.RecuperarPorId(listId2);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao recuperar lista por ID: ID inválido.");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("\nVisualizando tarefa por ID...");
                        System.out.print("Digite o ID da tarefa que deseja visualizar: ");
                        int listTarefa = sc.nextInt();
                        Recuperar recuperarTeste = new Recuperar();
                        recuperarTeste.RecuperarPorIdTarefa(listTarefa);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao recuperar tarefa por ID: ID inválido.");
                    }
                    break;
                case 8:
                    try {
                        System.out.print("Digite o ID da lista que deseja excluir: ");
                        int listId = sc.nextInt();
                        Delete dell = new Delete();
                        dell.DeleteList(listId);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao excluir lista: ID inválido.");
                    }
                    break;
                case 9:
                    try {
                        System.out.print("Digite o ID da tarefa que deseja excluir: ");
                        int idTarefa = sc.nextInt();
                        Delete dellTarefa = new Delete();
                        dellTarefa.DeleteTarefa(idTarefa);
                    } catch (InputMismatchException e) {
                        System.err.println("Erro ao excluir tarefa: ID inválido.");
                    }
                    break;
                case 0:
                    try {
                        System.out.println("\nSaindo do To-Do List App. Até logo!");
                        Add add = new Add();
                        Connection conn = null;
                        PreparedStatement pst = null;
                        ResultSet rs = null;
                        add.fecharRecursos(rs, pst, conn);
                    } catch (Exception e) {
                        System.err.println("Erro ao fechar recursos: " + e.getMessage());
                    }
                    sc.close();
                    return;
                default:
                    System.out.println("\nOpção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
