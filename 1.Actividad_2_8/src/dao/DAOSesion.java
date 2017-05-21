package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Sesion;

public class DAOSesion {

	/**
	 * Insertar un objeto Sesion en la BD o incrementa su cuenta si ya existe
	 * @param s
	 * @return Resultado de la operacion
	 */
	public ResultadoCRUD update(Sesion s){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="insert into sesiones (id,n) values (?,1)"
				+ "on duplicate key update n=n+1;";
		try(Connection con=DB.getConexion();
			PreparedStatement stm=con.prepareStatement(sql);){
			
			stm.setString(1, s.getId());
			stm.executeUpdate();
			r=read(s);
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return r;
	}
	
	/**
	 * Lee un objeto Sesion de la BD cuyo id coincida con el de s y rellena la cuenta de accesos en s
	 * @param s
	 * @return Resultado de la operacion
	 */
	public ResultadoCRUD read(Sesion s){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="select n from sesiones where id=?";
		try(Connection con=DB.getConexion();
			PreparedStatement stm=con.prepareStatement(sql);){
			stm.setString(1, s.getId());
			ResultSet rs=stm.executeQuery();
			if(rs.next()){
				s.setN(rs.getInt("n"));
			}
			rs.close();
			r=ResultadoCRUD.OK;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return r;
	}
	
	/**
	 * Borra la sesion de la base de datos
	 * @param s sesion a borrar
	 * @return Resultado de la operacion
	 */
	public ResultadoCRUD delete(Sesion s){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="delete from sesiones where id=?";
		try(Connection con=DB.getConexion();
			PreparedStatement stm=con.prepareStatement(sql);){
			stm.setString(1, s.getId());
			int n=stm.executeUpdate();
			
			if(n>0){
				r=ResultadoCRUD.OK;
			}
			else{
				r=ResultadoCRUD.NO_EXISTE;
			}
		}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
			return r;
	}
}
