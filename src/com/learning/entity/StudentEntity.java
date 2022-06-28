package com.learning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private int id; ////

	@Column(name = "name")
	private String name; // -----> NAME

	@Column(name = "branch")
	private String branch; // ----> BRANCH

	@Column(name = "yop")
	private int yop; // -----> YOP

	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth; // ---> ("DATE_OF_BIRTH")

	// private int student_detail_id;

	///// "id" column of StudentDetails by default why ? because id is annotated
	///// with @Id in that class
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_detail_id")
	private StudentDetails studentDetails;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Project> projects;

	public StudentEntity() {
	}

	public StudentEntity(String name, String branch, int yop, String dateOfBirth) {
		this.name = name;
		this.branch = branch;
		this.yop = yop;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", branch=" + branch + ", yop=" + yop + ", dateOfBirth="
				+ dateOfBirth + ", studentDetails=" + studentDetails.toString() + 
				"\nProjects" + projects + 
				"\n]";
	}
	
	
}
