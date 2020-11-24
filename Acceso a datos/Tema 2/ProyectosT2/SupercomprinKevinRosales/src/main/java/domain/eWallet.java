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
    private Date fecha_nacimiento;
    private int telefono;
    private float saldo = 0;
    private float puntos = 0;

    public eWallet() {
    }

    public eWallet(String nombre, String DNI, int edad, Date fecha_nacimiento, int telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    public eWallet(int ideWallet, String nombre, String DNI, int edad, Date fecha_nacimiento, int telefono, float saldo, float puntos) {
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
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
        this.saldo = saldo;
    }

    public void sumarSaldo(float saldo) {
        this.saldo += saldo;
    }

    public void restarSaldo(float saldo) {
        this.saldo -= saldo;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }
       public void sumarPuntos(float puntos) {
        this.puntos += puntos;
    }

    public void restarPuntos(float puntos) {
        this.puntos -= puntos;
    }

    @Override
    public String toString() {
        return "eWallet{" + "ideWallet=" + ideWallet + ", nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", saldo=" + saldo + ", puntos=" + puntos + '}';
    }
    public String verSaldoyPuntos() {
        return "La eWallet de "+nombre+" tiene:\nSaldo: "+saldo+" Puntos: "+puntos;
    }

}
