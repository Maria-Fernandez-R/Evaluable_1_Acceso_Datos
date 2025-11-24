package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Integer id;
    private Date fecha;
    private Integer idCliente;
    private Integer idProducto;

    public Pedido(Date fecha, Integer idCliente, Integer idProducto) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }
}
