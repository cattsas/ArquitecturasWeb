/**
 *<h3>Main</h3> 
 * 
 */

package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.*;

import Factories.FactoryDB;
import Interface.DAOCliente;
import Interface.DAOFactura;
import Interface.DAOFacturaProducto;
import Interface.DAOProducto;
import Modelo.Cliente;
import Modelo.Producto;

public class Main {

	public static void main(String[] args) {
		String dbName = "MySQL";
	//	String dbName = "Derby";

		FactoryDB db = FactoryDB.getConnetion(dbName);

		createProductosCSV(db.getDAOProducto());
		createClientesCSV(db.getDAOCliente());
		createFacturasCSV(db.getDAOFactura());
		createFacturaProductoCSV(db.getDAOFacturaProducto());
		
		
		Producto p = db.getDAOProducto().getMayorRecaudacion();
		System.out.println("Producto que mas recaudo: "+p.toString());
		List<Cliente> lisCli= db.getDAOCliente().getRankingFacturacion();
		System.out.println(lisCli);
		
	}	
	
	 /**
	 * This method populate the table FacturaProducto from a csv file.
	 * @param the daoFacturaProducto Is obtained from BBDD through getDAOFacturaProducto.
	 * @exception Not found file csv.
	 * @see Class DAOFacturaProducto.	  
	 **/
	private static void createFacturaProductoCSV(DAOFacturaProducto daoFacturaProducto) {
		CSVParser parser = null;

		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/facturas-productos.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoFacturaProducto.createFacturaProducto();
		for(CSVRecord row: parser) {
			daoFacturaProducto.insertFacturaProducto(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idProducto")), Integer.valueOf(row.get("cantidad")));

		}
		
	}

	/**
	 * This method populate the table Cliente from a csv file.
	 * @param the daoCliente Is obtained from BBDD through getDAOCliente method.
	 * @exception Not found file csv.
	 * @see Class DAOCliente.
	 **/
	private static void createClientesCSV(DAOCliente daoCliente) {
		CSVParser parser = null;

		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/clientes.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoCliente.createCliente();
		for(CSVRecord row: parser) {
			daoCliente.insertCliente(Integer.valueOf(row.get("idCliente")),row.get("nombre"), row.get("email"));

		}
		
	}

	
	/**
	 * This method populate the table Factura from a csv file.
	 * @param the daoFactura. Is obtained from BBDD through getDAOFactura.
	 * @exception Not found file csv.
	 * @see Class DAOFactura.	  
	 **/
	private static void createFacturasCSV(DAOFactura daoFactura) {
		CSVParser parser = null;

		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/facturas.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoFactura.createFactura();
		for(CSVRecord row: parser) {
			daoFactura.insertFactura(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idCliente")));
		}
		
	}

	/**
	 * This method populate the table Producto from a csv file.
	 * @param daoProducto. Is obtained from BBDD through getDAOProducto.
	 * @exception Not found file csv.
	 * @exception If an input or output.
	 * @see Class DAOProducto.	  
	 **/
	public static void createProductosCSV(DAOProducto daoProducto) {
		CSVParser parser = null;

		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/productos.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoProducto.createProducto();
		for(CSVRecord row: parser) {
			daoProducto.insertProducto(Integer.valueOf(row.get("idProducto")), row.get("nombre"), Float.valueOf(row.get("valor")));

		}
	}

}
