package com.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;

import com.service.entities.Etudiant;
import com.service.metier.IEtudiant;


public class EtudiantDao implements IEtudiant {

	@Override
	public Etudiant findOne(String cin, String num ) {
		Etudiant etudiant = null;
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM etudiant WHERE cin = ? AND num = ?");
			stmt.setString(1, cin);
			stmt.setString(2, num);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				int id = result.getInt("id");
				etudiant = new Etudiant(id, num, cin);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return etudiant;
	}

	@Override
	public Collection<Etudiant> findAll() {
		Collection<Etudiant> etudiants = new ArrayList<Etudiant>();
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM etudiant");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String num = result.getString("num");
				String cin = result.getString("cin");
				Etudiant etudiant = new Etudiant(id, num, cin);
				etudiants.add(etudiant);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return etudiants;
	}

	@Override
	public void add(Etudiant etudiant) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO etudiant VALUES (DEFAULT, ?, ?)");
			stmt.setString(1, etudiant.getNum());
			stmt.setString(2, etudiant.getCin());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void update(Etudiant etudiant) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE etudiant SET num = ?, cin = ? WHERE id = ?");
			stmt.setString(1, etudiant.getNum());
			stmt.setString(2, etudiant.getCin());
			stmt.setInt(3, etudiant.getId());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM etudiant WHERE id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}
}
