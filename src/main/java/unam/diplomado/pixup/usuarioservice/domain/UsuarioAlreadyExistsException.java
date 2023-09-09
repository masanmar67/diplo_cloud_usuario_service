package unam.diplomado.pixup.usuarioservice.domain;

public class UsuarioAlreadyExistsException extends RuntimeException{
	
	public UsuarioAlreadyExistsException(String email) {
		super("Ya existe un usuario registrado con el email " + email);
	}

}
