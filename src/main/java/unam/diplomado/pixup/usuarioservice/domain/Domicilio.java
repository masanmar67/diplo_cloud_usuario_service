package unam.diplomado.pixup.usuarioservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Domicilio {
	
	@NotBlank(message = "Calle no puede ser balnco")
	@Size(min = 3, max = 30, message = "")
	private String calle;
	@NotBlank(message = "Número exterior no puede ser balnco")
	@Size(min = 1, max = 30, message = "Número exterior debe contener entre {min} y {max}")
	private String numExterior;
	private String numInterior;

}
