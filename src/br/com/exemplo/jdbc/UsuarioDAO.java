package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.beans.Usuario;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnection();
	//Metodo que insere dados no BD
	public void cadastro(Usuario usuario){
		
		String sql = "INSERT INTO USUARIO(nome,email,senha,datainscricao)values(?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setDate(4, usuario.getDatainscricao());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Erro -"+e.getMessage());
		}
	}
	//Meotodo que altera dados na tabela do BD
	public void Alterar(Usuario usuario){
			
			String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, DATAINSCRICAO = ? WHERE id = ?";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setString(1, usuario.getNome());
				preparador.setString(2, usuario.getEmail());
				preparador.setString(3, usuario.getSenha());
				preparador.setDate(4, usuario.getDatainscricao());
				preparador.setInt(5, usuario.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Alterado com sucesso!!");
			} catch (SQLException e) {
				System.out.println("Erro -"+e.getMessage());
			}
		}
	
	//Meotodo que excluir dados na tabela do BD
		public void Deletar(Usuario usuario){
				
				String sql = "DELETE FROM USUARIO WHERE id = ?";
				
				try {
					PreparedStatement preparador = con.prepareStatement(sql);					
					preparador.setInt(1, usuario.getId());
					
					preparador.execute();
					preparador.close();
					
					System.out.println("Deletado com sucesso!!");
				} catch (SQLException e) {
					System.out.println("Erro -"+e.getMessage());
				}
			}
		//Metodo que faz o select no BD
		public  List<Usuario> buscarTodos(Usuario usuario){
			String sql = "SELECT * FROM USUARIO";
			List<Usuario> lista = new ArrayList<Usuario>();
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while(resultados.next()){
					Usuario usu = new Usuario();
					usu.setId(resultados.getInt("id"));
					usu.setNome(resultados.getString("nome"));
					usu.setEmail(resultados.getString("email"));
					usu.setSenha(resultados.getString("senha"));
					usu.setDatainscricao(resultados.getDate("datainscricao"));
					lista.add(usu);
				}
				
			} catch (SQLException e) {
				System.out.println("Erro - "+e.getMessage());
			}return lista;
			
		}
		
		//Metodo que faz o select no BD por id
				public  Usuario buscarporID(Integer id){//objeto de retorno do método
					Usuario usuRetorno= null;
					String sql = "SELECT * FROM USUARIO WHERE id=?";					
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						preparador.setInt(1, id);
						//Retorna a consulta em resultset
						ResultSet resultado = preparador.executeQuery();
						//Se tem registro
						if(resultado.next()){
							//instancia o objeto usuario
							usuRetorno = new Usuario();
							usuRetorno.setId(resultado.getInt("id"));
							usuRetorno.setNome(resultado.getString("nome"));
							usuRetorno.setEmail(resultado.getString("email"));
							usuRetorno.setSenha(resultado.getString("senha"));	
							usuRetorno.setDatainscricao(resultado.getDate("datainscricao"));
						}
						System.out.println("Encontrado com Sucesso!");
					} catch (SQLException e) {
						System.out.println("Erro de SQL:" +e.getMessage());
					}return usuRetorno;
					
				}
				
				//Metodo que faz o select no BD por id
				public  Usuario autenticacao(Usuario usuario){//objeto de retorno do método
					Usuario usuRetorno= null;
					String sql = "SELECT * FROM USUARIO WHERE email = ? and senha = ?";					
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						preparador.setString(1, usuario.getEmail());
						preparador.setString(2, usuario.getSenha());
						//Retorna a consulta em resultset
						ResultSet resultado = preparador.executeQuery();
						//Se tem registro
						if(resultado.next()){
							//instancia o objeto usuario
							usuRetorno = new Usuario();
							usuRetorno.setId(resultado.getInt("id"));
							usuRetorno.setNome(resultado.getString("nome"));
							usuRetorno.setEmail(resultado.getString("email"));
							usuRetorno.setSenha(resultado.getString("senha"));	
							usuRetorno.setDatainscricao(resultado.getDate("datainscricao"));
						}
						System.out.println("Encontrado com Sucesso!");
					} catch (SQLException e) {
						System.out.println("Erro de SQL:" +e.getMessage());
					}return usuRetorno;
					
				}
		
		}


