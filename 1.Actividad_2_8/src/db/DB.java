package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	/**
	 * Devuelve una conexion a la base de datos
	 * @return
	 */
	public static Connection getConexion(){
		Connection con=null;
		try{
			DataSource dataSource;
			
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Actividad_2_8_DB");
			con=dataSource.getConnection();
		}catch (NamingException e){
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
	}
}
