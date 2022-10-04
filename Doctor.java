package com.hospital.db.model;

public class Doctor {

	   String dname, specialist, appoint, dquali;
	   int did,droom;
	    
	   
	   public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}


	public String getAppoint() {
		return appoint;
	}


	public void setAppoint(String appoint) {
		this.appoint = appoint;
	}


	public String getDquali() {
		return dquali;
	}


	public void setDquali(String dquali) {
		this.dquali = dquali;
	}


	public int getDroom() {
		return droom;
	}


	public void setDroom(int droom) {
		this.droom = droom;
	}


	
	
	@Override
	public String toString() {
		String result = "\n_______________________________________________"+
				        "\n|Doctor Id:            |"+ this.getDid()+
				        "\n_______________________________________________"+
			        	"\n|Doctor Name:          |"+ this.getDname()+
			        	"\n_______________________________________________"+
			        	"\n|Specialist:           |"+ this.getSpecialist()+
			        	"\n_______________________________________________"+
			        	"\n|Appoint:              |"+ this.getAppoint()+
			        	"\n_______________________________________________"+
			        	"\n|Doctor Qualiication:  | "+ this.getDquali()+
			        	"\n_______________________________________________"+
			        	"\n|Doctor Room No:       |"+ this.getDroom()+
			        	"\n_______________________________________________";
		return result;
	}

	
	
}
