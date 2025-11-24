package model;

import controler.AlmacenController;

public class Main {
    public static void main(String[] args) {
        AlmacenController almacenController = new AlmacenController();

        //CARGAR PRODUCTOS DE JSON
        almacenController.cargarProductosBD();
        //CARGAR COMO PRODUCTOS FAVORITOS PRODUCTOS MAYORES A 1000€
        almacenController.cargarProductosFavoritos();
        System.out.println("OBTENER TODOS LOS PRODUCTOS");
        almacenController.getAllProductos();
        System.out.println("OBTENER TODOS LOS PRODUCTOS FAVORITOS");
        almacenController.getAllProductosFavoritos();
        System.out.println("OBTENER TODOS LOS PRODUCTOS QUE TIENEN UN PRECIO INFERIOR A 40 €");
        almacenController.getAllProductosPrecioMayor600();
    }
}
