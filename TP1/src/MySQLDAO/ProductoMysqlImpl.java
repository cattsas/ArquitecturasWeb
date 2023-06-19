package MySQLDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConexionMySql;
import Interface.DAOProducto;
import Modelo.Cliente;
import Modelo.Producto;

public class ProductoMysqlImpl extends ConexionMySql implements DAOProducto{

	@Override
	public List<Producto> selectProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProducto() {
		String query = "CREATE TABLE IF NOT EXISTS  producto (id INT, name VARCHAR(45), value float, PRIMARY KEY (id))";
		try {
			super.getInstance().prepareStatement(query).execute();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertProducto(int id, String name, float value) {
		String query = "INSERT IGNORE INTO producto(id,name, value) values (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, value);
			ps.executeUpdate();
			ps.close();
			super.getInstance().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Producto getProducto(int idProducto) {
		String query = "SELECT * FROM producto WHERE id = ?";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ps.setInt(1, idProducto);
			ResultSet rs = ps.executeQuery();
			ps.close();
			Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			return producto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Producto getMayorRecaudacion() {
		String query = "SELECT p.id, p.name, (SUM(p.value * fp.cantidad))as total FROM factura_producto fp"
				+ "	JOIN producto p ON p.id = fp.idProducto"
				+ "	GROUP BY idProducto"
				+ "	ORDER BY total DESC"
				+ "	LIMIT 1";
		PreparedStatement ps;
		try {
			ps = super.getInstance().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();				
			Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			
			return producto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
