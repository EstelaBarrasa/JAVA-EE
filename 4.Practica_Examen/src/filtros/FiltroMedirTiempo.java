package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroMedirTiempo
 */
@WebFilter(description = "Mide el tiempo de respuesta de las paginas", urlPatterns = { "/*" })
public class FiltroMedirTiempo implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroMedirTiempo() {
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
		long t0=System.currentTimeMillis();
		chain.doFilter(request, response);
		long t1=System.currentTimeMillis();
		System.out.println("Tiempo de respuesta: "+(t1-t0));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
