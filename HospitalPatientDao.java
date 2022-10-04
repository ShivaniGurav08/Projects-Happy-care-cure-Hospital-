package com.hospital.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.model.HospitalPatient;
import com.hospital.db.util.DatabaseConnect;


public class HospitalPatientDao {
	//Connect the database
		Connection con = DatabaseConnect.connect();
		
		public List<HospitalPatient> getAllRecords(){
			List<HospitalPatient> Hp1 = new ArrayList<>();
			try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from HospitalPatient");
			while(rs.next()) {
				HospitalPatient s = new HospitalPatient();
				s.setPatientId(rs.getInt("patientId"));
				s.setPatientName(rs.getString("patientName"));
				s.setPatientAge(rs.getInt("patientAge"));
				s.setPatientContact(rs.getString("patientContact"));
				s.setPatientCity(rs.getString("patientCity"));
				Hp1.add(s);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return Hp1;
		}
		public HospitalPatient searchById(int patientId) {
			HospitalPatient s = null;
			try {
				PreparedStatement ps = 
					con.prepareStatement
					("select * from HospitalPatient where patientId = ?");
				ps.setInt(1, patientId);
				ResultSet rs = ps.executeQuery();
				s = new HospitalPatient();
				rs.next();
				s.setPatientId(rs.getInt("patientId"));
				s.setPatientName(rs.getString("patientName"));
				s.setPatientAge(rs.getInt("patientAge"));
				s.setPatientContact(rs.getString("patientContact"));
				s.setPatientCity(rs.getString("patientCity"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return s;
		}
		
		public boolean insertRecord(int patientId,String patientName,int patientAge,String patientContact,String patientCity)
		{
			String sql = "insert into HospitalPatient values(?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, patientId);
				ps.setString(2, patientName);
				ps.setInt(3, patientAge);
				ps.setString(4, patientContact);
				ps.setString(5, patientCity);
				int i = ps.executeUpdate();
				if (i>0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public boolean deleteRecord(int patientId) {
			String sql = "delete from HospitalPatient where patientId=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, patientId);
				int i = ps.executeUpdate();
				if (i>0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public boolean updateRecord(HospitalPatient hp) {
			String sql = "update HospitalPatient set patientName=?, patientAge=?, patientContact=?,patientCity=? where patientId=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, hp.getPatientName());
				ps.setInt(2, hp.getPatientAge());
				ps.setString(3, hp.getPatientContact());
				ps.setString(4, hp.getPatientCity());
				ps.setInt(5, hp.getPatientId());
				int i = ps.executeUpdate();
				if(i>0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			return false;
		}

}
