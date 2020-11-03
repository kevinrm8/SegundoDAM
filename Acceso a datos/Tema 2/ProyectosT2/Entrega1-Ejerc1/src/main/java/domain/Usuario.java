/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kevmar
 */
public class Usuario {
    private int id_usuario;
    private String Usuario;
    private String Password;

    //CONSTRUCTORES
    public Usuario(){
    }
    
    public Usuario(int id_usuario, String Usuario, String Password) {
        this.id_usuario = id_usuario;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public Usuario(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getIdusuario() {
        return id_usuario;
    }

    public void setIdusuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return Usuario;
    }

    public void setNombre(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + id_usuario + ", nombre=" + Usuario + ", password=" + Password + '}';
    }
    
}
