package com.simple.boottest.iitem;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.simple.boottest.controller.Vo;
import com.simple.boottest.categoryy.cateVo;

//itemNum	int
//name	varchar(255)
//title	varchar(255)
//count	varchar(255)
//price	varchar(255)
//main_img	varchar(255)
//detail_img	varchar(255)
//model_num	varchar(255)

@Entity
@Table(name="item")
public class iitemVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_num")
	private Integer itemNum;
	private String name;
	private String title;
	private String count;
	private String price;
	private String detail_img;
	private String model_num;
	
	@Column(name="member_id")
	private String memberId; 
	@Column(name="cate_num")
	private int cateNum;
	@Column(name="main_img")
	private String mainImg;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@Column(name="sale_time")
	private Date saleTime;
	
//	@OneToOne(fetch = FetchType.LAZY) 
//	@JoinColumn(name="member_id", insertable=false, updatable=false)
//	private Vo member;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="cate_num", insertable=false, updatable=false)
//	private cateVo category;

	
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCateNum() {
		return cateNum;
	}
	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	public String getModel_num() {
		return model_num;
	}
	public void setModel_num(String model_num) {
		this.model_num = model_num;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	@Override
	public String toString() {
		return "iitemVo [itemNum=" + itemNum + ", name=" + name + ", title=" + title + ", count=" + count + ", price="
				+ price + ", detail_img=" + detail_img + ", model_num=" + model_num + ", memberId=" + memberId
				+ ", cateNum=" + cateNum + ", mainImg=" + mainImg + "]";
	}
	

	
}
