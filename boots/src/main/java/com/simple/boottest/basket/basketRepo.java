package com.simple.boottest.basket;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simple.boottest.basket.basketVo;

public interface basketRepo extends JpaRepository<basketVo, Integer> {
	
	
	public Iterable<basketVo> findByMemberId(String memberId);
	
	public basketVo findByItemNumAndMemberId(int itemNum,String memberId);

}
