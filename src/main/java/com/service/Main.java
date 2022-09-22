package com.service;

import java.util.Collection;

import com.service.dao.EtudiantDao;
import com.service.dao.MatiereDao;
import com.service.dao.NoteDao;
import com.service.entities.Etudiant;
import com.service.entities.Matiere;
import com.service.entities.Note;

public class Main {

	public static void main(String[] args) {
		MatiereDao matieredao =  new MatiereDao();
//		Matiere math = new Matiere("Mathématiques");
//		Matiere pc = new Matiere("Physique");
//		Matiere ar = new Matiere("Arabe");
//		Matiere ang = new Matiere("Anglais");
//		matieredao.add(math);
//		matieredao.add(pc);
//		matieredao.add(ar);
//		matieredao.add(ang);
		Collection<Matiere> matieres = matieredao.findAll();
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
System.out.println("----------------------------------------------");
		EtudiantDao etudiantDao = new EtudiantDao();
//		Etudiant etudiant1 = new Etudiant("121314","CD128094");
//		Etudiant etudiant2 = new Etudiant("151617","CD128095");	
//		etudiantDao.add(etudiant1);
//		etudiantDao.add(etudiant2);
		Collection<Etudiant> etudiants = etudiantDao.findAll();
		for (Etudiant etudiant : etudiants) {
			System.out.println(etudiant);
		}
System.out.println("----------------------------------------------");
		
		NoteDao noteDao = new NoteDao();
//		Note note_etu1_math = new Note(2,3,13);
//		Note note_etu1_pc = new Note(2,4,13);
//		Note note_etu1_ar = new Note(2,5,13.5);
//		Note note_etu1_ang = new Note(2,6,14.5);
//		
//		Note note_etu2_math = new Note(3,3,12);
//		Note note_etu2_pc = new Note(3,4,13);
//		Note note_etu2_ar = new Note(3,5,13);
//		Note note_etu2_ang = new Note(3,6,11.5);		
//		
//		noteDao.add(note_etu1_math);
//		noteDao.add(note_etu1_pc);
//		noteDao.add(note_etu1_ar);
//		noteDao.add(note_etu1_ang);
//
//		noteDao.add(note_etu2_math);
//		noteDao.add(note_etu2_pc);
//		noteDao.add(note_etu2_ar);
//		noteDao.add(note_etu2_ang);
		String entete= "Matière\t\tNote"+"\n"+"-----------------------------------------";
		System.out.println(entete);
		Collection<String> notes = noteDao.findAll(3);
		for (String note : notes) {
			System.out.println(note);
		}
		
		System.out.println(noteDao.verificationNote("CD128094","121314"));
		
	}

}
