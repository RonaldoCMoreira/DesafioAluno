package br.atos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dataBase.UserDao;
import br.atos.model.UserEntity;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao userDao = new UserDao();
		UserEntity user = new UserEntity();

		user.setNome(request.getParameter("nome"));
		user.setSenha(request.getParameter("senha"));
		user.setEmail(request.getParameter("email"));
		user.setTelefone(request.getParameter("telefone"));

		RequestDispatcher dispatcher = null;

		PrintWriter saida = response.getWriter();

		dispatcher = request.getRequestDispatcher("registration.jsp");// Direcionando para a JSP registration.jsp

		if (userDao.insertUser(user)) {
			// saida.print("Registrado com Sucesso");
			request.setAttribute("statusDispacher", "sucesso");// Criação da variavel

		} else {
			request.setAttribute("statusDispacher", "falha");

		}

		dispatcher.forward(request, response);

	}

}
