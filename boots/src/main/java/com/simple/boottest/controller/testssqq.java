package com.simple.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.boottest.iitem.itemRepository;
import com.simple.boottest.iitem.iitemVo;

@Controller
@RequestMapping("/ttes")
public class testssqq {
	
	@Autowired
	private itemRepository ir;
	
	@GetMapping("/main")
	public String list(Model model){
//		Iterable<ItemVo> itemList=ir.findAll();
		model.addAttribute("itemList",ir.findAll());
		return "/mem/testss";
	}
	
	@GetMapping("/test/user/mypage")
	public String mypage(String key, Model model) {
		return "/mem/testss";
	}

}
