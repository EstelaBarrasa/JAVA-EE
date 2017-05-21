package dao;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;
import modelo.Producto;

public class DAOProducto implements Serializable {
	
	public static final long serialVersionUID=1L;
	
	public Producto getProducto(int id){
		Producto p=null;
		
		String sql="Select nombre, precio from productos where id=?";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p=new Producto(id,rs.getString("nombre"),rs.getDouble("precio"));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return p;
	}
	
	public ArrayList<Producto> listar(){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		
		String sql="select * from productos order by id asc";
		try(Connection con=DB.getConexion();
			Statement st=con.createStatement()){
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Producto p=new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getDouble("precio"));
				lista.add(p);
			}
				
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  request.getRequestDispatcher("ServletTienda").forward(request, response); 
		}
}
