package unam.diplomado.pixup.usuarioservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.Estado;
import unam.diplomado.pixup.usuarioservice.repository.EstadoRepository;
import unam.diplomado.pixup.usuarioservice.service.EstadoService;

@RestController
@RequestMapping(path = "api/estados", produces = "application/json")
@CrossOrigin(origins = "*")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public Iterable<Estado> obtenerEstados(){
		return estadoRepository.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Estado crearEstado(@RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Estado> obtenerestadoPorId(@PathVariable("id") String id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return new ResponseEntity<Estado>(estado.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes = "application/json")
	public ResponseEntity<Estado> actualizarEstado(
			@PathVariable("id") String id, @RequestBody Estado estado){
				Estado estadoActualizado = estadoService.actualizarEstado(id, estado);
				if(estadoActualizado != null) {
					return new ResponseEntity<>(estadoActualizado, HttpStatus.OK);
				}
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarestado(@PathVariable("id") String id) {
		estadoRepository.deleteById(id);
	}
}
