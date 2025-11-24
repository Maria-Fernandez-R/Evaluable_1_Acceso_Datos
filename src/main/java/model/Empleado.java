package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String direccion;
    private String telefono;

    public Empleado(String nombre, String apellido, String dni, String email, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
