package dao;

import controler.SchemeDB;
import database.DBConnection;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAOImp implements EmpleadoDAO{
    private Connection connection = DBConnection.getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void insertarEmpleado(Empleado empleado) {

        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?)",
                SchemeDB.TAB_NAME_EMP, SchemeDB.COL_EMP_NOMBRE, SchemeDB.COL_EMP_APELLIDO,
                SchemeDB.COL_EMP_DNI,SchemeDB.COL_EMP_EMAIL,SchemeDB.COL_EMP_DIRECCION,
                SchemeDB.COL_EMP_TELEFONO);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,empleado.getNombre());
            preparedStatement.setString(2, empleado.getApellido());
            preparedStatement.setString(3,empleado.getDni());
            preparedStatement.setString(4,empleado.getEmail());
            preparedStatement.setString(5,empleado.getDireccion());
            preparedStatement.setString(6, empleado.getTelefono());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Ha ocurrido un error al insertar empleado");
            System.out.println(e.getMessage());
        }


    }
}
