package br.com.exemplo.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

/**
 * Servlet implementation class autenticador
 */
@WebServlet("/autenticador")
public class autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao =  request.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}		
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");	
		
		Usuario usu = new Usuario();
		usu.setEmail(semail);
		usu.setSenha(ssenha);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuAutenticado = usuDao.autenticacao(usu);
		
		if(usuAutenticado != null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuAutenticado", usuAutenticado);
			//sessao.setMaxInactiveInterval(8000);//Determina o tempo que a sessão expira
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else{
			response.sendRedirect("erroLogin.jsp");
		}
	}

}
