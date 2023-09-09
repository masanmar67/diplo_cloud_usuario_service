package unam.diplomado.pixup.usuarioservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuarioservice.domain.Municipio;

public interface MunicipioRepository 
	extends MongoRepository<Municipio, String>{
	
}
