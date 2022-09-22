package com.service.entities;

public class Matiere {
	private int id;
	private String matiere;
	public Matiere(int id, String matiere) {
		super();
		this.id = id;
		this.matiere = matiere;
	}
	public Matiere(String matiere) {
		super();
		this.matiere = matiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", matiere=" + matiere + "]";
	}
	
}
