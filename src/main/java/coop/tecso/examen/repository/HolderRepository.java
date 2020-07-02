package coop.tecso.examen.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import coop.tecso.examen.model.Holder;

public interface HolderRepository extends CrudRepository<Holder, Long>{
	
	Optional<Holder> findByRut(String rut);

}
