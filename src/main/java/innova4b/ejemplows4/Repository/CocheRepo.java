package innova4b.ejemplows4.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import innova4b.ejemplows4.Domain.Coche;

public class CocheRepo {
	Connection connection;
	
	public CocheRepo(Connection connection){
		this.connection = connection;
	}
	
	public ArrayList<Coche> list() {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from coche");				
			while (rs.next()){
				Coche coche = new Coche();	
				coche.setMarca(rs.getString("marca"));
				coche.setModelo(rs.getString("modelo"));
				coche.setMatricula(rs.getString("matricula"));
				coche.setAnyoCompra(rs.getInt("anyoCompra"));
				coches.add(coche);
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return coches;
	}
	

	public Coche get(int id) {
		Statement stmt = null;
		Coche coche = new Coche();
		try {
			stmt = connection.createStatement();
			String query = "select * from coche where id="+id+";";
			ResultSet rs = stmt.executeQuery(query);				
			while (rs.next()){	
				coche.setMarca(rs.getString("marca"));
				coche.setModelo(rs.getString("modelo"));
				coche.setMatricula(rs.getString("matricula"));
				coche.setAnyoCompra(rs.getInt("anyoCompra"));
				
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return coche;
	}

	public int insert(Coche coche) {
		int row = 0;
		String sql="insert into coche (marca, modelo, matricula, anyoCompra) values (?,?,?,?);";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
		
		ps.setString(1, coche.getMarca());
		ps.setString(2, coche.getModelo());
		ps.setString(3, coche.getMatricula());
		ps.setInt(4, coche.getAnyoCompra());
		row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
}
