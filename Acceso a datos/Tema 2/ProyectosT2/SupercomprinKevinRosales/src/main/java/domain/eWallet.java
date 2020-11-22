/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;

/**
 *
 * @author kevin
 */
public class eWallet {

    private int ideWallet;
    private String nombre;
    private String DNI;
    private int edad;
    private String fecha_nacimiento;
    private int telefono;
    private float saldo=0;
    private int puntos=0;
    
    public eWallet() {
    }

    public eWallet(String nombre, String DNI, int edad, String fecha_nacimiento, int telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    public eWallet(int ideWallet, String nombre, String DNI, int edad, String fecha_nacimiento, int telefono, float saldo, int puntos) {
        this.ideWallet = ideWallet;
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.saldo = saldo;
        this.puntos = puntos;
    }

    public int getIdeWallet() {
        return ideWallet;
    }

    public void setIdeWallet(int ideWallet) {
        this.ideWallet = ideWallet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo += saldo;
    }

        public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "eWallet{" + "ideWallet=" + ideWallet + ", nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", saldo=" + saldo + ", puntos=" + puntos + '}';
    }
   

    

}
