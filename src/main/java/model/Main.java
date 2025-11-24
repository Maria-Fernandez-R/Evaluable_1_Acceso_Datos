package model;

import controler.AlmacenController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlmacenController almacenController = new AlmacenController();

        //CARGAR PRODUCTOS DE JSON
        almacenController.cargarProductosBD();

        //AÑADIR EMPLEADOS
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();

        Empleado emp1 = new Empleado("Maria", "Fernandez", "123123234", "maria@gmail.com", "Madrid", "78910");
        Empleado emp2 = new Empleado("Juan", "Martinez", "654111222", "juan.mar@gmail.com", "Barcelona", "08001");
        Empleado emp3 = new Empleado("Lucia", "Gomez", "612345678", "lucia.gomez@hotmail.com", "Valencia", "46003");
        Empleado emp4 = new Empleado("Carlos", "Ruiz", "698777666", "carlos.ruiz@outlook.com", "Sevilla", "41004");
        Empleado emp5 = new Empleado("Ana", "Syla", "600999888", "ana.syla@yahoo.es", "Bilbao", "48005");
        Empleado emp6 = new Empleado("David", "Broncano", "722555444", "david.b@resistencia.com", "Madrid", "28010");
        Empleado emp7 = new Empleado("Elena", "Vargas", "633222111", "elena.vargas@gmail.com", "Zaragoza", "50002");
        Empleado emp8 = new Empleado("Sergio", "Ramos", "666444111", "sergio.ramos@futbol.com", "Sevilla", "41011");
        Empleado emp9 = new Empleado("Carmen", "Lomana", "611000999", "carmen.lo@tv.es", "Marbella", "29601");
        Empleado emp10 = new Empleado("Pedro", "Sanchez", "655888777", "pedro.s@gob.es", "Madrid", "28071");

        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);
        listaEmpleados.add(emp4);
        listaEmpleados.add(emp5);
        listaEmpleados.add(emp6);
        listaEmpleados.add(emp7);
        listaEmpleados.add(emp8);
        listaEmpleados.add(emp9);
        listaEmpleados.add(emp10);

        almacenController.cargarEmpleados(listaEmpleados);

        //AÑADIR PEDIDOS
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        LocalDate localDate = LocalDate.now();
        Date fecha = Date.valueOf(localDate);

        Pedido ped1 = new Pedido(fecha, 1, 2);
        Pedido ped2 = new Pedido(fecha, 2, 15);
        Pedido ped3 = new Pedido(fecha, 3, 7);
        Pedido ped4 = new Pedido(fecha, 4, 20);
        Pedido ped5 = new Pedido(fecha, 5, 1);
        Pedido ped6 = new Pedido(fecha, 1, 10);
        Pedido ped7 = new Pedido(fecha, 2, 4);
        Pedido ped8 = new Pedido(fecha, 3, 18);
        Pedido ped9 = new Pedido(fecha, 4, 11);
        Pedido ped10 = new Pedido(fecha, 5, 5);

        listaPedidos.add(ped1);
        listaPedidos.add(ped2);
        listaPedidos.add(ped3);
        listaPedidos.add(ped4);
        listaPedidos.add(ped5);
        listaPedidos.add(ped6);
        listaPedidos.add(ped7);
        listaPedidos.add(ped8);
        listaPedidos.add(ped9);
        listaPedidos.add(ped10);

        almacenController.cargarPedidos(listaPedidos);


        //CARGAR COMO PRODUCTOS FAVORITOS PRODUCTOS MAYORES A 50€
        almacenController.cargarProductosFavoritos();

        //OBTENER TODOS LOS PRODUCTOS
        System.out.println("OBTENER TODOS LOS PRODUCTOS");
        almacenController.getAllProductos();

        //OBTENER TODOS LOS PRODUCTOS FAVORITOS
        System.out.println("OBTENER TODOS LOS PRODUCTOS FAVORITOS");
        almacenController.getAllProductosFavoritos();

        //OBTENER TODOS LOS PRODUCTOS CON PRECIO INFERIOR A 40€
        System.out.println("OBTENER TODOS LOS PRODUCTOS QUE TIENEN UN PRECIO INFERIOR A 40 €");
        almacenController.getAllProductosPrecioMenor40();


    }
}
