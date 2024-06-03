package com.simple.boottest.categoryy;

import org.springframework.data.repository.CrudRepository;

import com.simple.boottest.categoryy.cateVo;

public interface cateRepository extends CrudRepository<cateVo, Integer>{
	
	public Iterable<cateVo> findAll();

}
