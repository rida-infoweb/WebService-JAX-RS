package com.service.metier;

import java.util.Collection;

import com.service.entities.Note;


public interface INote {
	public Collection<String> findAll(int idEtudiant);
	public void add(Note note);
	public void update(Note note);
	public void delete(int id);
	public boolean verificationNote (String cin , String num);
}
