package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOViaje;
import modelos.Viaje;

/**
 * Servlet implementation class AnyadirFavorito
 */
@WebServlet("/AnadirFavorito")
public class AnadirFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>)sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos",favoritos);
		}
		
		String stDestino=request.getParameter("destino");
		Integer id=Integer.parseInt(stDestino);
		DAOViaje dao=new DAOViaje();
		Viaje Viaje=dao.getViaje(id);
		
		boolean existe=false;
		for(Viaje v : favoritos){
			if(v.equals(Viaje)){
				existe=true;
				break;
			}
		}
		if(!existe){
			favoritos.add(Viaje);
		}
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/anadirFavorito.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
