/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class ConectarBase {
     

    public static Connection conectar() {
        Connection connect = null;

        String password = "password";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/alimentos?user=" + usuario
                + "&password=" + password;
        try {
            connect = DriverManager.getConnection(url);
            if (connect != null) {
                System.out.println("Conectado");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return connect;
    }
}
