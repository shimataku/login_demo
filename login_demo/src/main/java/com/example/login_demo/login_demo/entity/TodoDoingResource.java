package com.example.login_demo.login_demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TodoDoingResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean isFix;
}
