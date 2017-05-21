

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adios
 */
@WebServlet(
		description = "Servlet basica que se pira", 
		urlPatterns = { "/AdiosClase" },
		initParams={
			@WebInitParam(name="Empresa",value="Los Pollos Hermanos"),
			@WebInitParam(name="ColorFondo", value= "c8e5e3")
		})
		
public class Adios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adios() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		ServletConfig config=getServletConfig();
		String nombre=config.getInitParameter("Empresa");
		String color=config.getInitParameter("ColorFondo");
		String info=getServletInfo();
		
		Instant instant =
				Instant.ofEpochMilli(getLastModified(request));
				LocalDateTime fecha = LocalDateTime.ofInstant(instant,
				ZoneId.systemDefault());
				String strFecha = fecha.format(
				DateTimeFormatter.ofPattern(
				"EEEE d 'de' MMMM 'de' yyyy 'a las' hh:mm:ss"));
				String nombreServlet=config.getServletName();
		
		Enumeration<String> nombresParametros=config.getInitParameterNames();
		
		String respuesta=
				"<html>"
				+"<head><title>Servlet</title>"
				+"</head>"
				+"<body style='text-align:center;background-color:#"+color+"'>"
				+"<div style='text-align:left;font-size:2em;font-style:bold;'>PARAMETROS DE INICIO DEL SERVLET"
				+"<div style='margin-top:1em;text-align:left;border:solid;"+""
						+ "border-color:red;border-width:2px;width:60%;'>";
		while(nombresParametros.hasMoreElements()){
			String nombreParam=nombresParametros.nextElement();
			respuesta+="(NOMBRE="+nombreParam+",VALOR="+config.getInitParameter(nombreParam)+")<br/>";
		}
			
		respuesta += "</div>"
				+"<div style='margin-top:1em;padding:3em;display:inline-block;border:solid;"+""
						+ "border-color:black;border-width:1px;'>"
				+"Bienvenido a Desarrollo Soluciones Java<br/><br/>"
				+"Servlet information:"+info+ "<br/>"
				+"Nombre del servlet:"+nombreServlet+"<br/>"
				+"Fecha de modificacion: " +strFecha
				+"</div>"
				+"</body>"
				+"</html>";
		
		PrintWriter p=response.getWriter();
		p.println(respuesta);
	}
	
	@Override
	public String getServletInfo(){
		return "Copyright: Javatos 2017. Autor: Los javatos";
	}

	@Override
	protected long getLastModified(HttpServletRequest req){
		return System.currentTimeMillis();
	}
}
