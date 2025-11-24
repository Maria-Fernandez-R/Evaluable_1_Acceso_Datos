package dao;

import controler.SchemeDB;
import database.DBConnection;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAOImp implements PedidoDAO{
    private Connection connection = DBConnection.getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void insertarPedido(Pedido pedido) {
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                SchemeDB.TAB_NAME_PED, SchemeDB.COL_PED_FECHA, SchemeDB.COL_PED_ID_CLIENTE,
                SchemeDB.COL_PED_ID_PRODUCTO);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1,pedido.getFecha());
            preparedStatement.setInt(2,pedido.getIdCliente());
            preparedStatement.setInt(3,pedido.getIdProducto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al insertar pedido");
            System.out.println(e.getMessage());
        }
    }
}
