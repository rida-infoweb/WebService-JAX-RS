package com.service.metier;

import java.util.Collection;

import com.service.entities.Etudiant;


public interface IEtudiant {
	public Etudiant findOne(String cin, String num );
	public Collection<Etudiant> findAll();
	public void add(Etudiant etudiant);
	public void update(Etudiant etudiant);
	public void delete(int id);
}
