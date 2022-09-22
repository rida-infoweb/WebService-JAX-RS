package com.service.entities;

public class Etudiant {
	private int id;
	private String num;
	private String cin;
	public Etudiant(int id, String num, String cin) {
		super();
		this.id = id;
		this.num = num;
		this.cin = cin;
	}
	public Etudiant(String num, String cin) {
		super();
		this.num = num;
		this.cin = cin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", num=" + num + ", cin=" + cin + "]";
	}
	


	
	
}	
