package br.com.exemplo.testes;

import java.util.List;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

public class TesteDAO {

	public static void main(String[] args) {	
//		testCadastro();
//		testAlterar();
//		testDeletar();
		testbuscarTodos();
	}
	
	public static void testCadastro(){
		Usuario usu = new Usuario();
		usu.setNome("Joana");
		usu.setEmail("joana@gmail.com");
		usu.setSenha("5123");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastro(usu);
		
	}

	public static void testAlterar(){
		Usuario usu = new Usuario();
		usu.setNome("Rodolfo Rollin");
		usu.setEmail("Rodolfo.r@gmail.com");
		usu.setSenha("4123");
		usu.setId(2);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Alterar(usu);
		
	}
	
	public static void testDeletar(){
		Usuario usu = new Usuario();		
		usu.setId(2);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Deletar(usu);
		
	}
	
	public static void testbuscarTodos(){
		Usuario usu = new Usuario();
		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaResultado = usuDao.buscarTodos(usu);
		
		for(Usuario u:listaResultado){
			System.out.println("Id: "+u.getId()+" nome: "+u.getNome()+" email: "+u.getEmail()+" senha: "+u.getSenha());
		}
		
	}
	
}
