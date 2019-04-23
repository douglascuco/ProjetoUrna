/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dodoc
 */
public class ConnectionUrna {
    
    public Statement stm; //realizar pesquisa no BD
    public ResultSet rs; //armazenar o resultado da pesquisa
    private final String driver = "com.mysql.cj.jdbc.Driver"; //identifica o SV
    private final String caminho = "jdbc:mysql://localhost:3306/urna?useTimezone=true&serverTimezone=UTC";
    private final String usuario = "root";
    private final String senha = "cuco5525237";
    public Connection con;
    

    public void conexao(){
        
        try {
            System.setProperty("jdbc.Driver", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
//            JOptionPane.showMessageDialog(null, "Conexao com o BD bem sucedida");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao com o BD:\n" + ex);
        }
}
    
     public void desconectar(){
        try {
            System.setProperty("jdbc.Driver", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            con.close();
//            JOptionPane.showMessageDialog(null, "BD desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar com o BD:\n" + ex);
        }
    }
    
   public void executaSql (String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro executaSql:\n" + ex);
        }
        
    }
    
   public void executaSql1 (String sql){
        try {
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro executaSql:\n" + ex);
        }
        
    }
}