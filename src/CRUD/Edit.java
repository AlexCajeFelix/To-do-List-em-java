package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Coneccao.Coneccao;

public class Edit {

    private int id;
    private String name;
    
   

    public Edit(int id,String name) {
        this.id = id;
        this.name = name;
    }



    public Edit() {
        
    }



    public void EditList(int id,String name ) throws FileNotFoundException, IOException { // Método para executar o código
        Connection conn = null;
        PreparedStatement pst = null; 
        
        try {
            conn = Coneccao.getConnection();
            pst = conn.prepareStatement("UPDATE lista_tarefa SET name = ? WHERE list_id = ?");
            pst.setString(1, name);
            pst.setInt(2, id);

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

    public void EditTarefa(int id,String name ) throws FileNotFoundException, IOException { // Método para executar o código
        Connection conn = null;
        PreparedStatement pst = null; 
        
        try {
            conn = Coneccao.getConnection();
            pst = conn.prepareStatement("UPDATE tarefa SET name = ? WHERE list_id = ?");
            pst.setString(1, name);
            pst.setInt(2, id);

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
