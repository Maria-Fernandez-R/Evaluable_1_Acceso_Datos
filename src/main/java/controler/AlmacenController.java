package controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProductoDAOImp;
import model.Producto;
import model.ProductoJSON;
import model.ProductoResponse;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class AlmacenController {
    ProductoDAOImp productoDAOImp = new ProductoDAOImp();
    String uri = "https://dummyjson.com/products";
    ObjectMapper objectMapper = new ObjectMapper();


    public void cargarProductosBD() {
        URL url;
        {
            try {
                url = URI.create(uri).toURL();
                ProductoResponse response = objectMapper.readValue(url,ProductoResponse.class);
                for (ProductoJSON productoJSON : response.getProductos()){
                    String nombre = productoJSON.getTitle();
                    String descripcion = productoJSON.getDescription();
                    Integer cantidad = productoJSON.getStock();
                    Double precio = productoJSON.getPrice();

                    Producto producto = new Producto(nombre,descripcion,cantidad,precio);

                    productoDAOImp.insertaProducto(producto);
                }
            } catch (Exception e) {
                System.out.println("ERROR: Ha ocurrido un error al insertar un producto");
                System.out.println(e.getMessage());
            }
        }
    }

    public void getAllProductos(){
        for (Producto producto: productoDAOImp.getAllProductos()){
            System.out.println(producto.toString());
        }
    }
    public void getAllProductosFavoritos(){
        for (Producto producto: productoDAOImp.getAllProductosFavoritos()){
            System.out.println(producto.toString());
        }
    }

    public void getAllProductosPrecioMayor600() {
        for (Producto producto: productoDAOImp.getAllProductosPrecioMayor600()){
            System.out.println(producto.toString());
        }
    }

    public void cargarProductosFavoritos() {
        productoDAOImp.cargarProductosFavoritos();
    }
}
