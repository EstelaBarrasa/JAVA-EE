package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Mantiene conexiones a la bse de datos
 */
public class DB {
	/**
	 * Devuelve una conexion a la base de datos
	 * @return Conexion a la base de datos
	 */
	public static Connection getConexion(){
		Connection con=null;
		try {		
			Context contextoInicial  = new InitialContext();
			Context envContext  = (Context)contextoInicial.lookup("java:/comp/env");
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/Tienda");
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		System.out.println(con);
		return con;
	}
	
	/**
	 * Comprueba si se puede acceder a la base de datos
	 * @return true=se puede acceder, false=no se puede acceder
	 */
	public static boolean estaOK(){
		boolean r=false;
		
		String sql="select curdate()";
		try(Connection con=getConexion();
			Statement stm=con.createStatement()){
			
			ResultSet rs=stm.executeQuery(sql);
			r=rs.next();
			rs.close();
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo en la conexion a la base de datos.");
		}
		catch(NullPointerException npe){
			System.out.println("Fallo en la conexion a la base de datos.");
		}
		
		return r;
	}
}
