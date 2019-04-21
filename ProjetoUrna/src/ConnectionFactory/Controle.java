/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author dodoc
 */
    

public class Controle {
    ConnectionUrna conex = new ConnectionUrna();
    Usuario user = new Usuario();
    
    
    public void Cadastrar(Usuario user){
        conex.conexao();
        try{
        PreparedStatement pst = conex.con.prepareStatement("insert into Usuario(nomeUsuario, senhaUsuario, datanascUsuario) values (?,?,?)");
        pst.setString(1, user.getNomeUsuario());
        pst.setString(2, user.getSenhaUsuario());
        pst.setString(3, user.getDatanascUsuario());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao Efetuar Cadastro!\n" +ex);
        }
        conex.desconectar();
    }
    
    public void TrazerCod(Usuario user){
        conex.conexao();
        try{
        PreparedStatement stm = conex.con.prepareStatement("select max(idUsuario) from usuario");
        conex.rs = stm.executeQuery();
        conex.rs.next();
        user.setId(conex.rs.getInt(1));
        JOptionPane.showMessageDialog(null, "Sucesso ao trazer COD!\n");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Trazer COD!\n" +ex);
        }
        conex.desconectar();
    }
    
    public void TrazerSenha(Usuario user){
        conex.conexao();
        try {
            PreparedStatement stm = conex.con.prepareStatement("select * from urna.Usuario where idUsuario = ?");
            stm.setInt(1,user.getId());
            conex.rs = stm.executeQuery();
            conex.rs.next();
            user.setSenhaUsuario(conex.rs.getString("senhaUsuario"));
            JOptionPane.showMessageDialog(null, "Sucesso ao trazer Usuario!\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Trazer Usuario!\n" +ex);
        }
        conex.desconectar();
    }
    
    public void AlterarSenha(Usuario user){
        conex.conexao();
        try{
        PreparedStatement pst = conex.con.prepareStatement("UPDATE usuario set senhaUsuario = ? WHERE idUsuario = ? ");
        pst.setString(1, user.getSenhaUsuario());
        pst.setInt(2,user.getId());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso!");
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao Alterar Senha!\n" +ex);
        }
        conex.desconectar();
    }
    
}
