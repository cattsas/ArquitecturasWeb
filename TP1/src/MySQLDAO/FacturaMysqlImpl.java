package MySQLDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConexionMySql;
import Interface.DAOFactura;
import Modelo.Factura;

public class FacturaMysqlImpl extends ConexionMySql implements DAOFactura{

	@Override
	public List<Factura> selectFacturas() {
		List<Factura> listadoFactura = new ArrayList<>();
		String select = "SELECT * FROM factura";
		try {
			PreparedStatement ps = super.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Factura c = new Factura(rs.getInt(1), rs.getInt(2));
				listadoFactura.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listadoFactura;
	}

	@Override
	public void createFactura() {
		String query = "CREATE TABLE IF NOT EXISTS  factura (idFactura INT, idCliente INT, PRIMARY KEY (idFactura, idCliente))";
		try {
			super.getInstance().prepareStatement(query).execute();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertFactura(int idFactura, int idCliente) {
		String query = "INSERT IGNORE INTO factura values (?, ?)";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ps.setInt(1, idFactura);
			ps.setInt(2, idCliente);
			ps.executeUpdate();
			ps.close();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Factura getFactura(int idFactura) {
		String query = "SELECT * FROM factura WHERE id = ?";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ps.setInt(1, idFactura);
			ResultSet rs = ps.executeQuery();
			ps.close();
			Factura factura = new Factura(rs.getInt(1), rs.getInt(2));
			return factura;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
