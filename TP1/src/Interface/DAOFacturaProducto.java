package Interface;

import java.util.List;

import Modelo.FacturaProducto;

public interface DAOFacturaProducto {
	
	/**
	 * Create a table FacturaProducto.
	 */
	public void createFacturaProducto();
	
	/**
	 * Insert a new record FacturaProducto in the table.
	 * @param idFactura  the Factura identifier. 
	 * @param idProducto the Producto identifier.
	 * @param cantidad   the amount of Producto included in the Factura.
	 * @see FacturaProducto class
	 */
	public void insertFacturaProducto(int idFactura, int idProducto, int cantidad);
	
	/**
	 * Lists the Producto objects for the specified Factura.
	 * @param id  the Factura identifier. 
	 * @return ArrayList of FacturaProducto
	 * @see FacturaProducto class
	 */
	public List<FacturaProducto> detalleFactura(int id);	
		
}
