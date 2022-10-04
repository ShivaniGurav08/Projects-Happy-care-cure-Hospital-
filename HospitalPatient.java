package com.hospital.db.model;

public class HospitalPatient {
	
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientContact;
	private String patientCity;
	
	
	public int getPatientAge() {
		return patientAge;
	}


	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	
	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientContact() {
		return patientContact;
	}


	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}


	public String getPatientCity() {
		return patientCity;
	}


	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}


	
	@Override
	public String toString() {
		
		String result = "\n___________________________________________________"+
		
				        "\n| Patient Id:      |" + this.getPatientId()+
				        "\n___________________________________________________"+
				        
				        "\n| Patient Name:    |"+ this.getPatientName()+
				        "\n____________________________________________________"+
				        
				        "\n| Patient Age:     |" + this.getPatientAge()+
				        "\n____________________________________________________"+
				        
				        "\n| Patient Contact: | " + this.getPatientContact()+
				        "\n____________________________________________________"+
				        
				        "\n| Patient City:    |" + this.getPatientCity()+
				        
				        "\n____________________________________________________";
		return result;
		
	}





	
}
