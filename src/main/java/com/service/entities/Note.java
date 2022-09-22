package com.service.entities;

public class Note {
	private int id;
	private int idEtudiant;
	private int idMatiere;
	private double note;
	public Note(int idEtudiant, int idMatiere, double note) {
		super();
		this.idEtudiant = idEtudiant;
		this.idMatiere = idMatiere;
		this.note = note;
	}
	public Note(int id, int idEtudiant, int idMatiere, double note) {
		super();
		this.id = id;
		this.idEtudiant = idEtudiant;
		this.idMatiere = idMatiere;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", idEtudiant=" + idEtudiant + ", idMatiere=" + idMatiere + ", note=" + note + "]";
	}
	
	

}
