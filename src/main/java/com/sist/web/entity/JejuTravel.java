package com.sist.web.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="jejutravel")
@Data
public class JejuTravel {
	@Id
	@Column(name="contentid")
	private int contentid;
	
	private int no;
	private int contenttype,hit;
	
	private String title;
	private String image1;
	private String image2;
	private String address;
	
	private double x,y;
}
