package dao;

import model.Producto;

import java.util.List;

public interface ProductoDAO {
    void insertaProducto(Producto producto);
    List<Producto> getAllProductos();
    List<Producto> getAllProductosFavoritos();
    List<Producto> getAllProductosPrecioMayor600();
    void cargarProductosFavoritos();
}
