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
    

    public static void Recuperar() { 
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
                System.out.println("Descrição: " + rs.getString("description"));
                System.out.println("Data da criação: " + rs.getString("date_start"));
                System.out.println("------------------------------------------------------------------");
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


    public static void RecuperarPorId(Integer id) { 
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
       

        try {
            conn = Coneccao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM lista_tarefa WHERE list_id ="+id);
            


            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("list_id"));
                System.out.println("Nome: " + rs.getString("name"));
                System.out.println("Descrição: " + rs.getString("description"));
                System.out.println("Data da criação: " + rs.getString("date_start"));
                System.out.println("------------------------------------------------------------------");
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

    public static void RecuperarPorIdTarefa(int id) { 
        Connection conn = null;
        Statement st = null;
        ResultSet rs2 = null;
     

        try {
            conn = Coneccao.getConnection();
            st = conn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tarefa WHERE tarefa_id ="+id);
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("tarefa_id"));
                System.out.println("Nome: " + rs2.getString("name"));
                System.out.println("Descrição: " + rs2.getString("description"));
                System.out.println("Data da criação: " + rs2.getString("date_start"));
                System.out.println("Data da final: " + rs2.getString("date_finish"));
                System.out.println("Status: " + rs2.getString("enum_status"));
                System.out.println("Pertence a lista de tarefas : " + rs2.getString("list_id"));
                System.out.println("------------------------------------------------------------------");
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
                if (rs2 != null) rs2.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }




}
