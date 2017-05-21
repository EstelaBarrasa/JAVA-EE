package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.Producto;

public class DAOProducto implements Serializable{
	public static final long serialVersionUID=1L;
	
	public Producto getProducto(int idProducto){
		Producto p=null;
		
		String sql="select nombre,precio from productos where id_producto=?";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1,idProducto);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p=new Producto(idProducto,rs.getString("nombre"),rs.getDouble("precio"));
			}
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return p;
	}
	
	public ArrayList<Producto> listar(){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		
		String sql="select * from productos order by id_producto asc";
		try(Connection con=DB.getConexion();
		    Statement st=con.createStatement()){
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Producto p=new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("precio"));
				lista.add(p);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}
	
}
