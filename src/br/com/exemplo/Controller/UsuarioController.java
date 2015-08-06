package br.com.exemplo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usu = new Usuario();
		String acao = request.getParameter("acao");
		UsuarioDAO usuDao = new UsuarioDAO();
		
		if (acao != null && acao.equals("list")) {
			List<Usuario> lista = usuDao.buscarTodos(usu);
			request.setAttribute("lista", lista);
			RequestDispatcher saida = request.getRequestDispatcher("listaUsuarios.jsp");
			saida.forward(request, response);

		} else if (acao != null && acao.equals("ex")) {
			String id = request.getParameter("id");
			usu.setId(Integer.parseInt(id));
			usuDao.Deletar(usu);
			response.sendRedirect("UsuarioController?acao=list");
			
		} else if (acao != null && acao.equals("alt")) {
			String id = request.getParameter("id");
			Usuario usuario = usuDao.buscarporID(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("AlterarCad.jsp").forward(request, response);
			
		}else if (acao != null && acao.equals("cad")) {
			RequestDispatcher saida = request.getRequestDispatcher("cadastro.jsp");
			saida.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//Capturando Parametros da tela
		String sid = request.getParameter("id");
		String snome = request.getParameter("nome");
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		String sdata = request.getParameter("data");
		
		try{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = new Date(format.parse(sdata).getTime());
		
		//criando objeto usuario e atribuindo valores a tela		
		Usuario usuario = new Usuario();
		usuario.setNome(snome);
		usuario.setEmail(semail);
		usuario.setSenha(ssenha);
		usuario.setDatainscricao(data);
		usuario.setId(Integer.parseInt(sid));
		
		//criando um usuario DAO
		UsuarioDAO usuDao = new UsuarioDAO();
		//Salvando  no banco de dados
		usuDao.Alterar(usuario);
		//PrintWriter out = response.getWriter();
		//out.println("Salvo!");
		response.sendRedirect("UsuarioController?acao=list");		
		} catch (ParseException e) {
			System.out.println("Erro de Data - "+e.getMessage());
		}
	}

}
