package it.prova.gestionebigliettiweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareDeleteBigliettoServlet
 */
@WebServlet("/PrepareDeleteBigliettoServlet")
public class PrepareDeleteBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareDeleteBigliettoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDelBigliettoCheVoglioEliminare= request.getParameter("idDaInviareComeParametro");
		
		
		BigliettoService bigliettoServiceInstance = MyServiceFactory.getBigliettoServiceInstance();
		Biglietto result =null;
		try {
			 result = bigliettoServiceInstance.caricaSingoloElemento(Long.parseLong(parametroIdDelBigliettoCheVoglioEliminare));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("delete_biglietto_attr", result);
		
		request.getRequestDispatcher("/biglietto/provadelete.jsp").forward(request, response);
	}


}
