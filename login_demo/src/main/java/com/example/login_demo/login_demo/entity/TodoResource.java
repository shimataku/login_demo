package com.example.login_demo.login_demo.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class TodoResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//タイトル
	private String title;
	//説明
	private String description;
	//開始時間
	private Date startDate;
	//終了時間
	private Date limitDate;
}
