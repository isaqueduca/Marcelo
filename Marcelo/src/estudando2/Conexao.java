
package estudando2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static String connectionString = "jdbc:postgresql://localhost:5432/aula";
    private static String usuario = "postgres";
    private static String senha = "senha";
    
    public static Connection conectar(){
        try{
            Class.forName ("org.postgresql.Driver");
            return DriverManager.getConnection(connectionString, usuario, senha);
        } catch (Exception ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public static void desconectar(Connection con){
        try{
            con.close();
        } catch(SQLException ex){
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }
    
}
