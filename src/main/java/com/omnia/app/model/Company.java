package com.omnia.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnia.app.model.audit.UserDateAudit;

@Entity
@Table(name = "companies")
public class Company extends UserDateAudit {

	private static final long serialVersionUID = -1810446243809630389L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Column(unique = true)
	@Size(max = 140)
	private String name;

	// @NotBlank
	@Size(max = 140)
	private String language;

	// @NotBlank
	@Size(max = 140)
	private String logo;

	// @NotBlank
	@Size(max = 140)
	private String timeFormat;

	// @NotBlank
	@Size(max = 140)
	private String dateFormat;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@Size(min = 0, max = 10)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	private List<Licence> licences = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@Size(min = 0, max = 10)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	private List<Network> networks = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@Size(min = 0, max = 10)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	private List<Employee> employees = new ArrayList<>();

	 @JsonIgnore
	 @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)  
	 @Fetch(FetchMode.SELECT) 
	 private List<Commande> commands = new ArrayList<>();
	 

	
	  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	  @Fetch(FetchMode.SELECT) 
	  private List<Category> categories = new ArrayList<>();
	 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public List<Licence> getLicences() {
		return licences;
	}

	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}

	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Commande> getCommands() {
		return commands;
	}

	public void setCommands(List<Commande> commands) {
		this.commands = commands;
	}
	
	

}