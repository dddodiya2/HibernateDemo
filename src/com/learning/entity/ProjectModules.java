package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectModules {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "module_name")
	private String moduleName;
	
	@Column(name = "project_id")
	private int projectId;

	public ProjectModules() {
	}

	public ProjectModules(String moduleName, int projectId) {
		this.moduleName = moduleName;
		this.projectId = projectId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ProjectModules [id=" + id + ", moduleName=" + moduleName + ", projectId=" + projectId + "]";
	}

}


