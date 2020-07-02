package coop.tecso.examen.service;

import java.util.Optional;

import coop.tecso.examen.model.HolderType;

public interface HolderTypeService {

	void save(HolderType holderType);

	Optional <HolderType> findById(long id);

	public Iterable<HolderType> findAll();

	public Optional<HolderType> findById(Long id);

	public void deleteById(Long id);

}
