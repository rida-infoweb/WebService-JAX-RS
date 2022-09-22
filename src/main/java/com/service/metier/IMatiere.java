package com.service.metier;

import java.util.Collection;

import com.service.entities.Etudiant;
import com.service.entities.Matiere;


public interface IMatiere {
	public Matiere findOne(int id );
	public Collection<Matiere> findAll();
	public void add(Matiere matiere);
	public void update(Matiere matiere);
	public void delete(int id);
}
