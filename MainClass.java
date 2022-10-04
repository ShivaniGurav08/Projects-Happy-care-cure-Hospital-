package com.hospital.db.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.hospital.db.dao.DoctorDao;
import com.hospital.db.dao.HospitalPatientDao;
import com.hospital.db.model.Doctor;
import com.hospital.db.model.HospitalPatient;

public class MainClass {

	public static void main(String[] args) {
		
		 String months[] = {
		            "Jan",
		            "Feb",
		            "Mar",
		            "Apr",
		            "May",
		            "Jun",
		            "Jul",
		            "Aug",
		            "Sep",
		            "Oct",
		            "Nov",
		            "Dec"
		        };
		
		Calendar calendar = Calendar.getInstance();
        
        int count1 = 4, count2 = 4, count3 = 4, count4 = 4, count5 = 4, count6 = 4;
	    
		System.out.println("____________________________________________________________________________________");
        System.out.println("\n                        Happy Care & Cure Hospital  ");
 
		System.out.println("____________________________________________________________________________________");
		
		System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " 
		      + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
		
		System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) +
				 ":" + calendar.get(Calendar.MINUTE) + ":" +
				      calendar.get(Calendar.SECOND));
				
	//	doctor[] d = new doctor[25];
		
		Scanner input = new Scanner(System.in);
		int choices, j, c1, status = 1, t1 = 1, t2 = 1, t3 = 1, t4 = 1, t5 = 1, t6 = 1;
        while (status == 1)
        {
            System.out.println("\n                                    MAIN MENU");
    		System.out.println("____________________________________________________________________________________");
            System.out.println("1.Doctors  \n2.Patients ");
    		System.out.println("____________________________________________________________________________________");
            choices = input.nextInt();
            switch (choices)
            {
                case 1:
                    {
                		//System.out.println("____________________________________________________________________________________");
                        System.out.println("                                  DOCTOR SECTION");
                		System.out.println("____________________________________________________________________________________");
                        try {
                    		Scanner s2 = new Scanner(System.in);	
                    		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
                    		//int num= Integer.parseInt(s.readLine());
                    		//String str = s.readLine();
                    		DoctorDao dDao = new DoctorDao();
                    		int choice;
                    		while(true) {			
                    			System.out.println("____________________________________________________________________________________");
                    			System.out.println("\n1. Insert New Record");
                    			System.out.println("2. Update Record");
                    			System.out.println("3. Delete Record");
                    			System.out.println("4. Search By ID");
                    			System.out.println("5. Display all Records");
                    			System.out.println("6. Exit");
                    			System.out.println("____________________________________________________________________________________");
                    			
                    			 String dname, specialist, appoint, dquali;
                             	 int did,droom;
                    		     
                    			choice = s2.nextInt();
                    			if(choice == 6)
                    				break;
                    			else
                    				switch (choice) {				
                    				case 1 :System.out.print("Enter ID:                  ");
                    				        did = s2.nextInt();
                    						System.out.print("Enter Name:                  ");
                    						dname = b.readLine();
                    						System.out.println("Enter Speciality:           ");
                    						specialist = b.readLine();
                    						System.out.println("Enter appoint details:    ");
                    						appoint = b.readLine();
                    						System.out.println("Enter Qualification:      ");
                    						dquali = b.readLine();
                    						System.out.print("Enter Room No.:             ");
                    				        droom = s2.nextInt();
                    				        
                    						
                    						boolean result = dDao.insertRecord(did,dname,specialist, appoint, dquali,droom);
                    						if(result)
                    							System.out.println("Inserted Successfully"+
                    									"\n_______________________________________________");
                    						else
                    							System.out.println("Not Inserted"+
                    						"\n_______________________________________________");
                    				     	break;
                    					
                    				case 2 : System.out.print("Enter the ID of the Doctor:");
                    				 		 did= s2.nextInt();
                    				 		 Doctor  hd = dDao.searchById(did);
                    				 		 System.out.println("What do you want to update?    |");
                    				 		 System.out.println("|1. Name                       |");
                    				 		 System.out.println("|2. Speciality                 |");
                    				 		 System.out.println("|3. Appoint details            |");
                    				 		 System.out.println("|4. Qualification              |");
                    				 		 System.out.println("|5. Room No.                   |"+
                    				 		 "\n_______________________________________________");
                    				 		 
                    				 		 int update =s2.nextInt();
                    				 		 switch (update) {
                    				 		 	case 1: System.out.println("|Enter New Name:          ");
                    				 		 	        dname = b.readLine();
                    				 		 	        hd.setDname(dname);				 		 	
                    				 		 		    break;
                    				 		 	case 2: System.out.println("|Enter Speciality:         ");
                        						        specialist = b.readLine();
                        						        hd.setSpecialist(specialist);				 		 		
                    				 		 		    break;
                    				 		 	case 3: System.out.println("|Enter appoint details:   ");
                        						        appoint = b.readLine();
                        						        hd.setAppoint(appoint);
                    				 		 		    break;
                    					 	    case 4: System.out.println("|Enter Qualification:     ");
                        						        dquali = b.readLine();
                        						        hd.setDquali(dquali);				 		 	
                    			 		 		         break;
                    					 	    case 5: System.out.print("|Enter Room No.:             ");
                       				                    droom = s2.nextInt();
                       				                    hd.setDroom(droom);				 		 	
           			 		 		                break;    
                    				 		 }
                    				 		 
                    				 		result = dDao.updateRecord(hd);
                    						if(result)
                    							System.out.println("Updated Successfully"+
                    						"\n_______________________________________________");
                    						else
                    							System.out.println("Not Updated"+
                    									"\n_______________________________________________");
                    					 break;
                    					 
                    				case 3 : System.out.print("Enter the ID of the Doctor:");
                    				         did = s2.nextInt();
                    				 		result = dDao.deleteRecord(did);
                    						if(result)
                    							System.out.println("Deleted Successfully"+
                    						     "\n_______________________________________________");
                    						else
                    							System.out.println("Not Deleted"+
                    									"\n_______________________________________________");
                    					break;
                    					
                    				case 4 : System.out.print("Enter the ID of the Doctor: ");
                    				         did = s2.nextInt();
                    				         hd = dDao.searchById(did);
                    						 if(hd.getDid() != 0)
                    							 System.out.println(hd );
                    					break;
                    				case 5 : List<Doctor> Doc = dDao.getAllRecords();
                    						 for(Doctor p : Doc) {
                    							 System.out.println(p);
                    						 }
                    					break;
                    				default: System.out.println("Invalid Choice"+
                    					"\n_______________________________________________");
                    			}
                    		}
                    		}
                    		catch (Exception e) {
                    	     e.printStackTrace();
                    		}
                        
                        
                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                            t1 = input.nextInt();
                        }
                        break;
                    
                case 2:
                	 System.out.println("_________________________________________________________________________________");
                     System.out.println("                        PATIENT SECTION ");
                     System.out.println("_________________________________________________________________________________");
                   
	
		
		
							try {
							Scanner s1 = new Scanner(System.in);	
							BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
							//int num= Integer.parseInt(s.readLine());
							//String str = s.readLine();
							HospitalPatientDao patientDao = new HospitalPatientDao();
							int choice;
							while(true) {			
								System.out.println("\n___________________________________________________");
								System.out.println("1. Insert New Record");
								System.out.println("2. Update Record");
								System.out.println("3. Delete Record");
								System.out.println("4. Search By ID");
								System.out.println("5. Display all Records");
								System.out.println("6. Exit");
								System.out.println("\n___________________________________________________");
								
								 int patientId;
							     String patientName;
								 int patientAge;
						         String patientContact;
								 String patientCity;
								
								choice = s1.nextInt();
								if(choice == 6)
									break;
								else
									switch (choice) {
									
									case 1 :System.out.println("\n___________________________________________________");
										    System.out.print("Enter ID: ");
									        patientId = s1.nextInt();
											System.out.print("Enter Name: ");
											patientName = s.readLine();
											System.out.println("Enter Age: ");
											patientAge = s1.nextInt();
											System.out.println("Enter Contact Number: ");
											patientContact = s.readLine();
											System.out.println("Enter City: ");
											patientCity = s.readLine();
											System.out.println("___________________________________________________");
											
											
											boolean result = patientDao.insertRecord(patientId,patientName,patientAge,patientContact,patientCity);
											if(result)
												System.out.println("Inserted Successfully"+
											       "\n___________________________________________________");
											
											else
												System.out.println("Not Inserted"+
											"\n___________________________________________________");
										break;
									case 2 : System.out.print("Enter the ID of the Patient:");
									 		 patientId= s1.nextInt();
									 		 HospitalPatient  hp = patientDao.searchById(patientId);
									 		System.out.println("\n___________________________________________________");
									 		 System.out.println("What do you want to update?");
									 		 System.out.println("|1. Name            |");
									 		 System.out.println("|2. Age             |");
									 		 System.out.println("|3. Contact Number  |");
									 		 System.out.println("|4. City            |");
									 		 int update =s1.nextInt();
									 		 switch (update) {
									 		 	case 1: System.out.println("Enter New Name:");
									 		 	System.out.println("\n___________________________________________________");
									 		 	        patientName = s.readLine();
									 		 			hp.setPatientName(patientName);				 		 	
									 		 		break;
									 		 	case 2: System.out.println("Enter New Age:");
									 		 	System.out.println("\n___________________________________________________");
									 		 	        patientAge = s1.nextInt();
							 		 					hp.setPatientAge(patientAge);				 		 		
									 		 		break;
									 		 	case 3: System.out.println("Enter New Contact Number:");
									 		 	System.out.println("\n___________________________________________________");
									 		 	        patientContact = s.readLine();
							 		 					hp.setPatientContact(patientContact);
									 		 		break;
										 	    case 4: System.out.println("Enter New City:");
										 	   System.out.println("\n___________________________________________________");
								 		 	           patientCity = s.readLine();
								 		 			   hp.setPatientCity(patientCity);				 		 	
								 		 		    break;
									 		 		 }
									 		 
									 		result = patientDao.updateRecord(hp);
											if(result)
												System.out.println("Updated Successfully"+
														"\n___________________________________________________");
											else
												System.out.println("Not Updated"+
											"\n___________________________________________________");
										 break;
										 
									case 3 : System.out.print("Enter the ID of the Patient:");
									         patientId = s1.nextInt();
									 		result = patientDao.deleteRecord(patientId);
											if(result)
												System.out.println("Deleted Successfully"
														+
														"\n___________________________________________________");
											else
												System.out.println("Not Deleted"+
														"\n___________________________________________________");
										break;
										
									case 4 : //System.out.println("\n___________________________________________________");
										    System.out.print("Enter the ID of the Patient: ");
									         patientId = s1.nextInt();
											 hp = patientDao.searchById(patientId);
											 if(hp.getPatientId() != 0)
												 System.out.println(hp);
											 System.out.println("\n___________________________________________________");
										break;
									case 5 : List<HospitalPatient> Hp1 = patientDao.getAllRecords();
											 for(HospitalPatient p : Hp1) {
												 System.out.println("\n "+p);
												 System.out.println("\n___________________________________________________");
												 
											 }
										break;
									default: System.out.println("Invalid Choice");
									          System.out.println("\n___________________________________________________");
								}
							}
							}
							catch (Exception e) {
						     e.printStackTrace();
							}
					       

            }}}}