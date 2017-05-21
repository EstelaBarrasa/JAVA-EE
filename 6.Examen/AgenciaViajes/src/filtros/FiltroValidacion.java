package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroValidacion
 */
@WebFilter("/Buscar")
public class FiltroValidacion implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroValidacion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext contexto=request.getServletContext();
		String palabra=request.getParameter("palabra");
		if(palabra==null || palabra.trim().equals("")){
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/errordatos.jsp");
			dispatcher.forward(request,response);
		}
		else{
			palabra=palabra.trim();
			request.setAttribute("palabra",palabra);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
