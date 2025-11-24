package dao;

import controler.SchemeDB;
import database.DBConnection;
import model.Empleado;
import model.Pedido;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImp implements ProductoDAO{
    private Connection connection = DBConnection.getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public void insertaProducto(Producto producto) {
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                SchemeDB.TAB_NAME_P, SchemeDB.COL_NAME, SchemeDB.COL_DESCRIPTION,
                SchemeDB.COL_PRICE, SchemeDB.COL_QUANTITY);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,producto.getNombre());
            preparedStatement.setString(2,producto.getDescripcion());
            preparedStatement.setInt(3,producto.getCantidad());
            preparedStatement.setDouble(4,producto.getPrecio());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al insertar un producto");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> productos= new ArrayList<Producto>();
        String query = String.format("SELECT * FROM %s",SchemeDB.TAB_NAME_P);
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(SchemeDB.COL_ID);
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String descripcion = resultSet.getString(SchemeDB.COL_DESCRIPTION);
                Integer cantidad = resultSet.getInt(SchemeDB.COL_QUANTITY);
                Double precio = resultSet.getDouble(SchemeDB.COL_PRICE);

                Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al obtener todos los productos");
            System.out.println(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> getAllProductosFavoritos() {
        List<Producto> productos= new ArrayList<Producto>();
        String query = String.format("SELECT * FROM %s P RIGHT JOIN %s PF on P.%s=PF.%s",
                SchemeDB.TAB_NAME_P,SchemeDB.TAB_NAME_PF,SchemeDB.COL_ID,SchemeDB.COL_ID_PRODUCTO);
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(SchemeDB.COL_ID);
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String descripcion = resultSet.getString(SchemeDB.COL_DESCRIPTION);
                Integer cantidad = resultSet.getInt(SchemeDB.COL_QUANTITY);
                Double precio = resultSet.getDouble(SchemeDB.COL_PRICE);

                Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al obtener todos los productos favoritos");
            System.out.println(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> getAllProductosPrecioMenor40() {
        List<Producto> productos= new ArrayList<Producto>();
        //Se coloca 40 por que el maximo de precio que devuelve la pagina es 99
        String query = String.format("SELECT * FROM %s WHERE %s < 40",SchemeDB.TAB_NAME_P,SchemeDB.COL_PRICE);
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(SchemeDB.COL_ID);
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String descripcion = resultSet.getString(SchemeDB.COL_DESCRIPTION);
                Integer cantidad = resultSet.getInt(SchemeDB.COL_QUANTITY);
                Double precio = resultSet.getDouble(SchemeDB.COL_PRICE);

                Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al obtener todos los productos");
            System.out.println(e.getMessage());
        }
        return productos;
    }

    @Override
    public void cargarProductosFavoritos() {
        //Se coloca 50 porque la pagina no da productos con precio mayor a 99
        String query = String.format("INSERT INTO %s (%s) " +
                "SELECT %s FROM %s WHERE %s > 50",SchemeDB.TAB_NAME_PF, SchemeDB.COL_ID_PRODUCTO,
                SchemeDB.COL_ID,SchemeDB.TAB_NAME_P,SchemeDB.COL_PRICE);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al insertar productos favoritos");
            System.out.println(e.getMessage());
        }
    }




}

