/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author dodoc
 */
public class Usuario {
    private int idUsuario;
    private String senhaUsuario;
    private String nomeUsuario;
    private String datanascUsuario;

    public String getDatanascUsuario() {
        return datanascUsuario;
    }

    public void setDatanascUsuario(String datanascUsuario) {
        this.datanascUsuario = datanascUsuario;
    }
    
    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}