package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Coneccao.Coneccao;
import Coneccao.Dbexeption;

public class Recuperar {

    public static void main(String[] args) { // Adicionando um método para rodar o código
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = Coneccao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM lista_tarefa");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("list_id"));
                System.out.println("Nome: " + rs.getString("name"));
            }
        } 
        catch (SQLException e) {
            throw new Dbexeption("Erro no SQL: " + e.getMessage());
        } 
        catch (FileNotFoundException e) { 
            throw new Dbexeption("Arquivo não encontrado: " + e.getMessage());
        } 
        catch (IOException e) { 
            throw new Dbexeption("Erro de I/O: " + e.getMessage());
        } 
        finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
