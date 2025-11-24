package controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.EmpleadoDAOImp;
import dao.PedidoDAO;
import dao.PedidoDAOImp;
import dao.ProductoDAOImp;
import model.*;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AlmacenController {
    ProductoDAOImp productoDAOImp = new ProductoDAOImp();
    EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp();
    PedidoDAOImp pedidoDAOImp = new PedidoDAOImp();

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

    public void getAllProductosPrecioMenor40() {
        for (Producto producto: productoDAOImp.getAllProductosPrecioMenor40()){
            System.out.println(producto.toString());
        }
    }

    public void cargarProductosFavoritos() {
        productoDAOImp.cargarProductosFavoritos();
    }

    public void cargarEmpleados(List<Empleado> listaEmpleados) {

        for (Empleado empleado : listaEmpleados) {
            empleadoDAOImp.insertarEmpleado(empleado);
        }

    }

    public void cargarEmpleados(Empleado empleado) {
        empleadoDAOImp.insertarEmpleado(empleado);
    }

    public void cargarPedidos(List<Pedido> listaPedidos) {

        for (Pedido pedido : listaPedidos) {
            pedidoDAOImp.insertarPedido(pedido);
        }

    }

    public void cargarPedidos(Pedido pedido) {
        pedidoDAOImp.insertarPedido(pedido);
    }
}
