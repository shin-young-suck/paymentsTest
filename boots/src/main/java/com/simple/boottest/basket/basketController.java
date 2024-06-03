package com.simple.boottest.basket;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.boottest.basket.basketRepo;
import com.simple.boottest.basket.basketVo;
import com.simple.boottest.controller.Vo;

@Controller
@RequestMapping("/itemBasket")
public class basketController {
	
	@Autowired 
	basketRepo ibr;
	
	@GetMapping("/list.do")
	public String list(Model model,HttpSession session) {
		Vo memVo=(Vo)session.getAttribute("memVo");
		model.addAttribute("basketList", ibr.findByMemberId(memVo.getId()));
		return "/itemBasket/list";
	}
	
	@PostMapping("/insert.do")
	public String insert(int itemNum, int count,HttpSession session){
		Vo memVo=(Vo)session.getAttribute("memVo");
		basketVo basketVo=ibr.findByItemNumAndMemberId( itemNum, memVo.getId());
		if(basketVo==null) {
			basketVo=new basketVo();
			basketVo.setMemberId(memVo.getId());
			basketVo.setItemNum(itemNum);
			basketVo.setCount(count);
			ibr.save(basketVo); //기존의 값이 없으면 insert  
		}else {
			basketVo.setCount(basketVo.getCount()+count);
			ibr.save(basketVo); //기존의 값이 있고 basket_num이 정의되어 있으면  Update 
		}
		return "redirect:/itemBasket/list.do";
	}
	
	@PostMapping("/update.do")
	public String update(basketVo basketVo) {
		//System.out.println(basketVo);
		ibr.save(basketVo);
		return "redirect:/itemBasket/list.do";
	}
	
	@PostMapping("/delete.do")
	public String delete(basketVo basketVo) {
		System.out.println(basketVo);
		ibr.delete(basketVo);
		return "redirect:/itemBasket/list.do";
	}

	
}
