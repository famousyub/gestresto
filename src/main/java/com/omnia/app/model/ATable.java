package com.omnia.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "atable")
public class ATable implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String ref ;
	private Integer loc_x ;
	private Integer loc_y ;
	private Boolean serverCall;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

	public ATable(Long id, String ref, Integer loc_x, Integer loc_y, Area area) {
		super();
		this.id = id;
		this.ref = ref;
		this.loc_x = loc_x;
		this.loc_y = loc_y;
		this.area = area;
	}

	public ATable(String ref, Integer loc_x, Integer loc_y, Area area) {
		super();
		this.ref = ref;
		this.loc_x = loc_x;
		this.loc_y = loc_y;
		this.area = area;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public Integer getLoc_x() {
		return loc_x;
	}


	public void setLoc_x(Integer loc_x) {
		this.loc_x = loc_x;
	}


	public Integer getLoc_y() {
		return loc_y;
	}


	public void setLoc_y(Integer loc_y) {
		this.loc_y = loc_y;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}

	public Boolean getServerCall() {
		return serverCall;
	}

	public void setServerCall(Boolean serverCall) {
		this.serverCall = serverCall;
	}

}
