package Coneccao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Coneccao {

        private static Connection conn = null;

        public static Connection getConnection() throws FileNotFoundException, IOException{
        
                if(conn == null){
                    Properties props = load();
                    String url = props.getProperty("dburl");
                  try {
                    conn = DriverManager.getConnection(url, props);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                }

            return conn;
        }

        public static void close(){
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new Dbexeption("Deu ruim");
            }
        }

        private static Properties load() throws IOException {
            Properties props = new Properties();
            try (var inputStream = Coneccao.class.getClassLoader().getResourceAsStream("Db.properties")) {
                if (inputStream == null) {
                    throw new FileNotFoundException("Arquivo Db.properties não encontrado no classpath.");
                }
                props.load(inputStream);
            }
            return props;
        }
        
  
}
