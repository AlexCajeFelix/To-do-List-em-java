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

    public static void main(String[] args) throws FileNotFoundException, IOException { // Método necessário para executar o código
        Connection coon2 = null;
        PreparedStatement pst = null;

        try {
            coon2 = Coneccao.getConnection();
            pst = coon2.prepareStatement(
                "INSERT INTO lista_tarefa (name, description, date_start) VALUES (?, ?, ?)", 
                Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, "ALEX");
            pst.setString(2, "Alex Bonitão lindão");
            pst.setDate(3, Date.valueOf(LocalDate.now())); // Data atual

            int rows = pst.executeUpdate();

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
            System.out.println("ERRO: " + e.getMessage()); // Melhor exibir a mensagem do erro
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
}
