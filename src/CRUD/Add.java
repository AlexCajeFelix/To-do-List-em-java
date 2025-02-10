package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import Coneccao.Coneccao;

public class Add {

    
    
    public int addLista(String nome, String descricao) throws IOException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int listaId = -1;
    
        try {
            System.out.println("Conection criada novaente");
            conn = Coneccao.getConnection(); 
            String sql = "INSERT INTO lista_tarefa (name, description, date_start) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nome);
            pst.setString(2, descricao);
            pst.setDate(3, Date.valueOf(LocalDate.now()));
    
            int rows = pst.executeUpdate();
            if (rows > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    listaId = rs.getInt(1);
                    System.out.println("Lista criada com sucesso! ID = " + listaId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar lista: " + e.getMessage());
        } finally{
            fecharRecursos(null,pst,conn);
        }
        return listaId;
    }

  
    public int addTarefa(String nome, String descricao, int listaId) throws FileNotFoundException, IOException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int tarefaId = -1; // ID correto da tarefa criada
    
        try {
            conn = Coneccao.getConnection();
            
            // Query corrigida para permitir retorno do ID gerado automaticamente
            String sql = "INSERT INTO tarefa (name, description, date_start, enum_status, list_id) VALUES (?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
            pst.setString(1, nome);
            pst.setString(2, descricao);
            pst.setDate(3, Date.valueOf(LocalDate.now())); // Adiciona a data de início como a data atual
            pst.setString(4, "Pendente"); // Define o status inicial como "Pendente"
            pst.setInt(5, listaId);
    
            int rows = pst.executeUpdate();
    
            // Se a inserção foi bem-sucedida, pegar o ID gerado
            if (rows > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    tarefaId = rs.getInt(1);
                    System.out.println("Tarefa criada com sucesso! ID = " + tarefaId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
        } finally {
            fecharRecursos(rs, pst, conn); // Fechar conexão corretamente
        }
    
        return tarefaId; // Retorna o ID da nova tarefa criada
    }
   
    public void fecharRecursos(ResultSet rs, PreparedStatement pst, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();

            System.out.println("Conexao fechada");
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }

  
}
