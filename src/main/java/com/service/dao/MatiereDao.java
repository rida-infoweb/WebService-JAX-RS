package com.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;

import com.service.entities.Etudiant;
import com.service.entities.Matiere;
import com.service.metier.IEtudiant;
import com.service.metier.IMatiere;


public class MatiereDao implements IMatiere {

	@Override
	public Matiere findOne(int id ) {
		Matiere matiere = null;
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM matiere WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				int idt = result.getInt("id");
				String mat = result.getString("matiere");
				matiere = new Matiere(idt, mat);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return matiere;
	}
	
	@Override
	public Collection<Matiere> findAll() {
		Collection<Matiere> matieres = new ArrayList<Matiere>();
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM matiere");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String matiere = result.getString("matiere");
				Matiere etudiant = new Matiere(id, matiere);
				matieres.add(etudiant);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return matieres;
	}

	@Override
	public void add(Matiere matiere) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO matiere VALUES (DEFAULT, ?)");
			stmt.setString(1, matiere.getMatiere());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void update(Matiere matiere) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE matiere SET matiere = ? WHERE id = ?");
			stmt.setString(1, matiere.getMatiere());
			stmt.setInt(2, matiere.getId());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM matiere WHERE id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}
}
