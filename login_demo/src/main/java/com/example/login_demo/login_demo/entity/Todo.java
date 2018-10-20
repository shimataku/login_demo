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
	//詳細
	private String description;
	//公開時間
	private Long publishedDate;
	//開始時間
	private Long startDate;
	//終了時間
	private Long limitDate;
	//終わった?
	private Boolean isFix;

}
