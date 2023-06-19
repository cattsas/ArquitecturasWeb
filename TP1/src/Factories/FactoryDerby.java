package Factories;

import Interface.DAOCliente;
import Interface.DAOFactura;
import Interface.DAOFacturaProducto;
import Interface.DAOProducto;
import MyDerbyDAO.*;


public class FactoryDerby extends FactoryDB{

	@Override
	public DAOCliente getDAOCliente() {
		// TODO Auto-generated method stub
		return new ClienteDerbyImpl();
	}

	@Override
	public DAOFactura getDAOFactura() {
		return new FacturaDerbyImpl();
	}

	@Override
	public DAOProducto getDAOProducto() {
		return new ProductoDerbyImpl();
	}

	@Override
	public DAOFacturaProducto getDAOFacturaProducto() {
		return new FacturaProductoDerbyImpl();
	}
	
}
