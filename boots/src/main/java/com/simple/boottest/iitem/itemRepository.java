package com.simple.boottest.iitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simple.boottest.iitem.iitemVo;
import com.simple.boottest.controller.Vo;
import com.simple.boottest.categoryy.cateVo;

public interface itemRepository extends CrudRepository<iitemVo, Integer>{
	
	@Query(value = "SELECT item,mem,cate FROM iitemVo item "
			+ "LEFT JOIN Vo mem ON item.memberId=mem.id "
			+ "LEFT JOIN cateVo cate ON item.cateNum=cate.cateNum")
	public Iterable<Object[]> findAllWithCategoryWithMember();
	
	public Iterable<iitemVo> findAll();
	
	public iitemVo findByItemNum(Integer itemNum);
    
}
