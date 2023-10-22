package com.files.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "File")
public class UserFile {
	   @Id
	    private String id;
	    private String Firstname;
	    private String Lastname;
	    private String DOB;
	    private String City;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstname() {
			return Firstname;
		}
		public void setFirstname(String firstname) {
			Firstname = firstname;
		}
		public String getLastname() {
			return Lastname;
		}
		public void setLastname(String lastname) {
			Lastname = lastname;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public UserFile(String id, String firstname, String lastname, String dOB, String city) {
			super();
			this.id = id;
			Firstname = firstname;
			Lastname = lastname;
			DOB = dOB;
			City = city;
		}
		public UserFile() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "UserFile [id=" + id + ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", DOB=" + DOB
					+ ", City=" + City + "]";
		}
	    
}
