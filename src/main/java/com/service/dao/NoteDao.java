package com.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;

import com.service.entities.Etudiant;
import com.service.entities.Note;
import com.service.metier.INote;


public class NoteDao implements INote {

	@Override
	public Collection<String> findAll(int idEtudiant) {
		Collection<String> notes = new ArrayList<String>();
		try {
			MatiereDao matiereDao = new MatiereDao();
			EtudiantDao etudiantDao =new EtudiantDao();
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM note WHERE idetudiant = ?");
			stmt.setInt(1, idEtudiant);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				int idEt = result.getInt("idEtudiant");
				int idMat = result.getInt("idMatiere");
				double not = result.getDouble("note");
				
				String note = matiereDao.findOne(idMat).getMatiere() + "\t\t" + not;
				notes.add(note);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		
		return notes;
	}



	@Override
	public void add(Note note) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO note VALUES (DEFAULT, ?, ?, ?)");
			stmt.setInt(1, note.getIdEtudiant());
			stmt.setInt(2, note.getIdMatiere());
			stmt.setDouble(3, note.getNote());

			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void update(Note note) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE note SET idEtudiant = ?, idMatiere = ?, note = ? WHERE id = ?");
			stmt.setInt(1, note.getIdEtudiant());
			stmt.setInt(2, note.getIdMatiere());
			stmt.setDouble(3, note.getNote());
			stmt.setInt(4, note.getId());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM note WHERE id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}



	
	@Override
	public boolean verificationNote(String cin , String num) {
		boolean admis=true;
		try {
			Connection conn = Singleton.getInstance().getConnection();
			EtudiantDao etudiantDao = new EtudiantDao();
			Etudiant etudiant = etudiantDao.findOne(cin, num);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM note WHERE idEtudiant = ?");
			stmt.setInt(1, etudiant.getId());
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				if (result.getDouble("note")<12) {
					admis=false;
				}
				
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return admis;
	}
}
