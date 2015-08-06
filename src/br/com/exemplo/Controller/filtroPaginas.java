package br.com.exemplo.Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")//Especifica todas as paginas e não apenas uma
public class filtroPaginas implements Filter {

    
    public filtroPaginas() {
        
    }
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpSession sessao = request.getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest .getRequestURI();
		
		HttpSession sessao = httpServletRequest .getSession();
		
		if(sessao.getAttribute("usuAutenticado")!=null || url.lastIndexOf("login.jsp")>-1 ||
		url.lastIndexOf("autenticador")>-1){
		chain.doFilter(request, response);//o modo que ele permite entrar no sistema
		}else{//Se o login estiver errado volta para a página de login
		((HttpServletResponse) response).sendRedirect("login.jsp");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
