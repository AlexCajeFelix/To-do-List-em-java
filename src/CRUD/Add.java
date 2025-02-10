package CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Coneccao.Coneccao;

public class Add {

    private String nome;
    private String descricao;


  
    public Add() {
    }

    public Add(String nome,String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Método para adicionar uma tarefa no banco de dados
    public void addTask(String nome, String descricao) throws FileNotFoundException, IOException {
        Connection coon2 = null;
        PreparedStatement pst = null;

        try {
            // Obtendo a conexão
            coon2 = Coneccao.getConnection();
            pst = coon2.prepareStatement(
                "INSERT INTO lista_tarefa (name, description, date_start) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            // Passando os valores para o SQL
            pst.setString(1, nome);
            pst.setString(2, descricao);
            pst.setDate(3, Date.valueOf(LocalDate.now()));

            int rows = pst.executeUpdate();

            // Verificando se a inserção foi bem-sucedida
            if (rows > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("ID = " + id);
                }
            } else {
                System.out.println("Nada foi alterado");
            }

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            
        } finally {
            // Fechando os recursos
            try {
                if (pst != null) pst.close();
                if (coon2 != null) coon2.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        
    }

    // Getter e Setter para o campo 'teste'
    public String getTeste() {
        return nome;
    }

    
}
