package CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoCrud {

    ArrayList listaDeAlimentos = new ArrayList<Alimento>();
    String tabla = "alimentos";

    public ArrayList<Alimento> obtener() {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "select * from " + tabla + ";";

        try {
            connect = ConectarBase.conectar();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                //Suponiendo que la bd está dispuesta en las filas: id, nombre, cantidad
                    Alimento alimento = new Alimento();
                alimento.setId(result.getInt(1));
                alimento.setNombre(result.getString(2));
                alimento.setCantidad(result.getInt(3));
                listaDeAlimentos.add(alimento);
                
            }

            connect.close();
            statement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener información en una peticion a la bd");
            e.printStackTrace();
        }
        return listaDeAlimentos;
    }
    protected int nuevoId;

    public boolean eliminar(Alimento alimento) {
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        System.out.println("Id a borrar: " + alimento.getId());
        String sql = "DELETE FROM "+ tabla +" WHERE ID=" + alimento.getId() + ";";

        try {
            connect = ConectarBase.conectar();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
            }
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar información en una peticion a la bd");
            e.printStackTrace();
        }
        return false;
    }

    public boolean registrar(Alimento alimento) {
        boolean registrar = true;
        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;
        String sql = "insert into "+ tabla +" values ('$nombreProducto','$cantida');";

        try {
            connect = ConectarBase.conectar();
            statement = connect.createStatement();
            statement.execute(sql);
            registrar = true;
            statement.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println("No se pudo registrar información en una peticion a la bd");
            e.printStackTrace();
        }

        return false;
    }

    public boolean actualizar(Alimento alimento) {
        Connection connect = null;
        Statement statement = null;
        
        boolean actualizar = false;
        
        String sql = "update " + tabla + " set Cantidad = " + alimento.getCantidad() + " where ID=" + alimento.getId() + ";";
        
        try{
            connect = ConectarBase.conectar();
            statement = connect.createStatement();
            statement.execute(sql);
            actualizar = true;
            
        }catch(SQLException e){
            System.out.println("No se pudo actualizar informacion en una peticion a la bd");
            e.printStackTrace();
        }
        return actualizar;

    }
}
