package com.example.login_demo.login_demo.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class Todo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private String id;
	//タイトル
	private String title;
	//説明
	private String description;
	//登録日
	private Date publishedDate;
	//開始日
	private Date startDate;
	//期限日
	private Date limitDate;
	//完了フラグ
	private Boolean isFix;

}
