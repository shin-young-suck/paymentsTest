package com.simple.boottest.categoryy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="category")

public class cateVo {
	
	@Id
	@Column(name="cate_num")
	private int cateNum;
	private String name;
	@Column(insertable = false, updatable = false)
	private Integer sub;
	public int getCateNum() {
		return cateNum;
	}
	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSub() {
		return sub;
	}
	public void setSub(Integer sub) {
		this.sub = sub;
	}
	
	@Override
	public String toString() {
		return "cateVo [cateNum=" + cateNum + ", name=" + name + ", sub=" + sub + "]";
	}
	
	

}
