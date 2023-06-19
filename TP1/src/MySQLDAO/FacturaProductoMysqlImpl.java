package MySQLDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Connection.ConexionMySql;
import Interface.DAOFacturaProducto;
import Modelo.FacturaProducto;

public class FacturaProductoMysqlImpl extends ConexionMySql implements DAOFacturaProducto{

	@Override
	public void createFacturaProducto() {
		String query = "CREATE TABLE IF NOT EXISTS  factura_producto (idFactura INT, idProducto INT, cantidad INT, PRIMARY KEY (idFactura, idProducto))";
		try {
			super.getInstance().prepareStatement(query).execute();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertFacturaProducto(int idFactura, int idProducto, int cantidad) {
		String query = "INSERT IGNORE INTO factura_producto values (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ps.setInt(1, idFactura);
			ps.setInt(2, idProducto);
			ps.setInt(3, cantidad);
			ps.executeUpdate();
			ps.close();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<FacturaProducto> detalleFactura(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
