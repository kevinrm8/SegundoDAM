/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="Contactos")
public class Contacto implements Serializable {
    private static final long SerialVersionUTD=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContacto;
    private String nombre;
    private String email;
    private int telefono;
    
    public Contacto(){
    }

    public Contacto( String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idcontacto=" + idContacto + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }
       
    
}
