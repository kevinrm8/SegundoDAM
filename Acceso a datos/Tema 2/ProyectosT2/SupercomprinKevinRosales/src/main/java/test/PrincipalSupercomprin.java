/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.eWalletDAO;
import domain.eWallet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author kevin
 */
public class PrincipalSupercomprin {

    public static void main(String[] args) throws SQLException {

        //Para comprobar la edad
        int dia, mes, ano;
        dia = 31;
        mes = 07;
        ano = 92;
        Date fechanac = new Date(ano, mes - 1, dia);
        calcularAnios(fechanac); // Metodo calcular edad
        System.out.println(fechanac + " DIFERENCIA ES: " + calcularAnios(fechanac));

//crear cliente nuevo, asignarle una eWallet
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            eWalletDAO eWDAO = new eWalletDAO(conexion);
            eWallet insert_eWallet = new eWallet();
            insert_eWallet.setNombre("Kevin");
            insert_eWallet.setDNI("355A");
            insert_eWallet.setEdad(28);
            insert_eWallet.setFecha_nacimiento("31/07/1992");
            insert_eWallet.setTelefono(56465456);
            insert_eWallet.setSaldo(1000);
            eWDAO.insertar(insert_eWallet);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static int calcularAnios(Date fechaNac) {

        //Fecha actual
        java.util.Date actual = new java.util.Date();

        //Cojo los datos necesarios
        int diaActual = actual.getDate();
        int mesActual = actual.getMonth() + 1;
        int anioActual = actual.getYear() + 1900;

        //Diferencia de años
        int diferencia = anioActual - (fechaNac.getYear() + 1900);

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= fechaNac.getMonth()) {
            //si
            if (mesActual == fechaNac.getMonth() + 1) {
                if (fechaNac.getDay() > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }

        return diferencia;

    }
}
