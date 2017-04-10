
package modelo;


public class Procesos {

    public double Contado(Datos d) {
        return (d.getCantidad()*d.getPrecio())-(d.getCantidad()*d.getPrecio()*0.05);
    }
 public double Tarjeta(Datos d) {
        return (d.getCantidad()*d.getPrecio())-(d.getCantidad()*d.getPrecio()*0.10);
    }
   

}
