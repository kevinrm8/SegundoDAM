/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer5.orientobj;


public class VideoJuegos {
    
    private String titulo;
    private int horas;
    private boolean entregado;
    private String genero;
    private String compania;

    public VideoJuegos() {
        this.titulo = "";
        this.horas = 10;
        this.entregado = false;
        this.genero = "";
        this.compania = "";
    }

    public VideoJuegos(String titulo, int horas) {
        this.titulo = titulo;
        this.horas = horas;
        this.entregado = false;
        this.genero = "";
        this.compania = "";
    }

    public VideoJuegos(String titulo, int horas, String genero, String compania) {
        this.titulo = titulo;
        this.horas = horas;
        this.entregado = false;
        this.genero = genero;
        this.compania = compania;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "VideoJuegos{" + "titulo=" + titulo + ", horas=" + horas + ", entregado=" + entregado + ", genero=" + genero + ", compania=" + compania + '}';
    }
    
    
}
