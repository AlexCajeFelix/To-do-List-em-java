package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Coneccao.Coneccao;

public class Edit {

    public static void Ed() throws FileNotFoundException, IOException { // Método para executar o código
        Connection conn = null;
        PreparedStatement pst = null; 
        
        try {
            conn = Coneccao.getConnection();
            pst = conn.prepareStatement("UPDATE lista_tarefa SET name = ? WHERE list_id = ?");
            pst.setString(1, "VALERIA");
            pst.setInt(2, 4008);

            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
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
