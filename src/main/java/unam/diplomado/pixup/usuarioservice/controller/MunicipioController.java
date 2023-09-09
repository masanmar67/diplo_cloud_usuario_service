package unam.diplomado.pixup.usuarioservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.Municipio;
import unam.diplomado.pixup.usuarioservice.repository.MunicipioRepository;

@RestController
@RequestMapping(path = "municipios", produces = "application/json")
@CrossOrigin(origins = "*")
public class MunicipioController {

	private MunicipioRepository municipioRepository;
	public List<Municipio> getAll(){
		return municipioRepository.findAll();
	}
}
