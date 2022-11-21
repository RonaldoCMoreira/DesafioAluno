package br.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInicio
 */
@WebServlet("/ServletInicio")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletInicio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter saida = response.getWriter();
		saida.println("<!DOCTYPE html>");
		saida.println("<html>");
		saida.println("<head>");
		saida.println("<meta charset=\"ISO-8859-1\">");
		saida.println("<title>Dados do Professor</title>");
		saida.println("<body>");
		saida.println("<h2>Dados do aluno</h2>");
		saida.println("<h1>Nome: </h1>");
		saida.println("<p1>Ronaldo</p1>");
		saida.println("<h1>Idade: </h1>");
		saida.println("<p>45</p>");
		saida.println("<h1>Email: </h1>");
		saida.println("<p>ronaldo.crispim@atos.net</p>");
		saida.println("<h2>Como me vejo daqui 5 anos dentro do universo java: </h2>");
		saida.println("<p>somando conhecimento</p>");
		saida.println("</body>");
		saida.println("</head>");
		saida.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
