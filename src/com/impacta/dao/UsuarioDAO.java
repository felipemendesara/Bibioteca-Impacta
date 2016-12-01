package com.impacta.dao;
import com.impacta.model.Usuario;
import java.util.List;;
public interface UsuarioDAO {

	public void addUsuario(Usuario usuario);
	public void deletarUsuario(int idUsuario);
	public void alterarUsuario(Usuario usuario);
	public List<Usuario> todosUsuarios();
	public Usuario usuarioPorId(int idUsuario);
}
// Interface que vai ser implementada por esta classe