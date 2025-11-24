package controler;

public interface SchemeDB {


    String DB_NAME = "almacen";

    String TAB_NAME_P = "productos";
    String TAB_NAME_PF = "productos_fav";
    String TAB_NAME_EMP = "empleados";
    String TAB_NAME_PED = "pedidos";

    String COL_ID = "id";

    String COL_ID_PRODUCTO = "id_producto";
    String COL_NAME = "nombre";
    String COL_DESCRIPTION = "descripcion";
    String COL_QUANTITY = "cantidad";
    String COL_PRICE = "precio";

    String COL_EMP_NOMBRE = "nombre";
    String COL_EMP_APELLIDO = "apellido";
    String COL_EMP_DNI = "dni";
    String COL_EMP_EMAIL = "email";
    String COL_EMP_DIRECCION = "direccion";
    String COL_EMP_TELEFONO = "telefono";


    String COL_PED_FECHA = "fecha";
    String COL_PED_ID_CLIENTE = "id_cliente";
    String COL_PED_ID_PRODUCTO = "id_producto";




}
