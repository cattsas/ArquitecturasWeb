package Modelo;

/**
 * Defines the attributes of the FacturaProducto entity, which displays 
 * the results of matching between a Factura record and his corresponding 
 * Producto entities
 * @author fede
 *
 */
public class FacturaProducto {
	private int idFactura;
	private int idProducto;
	private int cantidad;
	public FacturaProducto(int idFactura, int idProducto, int cantidad) {
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public int getIdProducto() {
		return idProducto;
	}
	
	

}
