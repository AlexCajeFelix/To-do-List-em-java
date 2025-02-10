package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Coneccao.Coneccao;

public class Delete {

    public static void main(String[] args) throws FileNotFoundException, IOException { // Adicionando um método para executar o código
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Coneccao.getConnection();
            pst = conn.prepareStatement("DELETE FROM lista_tarefa WHERE list_id = ?");

            pst.setInt(1, 4007); // ID do registro a ser deletado

            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
