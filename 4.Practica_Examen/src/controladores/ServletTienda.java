package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOProducto;
import modelos.Producto;

/**
 * Servlet implementation class SevletTienda
 */
@WebServlet("/ServletTienda")
public class ServletTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion=request.getParameter("opcion");
		ServletContext contexto=request.getServletContext();
		String vista="opcionNoreconocida.jsp";
		HttpSession sesion=request.getSession();
		ArrayList<Producto> carrito=(ArrayList<Producto>)sesion.getAttribute("carrito");
		if(carrito==null){
			carrito=new ArrayList<Producto>();
			sesion.setAttribute("carrito",carrito);
		}
		
		if(opcion!=null && opcion.equals("1")){
			Cookie[] cookies=request.getCookies();
			String nombreUsuario="";
			for(Cookie co : cookies){
				if(co.getName().equals("nombreusuario")){
					nombreUsuario=co.getValue();
					break;
				}
			}
			if(nombreUsuario.equals("")){
				vista="/login.jsp";
			}
			else{
				request.setAttribute("nombreUsuario",nombreUsuario);
				DAOProducto dao=new DAOProducto();
				ArrayList<Producto> lista=dao.listar();
				request.setAttribute("lista",lista);
				Producto productoOferta=(Producto)contexto.getAttribute("oferta");
				String textoOferta="Producto oferta del dia: "+productoOferta.getNombre();
				request.setAttribute("oferta", textoOferta);
				vista="/mostrarTodos.jsp";
			}
		}
		if(opcion!=null && opcion.equals("2")){
			DAOProducto dao=new DAOProducto();
			String stIdProducto=request.getParameter("idProducto");
			try{
				int idProducto=Integer.parseInt(stIdProducto);
				Producto p=dao.getProducto(idProducto);
				request.setAttribute("producto", p);
				vista="/mostrarProducto.jsp";
			}
			catch(NumberFormatException nfe){
				vista="/datosincorrectos.jsp";
			}
		}
		if(opcion!=null && opcion.equals("3")){
			String stIdProducto=request.getParameter("idProducto");
			int idProducto=Integer.parseInt(stIdProducto);
			DAOProducto dao=new DAOProducto();
			Producto p=dao.getProducto(idProducto);
			carrito.add(p);
			request.setAttribute("carrito",carrito);
			
			double precioTotal=0;
			for(Producto prod : carrito){
				precioTotal+=prod.getPrecio();
			}
			request.setAttribute("precioTotal",precioTotal);
			vista="/mostrarCarrito.jsp";
		}
		
		if(opcion!=null && opcion.equals("4")){
			String nombre=request.getParameter("nombre");
			Cookie c=new Cookie("nombreusuario",nombre);
			response.addCookie(c);
			vista="/recibido.jsp";
		}
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
