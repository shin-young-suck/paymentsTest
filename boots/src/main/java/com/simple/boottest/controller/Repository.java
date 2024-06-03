package com.simple.boottest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simple.boottest.controller.Vo;
import com.simple.boottest.basket.basketVo;

public interface Repository extends CrudRepository<Vo, Integer> {
	
	public List<Vo> findAllByOrderByIdAsc();
	public Vo findByIdAndPw(String id, String pw);
	
	public Optional<Vo> findById(String id);
	public Optional<Vo> findByEmail(String email);	
	public Optional<Vo> findByPhone(String phone);
	
}
