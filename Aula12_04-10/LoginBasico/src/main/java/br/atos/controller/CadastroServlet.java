package br.atos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dataBase.LoginDao;
import br.atos.model.LoginEntidade;
import br.atos.validacao.ValidarLogin;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msgErro = null;
		LoginDao loginDao = new LoginDao();
		ValidarLogin validarLogin = new ValidarLogin();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		msgErro = validarLogin.validarSenha(password, passwordConfirm);

		if (msgErro == null) {

			msgErro = validarLogin.validarUserName(username, loginDao);
			
			if (msgErro == null) {
				LoginEntidade loginEntidade = new LoginEntidade();
				loginEntidade.setUsername(username);
				loginEntidade.setPassword(password);
	
				if (loginDao.inserirUserName(loginEntidade)) {
					response.sendRedirect("cadastroSucesso.jsp");
				} else {
					response.sendRedirect("cadastroErro.jsp");
				}
			} else {
				response.sendRedirect("usuarioInvalido.jsp");
			}
		} else {
			response.sendRedirect("senhaInvalida.jsp");
		} 
	}

}
