package com.hospital.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.model.Doctor;
import com.hospital.db.util.DatabaseConnect;

public class DoctorDao {
	
	//Connect the database
			Connection con = DatabaseConnect.connect();
			
			public List<Doctor> getAllRecords(){
				List<Doctor> Doc = new ArrayList<>();
				try {
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from Doctor");
				while(rs.next()) {
					Doctor s = new Doctor();
					s.setDid(rs.getInt("did"));
					s.setDname(rs.getString("dname"));
					s.setSpecialist(rs.getString("specialist"));
					s.setAppoint(rs.getString("appoint"));
					s.setDquali(rs.getString("dquali"));
					s.setDroom(rs.getInt("droom"));
					Doc.add(s);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return Doc;
			}
			public Doctor searchById(int did) {
				Doctor s = null;
				try {
					PreparedStatement ps = 
						con.prepareStatement
						("select * from Doctor where did = ?");
					ps.setInt(1, did);
					ResultSet rs = ps.executeQuery();
					s = new Doctor();
					rs.next();
					s.setDid(rs.getInt("did"));
					s.setDname(rs.getString("dname"));
					s.setSpecialist(rs.getString("specialist"));
					s.setAppoint(rs.getString("appoint"));
					s.setDquali(rs.getString("dquali"));
					s.setDroom(rs.getInt("droom"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}		
				return s;
			}
			
			public boolean insertRecord(int did,String dname,String specialist,String appoint,String dquali,int droom)
			{
				String sql = "insert into Doctor values(?,?,?,?,?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, did);
					ps.setString(2, dname);
					ps.setString(3, specialist);
					ps.setString(4, appoint);
					ps.setString(5, dquali);
					ps.setInt(6, droom);
					int i = ps.executeUpdate();
					if (i>0)
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}

			public boolean deleteRecord(int did) {
				String sql = "delete from Doctor where did=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, did);
					int i = ps.executeUpdate();
					if (i>0)
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}

			public boolean updateRecord(Doctor hd) {
				String sql = "update Doctor set dname=?, specialist=?, appoint=?,dquali=?,droom=? where did=?";
				try {
					PreparedStatement ps1 = con.prepareStatement(sql);
					ps1.setInt(6, hd.getDid());
					ps1.setString(1, hd.getDname());
					ps1.setString(2, hd.getSpecialist());
					ps1.setString(3, hd.getAppoint());
					ps1.setString(4, hd.getDquali());
					ps1.setInt(5, hd.getDroom());
					
					int i = ps1.executeUpdate();
					System.out.println(i);
					if(i>0)
						return true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
						
				return false;
			}

	

	
	}


