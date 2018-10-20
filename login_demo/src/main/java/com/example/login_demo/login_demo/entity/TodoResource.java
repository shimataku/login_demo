package com.example.login_demo.login_demo.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class TodoResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	//
	private String title;
	//
	private String description;
	
	private Long publishedDate;
	//
	private Long startDate;
	//
	private Long limitDate;
	
	private Boolean isFix;
}
