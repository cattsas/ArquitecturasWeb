package Factories;

import Interface.DAOCliente;
import Interface.DAOFactura;
import Interface.DAOFacturaProducto;
import Interface.DAOProducto;
import MySQLDAO.ClienteMysqlImpl;
import MySQLDAO.FacturaMysqlImpl;
import MySQLDAO.FacturaProductoMysqlImpl;
import MySQLDAO.ProductoMysqlImpl;

public class FactoryMySQL extends FactoryDB{
	public void createDB () {
		
	}
	@Override
	public DAOCliente getDAOCliente() {
		return new ClienteMysqlImpl();
	}

	@Override
	public DAOFactura getDAOFactura() {
		return new FacturaMysqlImpl();
	}

	@Override
	public DAOProducto getDAOProducto() {
		return new ProductoMysqlImpl();
	}

	@Override
	public DAOFacturaProducto getDAOFacturaProducto() {
		return new FacturaProductoMysqlImpl();
	}
	
}
