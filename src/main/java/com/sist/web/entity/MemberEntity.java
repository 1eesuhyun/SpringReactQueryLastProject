package com.sist.web.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="member_1")
@Data
public class MemberEntity {
	@Id
	private String id;
	
	private String name;
	private String pwd;
}
