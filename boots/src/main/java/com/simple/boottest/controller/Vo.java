package com.simple.boottest.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import com.simple.boottest.basket.basketVo;

@Entity
@Table(name="member")

public class Vo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Mnum;
	private String id;
	private String pw;             
	private String phone;          
	private String email;          
	private String name;           
	private String address;
	private String address_detail; 
	private	Date signup_time;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;          
	private byte grade;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@Column(name="signup_time",nullable=true, insertable= false, updatable= false)
	private	Date signupTime;
	
	
	@Formula(value = "(SELECT COUNT(b.count) FROM item_basket b WHERE b.member_id=id)")//subquery
	Integer basketCount;
	
	
    
	
	public Integer getBasketCount() {
		return basketCount;
	}
	public void setBasketCount(Integer basketCount) {
		this.basketCount = basketCount;
	}
	public int getMnum() {
		return Mnum;
	}
	public void setMnum(int mnum) {
		Mnum = mnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public Date getSignup_time() {
		return signup_time;
	}
	public void setSignup_time(Date signup_time) {
		this.signup_time = signup_time;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public byte getGrade() {
		return grade;
	}
	public void setGrade(byte grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Vo [id=" + id + ", pw=" + pw + ", phone=" + phone + ", email=" + email + ", name=" + name + ", address="
				+ address + ", address_detail=" + address_detail + ", signup_time=" + signup_time + ", birth=" + birth
				+ ", grade=" + grade + "]";
	}
	
	
	

}
