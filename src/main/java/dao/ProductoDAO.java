package dao;

import model.Empleado;
import model.Pedido;
import model.Producto;

import java.util.List;

public interface ProductoDAO {
    void insertaProducto(Producto producto);
    List<Producto> getAllProductos();
    List<Producto> getAllProductosFavoritos();
    List<Producto> getAllProductosPrecioMenor40();
    void cargarProductosFavoritos();
}
